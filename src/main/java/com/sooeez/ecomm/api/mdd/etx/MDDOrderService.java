package com.sooeez.ecomm.api.mdd.etx;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sooeez.ecomm.domain.Currency;
import com.sooeez.ecomm.domain.ObjectProcess;
import com.sooeez.ecomm.domain.Order;
import com.sooeez.ecomm.domain.OrderItem;
import com.sooeez.ecomm.domain.Process;
import com.sooeez.ecomm.domain.ProcessStep;
import com.sooeez.ecomm.domain.Product;
import com.sooeez.ecomm.domain.Shop;
import com.sooeez.ecomm.repository.OrderRepository;
import com.sooeez.ecomm.repository.ShopRepository;
import com.sooeez.ecomm.service.ProcessService;

@Service
@Configurable
@EnableScheduling
public class MDDOrderService {

	private String apiOrderList = "http://www.mdd.co.nz/mddAPI/OrderList.php?";
	private String apiOrderInfo = "http://www.mdd.co.nz/mddAPI/OrderInfo.php?";
	private String account = "account=Ecomm";
	private String key = "&key=f12535b111713d1fced74e08994c1882";
	private ObjectMapper mapper = new ObjectMapper();

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private ShopRepository shopRepository;

	@Autowired
	private ProcessService processService;

	/*
	 * import order data from mdd website
	 */
	@Transactional
	// @Scheduled(cron = "0 */3 * * * * ")
	//@Scheduled(cron = "*/10 * * * * * ")
	public void importOrder() throws JsonParseException, JsonMappingException, IOException {

		Shop shop = shopRepository.findOne(2l);

		List<String> urls = new ArrayList<>();

		// 导入四种状态的订单

		// status = 1, 仓库中转
		String url1 = apiOrderList + account + key + "&storage=1&status=1";

		String json = EcommHttp.postRequest(url1);
		OrderList orderStatus1 = mapper.readValue(json, OrderList.class);

		// System.out.println(orderStatus1.toString());

		if (orderStatus1.getSuccess().intValue() == 1) {
			if (orderStatus1.getData() != null && orderStatus1.getData().size() > 0) {
				for (OrderSub sub : orderStatus1.getData()) {
					Long count = orderRepository.countByExternalId(sub.getOrder_id().longValue());
					// mmd订单在ecomm中存在
					if (count.longValue() > 0) {

					} else { // mdd订单在ecomm中不存在

						json = EcommHttp.postRequest(apiOrderInfo + account + key + "&order_id=" + sub.getOrder_id().longValue() + "&pre=0");
						OrderInfo orderInfo = mapper.readValue(json, OrderInfo.class);

						// System.out.println(orderInfo.toString());

						// add items
//						for (OrderGood good : orderInfo.getGoods()) {
//
//							// System.out.println(good.toString());
//
//							OrderItem item = new OrderItem();
//							// set product
//							Product product = new Product();
//							product.setId(good.getGoods_id().longValue());
//							item.setProduct(product);
//							item.setExternalSku(good.getGoods_sn());
//							item.setSku(good.getGoods_sn());
//							item.setExternal_name(good.getGoods_name());
//							item.setName(good.getGoods_name());
//							item.setUnitWeight(0);
//							item.setQtyOrdered(good.getGoods_number());
//							// item.setQtyShipped(qtyShipped);
//							item.setUnitPrice(good.getMarket_price());
//							item.setUnitCost(good.getGoods_price());
//							item.setUnitGst(new BigDecimal(0));
//							// item.setWarehouseId(warehouseId);
//
//						}

						Order order = new Order();
						// set shop
						order.setShop(shop);
						order.setExternalId(orderInfo.getOrder_id().longValue());
						order.setExternalSn(orderInfo.getOrder_sn());
						order.setExternalCreateTime(new Date(orderInfo.getAdd_time()));
						order.setExternalLogTime(sub.getLog_time());
						order.setInternalCreateTime(new Date());
						order.setLastUpdateTime(new Date());
						order.setQtyTotalItemOrdered(orderInfo.getGoods().size());
						order.setQtyTotalItemShipped(0);
						order.setGrandTotal(new BigDecimal(0));
						order.setSubtotal(new BigDecimal(0));
						order.setShippingFee(orderInfo.getShipping_fee());
						order.setTax(new BigDecimal(0));
						// order.setTotalInvoiced();
						// order.setTotalPaid();
						// order.setTotalRefunded();
						// set currency
						Currency currency = new Currency();
						if (orderInfo.getBiz().intValue() == 0) {
							currency.setId(100L);
						} else if (orderInfo.getBiz().intValue() == 1) {
							currency.setId(101L);
						}
						order.setCurrency(currency);
						order.setWeight(0);
						// order.setCustomerId(customerId);
						order.setShippingDescription(orderInfo.getShipping_name());
						// set delivery
						if (orderInfo.getShipping_name() != null && !orderInfo.getShipping_name().trim().equals("")) {
							if (orderInfo.getShipping_name().contains("新西兰-中国") || (orderInfo.getShipping_name().contains("新西兰-新西兰") && orderInfo.getShipping_name().contains("快递邮寄"))) {
								order.setDeliveryMethod(1);
							} else if (orderInfo.getShipping_name().contains("新西兰-新西兰") && orderInfo.getShipping_name().contains("自己取货")) {
								order.setDeliveryMethod(2);
							} else if (orderInfo.getShipping_name().contains("新西兰-新西兰") && orderInfo.getShipping_name().contains("送货上门")) {
								order.setDeliveryMethod(3);
							}
						}
						// order.setSenderName(senderName);
						// order.setSenderAddress(senderAddress);
						// order.setSenderPhone(senderPhone);
						// order.setSenderEmail(senderEmail);
						// order.setSenderPost(senderPost);
						order.setReceiveName(orderInfo.getConsignee());
						order.setReceivePhone(orderInfo.getMobile());
						order.setReceiveEmail(orderInfo.getEmail());
						order.setReceiveCountry(orderInfo.getCountry().toString());
						order.setReceiveProvince(orderInfo.getProvince().toString());
						order.setReceiveCity(orderInfo.getCity().toString());
						order.setReceiveAddress(orderInfo.getAddress());
						order.setReceivePost(orderInfo.getZipcode());
						order.setDeleted(false);
						order.setMemo(orderInfo.getPostscript() + " " + orderInfo.getHow_oos());
						// set processes
						ObjectProcess objectProcess = new ObjectProcess();
						objectProcess.setObjectType(1);
						Process process = new Process();
						process.setId(shop.getDeployStep().getProcessId());
						objectProcess.setProcess(process);
						objectProcess.setStep(shop.getDeployStep());
						List<ObjectProcess> processes = new ArrayList<>();
						processes.add(objectProcess);
						order.setProcesses(processes);
						
						// save order
						orderRepository.save(order);

					}
				}
			}
		}

		// status = 2, 待支付订单
		String url2 = apiOrderList + account + key + "&storage=1&status=2";
		// status = 3, 待打印
		String url3 = apiOrderList + account + key + "&storage=1&status=3";
		// status = 5, 配货中
		String url5 = apiOrderList + account + key + "&storage=1&status=4";

	}

}

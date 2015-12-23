package com.sooeez.ecomm.api.mdd.etx;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OrderInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Response Result
	 */

	private Integer success; // 是否处理成功
	private Integer errorcode; // 失败编号
	private String errordesc; // 失败说明
	private Integer order_id; // 订单id
	private String order_sn; // 订单编号
	private Integer user_id; // 用户id
	private Integer order_status; // 订单状态
	private Integer shipping_status; // 配送状态
	private Integer pay_status; // 支付状态
	private Integer after_status; // 售后状态
	private String consignee; // 收货人
	private Integer country; // 收货国家参见地区表
	private Integer province; // 省份参见地区表
	private Integer city; // 城市参见地区表
	private Integer district; // 区参见地区表
	private String address; // 详细地址
	private String zipcode; // 邮编
	private String tel; // 电话
	private String mobile; // 手机
	private String email; // Email
	private String postscript; // 买家留言
	private String how_oos; // 缺货处理
	private Integer shipping_id; // 配送方式ID
	private String shipping_name; // 配送方式名称
	private Integer pay_id; // 支付方式ID
	private String pay_name; // 支付方式名称
	private BigDecimal goods_amount; // 商品总金额
	private BigDecimal discount; // 折扣
	private BigDecimal shipping_fee; // 配送费用
	private BigDecimal surplus; // 使用余额
	private BigDecimal integral_money; // 使用积分
	private BigDecimal bonus; // 使用现金券
	private BigDecimal order_vouchers; // 使用消费券
	private BigDecimal ship_vouchers; // 使用运费券
	private BigDecimal money_paid; // 已支付
	private BigDecimal order_amount; // 应付款
	private Integer biz; // 币种
	private BigDecimal huilv; // 汇率
	private Long add_time; // 下单时间
	private Long confirm_time; // 确认订单时间
	private Long pay_time; // 支付时间
	private Long shipping_time; // 发货时间
	private String invoice_no; // 快递单号
	private Integer express_id; // 快递公司ID
	private Integer is_pre; // 仓库ID

	private List<OrderGood> goods = new ArrayList<>(); // 订购商品

	public OrderInfo() {

	}

	public String toString() {
		String str = "OrderInfo = {\n";
		str += "  success: \"" + success + "\"\n";
		str += ", errorcode: \"" + errorcode + "\"\n";
		str += ", errordesc: \"" + errordesc + "\"\n";
		str += ", order_id: \"" + order_id + "\"\n";
		str += ", order_sn: \"" + order_sn + "\"\n";
		str += ", user_id: \"" + user_id + "\"\n";
		str += ", order_status: \"" + order_status + "\"\n";
		str += ", shipping_status: \"" + shipping_status + "\"\n";
		str += ", pay_status: \"" + pay_status + "\"\n";
		str += ", after_status: \"" + after_status + "\"\n";
		str += ", consignee: \"" + consignee + "\"\n";
		str += ", country: \"" + country + "\"\n";
		str += ", province: \"" + province + "\"\n";
		str += ", city: \"" + city + "\"\n";
		str += ", district: \"" + district + "\"\n";
		str += ", address: \"" + address + "\"\n";
		str += ", zipcode: \"" + zipcode + "\"\n";
		str += ", tel: \"" + tel + "\"\n";
		str += ", mobile: \"" + mobile + "\"\n";
		str += ", email: \"" + email + "\"\n";
		str += ", postscript: \"" + postscript + "\"\n";
		str += ", how_oos: \"" + how_oos + "\"\n";
		str += ", shipping_id: \"" + shipping_id + "\"\n";
		str += ", shipping_name: \"" + shipping_name + "\"\n";
		str += ", pay_id: \"" + pay_id + "\"\n";
		str += ", pay_name: \"" + pay_name + "\"\n";
		str += ", goods_amount: \"" + goods_amount + "\"\n";
		str += ", discount: \"" + discount + "\"\n";
		str += ", shipping_fee: \"" + shipping_fee + "\"\n";
		str += ", surplus: \"" + surplus + "\"\n";
		str += ", integral_money: \"" + integral_money + "\"\n";
		str += ", bonus: \"" + bonus + "\"\n";
		str += ", order_vouchers: \"" + order_vouchers + "\"\n";
		str += ", ship_vouchers: \"" + ship_vouchers + "\"\n";
		str += ", money_paid: \"" + money_paid + "\"\n";
		str += ", order_amount: \"" + order_amount + "\"\n";
		str += ", biz: \"" + biz + "\"\n";
		str += ", huilv: \"" + huilv + "\"\n";
		str += ", add_time: \"" + add_time + "\"\n";
		str += ", confirm_time: \"" + confirm_time + "\"\n";
		str += ", pay_time: \"" + pay_time + "\"\n";
		str += ", shipping_time: \"" + shipping_time + "\"\n";
		str += ", invoice_no: \"" + invoice_no + "\"\n";
		str += ", express_id: \"" + express_id + "\"\n";
		str += ", is_pre: \"" + is_pre + "\"\n";
		str += "}";
		return str;
	}

	public Integer getSuccess() {
		return success;
	}

	public void setSuccess(Integer success) {
		this.success = success;
	}

	public Integer getErrorcode() {
		return errorcode;
	}

	public void setErrorcode(Integer errorcode) {
		this.errorcode = errorcode;
	}

	public String getErrordesc() {
		return errordesc;
	}

	public void setErrordesc(String errordesc) {
		this.errordesc = errordesc;
	}

	public Integer getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}

	public String getOrder_sn() {
		return order_sn;
	}

	public void setOrder_sn(String order_sn) {
		this.order_sn = order_sn;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public Integer getOrder_status() {
		return order_status;
	}

	public void setOrder_status(Integer order_status) {
		this.order_status = order_status;
	}

	public Integer getShipping_status() {
		return shipping_status;
	}

	public void setShipping_status(Integer shipping_status) {
		this.shipping_status = shipping_status;
	}

	public Integer getPay_status() {
		return pay_status;
	}

	public void setPay_status(Integer pay_status) {
		this.pay_status = pay_status;
	}

	public Integer getAfter_status() {
		return after_status;
	}

	public void setAfter_status(Integer after_status) {
		this.after_status = after_status;
	}

	public String getConsignee() {
		return consignee;
	}

	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}

	public Integer getCountry() {
		return country;
	}

	public void setCountry(Integer country) {
		this.country = country;
	}

	public Integer getProvince() {
		return province;
	}

	public void setProvince(Integer province) {
		this.province = province;
	}

	public Integer getCity() {
		return city;
	}

	public void setCity(Integer city) {
		this.city = city;
	}

	public Integer getDistrict() {
		return district;
	}

	public void setDistrict(Integer district) {
		this.district = district;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPostscript() {
		return postscript;
	}

	public void setPostscript(String postscript) {
		this.postscript = postscript;
	}

	public String getHow_oos() {
		return how_oos;
	}

	public void setHow_oos(String how_oos) {
		this.how_oos = how_oos;
	}

	public Integer getShipping_id() {
		return shipping_id;
	}

	public void setShipping_id(Integer shipping_id) {
		this.shipping_id = shipping_id;
	}

	public String getShipping_name() {
		return shipping_name;
	}

	public void setShipping_name(String shipping_name) {
		this.shipping_name = shipping_name;
	}

	public Integer getPay_id() {
		return pay_id;
	}

	public void setPay_id(Integer pay_id) {
		this.pay_id = pay_id;
	}

	public String getPay_name() {
		return pay_name;
	}

	public void setPay_name(String pay_name) {
		this.pay_name = pay_name;
	}

	public BigDecimal getGoods_amount() {
		return goods_amount;
	}

	public void setGoods_amount(BigDecimal goods_amount) {
		this.goods_amount = goods_amount;
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public BigDecimal getShipping_fee() {
		return shipping_fee;
	}

	public void setShipping_fee(BigDecimal shipping_fee) {
		this.shipping_fee = shipping_fee;
	}

	public BigDecimal getSurplus() {
		return surplus;
	}

	public void setSurplus(BigDecimal surplus) {
		this.surplus = surplus;
	}

	public BigDecimal getIntegral_money() {
		return integral_money;
	}

	public void setIntegral_money(BigDecimal integral_money) {
		this.integral_money = integral_money;
	}

	public BigDecimal getBonus() {
		return bonus;
	}

	public void setBonus(BigDecimal bonus) {
		this.bonus = bonus;
	}

	public BigDecimal getOrder_vouchers() {
		return order_vouchers;
	}

	public void setOrder_vouchers(BigDecimal order_vouchers) {
		this.order_vouchers = order_vouchers;
	}

	public BigDecimal getShip_vouchers() {
		return ship_vouchers;
	}

	public void setShip_vouchers(BigDecimal ship_vouchers) {
		this.ship_vouchers = ship_vouchers;
	}

	public BigDecimal getMoney_paid() {
		return money_paid;
	}

	public void setMoney_paid(BigDecimal money_paid) {
		this.money_paid = money_paid;
	}

	public BigDecimal getOrder_amount() {
		return order_amount;
	}

	public void setOrder_amount(BigDecimal order_amount) {
		this.order_amount = order_amount;
	}

	public Integer getBiz() {
		return biz;
	}

	public void setBiz(Integer biz) {
		this.biz = biz;
	}

	public BigDecimal getHuilv() {
		return huilv;
	}

	public void setHuilv(BigDecimal huilv) {
		this.huilv = huilv;
	}

	public Long getAdd_time() {
		return add_time;
	}

	public void setAdd_time(Long add_time) {
		this.add_time = add_time;
	}

	public Long getConfirm_time() {
		return confirm_time;
	}

	public void setConfirm_time(Long confirm_time) {
		this.confirm_time = confirm_time;
	}

	public Long getPay_time() {
		return pay_time;
	}

	public void setPay_time(Long pay_time) {
		this.pay_time = pay_time;
	}

	public Long getShipping_time() {
		return shipping_time;
	}

	public void setShipping_time(Long shipping_time) {
		this.shipping_time = shipping_time;
	}

	public String getInvoice_no() {
		return invoice_no;
	}

	public void setInvoice_no(String invoice_no) {
		this.invoice_no = invoice_no;
	}

	public Integer getExpress_id() {
		return express_id;
	}

	public void setExpress_id(Integer express_id) {
		this.express_id = express_id;
	}

	public Integer getIs_pre() {
		return is_pre;
	}

	public void setIs_pre(Integer is_pre) {
		this.is_pre = is_pre;
	}

	public List<OrderGood> getGoods() {
		return goods;
	}

	public void setGoods(List<OrderGood> goods) {
		this.goods = goods;
	}

}

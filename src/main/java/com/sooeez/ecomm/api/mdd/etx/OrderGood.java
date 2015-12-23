package com.sooeez.ecomm.api.mdd.etx;

import java.io.Serializable;
import java.math.BigDecimal;

public class OrderGood implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Response Result
	 */

	private Integer goods_id; // 商品ID
	private String goods_name; // 商品名称
	private String goods_sn; // Ecomm 商品 sku
	private Integer goods_number; // 订购数量
	private BigDecimal market_price; // 市场价
	private BigDecimal goods_price; // 售价
	private Integer suppliers_id; // 供应商编号

	public OrderGood() {
	}
	
	public String toString() {
		String str = "OrderGood = {\n";
		str += ", goods_id: \"" + goods_id + "\"\n";
		str += ", goods_name: \"" + goods_name + "\"\n";
		str += ", goods_sn: \"" + goods_sn + "\"\n";
		str += ", goods_number: \"" + goods_number + "\"\n";
		str += ", market_price: \"" + market_price + "\"\n";
		str += ", goods_price: \"" + goods_price + "\"\n";
		str += ", suppliers_id: \"" + suppliers_id + "\"\n";
		str += "}";
		return str;
	}

	public Integer getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(Integer goods_id) {
		this.goods_id = goods_id;
	}

	public String getGoods_name() {
		return goods_name;
	}

	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}

	public String getGoods_sn() {
		return goods_sn;
	}

	public void setGoods_sn(String goods_sn) {
		this.goods_sn = goods_sn;
	}

	public Integer getGoods_number() {
		return goods_number;
	}

	public void setGoods_number(Integer goods_number) {
		this.goods_number = goods_number;
	}

	public BigDecimal getMarket_price() {
		return market_price;
	}

	public void setMarket_price(BigDecimal market_price) {
		this.market_price = market_price;
	}

	public BigDecimal getGoods_price() {
		return goods_price;
	}

	public void setGoods_price(BigDecimal goods_price) {
		this.goods_price = goods_price;
	}

	public Integer getSuppliers_id() {
		return suppliers_id;
	}

	public void setSuppliers_id(Integer suppliers_id) {
		this.suppliers_id = suppliers_id;
	}

}

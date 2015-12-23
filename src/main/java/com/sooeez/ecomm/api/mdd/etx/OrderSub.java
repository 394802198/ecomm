package com.sooeez.ecomm.api.mdd.etx;

import java.io.Serializable;

public class OrderSub implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/*
	 * Response Result
	 */

	private Integer order_id;
	private Long log_time;

	public OrderSub() {
	}

	public OrderSub(Integer order_id, Long log_time) {
		this.order_id = order_id;
		this.log_time = log_time;
	}

	public String toString() {
		String str = "OrderSub = {\n";
		str += "  order_id: \"" + order_id + "\"\n";
		str += ", log_time: \"" + log_time + "\"\n";
		str += "}";
		return str;
	}

	public Integer getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}

	public Long getLog_time() {
		return log_time;
	}

	public void setLog_time(Long log_time) {
		this.log_time = log_time;
	}

}

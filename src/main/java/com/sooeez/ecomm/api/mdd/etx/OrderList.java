package com.sooeez.ecomm.api.mdd.etx;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class OrderList implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Response Result
	 */

	private Integer success;
	private Integer errorcode;
	private String errordesc;
	private List<OrderSub> data = new ArrayList<>();

	public OrderList() {
	}

	public String toString() {
		String str = "OrderList = {\n";
		str += "  success: \"" + success + "\"\n";
		str += ", errorcode: \"" + errorcode + "\"\n";
		str += ", errordesc: \"" + errordesc + "\"\n";
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

	public List<OrderSub> getData() {
		return data;
	}

	public void setData(List<OrderSub> data) {
		this.data = data;
	}

}

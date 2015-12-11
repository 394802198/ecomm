package com.sooeez.ecomm.api.mdd.constant;

public class OrderStatus
{
	public static final Long	WAREHOUSE_TRANSIT	= 1L;	// 仓库中转
	public static final Long	PENDING_PAYMENT		= 2L;	// 待支付
	public static final Long	PENDING_PRINTING	= 3L;	// 待打印
	public static final Long	OUT_OF_STOCK		= 4L;	// 有缺货
	public static final Long	DEPLOYING			= 5L;	// 配货中
	public static final Long	EXCEPTION			= 6L;	// 问题单
}

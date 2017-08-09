package com.lshaci.alipay.constants;

/**
 * 支付宝支付响应码
 */
public interface AlipayResponseCode {

	/**
	 * 成功
	 */
	String SUCCESS = "10000";
	
	/**
	 * 用户支付中
	 */
	String PAYING  = "10003";
	
	/**
	 * 失败 
	 */
	String FAILED  = "40004";
	
	/**
	 * 系统异常
	 */
	String ERROR   = "20000";
}

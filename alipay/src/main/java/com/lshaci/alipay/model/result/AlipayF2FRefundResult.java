package com.lshaci.alipay.model.result;

import com.alipay.api.response.AlipayTradeRefundResponse;

/**
 * 面对面支付, 退款返回结果
 */
public class AlipayF2FRefundResult extends AbsAlipayResult {

	private static final long serialVersionUID = -8936363769035827186L;


	public AlipayF2FRefundResult(AlipayTradeRefundResponse response) {
		super(response);
	}

	public void setResponse(AlipayTradeRefundResponse response) {
		this.response = response;
	}

	public AlipayTradeRefundResponse getResponse() {
		return (AlipayTradeRefundResponse) response;
	}

}

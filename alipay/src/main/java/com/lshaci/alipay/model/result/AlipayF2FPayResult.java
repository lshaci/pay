package com.lshaci.alipay.model.result;

import com.alipay.api.response.AlipayTradePayResponse;

/**
 * 面对面支付, 支付返回结果
 */
public class AlipayF2FPayResult extends AbsAlipayResult {

	private static final long serialVersionUID = -2950162522275795091L;

	public AlipayF2FPayResult(AlipayTradePayResponse response) {
		super(response);
	}

	public void setResponse(AlipayTradePayResponse response) {
		this.response = response;
	}

	public AlipayTradePayResponse getResponse() {
		return (AlipayTradePayResponse) response;
	}

}

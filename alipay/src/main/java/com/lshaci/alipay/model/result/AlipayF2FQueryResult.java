package com.lshaci.alipay.model.result;

import com.alipay.api.response.AlipayTradeQueryResponse;

/**
 * 面对面支付, 查询返回结果
 */
public class AlipayF2FQueryResult extends AbsAlipayResult {

	private static final long serialVersionUID = -2969098463561819418L;

	public AlipayF2FQueryResult(AlipayTradeQueryResponse response) {
		super(response);
	}

	public void setResponse(AlipayTradeQueryResponse response) {
		this.response = response;
	}

	public AlipayTradeQueryResponse getResponse() {
		return (AlipayTradeQueryResponse) response;
	}

}

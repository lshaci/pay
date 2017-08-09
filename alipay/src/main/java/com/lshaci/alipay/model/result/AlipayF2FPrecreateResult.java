package com.lshaci.alipay.model.result;

import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.lshaci.alipay.constants.AlipayResponseCode;

/**
 * 当面付2.0, 预支付返回结果
 */
public class AlipayF2FPrecreateResult extends AbsAlipayResult {

	private static final long serialVersionUID = -2646739546812328935L;

	public AlipayF2FPrecreateResult(AlipayTradePrecreateResponse response) {
		super(response);
	}

	public void setResponse(AlipayTradePrecreateResponse response) {
		this.response = response;
	}

	public AlipayTradePrecreateResponse getResponse() {
		return (AlipayTradePrecreateResponse) response;
	}
	
	/**
	 * 获取生成的二维码地址
	 * 
	 * @return	二维码地址
	 */
	public String getQrCode() {
		if (response != null && AlipayResponseCode.SUCCESS.equals(response.getCode())) {
			return ((AlipayTradePrecreateResponse) response).getQrCode();
		}
		return null;
	}

}

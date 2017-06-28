package com.lshaci.alipay.model.result;

import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.lshaci.alipay.constants.Constants;
import com.lshaci.alipay.enums.TradeStatus;

/**
 * 当面付2.0, 预支付返回结果
 */
public class AlipayF2FPrecreateResult implements Result {

	private TradeStatus tradeStatus;
	private AlipayTradePrecreateResponse response;

	public AlipayF2FPrecreateResult(AlipayTradePrecreateResponse response) {
		this.response = response;
	}

	public void setTradeStatus(TradeStatus tradeStatus) {
		this.tradeStatus = tradeStatus;
	}

	public void setResponse(AlipayTradePrecreateResponse response) {
		this.response = response;
	}

	public TradeStatus getTradeStatus() {
		return tradeStatus;
	}

	public AlipayTradePrecreateResponse getResponse() {
		return response;
	}
	
	/**
	 * 获取生成的二维码地址
	 * 
	 * @return	二维码地址
	 */
	public String getQrCode() {
		if (response != null && Constants.SUCCESS.equals(response.getCode())) {
			return response.getQrCode();
		}
		return null;
	}

	@Override
	public boolean isTradeSuccess() {
		return response != null && TradeStatus.SUCCESS.equals(tradeStatus);
	}
}

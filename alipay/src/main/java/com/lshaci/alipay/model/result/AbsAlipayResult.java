package com.lshaci.alipay.model.result;

import java.io.Serializable;

import com.alipay.api.AlipayResponse;
import com.lshaci.alipay.enums.TradeStatus;
/**
 * 交易返回结果
 */
public abstract class AbsAlipayResult implements Serializable {

	private static final long serialVersionUID = -934549280230738923L;
	
	private TradeStatus tradeStatus;
	
	protected AlipayResponse response;
	
	protected AbsAlipayResult(AlipayResponse response) {
		this.response = response;
	}

	public TradeStatus getTradeStatus() {
		return tradeStatus;
	}

	public void setTradeStatus(TradeStatus tradeStatus) {
		this.tradeStatus = tradeStatus;
	}
	
	/**
	 * 判断交易是否在业务上成功
	 * 
	 * @return 返回true说明一定成功，但是返回false并不代表业务不成功！因为还有unknown的状态可能业务已经成功了
	 */
	public boolean isTradeSuccess() {
		return response != null && TradeStatus.SUCCESS.equals(tradeStatus);
	}

}

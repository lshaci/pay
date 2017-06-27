package com.lshaci.alipay.model.result;

import com.alipay.api.response.AlipayTradeQueryResponse;
import com.lshaci.alipay.enums.TradeStatus;

/**
 * 面对面支付, 查询返回结果
 */
public class AlipayF2FQueryResult implements Result {
	
    private TradeStatus tradeStatus;
    private AlipayTradeQueryResponse response;

    public AlipayF2FQueryResult(AlipayTradeQueryResponse response) {
        this.response = response;
    }

    public void setTradeStatus(TradeStatus tradeStatus) {
        this.tradeStatus = tradeStatus;
    }

    public void setResponse(AlipayTradeQueryResponse response) {
        this.response = response;
    }

    public TradeStatus getTradeStatus() {
        return tradeStatus;
    }

    public AlipayTradeQueryResponse getResponse() {
        return response;
    }

    @Override
    public boolean isTradeSuccess() {
        return response != null && TradeStatus.SUCCESS.equals(tradeStatus);
    }
}

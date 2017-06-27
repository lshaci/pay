package com.lshaci.alipay.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alipay.api.AlipayClient;
import com.alipay.api.AlipayResponse;
import com.alipay.api.request.AlipayTradePrecreateRequest;
import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.lshaci.alipay.constants.Constants;
import com.lshaci.alipay.enums.TradeStatus;
import com.lshaci.alipay.model.builder.AlipayTradePayRequestBuilder;
import com.lshaci.alipay.model.builder.AlipayTradePrecreateRequestBuilder;
import com.lshaci.alipay.model.builder.AlipayTradeQueryRequestBuilder;
import com.lshaci.alipay.model.builder.AlipayTradeRefundRequestBuilder;
import com.lshaci.alipay.model.result.AlipayF2FPayResult;
import com.lshaci.alipay.model.result.AlipayF2FPrecreateResult;
import com.lshaci.alipay.model.result.AlipayF2FQueryResult;
import com.lshaci.alipay.model.result.AlipayF2FRefundResult;
import com.lshaci.alipay.service.AlipayTradeService;

@Service
public class AlipayTradeServiceImpl extends AbsAlipayService implements AlipayTradeService {
	
	@Autowired
	private AlipayClient alipayCilent;

	@Override
	public AlipayF2FPrecreateResult tradePrecreate(AlipayTradePrecreateRequestBuilder builder) {
		validateBuilder(builder);
		
		AlipayTradePrecreateRequest request = new AlipayTradePrecreateRequest();
        request.setNotifyUrl(builder.getNotifyUrl());
        request.putOtherTextParam("app_auth_token", builder.getAppAuthToken());
        request.setBizContent(builder.toJsonString());
        logger.info("trade.precreate bizContent:" + request.getBizContent());

        AlipayTradePrecreateResponse response = (AlipayTradePrecreateResponse) getResponse(alipayCilent, request);

        AlipayF2FPrecreateResult result = new AlipayF2FPrecreateResult(response);
        if (response != null && Constants.SUCCESS.equals(response.getCode())) {
            // 预下单交易成功
            result.setTradeStatus(TradeStatus.SUCCESS);
        } else if (tradeError(response)) {
            // 预下单发生异常，状态未知
            result.setTradeStatus(TradeStatus.UNKNOWN);
        } else {
            // 其他情况表明该预下单明确失败
            result.setTradeStatus(TradeStatus.FAILED);
        }
        return result;
	}

	@Override
	public AlipayF2FPayResult tradePay(AlipayTradePayRequestBuilder builder) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AlipayF2FQueryResult queryTradeResult(AlipayTradeQueryRequestBuilder builder) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AlipayF2FRefundResult tradeRefund(AlipayTradeRefundRequestBuilder builder) {
		// TODO Auto-generated method stub
		return null;
	}

	
	/**
	 *  交易异常，或发生系统错误
	 */
    protected boolean tradeError(AlipayResponse response) {
        return response == null || Constants.ERROR.equals(response.getCode());
    }

}
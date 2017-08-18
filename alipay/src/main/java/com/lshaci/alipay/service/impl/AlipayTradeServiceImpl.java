package com.lshaci.alipay.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alipay.api.AlipayClient;
import com.alipay.api.AlipayResponse;
import com.alipay.api.request.AlipayTradePrecreateRequest;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.alipay.api.response.AlipayTradeQueryResponse;
import com.lshaci.alipay.config.AlipayConfig;
import com.lshaci.alipay.constants.AlipayResponseCode;
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
import com.lshaci.alipay.utils.VerifyUtils;

@Service
public class AlipayTradeServiceImpl extends AbsAlipayService implements AlipayTradeService {

	@Autowired
	private AlipayClient alipayCilent;

	@Autowired
	private AlipayConfig alipayConfig;

	@Override
	public AlipayF2FPrecreateResult tradePrecreate(AlipayTradePrecreateRequestBuilder builder) {
		validateBuilder(builder);

		AlipayTradePrecreateRequest request = new AlipayTradePrecreateRequest();
		request.setNotifyUrl(alipayConfig.getNotifyUrl());
		request.putOtherTextParam("app_auth_token", builder.getAppAuthToken());
		request.setBizContent(builder.toJsonString());
		logger.info("trade.precreate bizContent:" + request.getBizContent());

		AlipayTradePrecreateResponse response = (AlipayTradePrecreateResponse) getResponse(alipayCilent, request);

		AlipayF2FPrecreateResult result = new AlipayF2FPrecreateResult(response);
		if (response != null && AlipayResponseCode.SUCCESS.equals(response.getCode())) {
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
	public void tradeNotify(Map<String, String[]> params) {
		if (VerifyUtils.rsaCheckV1(params)) {
			//TODO
			System.err.println("验签成功");
			System.err.println("执行自己的业务逻辑");
		} else {
			System.err.println("验签失败");
		}
	}

	@Override
	public AlipayF2FPayResult tradePay(AlipayTradePayRequestBuilder builder) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AlipayF2FQueryResult queryTradeResult(AlipayTradeQueryRequestBuilder builder) {
		AlipayTradeQueryResponse response = tradeQuery(builder);

        AlipayF2FQueryResult result = new AlipayF2FQueryResult(response);
        if (querySuccess(response)) {
            // 查询返回该订单交易支付成功
            result.setTradeStatus(TradeStatus.SUCCESS);

        } else if (tradeError(response)) {
            // 查询发生异常，交易状态未知
            result.setTradeStatus(TradeStatus.UNKNOWN);

        } else {
            // 其他情况均表明该订单号交易失败
            result.setTradeStatus(TradeStatus.FAILED);
        }
        return result;
	}

	@Override
	public AlipayF2FRefundResult tradeRefund(AlipayTradeRefundRequestBuilder builder) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 交易异常，或发生系统错误
	 */
	protected boolean tradeError(AlipayResponse response) {
		return response == null || AlipayResponseCode.ERROR.equals(response.getCode());
	}
	
    /**
     *  查询返回“支付成功”
     */
    protected boolean querySuccess(AlipayTradeQueryResponse response) {
        return response != null &&
        		AlipayResponseCode.SUCCESS.equals(response.getCode()) &&
                ("TRADE_SUCCESS".equals(response.getTradeStatus()) ||
                        "TRADE_FINISHED".equals(response.getTradeStatus())
                );
    }

    /**
     * 订单查询
     * 
     * @param builder
     * @return
     */
    protected AlipayTradeQueryResponse tradeQuery(AlipayTradeQueryRequestBuilder builder) {
        validateBuilder(builder);

        AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();
        request.putOtherTextParam("app_auth_token", builder.getAppAuthToken());
        request.setBizContent(builder.toJsonString());
        logger.info("trade.query bizContent:" + request.getBizContent());

        return (AlipayTradeQueryResponse) getResponse(alipayCilent, request);
    }
}

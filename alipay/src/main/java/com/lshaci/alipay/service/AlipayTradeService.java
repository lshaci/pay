package com.lshaci.alipay.service;

import java.util.Map;

import com.lshaci.alipay.model.builder.AlipayTradePayRequestBuilder;
import com.lshaci.alipay.model.builder.AlipayTradePrecreateRequestBuilder;
import com.lshaci.alipay.model.builder.AlipayTradeQueryRequestBuilder;
import com.lshaci.alipay.model.builder.AlipayTradeRefundRequestBuilder;
import com.lshaci.alipay.model.result.AlipayF2FPayResult;
import com.lshaci.alipay.model.result.AlipayF2FPrecreateResult;
import com.lshaci.alipay.model.result.AlipayF2FQueryResult;
import com.lshaci.alipay.model.result.AlipayF2FRefundResult;

/**
 * 支付宝当面付2.0业务接口
 * 
 * @author lshaci
 *
 */
public interface AlipayTradeService {
	
	/**
	 *  当面付2.0预下单(生成二维码)
	 *  
	 * @param builder
	 * @return
	 */
	AlipayF2FPrecreateResult tradePrecreate(AlipayTradePrecreateRequestBuilder builder);
	
	/**
	 * 当面付2.0支付宝通知
	 * 
	 * @param params	request获取的参数
	 */
	void tradeNotify(Map<String, String[]> params);
	
    /**
     *  当面付2.0流程支付
     *  
     * @param builder
     * @return
     */
    AlipayF2FPayResult tradePay(AlipayTradePayRequestBuilder builder);

    /**
     *  当面付2.0消费查询
     *  
     * @param builder
     * @return
     */
    AlipayF2FQueryResult queryTradeResult(AlipayTradeQueryRequestBuilder builder);

    /**
     *  当面付2.0消费退款
     *  
     * @param builder
     * @return
     */
    AlipayF2FRefundResult tradeRefund(AlipayTradeRefundRequestBuilder builder);


}

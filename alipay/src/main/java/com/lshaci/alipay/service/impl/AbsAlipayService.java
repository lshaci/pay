package com.lshaci.alipay.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.AlipayRequest;
import com.alipay.api.AlipayResponse;
import com.lshaci.alipay.model.builder.RequestBuilder;

/**
 * 支付宝支付业务, 顶层抽象
 */
abstract class AbsAlipayService {

	protected Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * 验证bizContent对象
	 * 
	 * @param builder
	 */
	protected void validateBuilder(RequestBuilder builder) {
		if (builder == null) {
			throw new NullPointerException("builder should not be NULL!");
		}

		if (!builder.validate()) {
			throw new IllegalStateException("builder validate failed! " + builder.toString());
		}
	}

	/**
	 * 调用AlipayClient的execute方法，进行远程调用
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected AlipayResponse getResponse(AlipayClient client, AlipayRequest request) {
		try {
			AlipayResponse response = client.execute(request);
			if (response != null) {
				logger.info(response.getBody());
			}
			return response;

		} catch (AlipayApiException e) {
			e.printStackTrace();
			return null;
		}
	}
}

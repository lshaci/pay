package com.lshaci.alipay.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.lshaci.alipay.config.AlipayConfig;

@Component
public class VerifyUtils {
	
	private final static Logger logger = LoggerFactory.getLogger(VerifyUtils.class);
	
	private static AlipayConfig alipayConfig;
	
	private VerifyUtils() {}
	
	@Autowired
	private void setAlipayConfig(AlipayConfig alipayConfig) {
		VerifyUtils.alipayConfig = alipayConfig;
	}
	
	public static boolean rsaCheckV1(Map<String, String[]> params) {
		if (params == null || params.isEmpty()) {
			return false;
		}
		
		Map<String, String> checkParams = new HashMap<>();
		for (Entry<String, String[]> entry : params.entrySet()) {
			String key = entry.getKey();
			String value = "";
			String[] values = entry.getValue();
			for (String s : values) {
				value += "," + s;
			}
			checkParams.put(key, value.substring(1));
		}
		
		logger.debug("Cheak params is: " + checkParams);
		
		try {
			return AlipaySignature.rsaCheckV1(checkParams, alipayConfig.getAlipayPulicKey(),
					alipayConfig.getCharset(), alipayConfig.getSignType());
		} catch (AlipayApiException e) {
			logger.error("Verify sign is error!", e);
		}
		
		return false;
	}

}

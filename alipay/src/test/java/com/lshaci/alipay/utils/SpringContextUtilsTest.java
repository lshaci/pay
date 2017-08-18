package com.lshaci.alipay.utils;

import org.junit.Test;

import com.lshaci.alipay.AbsSpringBaseTest;
import com.lshaci.alipay.config.AlipayConfig;

public class SpringContextUtilsTest extends AbsSpringBaseTest {

	@Test
	public void test() {
		AlipayConfig alipayConfig = SpringContextUtils.getBean("alipayConfig", AlipayConfig.class);
		System.out.println(alipayConfig.getGatewayUrl());
	}

}

package com.lshaci.alipay.config;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.lshaci.alipay.AbsSpringBaseTest;

public class AlipayConfigTest extends AbsSpringBaseTest {
	
	@Autowired
	private AlipayConfig alipayConfig;
	
	@Test
	public void testName() throws Exception {
		System.out.println("=====================");
		System.out.println(alipayConfig.getAppId());
	}

}

package com.lshaci.alipay.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.lshaci.alipay.SpringTest;
import com.lshaci.alipay.model.builder.AlipayTradePrecreateRequestBuilder;
import com.lshaci.alipay.model.result.AlipayF2FPrecreateResult;

public class AlipayTradeServiceTest extends SpringTest {
	
	@Autowired
	private AlipayTradeService alipayTradeService;
	
	String outTradeNo;
	String totalAmount;
	String subject;
	String storeId;
	String timeoutExpress;
	
	@Before
	public void before() {
		outTradeNo = System.currentTimeMillis() + "";
		totalAmount = "1000";
		subject = "测试中";
		storeId = "CS001";
		timeoutExpress = "30m";
	}

	@Test
	public void testTradePrecreate() {
		AlipayTradePrecreateRequestBuilder builder = new AlipayTradePrecreateRequestBuilder();

		builder.setOutTradeNo(outTradeNo);
		builder.setTotalAmount(totalAmount);
		builder.setSubject(subject);
		builder.setStoreId(storeId);
		builder.setTimeoutExpress(timeoutExpress);
		
		AlipayF2FPrecreateResult tradePrecreate = alipayTradeService.tradePrecreate(builder);
		System.out.println("==========================");
		System.out.println(tradePrecreate.getResponse().getQrCode());
	}

	@Test
	public void testTradePay() {
		fail("Not yet implemented");
	}

	@Test
	public void testQueryTradeResult() {
		fail("Not yet implemented");
	}

	@Test
	public void testTradeRefund() {
		fail("Not yet implemented");
	}

}

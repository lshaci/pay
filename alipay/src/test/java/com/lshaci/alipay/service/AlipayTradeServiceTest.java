package com.lshaci.alipay.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.lshaci.alipay.AbsSpringBaseTest;
import com.lshaci.alipay.model.builder.AlipayTradePrecreateRequestBuilder;
import com.lshaci.alipay.model.builder.AlipayTradeQueryRequestBuilder;
import com.lshaci.alipay.model.result.AlipayF2FPrecreateResult;
import com.lshaci.alipay.model.result.AlipayF2FQueryResult;

public class AlipayTradeServiceTest extends AbsSpringBaseTest {
	
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

		builder.setOutTradeNo(outTradeNo)
				.setTotalAmount(totalAmount)
				.setSubject(subject)
				.setStoreId(storeId)
				.setTimeoutExpress(timeoutExpress);
		
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
		AlipayTradeQueryRequestBuilder builder = new AlipayTradeQueryRequestBuilder();
		
		builder.setOutTradeNo("19455832784896522").setTradeNo(null);
		
		AlipayF2FQueryResult queryTradeResult = alipayTradeService.queryTradeResult(builder);
		System.err.println(queryTradeResult.getTradeStatus());
	}

	@Test
	public void testTradeRefund() {
		fail("Not yet implemented");
	}

}

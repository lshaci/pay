package com.lshaci.alipay.web.controller;

import java.io.IOException;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lshaci.alipay.config.AlipayConfig;
import com.lshaci.alipay.model.builder.AlipayTradePrecreateRequestBuilder;
import com.lshaci.alipay.model.result.AlipayF2FPrecreateResult;
import com.lshaci.alipay.service.AlipayTradeService;

@Controller
@RequestMapping("alipay")
public class AlipayController {
	
	@Autowired
	private AlipayTradeService alipayTradeService;
	
	@Autowired
	private AlipayConfig alipayConfig;
	
	@RequestMapping("pay")
	@ResponseBody
	public Object pay() {
		AlipayTradePrecreateRequestBuilder builder = new AlipayTradePrecreateRequestBuilder();

		builder.setOutTradeNo(System.currentTimeMillis() + "");
		builder.setTotalAmount("1000");
		builder.setSubject("笔记本电脑");
		builder.setStoreId("小超市");
		builder.setTimeoutExpress("30m");
		builder.setNotifyUrl(alipayConfig.getNotifyUrl());
		
		AlipayF2FPrecreateResult tradePrecreate = alipayTradeService.tradePrecreate(builder);
		System.out.println("==========================");
		System.out.println(tradePrecreate.getResponse().getQrCode());
		
		return tradePrecreate.getResponse().getQrCode();
	}
	
	@RequestMapping("result")
	public void result(HttpServletRequest request, HttpServletResponse response) throws IOException {
		for (Entry<String, String[]> entry : request.getParameterMap().entrySet()) {
			String key = entry.getKey();
			String[] value = entry.getValue();
			System.out.println("The key is : " + key);
			for (String v : value) {
				System.out.println("The value is : " + v);
			}
		}
		response.getWriter().print("SUCCESS");
	}
}

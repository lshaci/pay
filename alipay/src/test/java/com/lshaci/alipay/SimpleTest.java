package com.lshaci.alipay;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.lshaci.alipay.model.result.AlipayF2FNotifyResult;

public class SimpleTest {

	@Test
	public void testName() throws Exception {
		AlipayF2FNotifyResult result = new AlipayF2FNotifyResult();
		result.setNotifyId("123");
		
		Gson gson = new Gson();
		
		String json = gson.toJson(result);
		System.out.println("gson : " + json);
		System.out.println("fastjson : " + JSON.toJSONString(result));
		
		
		String jsonStr = "{\"notify_id\":\"123\"}";
		
		AlipayF2FNotifyResult fromJson = gson.fromJson(jsonStr, AlipayF2FNotifyResult.class);
		AlipayF2FNotifyResult notifyResult = JSON.parseObject(jsonStr, AlipayF2FNotifyResult.class);
		
		System.out.println("gson : " + fromJson.getNotifyId());
		System.out.println("fastjson : " + notifyResult.getNotifyId());
	}
}

package com.lshaci.alipay.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.StringUtils;

@Configuration
@PropertySource("classpath:config/properties/alipay.properties")
@ConfigurationProperties(prefix = "alipay.config")
public class AlipayConfig {
	
	private Logger logger = LoggerFactory.getLogger(AlipayConfig.class);

	private String gatewayUrl;		// 支付宝网关（固定）
	private String appId;			// 商户应用id
	private String privateKey;		// RSA私钥，用于对商户请求报文加签
	private String format;			// 参数返回格式，只支持json
	private String charset;			// 请求和签名使用的字符编码格式，支持GBK和UTF-8
	private String alipayPulicKey;	// 支付宝RSA公钥，用于验签支付宝应答
	private String signType;		// 签名类型  
	private String notifyUrl;		// 通知地址
	
	private int maxQueryRetry;   	// 最大查询次数
	private long queryDuration;  	// 查询间隔（毫秒）
	
	private int maxCancelRetry;  	// 最大撤销次数
	private long cancelDuration; 	// 撤销间隔（毫秒）
	private long heartbeatDelay ; 	// 交易保障线程第一次调度延迟（秒）
	private long heartbeatDuration; // 交易保障线程调度间隔（秒）
	
	
	@Bean
	public AlipayClient alipayClient() {
		validateClientParamter();
		logger.debug("Init alipayClient.");
		
		return new DefaultAlipayClient(gatewayUrl, appId, privateKey, format, charset, alipayPulicKey, signType);
	}
	
	/**
	 * 验证AlipayClient参数
	 */
	private void validateClientParamter() {
		if (StringUtils.isEmpty(gatewayUrl)) {
            throw new NullPointerException("gatewayUrl should not be NULL!");
        }
        if (StringUtils.isEmpty(appId)) {
            throw new NullPointerException("appid should not be NULL!");
        }
        if (StringUtils.isEmpty(privateKey)) {
            throw new NullPointerException("privateKey should not be NULL!");
        }
        if (StringUtils.isEmpty(format)) {
            throw new NullPointerException("format should not be NULL!");
        }
        if (StringUtils.isEmpty(charset)) {
            throw new NullPointerException("charset should not be NULL!");
        }
        if (StringUtils.isEmpty(alipayPulicKey)) {
            throw new NullPointerException("alipayPublicKey should not be NULL!");
        }
        if (StringUtils.isEmpty(signType)) {
            throw new NullPointerException("signType should not be NULL!");
        }
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	public String getGatewayUrl() {
		return gatewayUrl;
	}

	public void setGatewayUrl(String gatewayUrl) {
		this.gatewayUrl = gatewayUrl;
	}

	public String getPrivateKey() {
		return privateKey;
	}

	public void setPrivateKey(String privateKey) {
		this.privateKey = privateKey;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getCharset() {
		return charset;
	}

	public void setCharset(String charset) {
		this.charset = charset;
	}

	public String getAlipayPulicKey() {
		return alipayPulicKey;
	}

	public void setAlipayPulicKey(String alipayPulicKey) {
		this.alipayPulicKey = alipayPulicKey;
	}

	public String getSignType() {
		return signType;
	}

	public void setSignType(String signType) {
		this.signType = signType;
	}

	public int getMaxQueryRetry() {
		return maxQueryRetry;
	}

	public void setMaxQueryRetry(int maxQueryRetry) {
		this.maxQueryRetry = maxQueryRetry;
	}

	public long getQueryDuration() {
		return queryDuration;
	}

	public void setQueryDuration(long queryDuration) {
		this.queryDuration = queryDuration;
	}

	public int getMaxCancelRetry() {
		return maxCancelRetry;
	}

	public void setMaxCancelRetry(int maxCancelRetry) {
		this.maxCancelRetry = maxCancelRetry;
	}

	public long getCancelDuration() {
		return cancelDuration;
	}

	public void setCancelDuration(long cancelDuration) {
		this.cancelDuration = cancelDuration;
	}

	public long getHeartbeatDelay() {
		return heartbeatDelay;
	}

	public void setHeartbeatDelay(long heartbeatDelay) {
		this.heartbeatDelay = heartbeatDelay;
	}

	public long getHeartbeatDuration() {
		return heartbeatDuration;
	}

	public void setHeartbeatDuration(long heartbeatDuration) {
		this.heartbeatDuration = heartbeatDuration;
	}

	public String getNotifyUrl() {
		return notifyUrl;
	}

	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}
	
}

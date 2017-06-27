package com.lshaci.alipay.model.builder;

import com.google.gson.Gson;

/**
 * 请求构建对象
 */
public abstract class RequestBuilder {
	
    private String appAuthToken;
    
    /**
     * 通知地址
     */
    private String notifyUrl;
    
    /**
     * 
     */
    private Gson gson = new Gson();

    /**
     *  验证请求对象
     */
    public abstract boolean validate();

    /**
     *  获取bizContent对象，用于下一步转换为json字符串
     */
    public abstract Object getBizContent();

    /**
     *  将bizContent对象转换为json字符串
     */
    public String toJsonString() {
        // 使用gson将对象转换为json字符串
        return gson.toJson(this.getBizContent());
    }

    public String getAppAuthToken() {
        return appAuthToken;
    }

    public RequestBuilder setAppAuthToken(String appAuthToken) {
        this.appAuthToken = appAuthToken;
        return this;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public RequestBuilder setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
        return this;
    }
}

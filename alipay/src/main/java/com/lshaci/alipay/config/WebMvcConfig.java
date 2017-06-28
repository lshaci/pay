package com.lshaci.alipay.config;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.support.ConfigurableWebBindingInitializer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter4;
import com.lshaci.alipay.web.converter.String2DateConverter;

@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {
	
	private Logger logger = LoggerFactory.getLogger(WebMvcConfig.class);
	
	@Autowired
	private RequestMappingHandlerAdapter handlerAdapter;
	
	@PostConstruct
	public void addConversionCofig() {
		ConfigurableWebBindingInitializer initializer = (ConfigurableWebBindingInitializer) handlerAdapter.getWebBindingInitializer();
		
		if (initializer.getConversionService() != null) {
			GenericConversionService conversionService = (GenericConversionService) initializer.getConversionService();
			logger.debug("Config Converter, add String2DateConverter.");
			
			conversionService.addConverter(new String2DateConverter());
		}
	}
	
	@PostConstruct
	public void fastJsonHttpMessageConverter() {
		logger.debug("Init fastJsonHttpMessageConverter.");
		FastJsonHttpMessageConverter4 fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter4();
		
		List<MediaType> supportedMediaTypes = new ArrayList<>();
		supportedMediaTypes.add(MediaType.parseMediaType("text/html;charset=UTF-8"));
		supportedMediaTypes.add(MediaType.parseMediaType("application/json"));
		
		fastJsonHttpMessageConverter.setSupportedMediaTypes(supportedMediaTypes);
		fastJsonHttpMessageConverter.setFastJsonConfig(getFastJsonConfig());
		
		logger.debug("Add fastJsonHttpMessageConverter to messageConverters.");
		List<HttpMessageConverter<?>> messageConverters = super.requestMappingHandlerAdapter().getMessageConverters();
		messageConverters.add(fastJsonHttpMessageConverter);
	}
	
	private FastJsonConfig getFastJsonConfig() {
		logger.debug("Init FastJsonConfig.");
		
		FastJsonConfig fastJsonConfig = new FastJsonConfig();
		
		List<SerializerFeature> serializerFeatures = new ArrayList<>();
		serializerFeatures.add(SerializerFeature.WriteMapNullValue);
		serializerFeatures.add(SerializerFeature.WriteNullStringAsEmpty);
		
		SerializerFeature[] features = serializerFeatures.toArray(new SerializerFeature[serializerFeatures.size()]);
		fastJsonConfig.setSerializerFeatures(features);
		
		return fastJsonConfig;
	}

}

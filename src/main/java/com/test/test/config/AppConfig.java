package com.test.test.config;

import java.time.Duration;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.test.test.client.ApiRegionDaoImpl;

@Configuration
@Order(1000)
public class AppConfig {

	@Value("${rest-template.time.conn}")
	private Integer timeConn;
	
	@Value("${rest-template.time.read}")
	private Integer timeRead;
	
	@Value("${api-rest.local-region.url}") 
	private String urlApi;
	
	@Value("${api-rest.local-region.cant-reg}")
	private  Integer cantRegion;
	
	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
	public ApiRegionDaoImpl ApiRegionDao() {
		return new ApiRegionDaoImpl
				(restTemplate(), urlApi, cantRegion );
	}

	@Bean
	public RestTemplate restTemplate() {
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
	    converter.setSupportedMediaTypes(Collections.singletonList(MediaType.TEXT_HTML));
		 RestTemplate restTemplate = new RestTemplateBuilder()
					.setConnectTimeout(Duration.ofMillis(this.timeConn))
					.setReadTimeout(Duration.ofMillis(this.timeRead))
					.build();
		    
		    restTemplate.getMessageConverters().add(converter);
		 return restTemplate;
	}
}

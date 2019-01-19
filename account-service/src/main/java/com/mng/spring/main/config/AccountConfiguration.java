package com.mng.spring.main.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.mng.spring.main","com.mng.spring.controller", "com.mng.spring.exception", "com.mng.spring.model"})
public class AccountConfiguration {

	/*@Bean
	public AlwaysSampler defaultSampler() {
	  return new AlwaysSampler();
	}*/
	
}

package com.mng.spring.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableZuulProxy
@RestController
public class GatewayServiceApplication {

	// urls for testing apis
	
	//http://nagendra:8765/api/customer/
	//http://localhost:8765/api/customer/customers/1
	//http://nagendra:8765/api/customer/
	//http://nagendra:8765/api/account/
	
	//http://localhost:2222/actuator/hystrix.stream
	
	//load balance check 
	//http://localhost:8765/api/customer/customers/ribbon
	
	//dasbord
	//http://localhost:2222/hystrix
	//http://localhost:3333/hystrix
	
	//http://localhost:3333/actuator/hystrix.stream
	
	public static void main(String[] args) {
		SpringApplication.run(GatewayServiceApplication.class, args);
	}

}


package com.mng.spring.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableZuulProxy
@RestController
public class GatewayServiceApplication {

	//http://nagendra:8765/api/customer/customers/1
	//http://nagendra:8765/api/customer/
	//http://nagendra:8765/api/account/
	public static void main(String[] args) {
		SpringApplication.run(GatewayServiceApplication.class, args);
	}

}


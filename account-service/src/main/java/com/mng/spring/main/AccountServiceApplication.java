package com.mng.spring.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AccountServiceApplication {

	//http://localhost:2222/accounts
	//http://localhost:2222/
	public static void main(String[] args) {
		SpringApplication.run(AccountServiceApplication.class, args);
	}

}


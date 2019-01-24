package com.mng.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import zipkin.server.EnableZipkinServer;

@SpringBootApplication
@EnableZipkinServer
public class PaymentZipkinServerApplication {

	// http://localhost:9411/
	public static void main(String[] args) {
		SpringApplication.run(PaymentZipkinServerApplication.class, args);
	}

}


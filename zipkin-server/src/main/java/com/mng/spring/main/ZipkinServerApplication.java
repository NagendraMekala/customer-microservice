package com.mng.spring.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import zipkin.server.EnableZipkinServer;

@SpringBootApplication
@EnableZipkinServer
public class ZipkinServerApplication {

	//http://localhost:9411/zipkin/
	public static void main(String[] args) {
		SpringApplication.run(ZipkinServerApplication.class, args);
	}

}


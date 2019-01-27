package com.mng.spring.main.controller;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mng.spring.main.model.Account;

@RestController
public class AccountEndpoint {

	private List<Account> accounts;
	
    @Autowired
    Environment environment;

	private static final Logger logger = LoggerFactory.getLogger(AccountEndpoint.class);

	public AccountEndpoint() {
		accounts = new ArrayList<>();
		accounts.add(new Account(1, 1, "111111", "Nagendra"));
		accounts.add(new Account(2, 2, "222222", "Scala"));
		accounts.add(new Account(3, 3, "333333", "java"));
		accounts.add(new Account(4, 4, "444444", "spark"));
		accounts.add(new Account(5, 1, "555555", "spring"));
		accounts.add(new Account(6, 2, "666666", "angular"));
		accounts.add(new Account(7, 2, "777777", "docker"));
	}
	
	@RequestMapping("/accounts/{number}")
	public Account findByNumber(@PathVariable("number") String number) {
		logger.info(String.format("Account.findByNumber(%s)", number));
		return accounts.stream().filter(it -> it.getNumber().equals(number)).findFirst().get();
	}
	
	@RequestMapping("/accounts/customer/{customer}")
	public List<Account> findByCustomer(@PathVariable("customer") Integer customerId) {
		logger.info(String.format("Account.findByCustomer(%s)", customerId));
		return accounts.stream().filter(it -> it.getCustomerId().intValue()==customerId.intValue()).collect(Collectors.toList());
	}
	
	@RequestMapping("/accounts")
	public List<Account> findAll() {
		logger.info("Account.findAll()");
		return accounts;
	}
	
    @RequestMapping("/")	
	public String hello() {
		return "wel come to account service";
	}
    
    @RequestMapping(value = "/accounts/elkdemo")
    public String helloWorld() {
        String response = "Hello user ! " + new Date();
        logger.info("/elkdemo - &gt; " + response);
        return response;
    }
    
    @RequestMapping(value = "/accounts/exception")
    public String exception() {
        String rsp = "";
        try {
            int i = 1 / 0;
            // should get exception
        } catch (Exception e) {
            e.printStackTrace();
            logger.info(e.toString());
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            String sStackTrace = sw.toString(); // stack trace as a string
            logger.info("Exception As String :: - &gt; "+sStackTrace);
             
            rsp = sStackTrace;
        }
        return rsp;
    }
    
    @RequestMapping("/accounts/ribbon")
    public String backend() {
        System.out.println("Inside MyRestController::backend...");
 
        String serverPort = environment.getProperty("local.server.port");
 
        System.out.println("Port : " + serverPort);
 
        return "Hello form Backend!!! " + " Host : localhost " + " :: Port : " + serverPort;
    }
	
}

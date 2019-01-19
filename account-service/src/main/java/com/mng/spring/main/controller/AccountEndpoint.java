package com.mng.spring.main.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mng.spring.main.model.Account;

@RestController
public class AccountEndpoint {

	private List<Account> accounts;
	
	protected Logger logger = Logger.getLogger(AccountEndpoint.class.getName());
	
	public AccountEndpoint() {
		accounts = new ArrayList<>();
		accounts.add(new Account(1, 1, "111111","Nagendra"));
		accounts.add(new Account(2, 2, "222222","Scala"));
		accounts.add(new Account(3, 3, "333333","java"));
		accounts.add(new Account(4, 4, "444444","spark"));
		accounts.add(new Account(5, 1, "555555","spring"));
		accounts.add(new Account(6, 2, "666666","angular"));
		accounts.add(new Account(7, 2, "777777","docker"));
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
	
}

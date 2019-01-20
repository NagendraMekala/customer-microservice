package com.mng.spring.main.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mng.spring.main.client.AccountClient;
import com.mng.spring.main.model.Account;
import com.mng.spring.main.model.Customer;
import com.mng.spring.main.model.CustomerType;


@RestController
public class CustomerEndpoint {
	
	@Autowired
	private AccountClient accountClient;
	
	 private static final Logger logger = LoggerFactory.getLogger(CustomerEndpoint.class);
	
	//protected Logger logger = Logger.getLogger(CustomerEndpoint.class.getName());
	
	private List<Customer> customers;
	
	public CustomerEndpoint() {
		customers = new ArrayList<>();
		customers.add(new Customer(1, "12345", "Adam Kowalski", CustomerType.INDIVIDUAL));
		customers.add(new Customer(2, "12346", "Anna Malinowska", CustomerType.INDIVIDUAL));
		customers.add(new Customer(3, "12347", "Paweł Michalski", CustomerType.INDIVIDUAL));
		customers.add(new Customer(4, "12348", "Karolina Lewandowska", CustomerType.INDIVIDUAL));
	}
	
	@RequestMapping("/customers/pesel/{pesel}")
	public Customer findByPesel(@PathVariable("pesel") String pesel) {
		logger.info(String.format("Customer.findByPesel(%s)", pesel));
		return customers.stream().filter(it -> it.getPesel().equals(pesel)).findFirst().get();	
	}
	
	//http://localhost:3333/customers
	@RequestMapping("/customers")
	public List<Customer> findAll() {
		logger.info("Customer.findAll()");
		return customers;
	}
	
	@RequestMapping("/customers/{id}")
	public Customer findById(@PathVariable("id") Integer id) {
		logger.info(String.format("Customer.findById(%s)", id));
		Customer customer = customers.stream().filter(it -> it.getId().intValue()==id.intValue()).findFirst().get();
		List<Account> accounts =  accountClient.getAccounts(id);
		customer.setAccounts(accounts);
		return customer;
	}
	
	@RequestMapping("/")
	public String hello() {
		logger.info("Account.hello()");
		return "welcome to cstomer service application";
	}
	
	@RequestMapping(value = "/customers/elk")
	public String helloWorld1() {
		String response = accountClient.helloWorld();
		logger.info("/elk - &gt; " + response);

		try {
			String exceptionrsp = accountClient.exception();
			logger.info("/elk trying to print exception - &gt; " + exceptionrsp);
			response = response + " === " + exceptionrsp;
		} catch (Exception e) {
			// exception should not reach here. Really bad practice 🙂
		}
		return response;
	}
}

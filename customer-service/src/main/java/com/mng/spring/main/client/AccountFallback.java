package com.mng.spring.main.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.mng.spring.main.model.Account;

@Component
public class AccountFallback implements AccountClient {

	@Override
	public List<Account> getAccounts(Integer customerId) {
		List<Account> acc = new ArrayList<Account>();
		return acc;
	}

	@Override
	public String helloWorld() {
		return "fall back helloWorld() is executed due to account service down";
	}

	@Override
	public String exception() {
		return "fall back exception() is executed due to account service down";
	}

	@Override
	public String backend() {
		return "fall back backend() is executed due to account service down";
	}
}
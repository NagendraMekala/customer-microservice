package com.mng.spring.main.model;

public class Account {

	private Integer id;
	private Integer customerId;
	private String number;
	private String name;

	public Account() {	}
	
	public Account(Integer id, Integer customerId, String number, String name) {
		this.id = id;
		this.customerId = customerId;
		this.number = number;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
}

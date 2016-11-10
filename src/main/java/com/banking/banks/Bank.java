package com.banking.banks;

public class Bank {
	private int bank_id;
	private String name;
	
	public Bank(int bank_id, String name) {
		super();
		this.bank_id = bank_id;
		this.name = name;
	}
	
	public int getBank_id() {
		return bank_id;
	}
	public void setBank_id(int bank_id) {
		this.bank_id = bank_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}

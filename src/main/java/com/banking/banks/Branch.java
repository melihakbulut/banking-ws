package com.banking.banks;

public class Branch {
	private int branch_id,bank_id,city_id;
	private String name;
	public Branch(int branch_id, int bank_id, int city_id, String name) {
		super();
		this.branch_id = branch_id;
		this.bank_id = bank_id;
		this.city_id = city_id;
		this.name = name;
	}
	
	public int getBranch_id() {
		return branch_id;
	}
	public void setBranch_id(int branch_id) {
		this.branch_id = branch_id;
	}
	public int getBank_id() {
		return bank_id;
	}
	public void setBank_id(int bank_id) {
		this.bank_id = bank_id;
	}
	public int getCity_id() {
		return city_id;
	}
	public void setCity_id(int city_id) {
		this.city_id = city_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
		
	
}

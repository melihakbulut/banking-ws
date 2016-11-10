package com.banking.banks;

public class SampleBranch {

	private String bankname;
	private String branch;
	private String city;
	
	public SampleBranch(String bankname,String branch,String city){
		this.bankname=bankname;
		this.branch=branch;
		this.city=city;
	}
	
	public SampleBranch(){
		
	}

	public String getBankname() {
		return bankname;
	}

	public void setBankname(String bankname) {
		this.bankname = bankname;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
}

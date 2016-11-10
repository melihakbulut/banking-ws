package com.banking.Entity;

public class DepositAccount extends BaseAccount {

	private int accountType,av_id;
	private String term;//in terms of Day
	private double interestRate;
	
	public DepositAccount(){
		
	}
	
	public DepositAccount(String a_id, int c_id, int currency, double balance,
			String creationDate, int status,int accountType,String term,double interestRate,int av_id) {
		super(a_id, c_id, currency, balance, creationDate, status);
		// TODO Auto-generated constructor stub
		this.av_id=av_id;
		this.accountType=accountType;
		this.term=term;
		this.interestRate=interestRate;
	}
	
	public int getAv_id() {
		return av_id;
	}

	public void setAv_id(int av_id) {
		this.av_id = av_id;
	}
	public int getAccountType() {
		return accountType;
	}

	public void setAccountType(int accountType) {
		this.accountType = accountType;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	
	

}

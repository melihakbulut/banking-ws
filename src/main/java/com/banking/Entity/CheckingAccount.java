package com.banking.Entity;

import java.util.Date;

public class CheckingAccount extends BaseAccount {
	
	private String IBAN;
	private double dailyTransferLimit;

	public CheckingAccount(){
		
	}
	
	public CheckingAccount(String a_id, int c_id, int currency, double balance,
			String creationDate, int status,String IBAN,double dailyTransferLimit) {
		super(a_id, c_id, currency, balance, creationDate, status);
		this.IBAN=IBAN;
		this.dailyTransferLimit=dailyTransferLimit;
	}
	

	public String getIBAN() {
		return IBAN;
	}

	public void setIBAN(String iBAN) {
		IBAN = iBAN;
	}

	public double getDailyTransferLimit() {
		return dailyTransferLimit;
	}

	public void setDailyTransferLimit(double dailyTransferLimit) {
		this.dailyTransferLimit = dailyTransferLimit;
	}
	
	

	
}

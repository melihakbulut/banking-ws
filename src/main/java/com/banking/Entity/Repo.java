package com.banking.Entity;

public class Repo {

	private int r_id, status;
	private String a_id, startDate, endDate;
	private double amount, interestRate;

	public Repo() {

	}

	public Repo(int r_id, int status, String a_id, String startDate,
			String endDate, double amount, double interestRate) {
		super();
		this.r_id = r_id;
		this.status = status;
		this.a_id = a_id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.amount = amount;
		this.interestRate = interestRate;
	}

	public int getR_id() {
		return r_id;
	}

	public void setR_id(int r_id) {
		this.r_id = r_id;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getA_id() {
		return a_id;
	}

	public void setA_id(String a_id) {
		this.a_id = a_id;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

}

package com.banking.Entity;

public class Payment {

	private int p_id,paymentType;
	private String a_id,paymentInfo,transcDate;
	private double amount;
	
	public Payment(){
		
	}
	
	public Payment(int p_id, int paymentType, String a_id, String paymentInfo,
			String transcDate, double amount) {
		super();
		this.p_id = p_id;
		this.paymentType = paymentType;
		this.a_id = a_id;
		this.paymentInfo = paymentInfo;
		this.transcDate = transcDate;
		this.amount = amount;
	}

	public int getP_id() {
		return p_id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}

	public int getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(int paymentType) {
		this.paymentType = paymentType;
	}

	public String getA_id() {
		return a_id;
	}

	public void setA_id(String a_id) {
		this.a_id = a_id;
	}

	public String getPaymentInfo() {
		return paymentInfo;
	}

	public void setPaymentInfo(String paymentInfo) {
		this.paymentInfo = paymentInfo;
	}

	public String getTranscDate() {
		return transcDate;
	}

	public void setTranscDate(String transcDate) {
		this.transcDate = transcDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
}

package com.banking.Entity;

public class Installment {
	private int i_id, status;
	private String card_id, company, term, transcDate,productName;
	private Double amount;
	
	public Installment(){
		
	}

	public Installment(int i_id, int status, String card_id, String company,
			String term, String transcDate, Double amount,String productName) {
		super();
		this.i_id = i_id;
		this.status = status;
		this.card_id = card_id;
		this.company = company;
		this.term = term;
		this.transcDate = transcDate;
		this.amount = amount;
		this.productName=productName;
	}
	

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getI_id() {
		return i_id;
	}

	public void setI_id(int i_id) {
		this.i_id = i_id;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getCard_id() {
		return card_id;
	}

	public void setCard_id(String card_id) {
		this.card_id = card_id;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public String getTranscDate() {
		return transcDate;
	}

	public void setTranscDate(String transcDate) {
		this.transcDate = transcDate;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

}

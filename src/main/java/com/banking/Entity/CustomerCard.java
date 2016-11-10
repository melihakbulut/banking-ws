package com.banking.Entity;

public class CustomerCard {

	private String card_id,password;
	private int c_id,cardType,cardStatus,cardClass;
	private double cardLimit;
	
	public CustomerCard(){
		
	}
	public CustomerCard(String card_id, int c_id, String password,
			int cardType, int cardStatus, double cardLimit,int cardClass) {
		super();
		this.card_id = card_id;
		this.c_id = c_id;
		this.password = password;
		this.cardType = cardType;
		this.cardStatus = cardStatus;
		this.cardLimit = cardLimit;
		this.cardClass=cardClass;
	}
	
	public int getCardClass() {
		return cardClass;
	}
	public void setCardClass(int cardClass) {
		this.cardClass = cardClass;
	}
	public String getCard_id() {
		return card_id;
	}
	public void setCard_id(String card_id) {
		this.card_id = card_id;
	}
	public int getC_id() {
		return c_id;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getCardType() {
		return cardType;
	}
	public void setCardType(int cardType) {
		this.cardType = cardType;
	}
	public int getCardStatus() {
		return cardStatus;
	}
	public void setCardStatus(int cardStatus) {
		this.cardStatus = cardStatus;
	}
	public double getCardLimit() {
		return cardLimit;
	}
	public void setCardLimit(double cardLimit) {
		this.cardLimit = cardLimit;
	}
	
}

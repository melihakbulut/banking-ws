package com.banking.Entity;

public class TransferBasedOnNumber {
	private int t_id,transferType;
	private String a_id,transferInfo,transacDate,desc;
	private double amount;
	
	public TransferBasedOnNumber(){
		
	}
	
	public TransferBasedOnNumber(int t_id, int transferType, String a_id,
			String transferInfo, String transacDate, String desc, double amount) {
		super();
		this.t_id = t_id;
		this.transferType = transferType;
		this.a_id = a_id;
		this.transferInfo = transferInfo;
		this.transacDate = transacDate;
		this.desc = desc;
		this.amount = amount;
	}

	public int getT_id() {
		return t_id;
	}

	public void setT_id(int t_id) {
		this.t_id = t_id;
	}

	public int getTransferType() {
		return transferType;
	}

	public void setTransferType(int transferType) {
		this.transferType = transferType;
	}

	public String getA_id() {
		return a_id;
	}

	public void setA_id(String a_id) {
		this.a_id = a_id;
	}

	public String getTransferInfo() {
		return transferInfo;
	}

	public void setTransferInfo(String transferInfo) {
		this.transferInfo = transferInfo;
	}

	public String getTransacDate() {
		return transacDate;
	}

	public void setTransacDate(String transacDate) {
		this.transacDate = transacDate;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
}

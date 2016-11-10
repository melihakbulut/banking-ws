package com.banking.Entity;

public class TransferBasedOnName extends TransferBasedOnNumber {

	private String receiverFullname,address;
	
	public TransferBasedOnName(){
		
	}
	
	public TransferBasedOnName(int t_id, int transferType, String a_id,
			String transferInfo, String transacDate, String desc, double amount,
			String receiverFullname,String address) {
		super(t_id, transferType, a_id, transferInfo, transacDate, desc, amount);
		
		this.receiverFullname=receiverFullname;
		this.address=address;
	}

	public String getReceiverFullname() {
		return receiverFullname;
	}

	public void setReceiverFullname(String receiverFullname) {
		this.receiverFullname = receiverFullname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
}

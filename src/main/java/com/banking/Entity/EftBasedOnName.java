package com.banking.Entity;

public class EftBasedOnName extends EftBaseClass {

	private String receiverMobile;
	
	public EftBasedOnName(){
		
	}
	
	public EftBasedOnName(int e_id, String a_id, String transferInfo,
			String receiverFullname, String receiver_identification_no,
			String transacDate, String desc, double amount,String receiverMobile) {
		super(e_id, a_id, transferInfo, receiverFullname, receiver_identification_no,
				transacDate, desc, amount);
		
		this.receiverMobile=receiverMobile;
	}

	public String getReceiverMobile() {
		return receiverMobile;
	}

	public void setReceiverMobile(String receiverMobile) {
		this.receiverMobile = receiverMobile;
	}

}

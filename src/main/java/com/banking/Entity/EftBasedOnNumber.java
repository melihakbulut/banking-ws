package com.banking.Entity;

public class EftBasedOnNumber extends EftBaseClass {

	private int transferType;
	
	public EftBasedOnNumber(){
		
	}
	
	public EftBasedOnNumber(int e_id, String a_id, String transferInfo,
			String receiverFullname, String receiver_identification_no,
			String transacDate, String desc, double amount,int transferType) {
		super(e_id, a_id, transferInfo, receiverFullname, receiver_identification_no,
				transacDate, desc, amount);
			
			this.transferType=transferType;
	}

	public int getTransferType() {
		return transferType;
	}

	public void setTransferType(int transferType) {
		this.transferType = transferType;
	}

}

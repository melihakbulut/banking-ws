package com.banking.generate_validation;

import java.util.Random;

public class TcNumber {

	private String number;
	
	public TcNumber(String number){
		this.number=number;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
	public boolean isValid(){
		boolean status=false;
		if(!number.substring(0,1).equals("0") && number.length()==11){
		
		int total_1=0;
		int total_2=0;
		for (int i = 0; i < number.length()-2; i++) {
			if(i%2==0)
			total_1+=Integer.parseInt(number.substring(i, i+1));
			else if(i%2==1)
			total_2+=Integer.parseInt(number.substring(i, i+1));
		}
		int num10=(total_1*7-total_2)%10;
		int num11=(total_1+total_2+num10)%10;
		if(num10==Integer.parseInt(number.substring(number.length()-2,number.length()-1)) && 
			num11==Integer.parseInt(number.substring(number.length()-1,number.length())))
			status=true;
		}
		
		return status;
	}
	
	
	public static String generateNumber(){
		String number="";
		Random rnd=new Random();
		number+=String.valueOf(rnd.nextInt(8)+1);
		for (int i = 1; i <=8 ; i++) 
			number+=String.valueOf(rnd.nextInt(9));	
		
		int total_1=0;
		int total_2=0;
		for (int i = 0; i < number.length(); i++) {
			if(i%2==0)
			total_1+=Integer.parseInt(number.substring(i, i+1));
			else if(i%2==1)
			total_2+=Integer.parseInt(number.substring(i, i+1));
		}
		int num10=(total_1*7-total_2)%10;
		int num11=(total_1+total_2+num10)%10;
		number+=String.valueOf(num10)+String.valueOf(num11);
		
		return number;
		
		
		
	}
	
}

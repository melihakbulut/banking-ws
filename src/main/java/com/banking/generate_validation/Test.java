package com.banking.generate_validation;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Minutes;
import org.joda.time.Seconds;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.banking.Entity.Customer;
import com.banking.enums.GRUD_Enum;
import com.banking.repository.CustomerRepository;
import com.banking.repository.DateType;

public class Test {
	
	
	public static void main(String[] args) {
					
//			for (int i = 0; i < 10; i++) {
//				System.out.println(CreditCard.getCardClass().isValidCreditCardNumber(CreditCard.getCardClass().generateAmericanExpressCardNumber())+" - Amx");
//				System.out.println(CreditCard.getCardClass().isValidCreditCardNumber(CreditCard.getCardClass().generateMasterCardNumber())+" - MASTER");
//				System.out.println(CreditCard.getCardClass().isValidCreditCardNumber(CreditCard.getCardClass().generateVisaCardNumber())+" - Visa");
//			}
		
//		DateTimeFormatter formatter = DateTimeFormat.forPattern("YYYY-MM-dd HH:mm:ss");
//	    String mysqldatetime = "2016-04-18 19:16:59";
//	    DateTime dt1 = formatter.parseDateTime(mysqldatetime); 
//	    
//		DateTimeFormatter formatter = DateTimeFormat.forPattern("YYYY-MM-dd HH:mm:ss");
//		DateTime dt2 = DateTime.now();
//		System.out.println(DateType.formatDate(dt2));
		
////		int days = Seconds.secondsBetween(dt1, dt2).getSeconds();
////		System.out.println("Remaining "+days/60+" minutes "+ days%60+" seconds left");
		
//		CustomerRepository cr=new CustomerRepository();
//		Customer c2=new Customer(3,"Melih Akbulut3","5374004103","melih.akbulut386@gmail.com","asdasdasfasdfasdasdfadasdasdasd asdas dasdasfasd","24581574804"
//				,DateType.formatDate(DateTime.now()),DateType.formatDate(DateTime.now()),"192.168.2.1","password12345678",1);
//		
//		System.out.println(cr.save(c2, GRUD_Enum.UPDATE));
		
//		CustomerRepository cr=new CustomerRepository();
//		System.out.println(cr.Delete(null));
		
//		CustomerRepository cr=new CustomerRepository();
//		Customer c=cr.login("24581574804", "password12345678");
//		System.out.println(c.getId());
//		System.out.println(c.getFullname());
//		System.out.println(c.getMobile());
//		System.out.println(c.getMail());
//		System.out.println(c.getAddress());
//		System.out.println(c.getId_num());
//		System.out.println(c.getPassword());
//		System.out.println(DateType.toDateTime(c.getRegisterDate()));
//		System.out.println(DateType.toDateTime(c.getLastLoginDate()));
//		System.out.println(c.getLastLoginIP());
//		System.out.println(c.getStatus());
//		
//		int days = Seconds.secondsBetween(DateType.toDateTime(c.getRegisterDate()), DateType.toDateTime(c.getLastLoginDate())).getSeconds();
//		System.out.println("Remaining "+days/60+" minutes "+ days%60+" seconds left");
		
		DateTime date=new DateTime();
		System.out.println();
		
		if(Seconds.secondsBetween(DateType.toDateTime("2016-05-01 19:13:21"), DateType.toDateTime("2016-11-01 19:13:21")).getSeconds()<=0)
			System.out.println("geçmiþ");
		else
			System.out.println("In progress...");
		
	}
}

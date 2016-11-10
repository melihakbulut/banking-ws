package com.banking.repository;

import java.util.List;

import org.joda.time.DateTime;

import com.banking.Entity.CheckingAccount;
import com.banking.Entity.Customer;
import com.banking.banks.Bank;
import com.banking.banks.Branch;
import com.banking.banks.City;
import com.banking.enums.Currency_Enum;
import com.banking.enums.GRUD_Enum;
import com.banking.transferService.CheckService;

public class TestRepository {

	public static void main(String[] args) {
		
//		CustomerRepository cr=new CustomerRepository();
//		Customer c=cr.login("melih akb", "melih akb");
//		System.out.println(c.getFullname());
//		
//		CustomerCardRepository ccr=new CustomerCardRepository();
//		List<CustomerCard> cards=(List<CustomerCard>)ccr.getRecord(c);
//		
//		for (CustomerCard cc : cards) {
//			System.out.print(cc.getC_id()+" - ");
//			System.out.print(cc.getCard_id()+" - ");
//			System.out.print(cc.getPassword()+" - ");
//			System.out.print(cc.getCardType()+" - ");
//			System.out.print(cc.getCardLimit()+" - ");
//			System.out.println(cc.getCardStatus());
//		}

//		CustomerCard card=new CustomerCard();
//		card.setCardLimit(6358);
//		card.setPassword("124123123");
//		card.setCardType(Card_Enum.BANK_CARD);
//		card.setCardStatus(1);
//		card.setCardClass(Card_Enum.AMEX);
//		card.setC_id(c.getId());
//		
//		CustomerCardRepository ccr=new CustomerCardRepository();
//		System.out.println(ccr.save(card, GRUD_Enum.INSERT));
			
//		CustomerRepository cr=new CustomerRepository();
//		Customer c=cr.login("24581574804", "password12345678");
//		System.out.println(c.getFullname());
			 
//			 CheckingAccount acc=new CheckingAccount();
//			 acc.setC_id(c.getId());
//			 acc.setCurrency(Currency_Enum.TL);
//			 acc.setBalance(125000);
//			 acc.setDailyTransferLimit(15000);
//			 acc.setCreationDate(DateType.formatDate(DateTime.now()));
//			 acc.setStatus(1);
		
//		CheckingAccount acc=new CheckingAccount();
//		acc.setIBAN("TR8169786Z4CR8XH1MXVECHT9H");
//		acc.setDailyTransferLimit(4512.45);
//		acc.setStatus(0);
//		acc.setBalance(202000);
			 
//			 CheckingAccountRepository car=new CheckingAccountRepository();
//			 //System.out.println(car.save(acc, GRUD_Enum.INSERT));
//			 List<CheckingAccount> accounts=(List<CheckingAccount>)car.getRecord(c);
//			 for (CheckingAccount acc : accounts) {
//				System.out.print(acc.getA_id()+" - ");
//				System.out.print(acc.getC_id()+" - ");
//				System.out.print(acc.getIBAN()+" - ");
//				System.out.print(acc.getCurrency()+" - ");
//				System.out.print(acc.getBalance()+" - ");
//				System.out.print(acc.getDailyTransferLimit()+" - ");
//				System.out.print(DateType.toDateTime(acc.getCreationDate())+" - ");
//				System.out.println(acc.getStatus()+" - ");
//			}
			 
//			 DepositAccount dacc=new DepositAccount();
//			 dacc.setC_id(c.getId());
//			 dacc.setAccountType(Account_Enum.E_DepositAcc);
//			 dacc.setCurrency(Currency_Enum.DOLLAR);
//			 dacc.setBalance(40000.65);
//			 dacc.setCreationDate(DateType.formatDate(DateTime.now()));
//			 dacc.setStatus(1);
//			 dacc.setTerm("180");
//			 dacc.setInterestRate(5.1);
//			 dacc.setAv_id(2);
//			 
//			 DepositAccountRepository daccr=new DepositAccountRepository();
//			 System.out.println(daccr.save(dacc, GRUD_Enum.UPDATE));
		
//			 DepositAccountRepository daccr=new DepositAccountRepository();
//			 List<DepositAccount> accounts=(List<DepositAccount>)daccr.getRecord(c);
//			 
//			 for (DepositAccount depositAccount : accounts) {
//				System.out.print(depositAccount.getAv_id()+" - ");
//				System.out.print(depositAccount.getBalance()+" - ");
//				System.out.print(depositAccount.getTerm()+" - ");
//				System.out.println(depositAccount.getInterestRate());
//			}
		

			
//			Payment p=new Payment();
//			p.setA_id(a_id);
//			p.setPaymentType(2);
//			p.setPaymentInfo("json 979845184515");
//			p.setTranscDate(DateType.formatDate(DateTime.now()));
//			p.setAmount(458.20);
//			
//			PaymentRepository pr=new PaymentRepository();
//			System.out.println(pr.save(p, GRUD_Enum.INSERT));
			
//			PaymentRepository pr=new PaymentRepository();
//			List<Payment> payments=(List<Payment>)pr.getRecord(cha);
//			
//			for (Payment p : payments) {
//				System.out.print(p.getP_id()+" - ");
//				System.out.print(p.getA_id()+" - ");
//				System.out.print(p.getPaymentType()+" - ");
//				System.out.print(p.getPaymentInfo()+" - ");
//				System.out.print(DateType.toDateTime(p.getTranscDate()) + " - ");
//				System.out.println(p.getAmount());
//			}
			
//			CustomerCardRepository ccr=new CustomerCardRepository();
//			List<CustomerCard> accounts=(List<CustomerCard>)ccr.getRecord(c);
//			String card_id="";
//			CustomerCard card=null;
//			for (CustomerCard customerCard : accounts) {
//				if(customerCard.getCardLimit()>=7000){
//					card_id=customerCard.getCard_id();
//					card=customerCard;
//				}
//			}
			
//			Installment ins=new Installment();
//			ins.setCard_id(card_id);
//			ins.setCompany("Migros");
//			ins.setProductName("Migros");
//			ins.setAmount(100.00);
//			ins.setTerm("0");
//			ins.setTranscDate(DateType.formatDate(DateTime.now()));
//			ins.setStatus(1);
//			
//			InstallmentRepository ir=new InstallmentRepository();
//			System.out.println(ir.save(ins, GRUD_Enum.INSERT));
			
//			InstallmentRepository ir=new InstallmentRepository();
//			List<Installment> payments=(List<Installment>)ir.getRecord(card);
//			
//			for (Installment installment : payments) {
//				System.out.print(installment.getI_id()+" - ");
//				System.out.print(installment.getCard_id()+" - ");
//				System.out.print(installment.getCompany()+" - ");
//				System.out.print(installment.getProductName()+" - ");
//				System.out.print(installment.getAmount()+" - ");
//				System.out.print(installment.getTerm()+" - ");
//				System.out.print(DateType.toDateTime(installment.getTranscDate())+" - ");
//				System.out.println(installment.getStatus());
//			}
			
//			Installment ins=new Installment();
//			ins.setI_id(3);
//			ins.setStatus(0);
//			
//			InstallmentRepository ir=new InstallmentRepository();
//			ir.save(ins, GRUD_Enum.UPDATE);
		
//			Repo repo=new Repo();
//			repo.setA_id(cha.getA_id());
//			repo.setStartDate(DateType.formatDate(DateTime.now()));
//			repo.setEndDate(DateType.formatDate(DateTime.now().plusMonths(6)));
//			repo.setAmount(150000);
//			repo.setStatus(1);
//			repo.setInterestRate(8);
//			repo.setR_id(1);
//			
//			RepoRepository rr=new RepoRepository();
//			System.out.println(rr.save(repo, GRUD_Enum.UPDATE));
		
//			CustomerRepository cr=new CustomerRepository();
//			Customer c=cr.login("24581574804", "password12345678");
//			System.out.println(c.getFullname());
//		
//			CheckingAccountRepository car=new CheckingAccountRepository();
//			List<CheckingAccount> accounts=(List<CheckingAccount>)car.getRecord(c);
//			CheckingAccount cha=null,cha2=null;
//			
//			for (CheckingAccount checkingAccount : accounts) {
//				if(checkingAccount.getCurrency()==Currency_Enum.TL){
//				cha=checkingAccount;
//				}
//				if(checkingAccount.getCurrency()==Currency_Enum.DOLLAR)
//					cha2=checkingAccount;
//			}
			
//			DepositAccountRepository dar=new DepositAccountRepository();
//			List<DepositAccount> Daccounts=(List<DepositAccount>)dar.getRecord(c);
//			DepositAccount dha=null;
//			
//			for (DepositAccount d : Daccounts) {
//				if(d.getCurrency()==Currency_Enum.TL){
//					dha=d;
//				}
//			}
			
//			RepoRepository rr=new RepoRepository();
//			List<Repo> repos=(List<Repo>)rr.getRecord(cha);
//			
//			DateTime dt1 = null,dt2 = null;
//			for (Repo repo : repos) {
//				System.out.print(repo.getR_id()+" - ");
//				System.out.print(repo.getA_id()+" - ");
//				dt1=DateType.toDateTime(repo.getStartDate());
//				dt2=DateType.toDateTime(repo.getEndDate());
//				System.out.print(DateType.toDateTime(repo.getStartDate())+" - ");
//				System.out.print(DateType.toDateTime(repo.getEndDate())+" - ");
//				System.out.print(repo.getAmount()+" - ");
//				System.out.print(repo.getStatus()+" - ");
//				System.out.println(repo.getInterestRate()+" - ");
//			}
//			
//			String b=DateType.getProperDateBetween(DateTime.now(), dt2);
//			System.out.println(b);
		
//			TransferBasedOnName tno=new TransferBasedOnName();
//			tno.setA_id(cha.getA_id());
//			tno.setTransferType(2);
//			tno.setTransferInfo("JSON trasfasfasdasdasd ");
//			tno.setReceiverFullname("Melih Akbulut");
//			tno.setAddress("asdagsd cad. asdadasd sok. no:20 d:8");
//			tno.setTransacDate(DateType.formatDate(DateTime.now()));
//			tno.setAmount(5000);
//			tno.setDesc("dfgdrer");
//			
//			TransferBasedOnNameRepository tnor=new TransferBasedOnNameRepository();
//			//System.out.println(tnor.save(tno, GRUD_Enum.INSERT));
//			List<TransferBasedOnName> tnos=(List<TransferBasedOnName>)tnor.getRecord(cha);
//			
//			for (TransferBasedOnName t : tnos) {
//				System.out.print(t.getT_id()+" - ");
//				System.out.print(t.getA_id()+" - ");
//				System.out.print(t.getTransferType()+" - ");
//				System.out.print(t.getReceiverFullname()+" - ");
//				System.out.print(t.getAddress()+" - ");
//				System.out.print(t.getTransferInfo()+" - ");
//				System.out.print(t.getTransacDate()+" - ");
//				System.out.print(t.getAmount()+" - ");
//				System.out.println(t.getDesc()+" - ");
//			}
			
//			EftBasedOnName eno=new EftBasedOnName();
//			eno.setA_id(cha.getA_id());
//			eno.setTransferInfo("JSON 34234asdasd ");
//			eno.setReceiverFullname("asdad Akbulut");
//			eno.setReceiverMobile("5374004103");
//			eno.setReceiver_identification_no("6549832165");
//			eno.setTransacDate(DateType.formatDate(DateTime.now()));
//			eno.setAmount(3500);
//			eno.setDesc("asdasdsad");
//			
//			EftBasedOnNameRepository enor=new EftBasedOnNameRepository();
//			//System.out.println(enor.save(eno, GRUD_Enum.INSERT));
//			
//			List<EftBasedOnName> tnos=(List<EftBasedOnName>)enor.getRecord(cha);
//			
//			for (EftBasedOnName t : tnos) {
//				System.out.print(t.getE_id()+" - ");
//				System.out.print(t.getA_id()+" - ");
//				System.out.print(t.getReceiverMobile()+" - ");
//				System.out.print(t.getReceiverFullname()+" - ");
//				System.out.print(t.getReceiver_identification_no()+" - ");
//				System.out.print(t.getTransferInfo()+" - ");
//				System.out.print(t.getTransacDate()+" - ");
//				System.out.print(t.getAmount()+" - ");
//				System.out.println(t.getDesc()+" - ");
//			}
//			double balance=5500*-1;
//			CheckingAccountRepository car2=new CheckingAccountRepository();
//			System.out.println(car2.updateBalance(balance, cha));
			
//			System.out.println(cha.getA_id());
//			System.out.println(cha2.getA_id());
			
//			TransferService ts=new TransferService();
//			System.out.println(ts.transferBetweenCheckingAccounts(cha, cha2.getIBAN(), TransferType_Enum.IBAN, 2000));
//			System.out.println(ts.transferBetweenCheckingAccounts(cha, cha2.getA_id(), TransferType_Enum.accountNo, 2000));
//			System.out.println(ts.transferToCheckingToDeposit(cha, dha,1000,3));

//			Repo repo2=new Repo();
//			repo2.setA_id(cha.getA_id());
//			repo2.setStartDate(DateType.formatDate(DateTime.now()));
//			repo2.setEndDate(DateType.formatDate(DateTime.now().plusMonths(6)));
//			repo2.setAmount(50000);
//			repo2.setStatus(1);
//			
//			RepoRepository rr=new RepoRepository();
//			System.out.println(rr.save(repo2, GRUD_Enum.INSERT));
//			rr=new RepoRepository();
//			List<Repo> repos=(List<Repo>)rr.getRecord(cha);
			
//			 DepositAccount dacc=new DepositAccount();
//			 dacc.setC_id(c.getId());
//			 dacc.setAccountType(Account_Enum.E_DepositAcc);
//			 dacc.setCurrency(Currency_Enum.DOLLAR);
//			 dacc.setBalance(50000);
//			 dacc.setCreationDate(DateType.formatDate(DateTime.now()));
//			 dacc.setStatus(1);
//			 dacc.setTerm("180");
//			 dacc.setAv_id(3);
			 
			 //DepositAccountRepository daccr=new DepositAccountRepository();
			 //System.out.println(daccr.save(dacc, GRUD_Enum.INSERT));
//			 List<DepositAccount> accounts2=(List<DepositAccount>)new DepositAccountRepository().getRecord(c);
//			 
//			 for (DepositAccount depositAccount : accounts2) {
//				System.out.print(depositAccount.getAv_id()+" - ");
//				System.out.print(depositAccount.getBalance()+" - ");
//				System.out.print(depositAccount.getTerm()+" - ");
//				System.out.println(depositAccount.getInterestRate());
//			}
			 
//			 TransferService ts=new TransferService();
//			 System.out.println(ts.transferToCheckingToDeposit(cha, dacc, 10000, TransferDirection.depositToChecking));
			
			
			
//			List<Bank> banks=new BranchListRepository().getBanks();
//			
//			for (Bank bank : banks) {
//				System.out.println(bank.getBank_id()+" - "+bank.getName());
//			}
//			System.out.println();
//			List<City> cities=new BranchListRepository().getCities();
//			
//			for (City city : cities) {
//				System.out.println(city.getCity_id()+" - "+city.getName());
//			}
//			
//			List<Branch> branches=new BranchListRepository().getBranches(20,1);
//			for (Branch branch : branches) {
//				System.out.println("("+branch.getBranch_id()+" , "+branch.getBank_id()+","+branch.getCity_id()+")  "+branch.getName());
//			}
		
		
//			Customer c=new Customer();
//			c.setFullname("asdasdsad asdasdsad");
//			c.setMobile("646546464");
//			c.setMail("asdad@asdasd.com");
//			c.setAddress("sadagfa kjhdajshdkashdkjhsa jkdh askj hdkashd");
//			c.setId_num("12345678901");
//			c.setPassword("pass123456");
//			c.setRegisterDate(DateType.formatDate(DateTime.now()));
//			c.setLastLoginDate(DateType.formatDate(DateTime.now()));
//			c.setLastLoginIP("178.65.232.93");
//			c.setStatus(1);
//			
//			System.out.println(new CustomerRepository().save(c, GRUD_Enum.INSERT));
//		CheckingAccount acc=new CheckingAccount();
//		acc.setA_id("dasd");
//		System.out.println(new CheckService().checkRepo(null));
		CustomerRepository sc=new CustomerRepository();
		boolean a=sc.save(new Customer(8,"melih yeni2","54644546","asdsad@s.com",
				"asdas dsadsadsadasd","23123123123",DateType.formatDate(DateTime.now()),
				DateType.formatDate(DateTime.now()),"123123123123","yenipass",1)
		,GRUD_Enum.UPDATE);
		System.out.println(a);
			
	}
}

package com.banking;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.banking.Entity.CheckingAccount;
import com.banking.Entity.Customer;
import com.banking.Entity.CustomerCard;
import com.banking.Entity.DepositAccount;
import com.banking.Entity.EftBasedOnName;
import com.banking.Entity.EftBasedOnNumber;
import com.banking.Entity.Installment;
import com.banking.Entity.Payment;
import com.banking.Entity.Repo;
import com.banking.Entity.TransferBasedOnName;
import com.banking.Entity.TransferBasedOnNumber;
import com.banking.banks.Bank;
import com.banking.banks.Branch;
import com.banking.banks.City;
import com.banking.enums.GRUD_Enum;
import com.banking.repository.BranchListRepository;
import com.banking.repository.CheckingAccountRepository;
import com.banking.repository.CustomerCardRepository;
import com.banking.repository.CustomerRepository;
import com.banking.repository.DepositAccountRepository;
import com.banking.repository.EftBasedOnNameRepository;
import com.banking.repository.EftBasedOnNumberRepository;
import com.banking.repository.InstallmentRepository;
import com.banking.repository.PaymentRepository;
import com.banking.repository.RepoRepository;
import com.banking.repository.TransferBasedOnNameRepository;
import com.banking.repository.TransferBasedOnNumberRepository;
import com.banking.transferService.CheckService;
import com.banking.transferService.TransferService;

@WebService
public class WS {

	//CUSTOMER
	@WebMethod
	public boolean saveCustomer(Customer c,int g){
		return new CustomerRepository().save(c, g);
	}
	@WebMethod
	public boolean deleteCustomer(Integer id){
		return new CustomerRepository().Delete(id);
	}
	@WebMethod
	public Customer loginCustomer(String id_number,String password){
		return new CustomerRepository().login(id_number, password);
	}
	
	//CUSTOMER CARD
	@WebMethod
	public boolean saveCustomerCard(CustomerCard card,int g){
		return new CustomerCardRepository().save(card, g);
	}
	@WebMethod
	public List<CustomerCard> getCustomerCards(Customer c){
		return (List<CustomerCard>)new CustomerCardRepository().getRecord(c);
	}
	
	//CHECKING ACCOUNT
	@WebMethod
	public boolean saveCheckingAccount(CheckingAccount acc,int g){
		return new CheckingAccountRepository().save(acc, g);
	}
	@WebMethod
	public boolean updateBalance(double pay,CheckingAccount acc){
		return new CheckingAccountRepository().updateBalance(pay, acc);		
	}
	@WebMethod
	public List<CheckingAccount> getCheckingAccounts(Customer id){
		return (List<CheckingAccount>)new CheckingAccountRepository().getRecord(id);
	}
	
	//DEPOSIT ACCOUNT
	@WebMethod
	public boolean saveDepositAccount(DepositAccount dacc,int g){
		return new DepositAccountRepository().save(dacc, g);	
	}
	@WebMethod
	public List<DepositAccount> getDepositAccounts(Customer id){
		return (List<DepositAccount>)new DepositAccountRepository().getRecord(id);
	}
	
	//EFT
	@WebMethod
	public boolean saveEftName(EftBasedOnName eft,int g){
		return new EftBasedOnNameRepository().save(eft, g);
	}
	@WebMethod
	public List<EftBasedOnName> getEftName(CheckingAccount acc){
		return (List<EftBasedOnName>)new EftBasedOnNameRepository().getRecord(acc);
	}
	@WebMethod
	public boolean saveEftNumber(EftBasedOnNumber eft,int g){
		return new EftBasedOnNumberRepository().save(eft, g);
	}
	@WebMethod
	public List<EftBasedOnNumber> getEftNumber(CheckingAccount acc){
		return (List<EftBasedOnNumber>)new EftBasedOnNumberRepository().getRecord(acc);
	}
	
	//Installments
	@WebMethod
	public boolean saveInstallment(Installment ins,int g){
		return new InstallmentRepository().save(ins, g);
	}
	@WebMethod
	public List<Installment> getInstallments(CustomerCard card){
		return (List<Installment>)new InstallmentRepository().getRecord(card);
	}
	
	//Payments
	@WebMethod
	public boolean savePayment(Payment p,int g){
		return new PaymentRepository().save(p, g);
	}
	@WebMethod
	public List<Payment> getPayments(CheckingAccount acc){
		return (List<Payment>) new PaymentRepository().getRecord(acc);
	}
	
	//Repo
	@WebMethod
	public boolean saveRepo(Repo r,int g){
		return new RepoRepository().save(r, g);
	}
	@WebMethod
	public List<Repo> getRepos(CheckingAccount acc){
		return (List<Repo>)new RepoRepository().getRecord(acc);
	}
	
	//Transfer
	@WebMethod
	public boolean saveTransferName(TransferBasedOnName t,int g){
		return new TransferBasedOnNameRepository().save(t, g);
	}
	@WebMethod
	public List<TransferBasedOnName> getTransferName(CheckingAccount acc){
		return (List<TransferBasedOnName>)new TransferBasedOnNameRepository().getRecord(acc);
	}
	@WebMethod
	public boolean saveTransferNumber(TransferBasedOnNumber t,int g){
		return new TransferBasedOnNumberRepository().save(t, g);
	}
	@WebMethod
	public List<TransferBasedOnNumber> getTransferNumber(CheckingAccount acc){
		return (List<TransferBasedOnNumber>)new TransferBasedOnNumberRepository().getRecord(acc);
	}
	
	//Transfer Service
	@WebMethod
	public boolean transferToCheckingToDeposit(CheckingAccount cacc,DepositAccount dacc,double amount,int direction){
		return new TransferService().transferToCheckingToDeposit(cacc, dacc, amount, direction);
	}
	@WebMethod
	public boolean transferBetweenCheckingAccounts(CheckingAccount acc,String transferInfo,int transferType,double amount){
		return new TransferService().transferBetweenCheckingAccounts(acc, transferInfo, transferType, amount);
	}
	
	//Banks,Cities,Branches
	@WebMethod
	public List<Bank> getBanks(){
		return new BranchListRepository().getBanks();
	}
	@WebMethod
	public List<City> getCities(){
		return new BranchListRepository().getCities();
	}
	@WebMethod
	public List<Branch> getBranches(int bankID,int cityID){
		return new BranchListRepository().getBranches(bankID, cityID);
	}
	
	//Check Service
	@WebMethod
	public boolean checkService(CheckingAccount acc){
		return new CheckService().checkRepo(acc);
	}
	
	

}

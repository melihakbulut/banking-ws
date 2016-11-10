package com.banking.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.iban4j.CountryCode;
import org.iban4j.Iban;
import org.iban4j.IbanUtil;

import com.banking.Entity.CheckingAccount;
import com.banking.Entity.Customer;
import com.banking.Entity.CustomerCard;
import com.banking.enums.GRUD_Enum;

public class CheckingAccountRepository extends Repository {

	@Override
	public boolean save(Object o, int g) {
		CheckingAccount account = null;
		boolean status = false;
		Connection con = connection;
		PreparedStatement statement = null;
		try {
			
			if (o != null) {
				account = (CheckingAccount) o;
				if (g != 0) {
					if (g == GRUD_Enum.INSERT) {
						statement = con.prepareStatement("insert into checking_account values(?,?,?,?,?,?,?,?)");
						
						String IBAN="";
						while(!checkIBAN(IBAN)){
							IBAN=Iban.random(CountryCode.TR).toString();
						}
						String accID=IBAN.toString().substring(IBAN.toString().length()-16,IBAN.toString().length());
						account.setA_id(accID);
						account.setIBAN(IBAN);
						
						statement.setString(1, account.getA_id());
						statement.setInt(2, account.getC_id());
						statement.setString(3, account.getIBAN());
						statement.setInt(4, account.getCurrency());
						statement.setDouble(5, account.getBalance());
						statement.setDouble(6, account.getDailyTransferLimit());
						statement.setString(7, account.getCreationDate());
						statement.setInt(8, account.getStatus());
						
						
						
					
					}
					else if(g == GRUD_Enum.UPDATE){
						 statement=con.prepareStatement("update checking_account set dailyTransferLimit=?,balance=?,accountStatus=? where IBAN=?");
							statement.setDouble(1, account.getDailyTransferLimit());
							statement.setDouble(2, account.getBalance());
							statement.setInt(3, account.getStatus());
							statement.setString(4, account.getIBAN());
						
					}
					
					if (statement.executeUpdate() != 0)
						status = true;
			
			
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			closeConnections(con, statement);
		}
		
		
		return status;
	}
	
	public boolean updateBalance(double deduct,CheckingAccount acc){
		boolean status=false;
		Connection con = connection;
		PreparedStatement statement = null;
		ResultSet rs=null;
		double balance=0;
		try {
			if(deduct!=0 && acc!=null){
				statement=con.prepareStatement("select balance from checking_account where a_id=?");
				statement.setString(1, acc.getA_id());
				
				rs = statement.executeQuery();
				while (rs.next()) {
					balance=rs.getDouble("balance");
				}
				if(balance!=0){
				balance+=deduct;
				
				statement=con.prepareStatement("update checking_account set balance=? where a_id=? ");
				statement.setDouble(1, balance);
				statement.setString(2, acc.getA_id());
				
				if (statement.executeUpdate() != 0)
					status = true;
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			closeConnections(con, statement);
		}
		return status;
	}
	
	
	public boolean checkIBAN(String IBAN) {
		boolean status = false;
		Connection con = connection;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			if (IBAN == null)
				return status;
			String accID=IBAN.toString().substring(IBAN.toString().length()-16,IBAN.toString().length());

			statement = con
					.prepareStatement("select * from checking_account where a_id=? and IBAN=?");
			statement.setString(1, accID);
			statement.setString(2, IBAN);

			rs = statement.executeQuery();
			if (!rs.next())
				status = true;

		} catch (Exception e) {

		} finally {
			try {
				statement.close();
				rs.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return status;
	}

	@Override
	public boolean Delete(Object id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object getRecord(Object id) {
		List<CheckingAccount> accounts=new ArrayList<CheckingAccount>();
		Connection con=connection;
		PreparedStatement statement=null;
		ResultSet rs=null;
		Customer customer=null;
		try {
			if(id!=null)
				customer=(Customer)id;
			
			System.out.println(customer.getId());
			
			statement=con.prepareStatement("select * from checking_account where c_id=?");
			statement.setInt(1,customer.getId());
			
			rs=statement.executeQuery();
			while (rs.next()) {
				CheckingAccount acc=new CheckingAccount();
				acc.setC_id(rs.getInt("c_id"));
				acc.setA_id(rs.getString("a_id"));
				acc.setIBAN(rs.getString("IBAN"));
				acc.setCurrency(rs.getInt("currency"));
				acc.setBalance(rs.getDouble("balance"));
				acc.setDailyTransferLimit(rs.getDouble("dailyTransferLimit"));
				acc.setCreationDate(rs.getString("creationDate"));
				acc.setStatus(rs.getInt("accountStatus"));
				
				accounts.add(acc);
				}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally
		{
			closeConnections(con, statement,rs);
		}
		return accounts;
	}

}

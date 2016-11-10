package com.banking.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.Days;

import com.banking.Entity.Customer;
import com.banking.Entity.DepositAccount;
import com.banking.enums.GRUD_Enum;


public class DepositAccountRepository extends Repository {

	@Override
	public boolean save(Object o, int g) {
		DepositAccount account = null;
		boolean status = false;
		Connection con = connection;
		PreparedStatement statement = null;
		try {
			
			if (o != null) {
				account = (DepositAccount) o;
				if (g != 0) {
					if (g == GRUD_Enum.INSERT) {
						statement = con.prepareStatement("insert into deposit_account values(0,?,?,?,?,?,?,?,?)");
						
						statement.setInt(1, account.getC_id());
						statement.setInt(2, account.getAccountType());
						statement.setInt(3, account.getCurrency());
						statement.setDouble(4, account.getBalance());
						statement.setString(5, account.getCreationDate());
						statement.setInt(6, account.getStatus());
						statement.setString(7, account.getTerm());
						statement.setDouble(8, account.getInterestRate());
						account.setInterestRate(calcInterestRate(Integer.parseInt(account.getTerm())));	
						
						statement.setDouble(8,account.getInterestRate());
						
					
					}
					else if(g == GRUD_Enum.UPDATE){
						 statement=con.prepareStatement("update deposit_account set accountStatus=?,term=?,creationDate=? where av_id=?");
							statement.setInt(1, account.getStatus());
							statement.setString(2, account.getTerm());
							statement.setString(3, account.getCreationDate());
							statement.setInt(4, account.getAv_id());
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
	};

	@Override
	public boolean Delete(Object id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public double calcInterestRate(int term){		
		return (double)term*7/36500;
		
	}

	@Override
	public Object getRecord(Object id) {
		List<DepositAccount> accounts=new ArrayList<DepositAccount>();
		Connection con=connection;
		PreparedStatement statement=null;
		ResultSet rs=null;
		Customer customer=null;
		try {
			if(id!=null)
				customer=(Customer)id;
			
			System.out.println(customer.getId());
			
			statement=con.prepareStatement("select * from deposit_account where c_id=?");
			statement.setInt(1,customer.getId());
			
			rs=statement.executeQuery();
			while (rs.next()) {
				DepositAccount acc=new DepositAccount();
				acc.setAv_id(rs.getInt("av_id"));
				acc.setC_id(rs.getInt("c_id"));
				acc.setAccountType(rs.getInt("accountType"));
				acc.setCurrency(rs.getInt("currency"));
				acc.setBalance(rs.getDouble("balance"));
				acc.setCreationDate(rs.getString("creationDate"));
				acc.setStatus(rs.getInt("accountStatus"));
				acc.setTerm(rs.getString("term"));
				acc.setInterestRate(rs.getDouble("interestRate"));
				
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

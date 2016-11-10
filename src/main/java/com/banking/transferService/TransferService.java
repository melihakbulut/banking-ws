package com.banking.transferService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.banking.Entity.CheckingAccount;
import com.banking.Entity.DepositAccount;
import com.banking.enums.GRUD_Enum;
import com.banking.enums.TransferDirection;
import com.banking.enums.TransferType_Enum;
import com.banking.repository.Repository;

public class TransferService extends Repository {
	
	
	//Checking->Deposit
	public boolean transferToCheckingToDeposit(CheckingAccount cacc,DepositAccount dacc,double amount,int direction){
		boolean status=false;
		Connection con = connection;
		PreparedStatement statement = null,statement2=null;
		ResultSet rs=null,rs2=null;
		double balance1=0,balance2=0;
		try {
			if(cacc==null || dacc==null || amount==0)
				return status;
			else {
					con.setAutoCommit(false);
					statement=con.prepareStatement("select balance from checking_account where a_id=?");
					statement.setString(1, cacc.getA_id());
					
					statement2=con.prepareStatement("select balance from deposit_account where av_id=?");
					statement2.setInt(1, dacc.getAv_id());
					
					rs=statement.executeQuery();
					rs2=statement2.executeQuery();
					
					con.commit();
					
					while(rs.next()){
						balance1=rs.getDouble("balance");
					}
					while(rs2.next()){
						balance2=rs2.getDouble("balance");
					}
					
					if(direction==TransferDirection.checkingToDeposit){
						balance1-=amount;
						balance2+=amount;
					}
					else if(direction==TransferDirection.depositToChecking){
						balance1+=amount;
						balance2-=amount;
					}
					else 
						return status;
					
					statement=con.prepareStatement("update checking_account set balance=? where a_id=?");
					statement.setDouble(1, balance1);
					statement.setString(2, cacc.getA_id());
					
					statement2=con.prepareStatement("update deposit_account set balance=? where av_id=?");
					statement2.setDouble(1, balance2);
					statement2.setInt(2, dacc.getAv_id());
					
					if(statement.executeUpdate()!= 0 && statement2.executeUpdate()!= 0)
						status=true;
					
					con.commit();
				
				
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		finally
		{
			closeConnections(con, statement,rs);
			closeConnections(con, statement2,rs2);
		}
		
		
		
		return status;
	}
	
	public boolean transferBetweenCheckingAccounts(CheckingAccount acc,String transferInfo,int transferType,double amount){
		boolean status=false;
		Connection con = connection;
		PreparedStatement statement = null,statement2=null;
		ResultSet rs=null,rs2=null;
		double balance1=0,balance2=0;
		try {
			if(acc==null || transferInfo==null ||transferInfo=="" || transferType==0 || amount==0){
				return status;
			}
			else{
				//JSON PARSE 
				con.setAutoCommit(false);
				statement=con.prepareStatement("select balance from checking_account where a_id=?");
				statement.setString(1, acc.getA_id());
				
				rs=statement.executeQuery();
				while(rs.next()){
					balance1=rs.getDouble("balance");
				}
				
				if(transferType==TransferType_Enum.accountNo){
					statement2=con.prepareStatement("select balance,a_id from checking_account where a_id=?");
					statement2.setString(1, transferInfo);
					
					rs2=statement2.executeQuery();
					String x=null;
					while(rs2.next()){
						balance2=rs2.getDouble("balance");
						x=rs2.getString("a_id");
					}
					if(x==null)
						return status;
					
					balance1-=amount;
					balance2+=amount;
					
					statement=con.prepareStatement("update checking_account set balance=? where a_id=?");
					statement.setDouble(1, balance1);
					statement.setString(2, acc.getA_id());
					
					statement2=con.prepareStatement("update checking_account set balance=? where a_id=?");
					statement2.setDouble(1, balance2);
					statement2.setString(2, transferInfo);
					
					if(statement.executeUpdate()!= 0 && statement2.executeUpdate()!= 0)
						status=true;
					
					con.commit();
					
				}
				else if(transferType==TransferType_Enum.IBAN){
					statement2=con.prepareStatement("select balance,IBAN from checking_account where IBAN=?");
					statement2.setString(1, transferInfo);
					
					rs2=statement2.executeQuery();
					String x=null;
					while(rs2.next()){
						balance2=rs2.getDouble("balance");
						x=rs2.getString("IBAN");
					}
					if(x==null)
						return status;	
					
					balance1-=amount;
					balance2+=amount;
					
					statement=con.prepareStatement("update checking_account set balance=? where a_id=?");
					statement.setDouble(1, balance1);
					statement.setString(2, acc.getA_id());
					
					statement2=con.prepareStatement("update checking_account set balance=? where IBAN=?");
					statement2.setDouble(1, balance2);
					statement2.setString(2, transferInfo);
					
					if(statement.executeUpdate()!= 0 && statement2.executeUpdate()!= 0)
						status=true;
					
					con.commit();
				}
				else
					return status;
				
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally
		{
			
		}
		
		return status;
	}
	
	

	
	
	@Override
	public boolean save(Object o, int g) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Delete(Object id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object getRecord(Object id) {
		// TODO Auto-generated method stub
		return null;
	}

}

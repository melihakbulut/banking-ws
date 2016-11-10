package com.banking.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.banking.banks.Bank;
import com.banking.banks.Branch;
import com.banking.banks.City;
import com.banking.enums.GRUD_Enum;

public class BranchListRepository extends Repository {

	public List<Bank> getBanks(){
		List<Bank> banks=null;
		Connection con = connection;
		PreparedStatement statement = null;
		ResultSet rs=null;
		try {
			statement=con.prepareStatement("select * from banks");
			rs=statement.executeQuery();
			banks=new ArrayList<Bank>();
			while(rs.next())
				banks.add(new Bank(rs.getInt("bank_id"),rs.getString("name")));

		} catch (Exception e) {
			
		}
		finally
		{
			closeConnections(con, statement,rs);
		}
		
		return banks;
	}
	
	public List<City> getCities(){
		List<City> cities=null;
		Connection con = connection;
		PreparedStatement statement = null;
		ResultSet rs=null;
		try {
			statement=con.prepareStatement("select * from cities");
			rs=statement.executeQuery();
			cities=new ArrayList<City>();
			while(rs.next())
				cities.add(new City(rs.getInt("city_id"),rs.getString("name")));

		} catch (Exception e) {
			
		}
		finally
		{
			closeConnections(con, statement,rs);
		}
		
		return cities;
	}
	
	public List<Branch> getBranches(int bank_id,int city_id){
		List<Branch> branches=null;
		Connection con = connection;
		PreparedStatement statement = null;
		ResultSet rs=null;
		try {
			statement=con.prepareStatement("select * from branches where bank_id=? and city_id=?");
			statement.setInt(1, bank_id);
			statement.setInt(2, city_id);
		
			rs=statement.executeQuery();
			branches=new ArrayList<Branch>();
			while(rs.next())
				branches.add(new Branch(rs.getInt("bank_bid"),rs.getInt("bank_id"),rs.getInt("city_id"),rs.getString("name")));

		} catch (Exception e) {
			
		}
		finally
		{
			closeConnections(con, statement,rs);
		}
		
		return branches;
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

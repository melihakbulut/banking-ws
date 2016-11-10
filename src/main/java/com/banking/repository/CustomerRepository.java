package com.banking.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.joda.time.DateTime;

import com.banking.Entity.Customer;
import com.banking.enums.GRUD_Enum;

public class CustomerRepository extends Repository {

	@Override
	public boolean save(Object o,int g) {
		Customer c=null;
		boolean status=false;
		Connection con=connection;
		PreparedStatement statement=null;
		try {
			if(o!=null){
				c=(Customer)o;
			if(g!=0){
				if(g==GRUD_Enum.INSERT)
			statement=con.prepareStatement("insert into customer values(0,?,?,?,?,?,?,?,?,?,?)");
				else if(g==GRUD_Enum.UPDATE)
			statement=con.prepareStatement("update customer set fullName=?,mobile=?,email=?,address=?,identification_num=?,password=?,"
					+ "registerDate=?,lastLoginDate=?,lastLoginIP=?,accountStatus=? where c_id=?");
			
			
			statement.setString(1, c.getFullname());
			statement.setString(2, c.getMobile());
			statement.setString(3, c.getMail());
			statement.setString(4, c.getAddress());
			
			if(g==GRUD_Enum.INSERT){
			if(checkIdNum(c.getId_num()))
				statement.setString(5, c.getId_num());
			else
				return status;
			}
			else if(g==GRUD_Enum.UPDATE){
				statement.setString(5, c.getId_num());
			}
			
			
			statement.setString(6, c.getPassword());
			statement.setString(7, c.getRegisterDate());
			statement.setString(8, c.getLastLoginDate());
			statement.setString(9, c.getLastLoginIP());
			statement.setInt(10, c.getStatus());
						
			
				if(g==GRUD_Enum.UPDATE)
					statement.setInt(11, c.getId());
				
				if(statement.executeUpdate()!=0)
					status=true;
				
				}//GRUD_Enum is null
				else
					return status;
			}//Customer is null
			else
				return status;
			
				
		} catch (Exception e) {
			
		}
		finally
		{	
			closeConnections(con, statement);
		}
		return status;
		
	}
	
	public boolean checkIdNum(String id_num) {
		boolean status = false;
		Connection con = connection;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			if (id_num == null)
				return status;

			statement = con
					.prepareStatement("select * from customer where identification_num=?");
			statement.setString(1, id_num);

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
		boolean status=false;
		Connection con=connection;
		PreparedStatement statement=null;
		try {
			Integer cid=0;
			if(id!=null)
				cid=(Integer)id;
			else
				return status;
			
			statement=con.prepareStatement("update customer set accountStatus=? where c_id=?");
			statement.setInt(1, 0);
			statement.setInt(2, cid);
				
			if(statement.executeUpdate()!=0)
				status=true;
			
				
		} catch (Exception e) {
			
		}
		finally
		{
			closeConnections(con, statement);
		}
		return status;
		
	}
	
	public Customer login(String id_number,String password){
		Connection con=connection;
		PreparedStatement statement=null;
		ResultSet rs=null;
		Customer customer=null;
		try {
			if(id_number==null && password==null)
				return customer;
			
			statement=con.prepareStatement("select * from customer where identification_num=? and password=?");
			statement.setString(1, id_number);
			statement.setString(2, password);
			
			rs=statement.executeQuery();
			while (rs.next()) {
				customer=new Customer(rs.getInt("c_id"),rs.getString("fullname"),rs.getString("mobile"),rs.getString("email"),rs.getString("address")
						,rs.getString("identification_num"),rs.getString("registerDate"),rs.getString("lastLoginDate"),rs.getString("lastLoginIP")
						,rs.getString("password"),rs.getInt("accountStatus"));
				}
			
			customer.setLastLoginDate(DateType.formatDate(DateTime.now()));
			//Last IP set 
			save(customer, GRUD_Enum.UPDATE);
			
				
		} catch (Exception e) {
			
		}
		finally
		{
			closeConnections(con, statement,rs);
		}
		return customer;
	}

	@Override
	public Object getRecord(Object id) {
		
		return null;
	}

}

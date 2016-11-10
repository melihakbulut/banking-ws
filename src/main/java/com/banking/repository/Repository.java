package com.banking.repository;

import com.banking.enums.GRUD_Enum;
import com.banking.pool.PoolConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class Repository implements IRepository {

	protected Connection connection=null;
	private static PoolConfig config=null;
	
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			config=new PoolConfig();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Repository(){
		
		try {
			
			connection=config.getDataSource().getConnection();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void closeConnections(Connection con,PreparedStatement statement){
		closeConnections(connection, statement, null);
	}
	
	public void closeConnections(Connection con,PreparedStatement statement,ResultSet rs){
		try {
			if(statement != null)
				statement.close();
			if(connection != null)
				connection.close();
			if(rs != null)
				rs.close();

			if(connection.isClosed())
				System.err.println(connection+" CLOSED");
			else
				System.err.println("connection NOT CLOSED");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public abstract boolean save(Object o, int g);
	public abstract boolean Delete(Object id);
	public abstract Object getRecord(Object id);
}

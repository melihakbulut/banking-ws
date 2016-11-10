package com.banking.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.banking.enums.GRUD_Enum;


public interface IRepository {

	boolean save(Object o,int g);
	boolean Delete(Object id);
	Object getRecord(Object id);
	
	void closeConnections(Connection con,PreparedStatement statement);
	void closeConnections(Connection con,PreparedStatement statement,ResultSet rs);
}


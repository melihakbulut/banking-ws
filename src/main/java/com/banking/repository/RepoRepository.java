package com.banking.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.Days;

import com.banking.Entity.CheckingAccount;
import com.banking.Entity.Repo;
import com.banking.enums.GRUD_Enum;

public class RepoRepository extends Repository {

	@Override
	public boolean save(Object o, int g) {
		Repo repo = null;
		boolean status = false;
		Connection con = connection;
		PreparedStatement statement = null;
		try {
			if (o != null) {
				repo = (Repo) o;
				if (g != 0) {
					if (g == GRUD_Enum.INSERT){
						statement = con
								.prepareStatement("insert into repo values(0,?,?,?,?,?,?)");
					
					statement.setString(1, repo.getA_id());
					statement.setString(2, repo.getStartDate());
					statement.setString(3, repo.getEndDate());
					statement.setDouble(4, repo.getAmount());
					statement.setInt(5, repo.getStatus());
					repo.setInterestRate(calcInterestRate(Days.daysBetween(DateType.toDateTime(repo.getStartDate()),
							DateType.toDateTime(repo.getEndDate())).getDays()));					
					statement.setDouble(6,repo.getInterestRate());
					}
					else if(g==GRUD_Enum.UPDATE){
						statement = con.prepareStatement("update repo set startingDate=?,endingDate=?,amount=?,status=?,interestRate=? where r_id=?");
						statement.setString(1, repo.getStartDate());
						statement.setString(2, repo.getEndDate());
						statement.setDouble(3, repo.getAmount());
						statement.setInt(4, repo.getStatus());
						statement.setDouble(5, repo.getInterestRate());
						statement.setInt(6, repo.getR_id());
						
					}
					
					
					if (statement.executeUpdate() != 0)
						status = true;

				}// GRUD_Enum is null
				else
					return status;
			}// Customer is null
			else
				return status;

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			closeConnections(con, statement);
		}
		return status;
	}

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
		List<Repo> repos = new ArrayList<Repo>();
		Connection con = connection;
		PreparedStatement statement = null;
		ResultSet rs = null;
		CheckingAccount acc = null;
		try {
			if (id != null)
				acc = (CheckingAccount) id;


			statement = con
					.prepareStatement("select * from repo where a_id=?");
			statement.setString(1, acc.getA_id());

			rs = statement.executeQuery();
			while (rs.next()) {
				Repo repo = new Repo();
				repo.setR_id(rs.getInt("r_id"));
				repo.setA_id(rs.getString("a_id"));
				repo.setStartDate(rs.getString("startingDate"));
				repo.setEndDate(rs.getString("endingDate"));
				repo.setAmount(rs.getDouble("amount"));
				repo.setStatus(rs.getInt("status"));
				repo.setInterestRate(rs.getDouble("interestRate"));
				
				repos.add(repo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnections(con, statement, rs);
		}
		return repos;
	}

}

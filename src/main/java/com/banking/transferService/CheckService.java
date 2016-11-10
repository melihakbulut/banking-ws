package com.banking.transferService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.Seconds;

import com.banking.Entity.CheckingAccount;
import com.banking.Entity.Repo;
import com.banking.enums.GRUD_Enum;
import com.banking.repository.DateType;
import com.banking.repository.Repository;

public class CheckService extends Repository {

	public boolean checkRepo(CheckingAccount c) {
		boolean status=false;
		List<Repo> repos = new ArrayList<Repo>();
		Connection con = connection;
		PreparedStatement statement = null;
		ResultSet rs = null;
		CheckingAccount acc = null;
		try {
			if(c==null)
				return status;
			
			statement = con
					.prepareStatement("select amount,a_id,r_id,endingDate,interestRate from repo where status=1 and a_id=?");
			statement.setString(1, c.getA_id());
			rs = statement.executeQuery();
			while (rs.next()) {
				Repo repo = new Repo();

				repo.setR_id(rs.getInt("r_id"));
				repo.setA_id(rs.getString("a_id"));
				repo.setAmount(rs.getDouble("amount"));
				repo.setEndDate(rs.getString("endingDate"));
				repo.setInterestRate(rs.getDouble("interestRate"));

				repos.add(repo);
			}
			System.out.println("Cycle Start.");
			for (Repo repo2 : repos) {
				if (Seconds.secondsBetween(DateTime.now(),
						DateType.toDateTime(repo2.getEndDate())).getSeconds() <= 0) {
					statement = con
							.prepareStatement("select balance from checking_account where a_id=?");
					statement.setString(1, repo2.getA_id());
					rs = statement.executeQuery();
					while (rs.next()) {
						acc = new CheckingAccount();
						acc.setA_id(repo2.getA_id());
						acc.setBalance(rs.getDouble("balance"));
					}
					updateFinishedRepo(repo2, acc);
				}
			}
			System.out.println("Cycle Done.");
			status=true;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnections(con, statement, rs);
		}
		
		return status;
	}

	public boolean updateFinishedRepo(Repo r, CheckingAccount c) {
		boolean status = false;
		Connection con = connection;
		PreparedStatement statement = null, statement2 = null;
		Repo repo = null;
		CheckingAccount acc = null;
		try {
			if (r == null || c == null)
				return status;
			else {
				repo = r;
				acc = c;
				con.setAutoCommit(false);

				statement = con
						.prepareStatement("update repo set status=0 where r_id=?");
				statement.setInt(1, repo.getR_id());

				statement2 = con
						.prepareStatement("update checking_account set balance=? where a_id=?");
				double newBalance = (acc.getBalance() + repo.getAmount()
						* repo.getInterestRate());
				newBalance = Double.parseDouble(String.format("%.2f",
						newBalance).replace(",", "."));

				statement2.setDouble(1, newBalance);
				statement2.setString(2, c.getA_id());

				if (statement.executeUpdate() != 0
						&& statement2.executeUpdate() != 0)
					status = true;

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
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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

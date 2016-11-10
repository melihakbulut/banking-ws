package com.banking.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.banking.Entity.CheckingAccount;
import com.banking.Entity.EftBasedOnName;
import com.banking.enums.GRUD_Enum;

public class EftBasedOnNameRepository extends Repository {

	@Override
	public boolean save(Object o, int g) {
		EftBasedOnName t = null;
		boolean status = false;
		Connection con = connection;
		PreparedStatement statement = null;
		try {
			if (o != null) {
				t = (EftBasedOnName) o;
				if (g != 0) {
					if (g == GRUD_Enum.INSERT)
						statement = con
								.prepareStatement("insert into eft_based_on_name values(0,?,?,?,?,?,?,?,?)");
					
					statement.setString(1, t.getA_id());
					statement.setString(2, t.getTransferInfo());
					statement.setString(3, t.getReceiverFullname());
					statement.setString(4, t.getReceiverMobile());
					statement.setString(5, t.getReceiver_identification_no());
					statement.setString(6, t.getTransacDate());
					statement.setDouble(7, t.getAmount());
					statement.setString(8, t.getDesc());
					
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

	@Override
	public Object getRecord(Object id) {
		List<EftBasedOnName> transfers = new ArrayList<EftBasedOnName>();
		Connection con = connection;
		PreparedStatement statement = null;
		ResultSet rs = null;
		CheckingAccount acc = null;
		try {
			if (id != null)
				acc = (CheckingAccount) id;


			statement = con
					.prepareStatement("select * from eft_based_on_name where a_id=?");
			statement.setString(1, acc.getA_id());

			rs = statement.executeQuery();
			while (rs.next()) {
				EftBasedOnName transfer = new EftBasedOnName();
				transfer.setE_id(rs.getInt("eftName_id"));
				transfer.setA_id(rs.getString("a_id"));
				transfer.setTransferInfo(rs.getString("transferInfo"));
				transfer.setReceiverFullname(rs.getString("receiverFullname"));
				transfer.setReceiverMobile(rs.getString("receiverMobile"));
				transfer.setReceiver_identification_no(rs.getString("receiver_identification_no"));
				transfer.setTransacDate(rs.getString("transactionDate"));
				transfer.setAmount(rs.getDouble("amount"));
				transfer.setDesc(rs.getString("description"));
				
				transfers.add(transfer);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnections(con, statement, rs);
		}
		return transfers;
	}

}

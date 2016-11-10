package com.banking.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.banking.Entity.CheckingAccount;
import com.banking.Entity.TransferBasedOnNumber;
import com.banking.enums.GRUD_Enum;

public class TransferBasedOnNumberRepository extends Repository {

	@Override
	public boolean save(Object o, int g) {
		TransferBasedOnNumber t = null;
		boolean status = false;
		Connection con = connection;
		PreparedStatement statement = null;
		try {
			if (o != null) {
				t = (TransferBasedOnNumber) o;
				if (g != 0) {
					if (g == GRUD_Enum.INSERT)
						statement = con
								.prepareStatement("insert into transfer_based_on_no values(0,?,?,?,?,?,?)");
					
					statement.setString(1, t.getA_id());
					statement.setInt(2, t.getTransferType());
					statement.setString(3, t.getTransferInfo());
					statement.setString(4, t.getTransacDate());
					statement.setDouble(5, t.getAmount());
					statement.setString(6, t.getDesc());
					
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
		List<TransferBasedOnNumber> transfers = new ArrayList<TransferBasedOnNumber>();
		Connection con = connection;
		PreparedStatement statement = null;
		ResultSet rs = null;
		CheckingAccount acc = null;
		try {
			if (id != null)
				acc = (CheckingAccount) id;


			statement = con
					.prepareStatement("select * from transfer_based_on_no where a_id=?");
			statement.setString(1, acc.getA_id());

			rs = statement.executeQuery();
			while (rs.next()) {
				TransferBasedOnNumber transfer = new TransferBasedOnNumber();
				transfer.setT_id(rs.getInt("tno_id"));
				transfer.setA_id(rs.getString("a_id"));
				transfer.setTransferType(rs.getInt("transferType"));
				transfer.setTransferInfo(rs.getString("transferInfo"));
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

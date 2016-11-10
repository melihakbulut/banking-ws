package com.banking.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.banking.Entity.CustomerCard;
import com.banking.Entity.Installment;
import com.banking.enums.GRUD_Enum;

public class InstallmentRepository extends Repository {

	@Override
	public boolean save(Object o, int g) {
		Installment inst = null;
		boolean status = false;
		Connection con = connection;
		PreparedStatement statement = null;
		try {
			if (o != null) {
				inst = (Installment) o;
				if (g != 0) {
					if (g == GRUD_Enum.INSERT){
						statement = con
								.prepareStatement("insert into installments values(0,?,?,?,?,?,?,?)");

					statement.setString(1, inst.getCard_id());
					statement.setString(2, inst.getCompany());
					statement.setString(3, inst.getProductName());
					statement.setDouble(4, inst.getAmount());
					statement.setString(5, inst.getTerm());
					statement.setString(6, inst.getTranscDate());
					statement.setInt(7, inst.getStatus());
					}
					else if(g==GRUD_Enum.UPDATE){
						statement = con.prepareStatement("update installments set status=? where i_id=?");
						statement.setInt(1, inst.getStatus());
						statement.setInt(2, inst.getI_id());
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

	@Override
	public Object getRecord(Object id) {
		List<Installment> installments = new ArrayList<Installment>();
		Connection con = connection;
		PreparedStatement statement = null;
		ResultSet rs = null;
		CustomerCard card = null;
		try {
			if (id != null)
				card = (CustomerCard) id;


			statement = con
					.prepareStatement("select * from installments where card_id=?");
			statement.setString(1, card.getCard_id());

			rs = statement.executeQuery();
			while (rs.next()) {
				Installment inst = new Installment();
				inst.setI_id(rs.getInt("i_id"));
				inst.setCard_id(rs.getString("card_id"));
				inst.setCompany(rs.getString("company"));
				inst.setProductName(rs.getString("productName"));
				inst.setAmount(rs.getDouble("amount"));
				inst.setTerm(rs.getString("term"));
				inst.setTranscDate(rs.getString("transactionDate"));
				inst.setStatus(rs.getInt("status"));
				
				installments.add(inst);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnections(con, statement, rs);
		}
		return installments;
	}

	
}

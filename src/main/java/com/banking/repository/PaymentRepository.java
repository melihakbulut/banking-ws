package com.banking.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.banking.Entity.CheckingAccount;
import com.banking.Entity.Payment;
import com.banking.enums.GRUD_Enum;

public class PaymentRepository extends Repository {

	@Override
	public boolean save(Object o, int g) {
		Payment p = null;
		boolean status = false;
		Connection con = connection;
		PreparedStatement statement = null;
		try {
			if (o != null) {
				p = (Payment) o;
				if (g != 0) {
					if (g == GRUD_Enum.INSERT)
						statement = con
								.prepareStatement("insert into payments values(0,?,?,?,?,?)");

					statement.setString(1, p.getA_id());
					statement.setInt(2, p.getPaymentType());
					statement.setString(3, p.getPaymentInfo());
					statement.setString(4, p.getTranscDate());
					statement.setDouble(5, p.getAmount());

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
		List<Payment> payments = new ArrayList<Payment>();
		Connection con = connection;
		PreparedStatement statement = null;
		ResultSet rs = null;
		CheckingAccount acc = null;
		try {
			if (id != null)
				acc = (CheckingAccount) id;


			statement = con
					.prepareStatement("select * from payments where a_id=?");
			statement.setString(1, acc.getA_id());

			rs = statement.executeQuery();
			while (rs.next()) {
				Payment payment = new Payment();
				payment.setP_id(rs.getInt("p_id"));
				payment.setA_id(rs.getString("a_id"));
				payment.setPaymentType(rs.getInt("paymentType"));
				payment.setPaymentInfo(rs.getString("paymentInfo"));
				payment.setTranscDate(rs.getString("transactionDate"));
				payment.setAmount(rs.getDouble("amount"));

				payments.add(payment);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnections(con, statement, rs);
		}
		return payments;
	}

}

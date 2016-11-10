package com.banking.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;

import com.banking.Entity.Customer;
import com.banking.Entity.CustomerCard;
import com.banking.enums.Card_Enum;
import com.banking.enums.GRUD_Enum;
import com.banking.generate_validation.RandomCreditCardNumberGenerator;

public class CustomerCardRepository extends Repository {

	@Override
	public boolean save(Object o, int g) {
		CustomerCard c = null;
		boolean status = false;
		Connection con = connection;
		PreparedStatement statement = null;
		try {
			if (o != null) {
				c = (CustomerCard) o;
				if (g != 0) {
					if (g == GRUD_Enum.INSERT) {
						statement = con.prepareStatement("insert into card values(?,?,?,?,?,?)");

						String cardID = null;
						while (!checkCardID(cardID)) {
							if (c.getCardClass() == Card_Enum.AMEX) {
								cardID = RandomCreditCardNumberGenerator
										.generateAmericanExpressCardNumber();
							}
							if (c.getCardClass() == Card_Enum.MASTERCARD) {
								cardID = RandomCreditCardNumberGenerator
										.generateMasterCardNumber();
							}
							if (c.getCardClass() == Card_Enum.VISA) {
								cardID = RandomCreditCardNumberGenerator
										.generateVisaCardNumber();
							}
						}
						c.setCard_id(cardID);
						System.out.println(c.getCard_id());

						statement.setString(1, c.getCard_id());
						statement.setInt(2, c.getC_id());
						statement.setInt(3, c.getCardType());
						statement.setDouble(4, c.getCardLimit());
						statement.setString(5, c.getPassword());
						statement.setInt(6, c.getCardStatus());


					}
					 else if(g==GRUD_Enum.UPDATE){
					 statement=con.prepareStatement("update card set cardLimit=?,password=?,cardStatus=? where card_id=?");
						statement.setDouble(1, c.getCardLimit());
						statement.setString(2, c.getPassword());
						statement.setInt(3, c.getCardStatus());
						statement.setString(4, c.getCard_id());
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
			System.out.println(e);
		} finally {
			closeConnections(con, statement);
		}
		return status;
	}

	public boolean checkCardID(String cardnumber) {
		boolean status = false;
		Connection con = connection;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			if (cardnumber == null)
				return status;

			statement = con
					.prepareStatement("select * from card where card_id=?");
			statement.setString(1, cardnumber);

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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object getRecord(Object id) {
		List<CustomerCard> cards=new ArrayList<CustomerCard>();
		Connection con=connection;
		PreparedStatement statement=null;
		ResultSet rs=null;
		Customer customer=null;
		try {
			if(id!=null)
				customer=(Customer)id;
			
			System.out.println(customer.getId());
			
			statement=con.prepareStatement("select * from card where c_id=?");
			statement.setInt(1,customer.getId());
			
			rs=statement.executeQuery();
			while (rs.next()) {
				CustomerCard card=new CustomerCard();
				card.setC_id(rs.getInt("c_id"));
				card.setCard_id(rs.getString("card_id"));
				card.setPassword(rs.getString("password"));
				card.setCardType(rs.getInt("cardType"));
				card.setCardStatus(rs.getInt("cardStatus"));
				card.setCardLimit(rs.getDouble("cardLimit"));
				cards.add(card);
				}
			
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally
		{
			closeConnections(con, statement,rs);
		}
		return cards;
	}

}

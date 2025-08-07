package model.payments;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.DatabaseConnection;

public class Payment {
	DatabaseConnection db;
	private PreparedStatement pstat = null;
	private Connection conn = null;
//	private Statement stat = null;

	private static Payment instance;
	List<Payment> list;

	String customerIdNo;
	String receivedPayments;
	String date;

	public Payment() {
		super();
		this.db = DatabaseConnection.getInstance();
		this.conn = db.getConnection();
	}

	public static Payment getInstance() {
		if (instance == null) {
			instance = new Payment();
		}
		return instance;
	}
	

	public List<Payment> getAllReceivedPaymentsWithCustomerIdNo(String IdNo) {
		list = new ArrayList<>();

		try {
			String query = "SELECT ReceivedPayments,Date FROM receivedpayments where CustomerId=(Select id from customers where IdNo=?)";
			pstat = conn.prepareStatement(query);
			pstat.setString(1, IdNo);
			ResultSet rs = pstat.executeQuery();

			while (rs.next()) {
				Payment payments = new Payment();
				payments.setReceivedPayments(rs.getString("ReceivedPayments"));
				payments.setDate(rs.getString("Date"));
				list.add(payments);
			}

			pstat.close();
			rs.close();

		} catch (Exception e) {
			e.printStackTrace();

		}
		return list;
	}

	public void setReceievedPaymentsWithPrepaeredStatement(String query) {
		try {
			Payment rePayment = Payment.getInstance();
			pstat = conn.prepareStatement(query);
			pstat.setString(1, rePayment.getCustomerIdNo());
			pstat.setString(2, rePayment.getReceivedPayment());

			pstat.executeUpdate();
			pstat.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getCustomerIdNo() {
		return customerIdNo;
	}

	public void setCustomerIdNo(String customerIdNo) {
		this.customerIdNo = customerIdNo;
	}

	public String getReceivedPayment() {
		return receivedPayments;
	}

	public void setReceivedPayments(String receivedPayments) {
		this.receivedPayments = receivedPayments;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}

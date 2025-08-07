package model.payments;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import model.DatabaseConnection;

public class ReceivingPayment {
	DatabaseConnection db;
	private PreparedStatement pstat = null;
	private Connection conn = null;
	private Statement stat = null;

	private static ReceivingPayment instance;

	int paymentsId;
	String receivedPayment;
	String customerIdNo;

	public ReceivingPayment() {
		super();
		this.db = DatabaseConnection.getInstance();
		this.conn = db.getConnection();
	}

	public static ReceivingPayment getInstance() {
		if (instance == null) {
			instance = new ReceivingPayment();
		}
		return instance;
	}

	public String getRemainingPaymentAmount() {
		String query = "Select RemainingPaymentAmount from vehiclessold where CustomerId=((Select id from customers where IdNo=?))";
		String amount="";
		try {
			pstat = conn.prepareStatement(query);
			pstat.setString(1, ReceivingPayment.getInstance().getCustomerIdNo());
			ResultSet rs = pstat.executeQuery();

			if (rs.next()) {
			 amount = rs.getString("RemainingPaymentAmount");
			}
			pstat.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();

		}
		return amount;
	}

	public void setRemainingPaymentAmount() {
		Payment payment = Payment.getInstance();
		try {
			String query = "UPDATE vehiclessold SET RemainingPaymentAmount=RemainingPaymentAmount-?  where CustomerId=(Select id from customers where IdNo=?)";
			pstat = conn.prepareStatement(query);
			pstat.setString(1, payment.getReceivedPayment());
			pstat.setString(2, payment.getCustomerIdNo());

			pstat.executeUpdate();
			pstat.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void savePayment() {
		try {

			String query = "insert into receivedpayments(CustomerId,ReceivedPayments)values((Select id from  customers where IdNo=?) ,?)";
			setReceievedPaymentsWithPrepaeredStatement(query);

			String query2="UPDATE vehiclessold SET RemainingPaymentAmount = RemainingPaymentAmount - ? WHERE CustomerId = (SELECT id FROM customers WHERE IdNo = ?);";
			setRemainingPaymentAmount(query2);
			
			JOptionPane.showMessageDialog(null, "Ödeme başarıyla alındı.", "  ", JOptionPane.INFORMATION_MESSAGE);

		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Müşteri bulunamadı.", "  ", JOptionPane.INFORMATION_MESSAGE);


		}
	}
	
	public void setRemainingPaymentAmount(String query) {
		try {
			ReceivingPayment rePayment = ReceivingPayment.getInstance();
			pstat = conn.prepareStatement(query);
			pstat.setString(1, rePayment.getReceivedPayment());
			pstat.setString(2, rePayment.getCustomerIdNo());

			pstat.executeUpdate();
			pstat.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setReceievedPaymentsWithPrepaeredStatement(String query) {
		try {
			ReceivingPayment rePayment = ReceivingPayment.getInstance();
			pstat = conn.prepareStatement(query);
			pstat.setString(1, rePayment.getCustomerIdNo());
			pstat.setString(2, rePayment.getReceivedPayment());

			pstat.executeUpdate();
			pstat.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getReceievedPaymentsWithPrepaeredStatement(String query) {
		ReceivingPayment rePayment = ReceivingPayment.getInstance();

		try {
			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(query);

			if (rs.next()) {

				rePayment.setCustomerIdNo(rs.getString("CustomerId"));
				rePayment.setReceivedPayment(rs.getString("ReceivedPayment"));

			}
			stat.close();
			rs.close();

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

	public int getPaymentsId() {
		return paymentsId;
	}

	public void setPaymentsId(int paymentsId) {
		this.paymentsId = paymentsId;
	}

	public String getReceivedPayment() {
		return receivedPayment;
	}

	public void setReceivedPayment(String receivedPayment) {
		this.receivedPayment = receivedPayment;
	}

}

package model.payments;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.DatabaseConnection;

public class AllRemainingPayments {
	DatabaseConnection db;
//	private PreparedStatement pstat = null;
	private Connection conn = null;
	private Statement stat = null;
	
	
	private static AllRemainingPayments instance;
	List<AllRemainingPayments> list;
	
	String customerIdNo;
	String customerName;
	String customerSurname;

	String remainingPayments;

	
	
	 public AllRemainingPayments() {
		super();
		this.db = DatabaseConnection.getInstance();
		this.conn = db.getConnection();
	}
	
	
		public static AllRemainingPayments getInstance() {
			if (instance == null) {
				instance = new AllRemainingPayments();
			}
			return instance;
		}

	
		public List<AllRemainingPayments> getAllRemainingPayments() {
			list = new ArrayList<>();

			try {
				String query = "SELECT customers.IdNo, customers.Name, customers.Surname, vehiclessold.RemainingPaymentAmount\r\n"
						+ "FROM vehiclessold\r\n"
						+ "INNER JOIN customers ON vehiclessold.CustomerId = customers.Id\r\n"
						+ "WHERE vehiclessold.RemainingPaymentAmount REGEXP '^[0-9]+$' \r\n"
						+ "AND CAST(vehiclessold.RemainingPaymentAmount AS DECIMAL) > 0; ";

				stat = conn.createStatement();
				ResultSet rs = stat.executeQuery(query);

				while (rs.next()) {
					AllRemainingPayments payments = new AllRemainingPayments();
					payments.setCustomerIdNo(rs.getString("IdNo"));
					payments.setCustomerName(rs.getString("Name"));
					payments.setCustomerSurname(rs.getString("Surname"));
					payments.setRemainingPayments(rs.getString("RemainingPaymentAmount"));

					list.add(payments);
				}

				stat.close();
				rs.close();

			} catch (Exception e) {
				e.printStackTrace();

			}
			return list;
		}


		public String getCustomerIdNo() {
			return customerIdNo;
		}


		public void setCustomerIdNo(String customerIdNo) {
			this.customerIdNo = customerIdNo;
		}


		public String getRemainingPayments() {
			return remainingPayments;
		}


		public void setRemainingPayments(String remainingPayments) {
			this.remainingPayments = remainingPayments;
		}


		public String getCustomerName() {
			return customerName;
		}


		public void setCustomerName(String customerName) {
			this.customerName = customerName;
		}


		public String getCustomerSurname() {
			return customerSurname;
		}


		public void setCustomerSurname(String customerSurname) {
			this.customerSurname = customerSurname;
		}


	
	
	
	
	
	
	
	
}

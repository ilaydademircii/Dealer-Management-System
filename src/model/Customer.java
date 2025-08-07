package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Customer {
	DatabaseConnection db;
	private PreparedStatement pstat = null;
	private Connection conn = null;
	private Statement stat = null;

	private static Customer instance;

	String name;
	String surname;
	String idNumber;
	String phoneNumber;
	String address;

	public Customer() {
		super();
		this.db = DatabaseConnection.getInstance();
		this.conn = db.getConnection();
	}

	public static Customer getInstance() {
		if (instance == null) {
			instance = new Customer();
		}
		return instance;
	}

	public void save() {
		try {
			if (!Customer.getInstance().getIdNumber().isEmpty()) {
				if (!isExists(Customer.getInstance().getIdNumber())) {
					String query = "insert into customers(Name,Surname,IdNo,PhoneNumber,Address)values(?,?,?,?,?)";
					setcustomerWithPrepaeredStatement(query);

				}
			} else {
				JOptionPane.showMessageDialog(null, "Tc Kimlik numarası boş bırakılamaz.", " Hata ",
						JOptionPane.ERROR_MESSAGE);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean isExists(String customerTcIdNo) {
		try {
			String query = "SELECT EXISTS (SELECT 1 FROM customers WHERE IdNo=?) AS var_mi";
			pstat = conn.prepareStatement(query);
			pstat.setString(1, customerTcIdNo);

			ResultSet rs = pstat.executeQuery();
			rs.next();
			int sonuc = rs.getInt("var_mi");
			pstat.close();
			return sonuc == 1;

		} catch (Exception e) {
			e.printStackTrace();
			return false;

		}
	}

	public void setcustomerWithPrepaeredStatement(String query) {
		try {
			Customer customer = Customer.getInstance();
			pstat = conn.prepareStatement(query);
			pstat.setString(1, customer.getName());
			pstat.setString(2, customer.getSurname());
			pstat.setString(3, customer.getIdNumber());
			pstat.setString(4, customer.getPhoneNumber());
			pstat.setString(5, customer.getAddress());

			pstat.executeUpdate();
			pstat.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getCustomerWithStatement(String query) {
		Customer customer = Customer.getInstance();
		try {

			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(query);

			if (rs.next()) {
				customer.setName(rs.getString("Name"));
				customer.setSurname(rs.getString("Surname"));
				customer.setIdNumber(rs.getString("TcIdNo"));
				customer.setPhoneNumber(rs.getString("PhoneNumber"));
				customer.setAddress(rs.getString("Address"));

			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}

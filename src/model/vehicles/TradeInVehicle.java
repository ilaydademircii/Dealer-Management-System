package model.vehicles;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.Customer;
import model.DatabaseConnection;

public class TradeInVehicle {

	DatabaseConnection db;
	private PreparedStatement pstat = null;
	private Connection conn = null;
	private Statement stat = null;

	private static TradeInVehicle instance;

	String customerIdNo;
	String model;
	String year;
	String price;
	String chassisNo;
	String licensePlate;
	String explanation;
	String date;

	Customer customer;

	public TradeInVehicle() {
		super();
		this.db = DatabaseConnection.getInstance();
		this.conn = db.getConnection();
		this.customer = Customer.getInstance();
	}

	public static TradeInVehicle getInstance() {
		if (instance == null) {
			instance = new TradeInVehicle();
		}
		return instance;
	}

	public void setVehicle(String licensePlate) {
		if (licensePlate != null && !licensePlate.isEmpty()) {
			try {
				String query = "Select * from tradeinvehicles where LicensePlate=?";
				getVehicleWithPreparedStatement(query, licensePlate);
			} catch (Exception e) {
				e.printStackTrace();

			}
		}
	}

	public List<String> getAllVehicleWithLicensePlate() {
		List<String> list = new ArrayList<>();
		try {
			String query = "SELECT LicensePlate FROM tradeinvehicles";
			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(query);

			while (rs.next()) {
				list.add(rs.getString("LicensePlate"));
			}

			rs.close();
			stat.close();

		} catch (Exception e) {
			e.printStackTrace();

		}
		return list;
	}

	public void save() {
		try {
			if (!TradeInVehicle.getInstance().getLicensePlate().isEmpty()) {
				if (!isExists(TradeInVehicle.getInstance().getLicensePlate())) {

					String query = "insert into tradeinvehicles(CustomerId,Model,Year,Price,ChassisNo,LicensePlate,Explanation)values((Select id from customers where IdNo=?),?,?,?,?,?,?)";
					setVehicleWithPrepaeredStatement(query);

					JOptionPane.showMessageDialog(null, "Takas araç başarıyla eklendi.", "  ",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					String query = "UPDATE tradeinvehicles SET CustomerId=(Select id from customers where IdNo=?), Model=?,Year=?,Price=?,LicensePlate=?,Explanation=? WHERE ChassisNo=?";
					setVehicleWithPrepaeredStatement(query);

					JOptionPane.showMessageDialog(null, "Takas araç başarıyla güncellendi.", "  ",
							JOptionPane.INFORMATION_MESSAGE);

				}
			} else {
				JOptionPane.showMessageDialog(null, "Plaka boş bırakılamaz.", " Hata ", JOptionPane.ERROR_MESSAGE);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteVehicle(String licensePlate) {
		try {
				String query = "Delete from tradeinvehicles where LicensePlate =?";

				pstat = conn.prepareStatement(query);
				pstat.setString(1, licensePlate);

				pstat.executeUpdate();
				pstat.close();

	
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public boolean isExists(String licensePlate) {
		try {
			String query = "SELECT EXISTS (SELECT 1 FROM tradeinvehicles WHERE LicensePlate=?) AS var_mi";
			pstat = conn.prepareStatement(query);
			pstat.setString(1, licensePlate);

			ResultSet rs = pstat.executeQuery();
			rs.next();
			int sonuc = rs.getInt("var_mi");

			pstat.close();
			rs.close();

			return sonuc == 1;

		} catch (Exception e) {
			e.printStackTrace();
			return false;

		}
	}

	public void setVehicleWithPrepaeredStatement(String query) {
		try {
			TradeInVehicle vehicle = TradeInVehicle.getInstance();
			pstat = conn.prepareStatement(query);
			pstat.setString(1, getCustomerIdNo());
			pstat.setString(2, vehicle.getModel());
			pstat.setString(3, vehicle.getYear());
			pstat.setString(4, vehicle.getPrice());
			pstat.setString(5, vehicle.getChassisNo());
			pstat.setString(6, vehicle.getLicensePlate());
			pstat.setString(7, vehicle.getExplanation());

			pstat.executeUpdate();
			pstat.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getVehicleWithStatement(String query) {
		TradeInVehicle vehicle = TradeInVehicle.getInstance();
		try {

			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(query);

			if (rs.next()) {
				vehicle.setCustomerIdNo(rs.getString("CustomerId"));
				vehicle.setModel(rs.getString("Model"));
				vehicle.setYear(rs.getString("Year"));
				vehicle.setPrice(rs.getString("Price"));
				vehicle.setChassisNo(rs.getString("ChassisNo"));
				vehicle.setLicensePlate(rs.getString("LicensePlate"));
				vehicle.setExplanation(rs.getString("Explanation"));

			}
			rs.close();
			stat.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getVehicleWithPreparedStatement(String query, String licensePlate) {
		try {
			TradeInVehicle vehicle = TradeInVehicle.getInstance();
			pstat = conn.prepareStatement(query);
			pstat.setString(1, licensePlate);
			ResultSet rs = pstat.executeQuery();

			if (rs.next()) {
				vehicle.setModel(rs.getString("Model"));
				vehicle.setYear(rs.getString("Year"));
				vehicle.setPrice(rs.getString("Price"));
				vehicle.setChassisNo(rs.getString("ChassisNo"));
				vehicle.setLicensePlate(rs.getString("LicensePlate"));
				vehicle.setExplanation(rs.getString("Explanation"));
			}

			rs.close();
			pstat.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getCustomerIdNo() {
		return customerIdNo;
	}

	public void setCustomerIdNo(String customerId) {
		this.customerIdNo = customerId;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getChassisNo() {
		return chassisNo;
	}

	public void setChassisNo(String chasisNo) {
		this.chassisNo = chasisNo;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getExplanation() {
		return explanation;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}

}

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

public class SoldVehicle {
	DatabaseConnection db;
	private PreparedStatement pstat = null;
	private Connection conn = null;
	private Statement stat = null;

	private static SoldVehicle instance;

	String customerIdNo;
	String model;
	String year;
	String chassisNo;
	String licensePlate;
	String receivingPrice;
	String salePrice;
	String remainingPaymentAmount;
	String explanation;
	String date;
	String receivedPayment;

	Customer customer;

	public SoldVehicle() {
		super();
		this.db = DatabaseConnection.getInstance();
		this.conn = db.getConnection();
		this.customer = Customer.getInstance();

	}

	public static SoldVehicle getInstance() {
		if (instance == null) {
			instance = new SoldVehicle();
		}
		return instance;
	}

	public void save() {
		try {
			if (!SoldVehicle.getInstance().getChassisNo().isEmpty()) {
				if (!isExists(SoldVehicle.getInstance().getChassisNo())) {

					String query = "insert into vehiclessold(CustomerId,Model,Year,ChassisNo,LicensePlate,ReceivingPrice,SalePrice,RemainingPaymentAmount,Explanation)values((Select id from customers where IdNo=?),?,?,?,?,?,?,?,?)";
					setRemainingPaymentAmount(getSalePrice());
					setVehicleWithPrepaeredStatement(query);

					JOptionPane.showMessageDialog(null, "Araç başarıyla satıldı.", "  ",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					String query = "UPDATE vehiclessold SET SalePrice=?,RemainingPaymentAmount=?,Explanation=? WHERE ChassisNo=?";
					setRemainingPaymentAmount(getSalePrice());
					updateVehicleWithPrepaeredStatement(query);

					JOptionPane.showMessageDialog(null, "Satılan araç güncellendi.", "  ",
							JOptionPane.INFORMATION_MESSAGE);

				}
			} else {
				JOptionPane.showMessageDialog(null, "Şasi Numarası boş bırakılamaz.", " Hata ",
						JOptionPane.ERROR_MESSAGE);
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public void deleteNewVehicle() {
		try {
			if (isExists(NewVehicle.getInstance().getChassisNo())) {
				String query = "Delete from newvehicles where ChassisNo =?";

				pstat = conn.prepareStatement(query);
				pstat.setString(1, NewVehicle.getInstance().getChassisNo());

				pstat.executeUpdate();
				pstat.close();

			} else {

			}
		} catch (Exception e) {
			e.printStackTrace();

		}
	}



	public void deleteTradeInVehicle() {
		try {
			if (isExists(TradeInVehicle.getInstance().getLicensePlate())) {
				String query = "Delete from tradeinvehicles where LicensePlate =?";

				pstat = conn.prepareStatement(query);
				pstat.setString(1, TradeInVehicle.getInstance().getLicensePlate());

				pstat.executeUpdate();
				pstat.close();

			} else {

			}
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public boolean isExists(String chassisNo) {
		try {
			String query = "SELECT EXISTS (SELECT 1 FROM vehiclessold WHERE ChassisNo=?) AS var_mi";
			pstat = conn.prepareStatement(query);
			pstat.setString(1, chassisNo);

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

	public List<String> getAllVehicleModels() {
		List<String> list = new ArrayList<>();
		try {
			String query = "SELECT Model FROM vehiclessold";
			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(query);

			while (rs.next()) {
				list.add(rs.getString("Model"));
			}
			
			rs.close();
			stat.close();
			
		} catch (Exception e) {
			e.printStackTrace();

		}
		return list;
	}



	
	
	public void updateVehicleWithPrepaeredStatement(String query) {
		try {
			SoldVehicle vehicle = SoldVehicle.getInstance();
			pstat = conn.prepareStatement(query);
			pstat.setString(1, vehicle.getSalePrice());
			pstat.setString(2, vehicle.getRemainingPaymentAmount());
			pstat.setString(3, vehicle.getExplanation());
			pstat.setString(4, vehicle.getChassisNo());

			pstat.executeUpdate();
			pstat.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void setVehicleWithPrepaeredStatement(String query) {
		try {
			SoldVehicle vehicle = SoldVehicle.getInstance();
			pstat = conn.prepareStatement(query);
			pstat.setString(1, getCustomerIdNo());
			pstat.setString(2, vehicle.getModel());
			pstat.setString(3, vehicle.getYear());
			pstat.setString(4, vehicle.getChassisNo());
			pstat.setString(5, vehicle.getLicensePlate());
			pstat.setString(6, vehicle.getReceivingPrice());
			pstat.setString(7, vehicle.getSalePrice());
			pstat.setString(8, vehicle.getRemainingPaymentAmount());
			pstat.setString(9, vehicle.getExplanation());

			pstat.executeUpdate();
			pstat.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	public void getVehicleWithStatement(String query) {
//		SoldVehicle vehicle = SoldVehicle.getInstance();
//		try {
//
//			stat = conn.createStatement();
//			ResultSet rs = stat.executeQuery(query);
//
//			if (rs.next()) {
//				vehicle.setCustomerIdNo("IdNo");
//				vehicle.setModel(rs.getString("Model"));
//				vehicle.setYear(rs.getString("Year"));
//				vehicle.setChassisNo(rs.getString("ChassisNo"));
//				vehicle.setLicensePlate(rs.getString("LicensePlate"));
//				vehicle.setReceivingPrice(rs.getString("ReceivingPrice"));
//				vehicle.setSalePrice(rs.getString("SalePrice"));
//				vehicle.setRemainingPaymentAmount(rs.getString("RemainingPaymentAmount"));
//				vehicle.setExplanation(rs.getString("Explanation"));
//
//			}
//			rs.close();
//			stat.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

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

	public String getReceivingPrice() {
		return receivingPrice;
	}

	public void setReceivingPrice(String receivingPrice) {
		this.receivingPrice = receivingPrice;
	}

	public String getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(String salePrice) {
		this.salePrice = salePrice;
	}

	public String getRemainingPaymentAmount() {
		return remainingPaymentAmount;
	}

	public void setRemainingPaymentAmount(String remainingPaymentAmount) {
		this.remainingPaymentAmount = remainingPaymentAmount;
	}

	public String getExplanation() {
		return explanation;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getReceivedPayment() {
		return receivedPayment;
	}

	public void setReceivedPayment(String receivedPayment) {
		this.receivedPayment = receivedPayment;
	}

}

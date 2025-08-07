package model.vehicles;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.DatabaseConnection;

public class NewVehicle {

	DatabaseConnection db;
	private PreparedStatement pstat = null;
	private Connection conn = null;
	private Statement stat = null;

	private static NewVehicle instance;

	String model;
	String year;
	String price;
	String chassisNo;
	double kdvRate;
	String explanation;
	String date;

	public NewVehicle() {
		super();
		this.db = DatabaseConnection.getInstance();
		this.conn = db.getConnection();
	}

	public static NewVehicle getInstance() {
		if (instance == null) {
			instance = new NewVehicle();
		}
		return instance;
	}

	public void setVehicle(String chassisNo) {
		if (chassisNo != null && !chassisNo.isEmpty()) {
			try {
				String query = "Select * from newvehicles where ChassisNo=" + chassisNo;
				getVehicleWithStatement(query);
			} catch (Exception e) {
				e.printStackTrace();

			}
		}
	}

	public List<String> getAllVehicleWithChassisNo() {
		List<String> list = new ArrayList<>();
		try {
			String query = "SELECT ChassisNo FROM newvehicles";
			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(query);

			while (rs.next()) {
				list.add(rs.getString("ChassisNo"));
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();

		}
		return list;
	}

	public void getVehicleId() {
		try {
			if (isExists(NewVehicle.getInstance().getChassisNo())) {
				String query = "insert into newvehicles(SoldCustomerId ,VehicleId)values(?,?)";

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

	public void save() {
		try {
			if (!NewVehicle.getInstance().getChassisNo().isEmpty()) {
				if (!isExists(NewVehicle.getInstance().getChassisNo())) {

					String query = "insert into newvehicles(Model,Year,Price,ChassisNo,KdvRate,Explanation)values(?,?,?,?,?,?)";
					setVehicleWithPrepaeredStatement(query);

					JOptionPane.showMessageDialog(null, "Yeni araç başarıyla eklendi.", "  ",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					String query = "UPDATE newvehicles SET  Model=?,Year=?,Price=?,ChassisNo=?,KdvRate=?,Explanation=? WHERE ChassisNo=?";
					setVehicleWithPrepaeredStatement(query);

					JOptionPane.showMessageDialog(null, "Yeni araç başarıyla güncellendi.", "  ",
							JOptionPane.INFORMATION_MESSAGE);

				}
			} else {
				JOptionPane.showMessageDialog(null, "Şasi numarası boş bırakılamaz.", " Hata ",
						JOptionPane.ERROR_MESSAGE);
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
	}
	
	public void deleteVehicle(String chassisNo) {
		try {
				String query = "Delete from newvehicles where ChassisNo =?";

				pstat = conn.prepareStatement(query);
				pstat.setString(1, chassisNo);

				pstat.executeUpdate();
				pstat.close();

	
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
	

	public boolean isExists(String chasisNo) {
		try {
			String query = "SELECT EXISTS (SELECT 1 FROM newvehicles WHERE ChassisNo=?) AS var_mi";
			pstat = conn.prepareStatement(query);
			pstat.setString(1, chasisNo);

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
			NewVehicle vehicle = NewVehicle.getInstance();
			pstat = conn.prepareStatement(query);
			pstat.setString(1, vehicle.getModel());
			pstat.setString(2, vehicle.getYear());
			pstat.setString(3, vehicle.getPrice());
			pstat.setString(4, vehicle.getChassisNo());
			pstat.setDouble(5, vehicle.getKdvRate());
			pstat.setString(6, vehicle.getExplanation());

			pstat.executeUpdate();
			pstat.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getVehicleWithStatement(String query) {
		NewVehicle vehicle = NewVehicle.getInstance();
		try {

			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(query);

			if (rs.next()) {
				vehicle.setModel(rs.getString("Model"));
				vehicle.setYear(rs.getString("Year"));
				vehicle.setPrice(rs.getString("Price"));
				vehicle.setChassisNo(rs.getString("ChassisNo"));
				vehicle.setKdvRate(rs.getDouble("KdvRate"));
				vehicle.setExplanation(rs.getString("Explanation"));

			}
			stat.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getVehicleWithPreparedStatement(String query, String chassisNo) {
		NewVehicle vehicle = NewVehicle.getInstance();
		try {
			pstat = conn.prepareStatement(query);
			pstat.setString(1, chassisNo);
			ResultSet rs = pstat.executeQuery(query);

			if (rs.next()) {

				vehicle.setModel(rs.getString("Model"));
				vehicle.setYear(rs.getString("Year"));
				vehicle.setPrice(rs.getString("Price"));
				vehicle.setChassisNo(rs.getString("ChassisNo"));
				vehicle.setExplanation(rs.getString("Explanation"));

			}
			
			rs.close();
			pstat.close();

		} catch (Exception e) {
			e.printStackTrace();

		}
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

	public double getKdvRate() {
		return kdvRate;
	}

	public void setKdvRate(double kdvRate) {
		this.kdvRate = kdvRate;
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

package view.vehicles;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;
import javax.swing.JSeparator;
import javax.swing.JButton;

public class SecondHandVehicleFrame extends JInternalFrame {
	public JTextField customerName;
	public JTextField customerSurname;
	public JTextField customerTcNo;
	public JTextField customerPhoneNumber;
	public JTextField receivingPrice;
	public JTextField model;
	public JTextField year;
	public JTextField licensePlate;
	public JTextField chassisNo;
	public JFormattedTextField dateArea;
	public JTextArea explanation;
	public JButton receivingButton;
	public JTextField customerAddress;

	public SecondHandVehicleFrame() {
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setTitle("İkinci El Alış");
		setBounds(100, 100, 1156, 599);
		getContentPane().setLayout(null);
		
		customerName = new JTextField();
		customerName.setColumns(10);
		customerName.setBounds(803, 81, 240, 30);
		getContentPane().add(customerName);
		
		JLabel name = new JLabel("Ad");
		name.setHorizontalAlignment(SwingConstants.LEFT);
		name.setFont(new Font("Tahoma", Font.PLAIN, 15));
		name.setBounds(649, 81, 90, 30);
		getContentPane().add(name);
		
		customerSurname = new JTextField();
		customerSurname.setColumns(10);
		customerSurname.setBounds(803, 131, 240, 30);
		getContentPane().add(customerSurname);
		
		JLabel lblNewLabel_1 = new JLabel("Soyad");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(649, 131, 90, 30);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tc Kimlik No");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(649, 181, 90, 30);
		getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Numara");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(649, 231, 90, 30);
		getContentPane().add(lblNewLabel_1_2);
		
		customerTcNo = new JTextField();
		customerTcNo.setColumns(10);
		customerTcNo.setBounds(803, 181, 240, 30);
		getContentPane().add(customerTcNo);
		
		customerPhoneNumber = new JTextField();
		customerPhoneNumber.setColumns(10);
		customerPhoneNumber.setBounds(803, 231, 240, 30);
		getContentPane().add(customerPhoneNumber);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(612, 60, 509, 2);
		getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(612, 352, 509, 2);
		getContentPane().add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBounds(611, 60, 22, 294);
		getContentPane().add(separator_2);
		
		JSeparator separator_2_1 = new JSeparator();
		separator_2_1.setOrientation(SwingConstants.VERTICAL);
		separator_2_1.setBounds(1120, 60, 11, 294);
		getContentPane().add(separator_2_1);
		
		JLabel lblNewLabel = new JLabel("  Müşteri Bilgileri");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(611, 22, 127, 27);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Alış Fiyatı");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_1.setBounds(78, 275, 112, 30);
		getContentPane().add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_3 = new JLabel("Açıklama");
		lblNewLabel_1_2_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_3.setBounds(78, 325, 90, 30);
		getContentPane().add(lblNewLabel_1_2_3);
		
		receivingPrice = new JTextField();
		receivingPrice.setColumns(10);
		receivingPrice.setBounds(232, 275, 240, 30);
		getContentPane().add(receivingPrice);
		
		explanation = new JTextArea();
		explanation.setBounds(232, 325, 240, 120);
		getContentPane().add(explanation);
		
		dateArea = new JFormattedTextField();
		dateArea.setEnabled(false);
		dateArea.setBounds(232, 465, 240, 30);
		getContentPane().add(dateArea);
		
		JLabel lblNewLabel_1_2_3_1 = new JLabel("Alış Zamanı");
		lblNewLabel_1_2_3_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_2_3_1.setBounds(78, 465, 144, 30);
		getContentPane().add(lblNewLabel_1_2_3_1);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Model");
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_1_1.setBounds(79, 75, 112, 30);
		getContentPane().add(lblNewLabel_1_2_1_1);
		
		JLabel lblNewLabel_1_2_2_1 = new JLabel("Yılı");
		lblNewLabel_1_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_2_1.setBounds(79, 125, 112, 30);
		getContentPane().add(lblNewLabel_1_2_2_1);
		
		model = new JTextField();
		model.setColumns(10);
		model.setBounds(233, 75, 240, 30);
		getContentPane().add(model);
		
		year = new JTextField();
		year.setColumns(10);
		year.setBounds(233, 125, 240, 30);
		getContentPane().add(year);
		
		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("Plaka");
		lblNewLabel_1_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_1_1_1.setBounds(78, 175, 112, 30);
		getContentPane().add(lblNewLabel_1_2_1_1_1);
		
		JLabel lblNewLabel_1_2_2_1_1 = new JLabel("Şasi Numarası");
		lblNewLabel_1_2_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_2_1_1.setBounds(78, 225, 112, 30);
		getContentPane().add(lblNewLabel_1_2_2_1_1);
		
		licensePlate = new JTextField();
		licensePlate.setColumns(10);
		licensePlate.setBounds(232, 175, 240, 30);
		getContentPane().add(licensePlate);
		
		chassisNo = new JTextField();
		chassisNo.setColumns(10);
		chassisNo.setBounds(232, 225, 240, 30);
		getContentPane().add(chassisNo);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(41, 60, 509, 2);
		getContentPane().add(separator_1_1);
		
		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setBounds(41, 506, 509, 2);
		getContentPane().add(separator_1_2);
		
		JSeparator separator_2_1_1 = new JSeparator();
		separator_2_1_1.setOrientation(SwingConstants.VERTICAL);
		separator_2_1_1.setBounds(549, 60, 11, 448);
		getContentPane().add(separator_2_1_1);
		
		JSeparator separator_2_1_1_1 = new JSeparator();
		separator_2_1_1_1.setOrientation(SwingConstants.VERTICAL);
		separator_2_1_1_1.setBounds(41, 60, 257, 448);
		getContentPane().add(separator_2_1_1_1);
		
		JLabel lblAraBilgileri = new JLabel("  Araç Bilgileri");
		lblAraBilgileri.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAraBilgileri.setBounds(41, 22, 100, 27);
		getContentPane().add(lblAraBilgileri);
		
		receivingButton = new JButton("Alış");
		receivingButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		receivingButton.setBounds(957, 401, 100, 30);
		getContentPane().add(receivingButton);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Adres");
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_2.setBounds(649, 281, 90, 30);
		getContentPane().add(lblNewLabel_1_2_2);
		
		customerAddress = new JTextField();
		customerAddress.setColumns(10);
		customerAddress.setBounds(803, 281, 296, 60);
		getContentPane().add(customerAddress);

	}
}

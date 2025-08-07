package view.vehicles;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class SoldVehicleFrame extends JInternalFrame {
	public JTextField customerName;
	public JTextField customerSurname;
	public JTextField customerTcNo;
	public JTextField customerPhoneNumber;
	public JTextField customerAddress;
	public JTextField receivingPrice;
	public JTextField year;
	public JTextField licensePlate;
	public JTextField chassisNo;
	public JComboBox modelsComboBox;
	public JTextField salePrice;
	public JTextArea explanation; 
	public JFormattedTextField dateArea;
	public JButton saleButton;
	public JComboBox vehicleTypeComboBox;
	public JTextField model;
	public JTextField receivedPayment;

	public SoldVehicleFrame() {
		setClosable(true);
		setIconifiable(true);
		setMaximizable(true);
		setTitle("Araç Satış");
		setBounds(100, 100, 1194, 779);
		getContentPane().setLayout(null);
		
		customerName = new JTextField();
		customerName.setColumns(10);
		customerName.setBounds(771, 79, 240, 30);
		getContentPane().add(customerName);
		
		JLabel name = new JLabel("Ad");
		name.setHorizontalAlignment(SwingConstants.LEFT);
		name.setFont(new Font("Tahoma", Font.PLAIN, 15));
		name.setBounds(617, 79, 90, 30);
		getContentPane().add(name);
		
		customerSurname = new JTextField();
		customerSurname.setColumns(10);
		customerSurname.setBounds(771, 129, 240, 30);
		getContentPane().add(customerSurname);
		
		JLabel lblNewLabel_1 = new JLabel("Soyad");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(617, 129, 90, 30);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tc Kimlik No");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(617, 179, 90, 30);
		getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Numara");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(617, 229, 90, 30);
		getContentPane().add(lblNewLabel_1_2);
		
		customerTcNo = new JTextField();
		customerTcNo.setColumns(10);
		customerTcNo.setBounds(771, 179, 240, 30);
		getContentPane().add(customerTcNo);
		
		customerPhoneNumber = new JTextField();
		customerPhoneNumber.setColumns(10);
		customerPhoneNumber.setBounds(771, 229, 240, 30);
		getContentPane().add(customerPhoneNumber);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(580, 58, 509, 2);
		getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(580, 353, 509, 2);
		getContentPane().add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBounds(580, 58, 23, 297);
		getContentPane().add(separator_2);
		
		JSeparator separator_2_1 = new JSeparator();
		separator_2_1.setOrientation(SwingConstants.VERTICAL);
		separator_2_1.setBounds(1088, 58, 11, 297);
		getContentPane().add(separator_2_1);
		
		JLabel lblNewLabel = new JLabel("  Müşteri Bilgileri");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(580, 32, 127, 27);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Alış Fiyatı");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_1.setBounds(72, 375, 112, 30);
		getContentPane().add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_3 = new JLabel("Açıklama");
		lblNewLabel_1_2_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_3.setBounds(72, 525, 90, 30);
		getContentPane().add(lblNewLabel_1_2_3);
		
		receivingPrice = new JTextField();
		receivingPrice.setEditable(false);
		receivingPrice.setColumns(10);
		receivingPrice.setBounds(226, 375, 240, 30);
		getContentPane().add(receivingPrice);
		
		explanation = new JTextArea();
		explanation.setBounds(226, 525, 240, 120);
		getContentPane().add(explanation);
		
		dateArea = new JFormattedTextField();
		dateArea.setEnabled(false);
		dateArea.setBounds(226, 665, 240, 30);
		getContentPane().add(dateArea);
		
		JLabel lblNewLabel_1_2_3_1 = new JLabel("Satış Zamanı");
		lblNewLabel_1_2_3_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_2_3_1.setBounds(72, 665, 144, 30);
		getContentPane().add(lblNewLabel_1_2_3_1);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Araç");
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_1_1.setBounds(74, 125, 112, 30);
		getContentPane().add(lblNewLabel_1_2_1_1);
		
		JLabel lblNewLabel_1_2_2_1 = new JLabel("Yılı");
		lblNewLabel_1_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_2_1.setBounds(73, 225, 112, 30);
		getContentPane().add(lblNewLabel_1_2_2_1);
		
		year = new JTextField();
		year.setEditable(false);
		year.setColumns(10);
		year.setBounds(227, 225, 240, 30);
		getContentPane().add(year);
		
		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("Plaka");
		lblNewLabel_1_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_1_1_1.setBounds(72, 275, 112, 30);
		getContentPane().add(lblNewLabel_1_2_1_1_1);
		
		JLabel lblNewLabel_1_2_2_1_1 = new JLabel("Şasi Numarası");
		lblNewLabel_1_2_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_2_1_1.setBounds(72, 325, 112, 30);
		getContentPane().add(lblNewLabel_1_2_2_1_1);
		
		licensePlate = new JTextField();
		licensePlate.setColumns(10);
		licensePlate.setBounds(226, 275, 240, 30);
		getContentPane().add(licensePlate);
		
		chassisNo = new JTextField();
		chassisNo.setEditable(false);
		chassisNo.setColumns(10);
		chassisNo.setBounds(226, 325, 240, 30);
		getContentPane().add(chassisNo);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(36, 55, 509, 2);
		getContentPane().add(separator_1_1);
		
		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setBounds(36, 708, 509, 2);
		getContentPane().add(separator_1_2);
		
		JSeparator separator_2_1_1 = new JSeparator();
		separator_2_1_1.setOrientation(SwingConstants.VERTICAL);
		separator_2_1_1.setBounds(544, 55, 11, 655);
		getContentPane().add(separator_2_1_1);
		
		JSeparator separator_2_1_1_1 = new JSeparator();
		separator_2_1_1_1.setOrientation(SwingConstants.VERTICAL);
		separator_2_1_1_1.setBounds(36, 55, 23, 657);
		getContentPane().add(separator_2_1_1_1);
		
		JLabel lblAraBilgileri = new JLabel("  Araç Bilgileri");
		lblAraBilgileri.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAraBilgileri.setBounds(36, 32, 100, 27);
		getContentPane().add(lblAraBilgileri);
		
		modelsComboBox = new JComboBox();

		modelsComboBox.setBounds(227, 125, 240, 30);
		getContentPane().add(modelsComboBox);
		
		JLabel lblNewLabel_1_2_1_2 = new JLabel("Satış Fiyatı");
		lblNewLabel_1_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_1_2.setBounds(72, 425, 112, 30);
		getContentPane().add(lblNewLabel_1_2_1_2);
		
		salePrice = new JTextField();
		salePrice.setColumns(10);
		salePrice.setBounds(226, 425, 240, 30);
		getContentPane().add(salePrice);
		
		saleButton = new JButton("Satış");

		saleButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		saleButton.setBounds(975, 375, 100, 30);
		getContentPane().add(saleButton);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Adres");
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_2.setBounds(617, 279, 90, 30);
		getContentPane().add(lblNewLabel_1_2_2);
		
		customerAddress = new JTextField();
		customerAddress.setColumns(10);
		customerAddress.setBounds(771, 279, 296, 60);
		getContentPane().add(customerAddress);
		
		JLabel lblNewLabel_1_2_1_1_2 = new JLabel("Araç Türü");
		lblNewLabel_1_2_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_1_1_2.setBounds(73, 75, 112, 30);
		getContentPane().add(lblNewLabel_1_2_1_1_2);
		
		 vehicleTypeComboBox = new JComboBox();

		vehicleTypeComboBox.setFont(new Font("Tahoma", Font.BOLD, 11));
		vehicleTypeComboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Yeni Araç", "İkinci El Araç", "Takas Araç"}));
		vehicleTypeComboBox.setBounds(226, 75, 240, 30);
		getContentPane().add(vehicleTypeComboBox);
		
		JLabel lblNewLabel_1_2_2_1_2 = new JLabel("Model");
		lblNewLabel_1_2_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_2_1_2.setBounds(73, 175, 112, 30);
		getContentPane().add(lblNewLabel_1_2_2_1_2);
		
		model = new JTextField();
		model.setEditable(false);
		model.setColumns(10);
		model.setBounds(227, 175, 240, 30);
		getContentPane().add(model);
		
		JLabel lblNewLabel_1_2_1_2_1 = new JLabel("Alınan Ödeme");
		lblNewLabel_1_2_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_1_2_1.setBounds(72, 475, 112, 30);
		getContentPane().add(lblNewLabel_1_2_1_2_1);
		
		receivedPayment = new JTextField();
		receivedPayment.setColumns(10);
		receivedPayment.setBounds(226, 475, 240, 30);
		getContentPane().add(receivedPayment);

	}
}

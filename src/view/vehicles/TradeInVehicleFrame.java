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

public class TradeInVehicleFrame extends JInternalFrame {
	public JTextField customerName;
	public JTextField customerSurname;
	public JTextField customerTcNo;
	public JTextField customerPhoneNumber;
	public JTextField receivingPrice;
	public JTextField model;
	public JTextField year;
	public JTextField licensePlate;
	public JTextField chassisNo;
	public JTextArea explanation; 
	public JButton receivingButton;
	public JFormattedTextField dateArea;
	public JTextField customerAddress;

	public TradeInVehicleFrame() {
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Takas Alış");
		setBounds(100, 100, 1166, 611);
		getContentPane().setLayout(null);
		
		customerName = new JTextField();
		customerName.setColumns(10);
		customerName.setBounds(782, 82, 240, 30);
		getContentPane().add(customerName);
		
		JLabel name = new JLabel("Ad");
		name.setHorizontalAlignment(SwingConstants.LEFT);
		name.setFont(new Font("Tahoma", Font.PLAIN, 15));
		name.setBounds(628, 82, 90, 30);
		getContentPane().add(name);
		
		customerSurname = new JTextField();
		customerSurname.setColumns(10);
		customerSurname.setBounds(782, 132, 240, 30);
		getContentPane().add(customerSurname);
		
		JLabel lblNewLabel_1 = new JLabel("Soyad");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(628, 132, 90, 30);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tc Kimlik No");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(628, 182, 90, 30);
		getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Numara");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(628, 232, 90, 30);
		getContentPane().add(lblNewLabel_1_2);
		
		customerTcNo = new JTextField();
		customerTcNo.setColumns(10);
		customerTcNo.setBounds(782, 182, 240, 30);
		getContentPane().add(customerTcNo);
		
		customerPhoneNumber = new JTextField();
		customerPhoneNumber.setColumns(10);
		customerPhoneNumber.setBounds(782, 232, 240, 30);
		getContentPane().add(customerPhoneNumber);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(591, 61, 509, 2);
		getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(591, 353, 509, 2);
		getContentPane().add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBounds(591, 61, 11, 294);
		getContentPane().add(separator_2);
		
		JSeparator separator_2_1 = new JSeparator();
		separator_2_1.setOrientation(SwingConstants.VERTICAL);
		separator_2_1.setBounds(1099, 61, 11, 294);
		getContentPane().add(separator_2_1);
		
		JLabel lblNewLabel = new JLabel("  Müşteri Bilgileri");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(591, 20, 127, 27);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Alış Fiyatı");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_1.setBounds(84, 273, 112, 30);
		getContentPane().add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_3 = new JLabel("Açıklama");
		lblNewLabel_1_2_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_3.setBounds(84, 323, 90, 30);
		getContentPane().add(lblNewLabel_1_2_3);
		
		receivingPrice = new JTextField();
		receivingPrice.setColumns(10);
		receivingPrice.setBounds(238, 273, 240, 30);
		getContentPane().add(receivingPrice);
		
		explanation = new JTextArea();
		explanation.setBounds(238, 323, 240, 120);
		getContentPane().add(explanation);
		
		dateArea = new JFormattedTextField();
		dateArea.setEnabled(false);
		dateArea.setBounds(238, 463, 240, 30);
		getContentPane().add(dateArea);
		
		JLabel lblNewLabel_1_2_3_1 = new JLabel("Alış Zamanı");
		lblNewLabel_1_2_3_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_2_3_1.setBounds(84, 463, 144, 30);
		getContentPane().add(lblNewLabel_1_2_3_1);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Model");
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_1_1.setBounds(85, 73, 112, 30);
		getContentPane().add(lblNewLabel_1_2_1_1);
		
		JLabel lblNewLabel_1_2_2_1 = new JLabel("Yılı");
		lblNewLabel_1_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_2_1.setBounds(85, 123, 112, 30);
		getContentPane().add(lblNewLabel_1_2_2_1);
		
		model = new JTextField();
		model.setColumns(10);
		model.setBounds(239, 73, 240, 30);
		getContentPane().add(model);
		
		year = new JTextField();
		year.setColumns(10);
		year.setBounds(239, 123, 240, 30);
		getContentPane().add(year);
		
		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("Plaka");
		lblNewLabel_1_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_1_1_1.setBounds(84, 173, 112, 30);
		getContentPane().add(lblNewLabel_1_2_1_1_1);
		
		JLabel lblNewLabel_1_2_2_1_1 = new JLabel("Şasi Numarası");
		lblNewLabel_1_2_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_2_1_1.setBounds(84, 223, 112, 30);
		getContentPane().add(lblNewLabel_1_2_2_1_1);
		
		licensePlate = new JTextField();
		licensePlate.setColumns(10);
		licensePlate.setBounds(238, 173, 240, 30);
		getContentPane().add(licensePlate);
		
		chassisNo = new JTextField();
		chassisNo.setColumns(10);
		chassisNo.setBounds(238, 223, 240, 30);
		getContentPane().add(chassisNo);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(47, 58, 509, 2);
		getContentPane().add(separator_1_1);
		
		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setBounds(47, 504, 509, 2);
		getContentPane().add(separator_1_2);
		
		JSeparator separator_2_1_1 = new JSeparator();
		separator_2_1_1.setOrientation(SwingConstants.VERTICAL);
		separator_2_1_1.setBounds(555, 58, 11, 448);
		getContentPane().add(separator_2_1_1);
		
		JSeparator separator_2_1_1_1 = new JSeparator();
		separator_2_1_1_1.setOrientation(SwingConstants.VERTICAL);
		separator_2_1_1_1.setBounds(47, 58, 257, 448);
		getContentPane().add(separator_2_1_1_1);
		
		JLabel lblAraBilgileri = new JLabel("  Araç Bilgileri");
		lblAraBilgileri.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAraBilgileri.setBounds(47, 20, 100, 27);
		getContentPane().add(lblAraBilgileri);
		
		receivingButton = new JButton("Alış");
		receivingButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		receivingButton.setBounds(942, 403, 100, 30);
		getContentPane().add(receivingButton);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Adres");
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_2.setBounds(628, 282, 90, 30);
		getContentPane().add(lblNewLabel_1_2_2);
		
		customerAddress = new JTextField();
		customerAddress.setColumns(10);
		customerAddress.setBounds(782, 282, 296, 60);
		getContentPane().add(customerAddress);

	}

}

package view.vehicles;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NewVehicleFrame extends JInternalFrame {
	public JTextField modell;
	public JTextField year;
	public JTextField price;
	public JTextField chassisNo;
	public JTextField kdvRate;
	public JFormattedTextField dateArea;
	public JTextArea explanation;
	public JButton receivingButton;


	public NewVehicleFrame() {
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setTitle("Araç Alış");
		setBounds(100, 100, 560, 611);
		getContentPane().setLayout(null);
		
		modell = new JTextField();
		modell.setColumns(10);
		modell.setBounds(217, 32, 240, 30);
		getContentPane().add(modell);
		
		JLabel model = new JLabel("Model");
		model.setHorizontalAlignment(SwingConstants.LEFT);
		model.setFont(new Font("Tahoma", Font.PLAIN, 15));
		model.setBounds(63, 32, 90, 30);
		getContentPane().add(model);
		
		year = new JTextField();
		year.setColumns(10);
		year.setBounds(217, 82, 240, 30);
		getContentPane().add(year);
		
		JLabel lblNewLabel_1 = new JLabel("Yılı");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(63, 82, 90, 30);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Şasi Numarası");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(63, 133, 112, 30);
		getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblFiyat = new JLabel("Fiyat");
		lblFiyat.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFiyat.setBounds(63, 183, 112, 30);
		getContentPane().add(lblFiyat);
		
		JLabel lblNewLabel_1_2_3 = new JLabel("Açıklama");
		lblNewLabel_1_2_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_3.setBounds(63, 283, 90, 30);
		getContentPane().add(lblNewLabel_1_2_3);
		
		price = new JTextField();
		price.setColumns(10);
		price.setBounds(217, 183, 240, 30);
		getContentPane().add(price);
		
		explanation = new JTextArea();
		explanation.setBounds(217, 283, 240, 120);
		getContentPane().add(explanation);
		
		dateArea = new JFormattedTextField();
		dateArea.setEnabled(false);
		dateArea.setBounds(217, 423, 240, 30);
		getContentPane().add(dateArea);
		
		JLabel lblNewLabel_1_2_3_1 = new JLabel("Alış Zamanı");
		lblNewLabel_1_2_3_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_2_3_1.setBounds(63, 423, 144, 30);
		getContentPane().add(lblNewLabel_1_2_3_1);
		
		chassisNo = new JTextField();
		chassisNo.setColumns(10);
		chassisNo.setBounds(217, 133, 240, 30);
		getContentPane().add(chassisNo);
		
		JLabel lblKdvOran = new JLabel("Kdv Oranı");
		lblKdvOran.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblKdvOran.setBounds(63, 233, 112, 30);
		getContentPane().add(lblKdvOran);
		
		kdvRate = new JTextField();
		kdvRate.setColumns(10);
		kdvRate.setBounds(217, 233, 240, 30);
		getContentPane().add(kdvRate);
		
		receivingButton = new JButton("Alış");

		receivingButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		receivingButton.setBounds(357, 489, 100, 30);
		getContentPane().add(receivingButton);
		
		JLabel lblNewLabel = new JLabel("TL");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(467, 183, 52, 30);
		getContentPane().add(lblNewLabel);

	}
}

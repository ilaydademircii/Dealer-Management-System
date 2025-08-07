package view.payments;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ReceivingPaymentFrame extends JInternalFrame {
	public JTextField customerIdNo;
	public JTextField remainingPayment;
	public JTextField receivedPayment;
	public JButton searchButton;
	public JButton getPaymnetsButton;

	public ReceivingPaymentFrame() {
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setTitle("Ödeme");
		setBounds(100, 100, 548, 481);
		getContentPane().setLayout(null);

		customerIdNo = new JTextField();
		customerIdNo.setColumns(10);
		customerIdNo.setBounds(190, 47, 240, 30);
		getContentPane().add(customerIdNo);

		JLabel lblTcKimlikNo = new JLabel("Tc Kimlik No");
		lblTcKimlikNo.setHorizontalAlignment(SwingConstants.LEFT);
		lblTcKimlikNo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTcKimlikNo.setBounds(36, 47, 90, 30);
		getContentPane().add(lblTcKimlikNo);

		remainingPayment = new JTextField();
		remainingPayment.setEditable(false);
		remainingPayment.setColumns(10);
		remainingPayment.setBounds(190, 99, 240, 30);
		getContentPane().add(remainingPayment);

		JLabel lblKalandeme = new JLabel("Kalan Ödeme");
		lblKalandeme.setHorizontalAlignment(SwingConstants.LEFT);
		lblKalandeme.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblKalandeme.setBounds(36, 99, 109, 30);
		getContentPane().add(lblKalandeme);

		JSeparator separator = new JSeparator();
		separator.setBounds(24, 189, 473, 2);
		getContentPane().add(separator);

		JLabel receivingPayment = new JLabel("Ödeme Alış ");
		receivingPayment.setFont(new Font("Tahoma", Font.BOLD, 15));
		receivingPayment.setBounds(36, 201, 109, 22);
		getContentPane().add(receivingPayment);

		receivedPayment = new JTextField();
		receivedPayment.setColumns(10);
		receivedPayment.setBounds(190, 263, 240, 30);
		getContentPane().add(receivedPayment);

		JLabel lblAlnandeme = new JLabel("Alınan Ödeme Miktarı :");
		lblAlnandeme.setHorizontalAlignment(SwingConstants.LEFT);
		lblAlnandeme.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAlnandeme.setBounds(36, 261, 154, 30);
		getContentPane().add(lblAlnandeme);

		getPaymnetsButton = new JButton("Ödeme al");
		getPaymnetsButton.setBounds(335, 319, 89, 23);
		getContentPane().add(getPaymnetsButton);

		searchButton = new JButton("");

		searchButton.setIcon(new ImageIcon("C:\\Users\\zehra\\OneDrive\\Masaüstü\\icons\\icons8-search-20.png"));
		searchButton.setBounds(372, 140, 58, 26);
		getContentPane().add(searchButton);

	}

}

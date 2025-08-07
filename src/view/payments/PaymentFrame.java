package view.payments;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class PaymentFrame extends JInternalFrame {
	public JTextField IdNo;
	public JTable table;
	public DefaultTableModel modelim;
	Object[] colums = {"Ödenen Tutar","Ödeme Tarihi"};

	public JButton searchButton;


	public PaymentFrame() {
		setTitle("Geçmiş Ödemeler");
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setBounds(100, 100, 838, 656);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tc Kimlik No :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(52, 37, 90, 30);
		getContentPane().add(lblNewLabel_1_1);
		
		IdNo = new JTextField();
		IdNo.setColumns(10);
		IdNo.setBounds(206, 37, 240, 30);
		getContentPane().add(IdNo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(52, 149, 715, 301);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		modelim = new DefaultTableModel();
		modelim.setColumnIdentifiers(colums);
		
		searchButton = new JButton("");
		searchButton.setIcon(new ImageIcon("C:\\Users\\zehra\\OneDrive\\Masaüstü\\icons\\icons8-search-20.png"));
		searchButton.setBounds(469, 37, 58, 26);
		getContentPane().add(searchButton);

	}
}

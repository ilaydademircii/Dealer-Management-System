package payments;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AllRemainingPaymentsFrame extends JInternalFrame {
	public JTable table;
	public JButton searchButton;
	public DefaultTableModel modelim;
	Object[] colums = {"Tc Kimlik No","Ad","Soyad","Kalan Ödeme"};

	public AllRemainingPaymentsFrame() {
		setClosable(true);
		setIconifiable(true);
		setMaximizable(true);
		setTitle("Kalan Ödemeler");
		setBounds(100, 100, 704, 546);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 36, 612, 349);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		
		table.setRowSelectionAllowed(false);
		table.setCellSelectionEnabled(true);
		
		scrollPane.setViewportView(table);
		modelim = new DefaultTableModel();
		modelim.setColumnIdentifiers(colums);
		
		table.setDefaultEditor(Object.class, null);
		searchButton = new JButton("Kalan Ödemeler");

		searchButton.setBounds(249, 408, 147, 23);
		getContentPane().add(searchButton);

	}
}

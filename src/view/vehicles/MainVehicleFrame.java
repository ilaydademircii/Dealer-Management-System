package view.vehicles;

import javax.swing.JInternalFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainVehicleFrame extends JInternalFrame {


	public MainVehicleFrame() {
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JButton tradeInButton = new JButton("Takas");
		tradeInButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		tradeInButton.setBounds(154, 52, 89, 23);
		getContentPane().add(tradeInButton);
		
		JButton secondHandButton = new JButton("İkinci El");
		secondHandButton.setBounds(154, 86, 89, 23);
		getContentPane().add(secondHandButton);

	}
}

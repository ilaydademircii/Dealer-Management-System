package view;

import java.awt.CardLayout;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	public JDesktopPane desktopPane;
	public JMenuItem secondHandVehiclesMenuItem;
	public JMenuItem tradeInVehicleMenuItem;
	public JMenu paymentsMenu;
	public JMenuItem newVehiclesMenuItem;
	public JMenuItem soldVehiclesMenuItem;
	public JMenuItem paymentMenuItem;
	public JMenuItem receivingPaymentMenuItem;
	public JMenuItem remainingPaymentsMenuItem;


	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu vehiclesMenu = new JMenu("Araçlar");
		menuBar.add(vehiclesMenu);
		
		secondHandVehiclesMenuItem = new JMenuItem("İkinci El ");

		vehiclesMenu.add(secondHandVehiclesMenuItem);
		
		tradeInVehicleMenuItem = new JMenuItem("Takas");
		vehiclesMenu.add(tradeInVehicleMenuItem);
		
		newVehiclesMenuItem = new JMenuItem("Yeni Araç");
		vehiclesMenu.add(newVehiclesMenuItem);
		
		soldVehiclesMenuItem = new JMenuItem("Araç Satış");
		vehiclesMenu.add(soldVehiclesMenuItem);
		
		paymentsMenu = new JMenu("Ödemeler");
		menuBar.add(paymentsMenu);
		
		receivingPaymentMenuItem = new JMenuItem("Ödeme Alış");
		paymentsMenu.add(receivingPaymentMenuItem);
		
		paymentMenuItem = new JMenuItem("Geçmiş Ödemeler");
		paymentsMenu.add(paymentMenuItem);
		
		remainingPaymentsMenuItem = new JMenuItem("Kalan Ödemeler");
		paymentsMenu.add(remainingPaymentsMenuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));

		desktopPane = new JDesktopPane();
		contentPane.add(desktopPane, "name_73753716930100");

	}
}

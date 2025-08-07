package controllers.payments;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import command.PaymentCommands.listingPaymentsCommand.ListingAllRemainingPaymentsCommand;
import model.Customer;
import model.payments.AllRemainingPayments;
import view.MainFrame;
import view.payments.AllRemainingPaymentsFrame;

public class AllRemainingPaymentsController {

	
	private MainFrame mainFrame;
	AllRemainingPaymentsFrame frame;
	
	AllRemainingPayments payments;
	Customer customer;
	
	ListingAllRemainingPaymentsCommand listingAllRemainingPayments;
	
	public AllRemainingPaymentsController(MainFrame mainFrame) {
		super();
		this.mainFrame = mainFrame;
		this.frame = new AllRemainingPaymentsFrame();
		this.payments=AllRemainingPayments.getInstance();
		this.customer=Customer.getInstance();
		this.listingAllRemainingPayments=new ListingAllRemainingPaymentsCommand(frame);
	}
	
	public void execute() {
		fillFrameInstance();
		search();
	}

	
	private void fillFrameInstance() {
		frame.setVisible(true);
		mainFrame.desktopPane.add(frame);
		frame.toFront();
	}

	private void search() {
		frame.searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listingAllRemainingPayments.execute();				
			}
		});
	}
	
	
	
	
}

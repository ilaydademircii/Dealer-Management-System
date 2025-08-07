package controllers.payments;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import command.PaymentCommands.listingPaymentsCommand.ListingPaymentsCommand;
import model.Customer;
import model.payments.Payment;
import view.MainFrame;
import view.payments.PaymentFrame;

public class PaymentController {
	private MainFrame mainFrame;
	PaymentFrame frame;
	
	Payment payments;
	Customer customer;
	
	ListingPaymentsCommand listingCommand;
	
	public PaymentController(MainFrame mainFrame) {
		super();
		this.mainFrame = mainFrame;
		this.frame = new PaymentFrame();
		this.payments=Payment.getInstance();
		this.customer=Customer.getInstance();
		this.listingCommand=new ListingPaymentsCommand(frame);
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
				customer.setIdNumber(frame.IdNo.getText().trim());
				listingCommand.execute();				
			}
		});
	}
	
	
	
}

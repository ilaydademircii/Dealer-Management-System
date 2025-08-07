package controllers.payments;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import command.PaymentCommands.getCustomerIdNoCommand.GetCustomerIdNoCommand;
import command.PaymentCommands.receivingPaymentButtonCommand.ReceivingPaymentCommand;
import model.payments.ReceivingPayment;
import view.MainFrame;
import view.payments.ReceivingPaymentFrame;

public class ReceivingPaymentController {
	private MainFrame mainFrame;
	ReceivingPaymentFrame frame;

	ReceivingPayment receivingPayments;

	GetCustomerIdNoCommand getCustomerIdNoCommand;
	ReceivingPaymentCommand receivingPaymentCommand;

	public ReceivingPaymentController(MainFrame mainFrame) {
		super();
		this.mainFrame = mainFrame;
		this.frame = new ReceivingPaymentFrame();
		this.getCustomerIdNoCommand = new GetCustomerIdNoCommand(frame);
		this.receivingPaymentCommand=new ReceivingPaymentCommand(frame);
		this.receivingPayments = ReceivingPayment.getInstance();
	}

	public void execute() {
		fillFrameInstance();
		search();
		getPayment();

	}

	private void fillFrameInstance() {
		frame.setVisible(true);
		mainFrame.desktopPane.add(frame);
		frame.toFront();
	}

	private void search() {
		frame.searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReceivingPayment.getInstance().setCustomerIdNo(frame.customerIdNo.getText());
				frame.remainingPayment.setText(receivingPayments.getRemainingPaymentAmount());
				
			}
		});
	}

	private void getPayment() {
		frame.getPaymnetsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				receivingPaymentCommand.execute();
				receivingPayments.savePayment();
				receivingPayments.setRemainingPaymentAmount();
				frame.remainingPayment.setText(receivingPayments.getRemainingPaymentAmount());
				
			}
		});
	}

}

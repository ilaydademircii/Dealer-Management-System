package command.PaymentCommands.getCustomerIdNoCommand;

import model.payments.Payment;
import view.payments.ReceivingPaymentFrame;

public class GetCustomerIdNoCommand {

	ReceivingPaymentFrame frame;
	Payment payment;

	public GetCustomerIdNoCommand(ReceivingPaymentFrame frame) {
		super();
		this.frame = frame;
		this.payment = Payment.getInstance();
	}
/*
	public void execute() {
		payment.setCustomerIdNo(frame.customerIdNo.getText().trim());
	}
	*/
}

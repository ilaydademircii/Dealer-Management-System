package command.PaymentCommands.receivingPaymentButtonCommand;

import model.payments.ReceivingPayment;
import view.payments.ReceivingPaymentFrame;

public class ReceivingPaymentCommand {
	
	ReceivingPaymentFrame frame;
	ReceivingPayment payment;

	public  ReceivingPaymentCommand(ReceivingPaymentFrame frame) {
		super();
		this.frame = frame;
		this.payment = ReceivingPayment.getInstance();
	}

	public void execute() {
		payment.setReceivedPayment(frame.receivedPayment.getText().trim());
	}
	
	
	
}

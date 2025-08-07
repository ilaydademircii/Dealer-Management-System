package command.PaymentCommands.receivingPaymentButtonCommand;

import model.payments.ReceivingPayment;
import view.vehicles.SoldVehicleFrame;

public class ReceivingPaymentForSoldVehicleCommand {
	SoldVehicleFrame frame;
	ReceivingPayment payment;
	String formattedPrice;
	String priceWithoutDot;

	public  ReceivingPaymentForSoldVehicleCommand(SoldVehicleFrame frame) {
		super();
		this.frame = frame;
		this.payment = ReceivingPayment.getInstance();
	}

	public void execute() {
		formattedPrice =frame.receivedPayment.getText().trim();
		priceWithoutDot = formattedPrice.replace(".", "");
		payment.setReceivedPayment(priceWithoutDot);
		payment.setCustomerIdNo(frame.customerTcNo.getText().trim());
	}
	
	
}

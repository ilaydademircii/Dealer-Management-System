package command.PaymentCommands.listingPaymentsCommand;

import model.payments.Payment;
import view.payments.PaymentFrame;

public class ListingPaymentsCommand {

	PaymentFrame frame;
	

	public ListingPaymentsCommand(PaymentFrame frame) {
		super();
		this.frame = frame;

	}

	public void execute() {
		frame.modelim.setRowCount(0);
		for (Payment p : Payment.getInstance().getAllReceivedPaymentsWithCustomerIdNo(frame.IdNo.getText().trim())) {
			Object[] rowData = {  p.getReceivedPayment(), p.getDate()};
			frame.modelim.addRow(rowData);

		}
		frame.table.setModel(frame.modelim);
	}

}


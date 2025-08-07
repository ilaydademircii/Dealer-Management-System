package command.PaymentCommands.listingPaymentsCommand;

import model.payments.AllRemainingPayments;
import view.payments.AllRemainingPaymentsFrame;

public class ListingAllRemainingPaymentsCommand {

	AllRemainingPaymentsFrame frame;

	public ListingAllRemainingPaymentsCommand(AllRemainingPaymentsFrame frame) {
		super();
		this.frame = frame;

	}

	public void execute() {
		frame.modelim.setRowCount(0);
		for (AllRemainingPayments p : AllRemainingPayments.getInstance().getAllRemainingPayments()) {
			Object[] rowData = {  p.getCustomerIdNo(),p.getCustomerName(),p.getCustomerSurname(),p.getRemainingPayments()};
			frame.modelim.addRow(rowData);

		}
		frame.table.setModel(frame.modelim);
	}

}

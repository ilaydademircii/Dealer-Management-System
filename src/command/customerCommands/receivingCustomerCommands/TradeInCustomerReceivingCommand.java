package command.customerCommands.receivingCustomerCommands;

import model.Customer;
import model.vehicles.SecondHandVehicle;
import view.vehicles.TradeInVehicleFrame;

public class TradeInCustomerReceivingCommand implements ReceivingCustomerCommand {

	TradeInVehicleFrame frame;
	Customer customer;
	SecondHandVehicle vehicle;

	public TradeInCustomerReceivingCommand(TradeInVehicleFrame frame) {
		super();
		this.frame = frame;
		this.customer = Customer.getInstance();
		this.vehicle = SecondHandVehicle.getInstance();
	}

	@Override
	public void execute() {
		customer.setName(frame.customerName.getText().trim());
		customer.setSurname(frame.customerSurname.getText().trim());
		customer.setIdNumber(frame.customerTcNo.getText().trim());
		customer.setPhoneNumber(frame.customerPhoneNumber.getText().trim());
		customer.setAddress(frame.customerAddress.getText().trim());

	}

}

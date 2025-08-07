package command.customerCommands.receivingCustomerCommands;

import model.Customer;
import view.vehicles.SecondHandVehicleFrame;

public class SecondHandCustomerReceivingCommand implements ReceivingCustomerCommand {

	SecondHandVehicleFrame frame;
	Customer customer;

	public SecondHandCustomerReceivingCommand(SecondHandVehicleFrame frame) {
		super();
		this.frame = frame;
		this.customer = Customer.getInstance();
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

package command.VehicleCommands.saveVehicleCommand;

import model.Customer;
import model.vehicles.TradeInVehicle;
import view.vehicles.TradeInVehicleFrame;

public class TradeInVReceivingButtonCommand implements VehicleReceivingButtonCommand {

	TradeInVehicleFrame frame;
	Customer customer;
	TradeInVehicle vehicle;

	public TradeInVReceivingButtonCommand(TradeInVehicleFrame frame) {
		super();
		this.frame = frame;
		this.customer = Customer.getInstance();
		this.vehicle = TradeInVehicle.getInstance();
	}

	@Override
	public void execute() {
		customer.setName(frame.customerName.getText().trim());
		customer.setSurname(frame.customerSurname.getText().trim());
		customer.setIdNumber(frame.customerTcNo.getText().trim());
		customer.setPhoneNumber(frame.customerPhoneNumber.getText().trim());
		customer.setAddress(frame.customerAddress.getText().trim());


		vehicle.setModel(frame.model.getText().trim());
		vehicle.setYear(frame.year.getText().trim());
		
		String formattedPrice =frame.receivingPrice.getText().trim();
		String priceWithoutDot = formattedPrice.replace(".", "");
		vehicle.setPrice(priceWithoutDot);
		
		vehicle.setLicensePlate(frame.licensePlate.getText().trim());
		vehicle.setChassisNo(frame.chassisNo.getText().trim());
		vehicle.setExplanation(frame.explanation.getText().trim());

	}

}

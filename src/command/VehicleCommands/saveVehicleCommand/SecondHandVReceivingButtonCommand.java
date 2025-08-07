package command.VehicleCommands.saveVehicleCommand;

import model.Customer;
import model.vehicles.SecondHandVehicle;
import view.vehicles.SecondHandVehicleFrame;

public class SecondHandVReceivingButtonCommand implements VehicleReceivingButtonCommand{
	
	SecondHandVehicleFrame frame;
	Customer customer;
	SecondHandVehicle vehicle;

	public SecondHandVReceivingButtonCommand(SecondHandVehicleFrame frame) {
		super();
		this.frame = frame;
		this.customer = Customer.getInstance();
		this.vehicle =SecondHandVehicle.getInstance();
	}

	@Override
	public void execute() {
		
		vehicle.setModel(frame.model.getText().trim());
		vehicle.setYear(frame.year.getText().trim());
		
		String formattedPrice =frame.receivingPrice.getText().trim();
		String priceWithoutDot = formattedPrice.replace(".", "");
		vehicle.setPrice(priceWithoutDot);
		
		vehicle.setChassisNo(frame.chassisNo.getText().trim());
		vehicle.setLicensePlate(frame.licensePlate.getText().trim());
		vehicle.setExplanation(frame.explanation.getText().trim());

	}

}

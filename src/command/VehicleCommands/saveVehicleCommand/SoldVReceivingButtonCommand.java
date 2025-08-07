package command.VehicleCommands.saveVehicleCommand;

import model.Customer;
import model.vehicles.SoldVehicle;
import view.vehicles.SoldVehicleFrame;

public class SoldVReceivingButtonCommand {
	SoldVehicleFrame frame;
	SoldVehicle vehicle;
	Customer customer;
	
	
	String formattedPrice;
	String priceWithoutDot;
	
	public SoldVReceivingButtonCommand(SoldVehicleFrame frame) {
		super();
		this.frame = frame;
		this.vehicle = SoldVehicle.getInstance();
		this.customer = Customer.getInstance();
	}
	
	public void execute(){
		customer.setName(frame.customerName.getText().trim());
		customer.setSurname(frame.customerSurname.getText().trim());
		customer.setIdNumber(frame.customerTcNo.getText().trim());
		customer.setPhoneNumber(frame.customerPhoneNumber.getText().trim());
		customer.setAddress(frame.customerAddress.getText().trim());


		vehicle.setModel(frame.model.getText().trim());
		vehicle.setYear(frame.year.getText().trim());
		vehicle.setLicensePlate(frame.licensePlate.getText().trim());
		vehicle.setYear(frame.year.getText().trim());
		
		formattedPrice =frame.receivingPrice.getText().trim();
		priceWithoutDot = formattedPrice.replace(".", "");
		
		vehicle.setReceivingPrice(priceWithoutDot);
		
		formattedPrice =frame.salePrice.getText().trim();
		priceWithoutDot = formattedPrice.replace(".", "");
		vehicle.setSalePrice(priceWithoutDot);
		
		vehicle.setRemainingPaymentAmount(frame.salePrice.getText().trim());
		
		formattedPrice =frame.receivedPayment.getText().trim();
		priceWithoutDot = formattedPrice.replace(".", "");
		
		vehicle.setReceivedPayment(priceWithoutDot);
		vehicle.setChassisNo(frame.chassisNo.getText().trim());
		vehicle.setExplanation(frame.explanation.getText().trim());

	}
}

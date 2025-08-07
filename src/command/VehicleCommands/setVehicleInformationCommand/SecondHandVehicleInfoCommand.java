package command.VehicleCommands.setVehicleInformationCommand;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

import model.vehicles.SecondHandVehicle;
import view.vehicles.SoldVehicleFrame;

public class SecondHandVehicleInfoCommand implements SetVehicleInfoCommand {

	SoldVehicleFrame frame;
	SecondHandVehicle vehicle;

	public SecondHandVehicleInfoCommand(SoldVehicleFrame frame) {
		super();
		this.frame = frame;
		this.vehicle = SecondHandVehicle.getInstance();
	}

	@Override
	public void execute() {
		frame.model.setText(vehicle.getModel());
		frame.year.setText(vehicle.getYear());
		
		BigDecimal priceAsBigDecimal = new BigDecimal(vehicle.getPrice());
		NumberFormat numberFormat = NumberFormat.getNumberInstance(new Locale("tr", "TR"));
		String formattedPrice = numberFormat.format(priceAsBigDecimal);
		formattedPrice += " TL";
		frame.receivingPrice.setText(formattedPrice);
		frame.licensePlate.setText(vehicle.getLicensePlate());
		frame.chassisNo.setText(vehicle.getChassisNo());
		frame.explanation.setText(vehicle.getExplanation());
	}

}

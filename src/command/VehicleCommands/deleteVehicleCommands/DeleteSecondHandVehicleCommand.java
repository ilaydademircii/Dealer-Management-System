package command.VehicleCommands.deleteVehicleCommands;

import model.vehicles.SecondHandVehicle;
import view.vehicles.SoldVehicleFrame;

public class DeleteSecondHandVehicleCommand implements DeleteVehicleCommand {

	SoldVehicleFrame frame;

	public DeleteSecondHandVehicleCommand(SoldVehicleFrame frame) {
		super();
		this.frame = frame;

	}

	@Override
	public void execute() {
		SecondHandVehicle vehicle = SecondHandVehicle.getInstance();
		vehicle.setLicensePlate(frame.licensePlate.getText().trim());

	}

}

package command.VehicleCommands.deleteVehicleCommands;

import model.vehicles.NewVehicle;
import view.vehicles.SoldVehicleFrame;

public class DeleteNewVehicleCommand implements DeleteVehicleCommand {

	SoldVehicleFrame frame;

	public DeleteNewVehicleCommand(SoldVehicleFrame frame) {
		super();
		this.frame = frame;

	}

	@Override
	public void execute() {
		NewVehicle vehicle = NewVehicle.getInstance();
		vehicle.setChassisNo(frame.chassisNo.getText().trim());

	}

}

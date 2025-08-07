package command.VehicleCommands.deleteVehicleCommands;

import model.vehicles.TradeInVehicle;
import view.vehicles.SoldVehicleFrame;

public class DeleteTradeInVehicleCommand implements DeleteVehicleCommand {

	SoldVehicleFrame frame;

	public DeleteTradeInVehicleCommand(SoldVehicleFrame frame) {
		super();
		this.frame = frame;

	}

	@Override
	public void execute() {
		TradeInVehicle vehicle = TradeInVehicle.getInstance();
		vehicle.setLicensePlate(frame.licensePlate.getText().trim());

	}

}

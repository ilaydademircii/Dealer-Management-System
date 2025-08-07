package command.VehicleCommands.comboBoxCommands;

import java.util.List;

import model.vehicles.TradeInVehicle;
import view.vehicles.SoldVehicleFrame;

public class TradeInModelsCommand {

	SoldVehicleFrame frame;
	List<String> list;

	public TradeInModelsCommand(SoldVehicleFrame frame) {
		super();
		this.frame = frame;
	}

	public void execute() {
		list = TradeInVehicle.getInstance().getAllVehicleWithLicensePlate();

		for (String licensePlate : list) {
			frame.modelsComboBox.addItem(licensePlate);
		}
	}
}

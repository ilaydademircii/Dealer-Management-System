package command.VehicleCommands.comboBoxCommands;

import java.util.List;

import model.vehicles.SecondHandVehicle;
import view.vehicles.SoldVehicleFrame;

public class SecondHandModelsCommand {
	
	SoldVehicleFrame frame;
	List<String> list;

	public SecondHandModelsCommand(SoldVehicleFrame frame) {
		super();
		this.frame = frame;
	}

	public void execute() {
		list = SecondHandVehicle.getInstance().getAllVehicleWithLicensePlate();

		for (String model : list) {
			frame.modelsComboBox.addItem(model);
		}
	}

}

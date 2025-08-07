package command.VehicleCommands.comboBoxCommands;

import java.util.List;

import model.vehicles.NewVehicle;
import view.vehicles.SoldVehicleFrame;

public class NewVehicleModelsCommand {

	SoldVehicleFrame frame;
	List<String> list;

	public NewVehicleModelsCommand(SoldVehicleFrame frame) {
		super();
		this.frame = frame;
	}

	public void execute() {
		list = NewVehicle.getInstance().getAllVehicleWithChassisNo();

		for (String model : list) {
			frame.modelsComboBox.addItem(model);
		}
	}
}

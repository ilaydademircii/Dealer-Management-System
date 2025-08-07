package controllers.vehicles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import command.VehicleCommands.saveVehicleCommand.NewVReceivingButtonCommand;
import model.vehicles.NewVehicle;
import view.MainFrame;
import view.vehicles.NewVehicleFrame;

public class NewVehicleController {

	private MainFrame mainFrame;
	NewVehicleFrame frame;
	
	NewVehicle vehicle;
	
	NewVReceivingButtonCommand receivingButtonCommand;
	
	public NewVehicleController(MainFrame mainFrame) {
		super();
		this.mainFrame = mainFrame;
		this.frame = new NewVehicleFrame();
		this.vehicle=NewVehicle.getInstance();
		this.receivingButtonCommand=new NewVReceivingButtonCommand(frame);
	}
	
	public void execute() {
		fillFrameInstance();
		save();
	}

	private void fillFrameInstance() {
		frame.setVisible(true);
		mainFrame.desktopPane.add(frame);
		frame.toFront();
	}

	private void save() {
		frame.receivingButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				receivingButtonCommand.execute();
				vehicle.save();

			}
		});
	}
	
}

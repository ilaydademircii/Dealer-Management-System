package controllers.vehicles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import command.VehicleCommands.saveVehicleCommand.SecondHandVReceivingButtonCommand;
import command.customerCommands.receivingCustomerCommands.SecondHandCustomerReceivingCommand;
import model.Customer;
import model.vehicles.SecondHandVehicle;
import view.MainFrame;
import view.vehicles.SecondHandVehicleFrame;

public class SecondHandVehicleController {
	private MainFrame mainFrame;
	SecondHandVehicleFrame frame;

	SecondHandVehicle vehicle;
	Customer customer;

	SecondHandVReceivingButtonCommand receivingButtonCommand;
	SecondHandCustomerReceivingCommand customerReceivingCommand;

	public SecondHandVehicleController(MainFrame mainFrame) {
		super();
		this.mainFrame = mainFrame;
		this.frame = new SecondHandVehicleFrame();
		this.vehicle=SecondHandVehicle.getInstance();
		this.customer=Customer.getInstance();

		this.receivingButtonCommand = new SecondHandVReceivingButtonCommand(frame);
		this.customerReceivingCommand = new SecondHandCustomerReceivingCommand(frame);
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
				customerReceivingCommand.execute();
				vehicle.setCustomerIdNo(Customer.getInstance().getIdNumber());
				customer.save();
				receivingButtonCommand.execute();
				vehicle.save();

			}
		});
	}

}

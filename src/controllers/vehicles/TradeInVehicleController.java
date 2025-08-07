package controllers.vehicles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import command.VehicleCommands.saveVehicleCommand.TradeInVReceivingButtonCommand;
import command.customerCommands.receivingCustomerCommands.TradeInCustomerReceivingCommand;
import controllers.CustomerController;
import model.Customer;
import model.vehicles.TradeInVehicle;
import view.MainFrame;
import view.vehicles.TradeInVehicleFrame;

public class TradeInVehicleController {
	private MainFrame mainFrame;
	TradeInVehicleFrame frame;

	TradeInVehicle vehicle;
	Customer customer;

	TradeInVReceivingButtonCommand receivingButtonCommand;
	TradeInCustomerReceivingCommand customerReceivingCommand;

	CustomerController customerController;

	public TradeInVehicleController(MainFrame mainFrame) {
		super();
		this.mainFrame = mainFrame;
		this.frame = new TradeInVehicleFrame();
		this.vehicle=TradeInVehicle.getInstance();
		this.customer=Customer.getInstance();
		this.receivingButtonCommand = new TradeInVReceivingButtonCommand(frame);
		this.customerReceivingCommand = new TradeInCustomerReceivingCommand(frame);
		this.customerController = CustomerController.getInstance();
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

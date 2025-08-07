package controllers.vehicles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import command.PaymentCommands.receivingPaymentButtonCommand.ReceivingPaymentForSoldVehicleCommand;
import command.VehicleCommands.comboBoxCommands.NewVehicleModelsCommand;
import command.VehicleCommands.comboBoxCommands.SecondHandModelsCommand;
import command.VehicleCommands.comboBoxCommands.TradeInModelsCommand;
import command.VehicleCommands.deleteVehicleCommands.DeleteNewVehicleCommand;
import command.VehicleCommands.deleteVehicleCommands.DeleteSecondHandVehicleCommand;
import command.VehicleCommands.deleteVehicleCommands.DeleteTradeInVehicleCommand;
import command.VehicleCommands.saveVehicleCommand.SoldVReceivingButtonCommand;
import command.VehicleCommands.setVehicleInformationCommand.NewVehicleInfoCommand;
import command.VehicleCommands.setVehicleInformationCommand.SecondHandVehicleInfoCommand;
import command.VehicleCommands.setVehicleInformationCommand.TradeInVehicleInfoCommand;
import command.customerCommands.receivingCustomerCommands.SoldCustomerReceivingCommand;
import model.Customer;
import model.payments.ReceivingPayment;
import model.vehicles.NewVehicle;
import model.vehicles.SecondHandVehicle;
import model.vehicles.SoldVehicle;
import model.vehicles.TradeInVehicle;
import view.MainFrame;
import view.vehicles.SoldVehicleFrame;

public class SoldVehicleController {
	private MainFrame mainFrame;
	SoldVehicleFrame frame;

	SoldVehicle vehicle;
	Customer customer;
	SecondHandVehicle secondHandVehicle;
	TradeInVehicle tradeInVehicle;
	NewVehicle newVehicle;
	ReceivingPayment receivingPayments;

	SoldVReceivingButtonCommand receivingButtonCommand;
	SoldCustomerReceivingCommand customerReceivingCommand;
	NewVehicleModelsCommand newVehicleModels;
	SecondHandModelsCommand secondHandModels;
	TradeInModelsCommand tradeInModels;
	NewVehicleInfoCommand newVehicleInfoCommand;
	SecondHandVehicleInfoCommand secondHandVehicleInfoCommand;
	TradeInVehicleInfoCommand tradeInVehicleInfoCommand;
	DeleteNewVehicleCommand deleteNewVehicleCommand;
	DeleteSecondHandVehicleCommand deleteSecondHandVehicleCommand;
	DeleteTradeInVehicleCommand deleteTradeInVehicleCommand;
	ReceivingPaymentForSoldVehicleCommand receivingPaymentCommand;

	String type;
	String vehicleModel;

	public SoldVehicleController(MainFrame mainFrame) {
		super();
		this.mainFrame = mainFrame;
		this.frame = new SoldVehicleFrame();
		this.vehicle = SoldVehicle.getInstance();
		this.customer = Customer.getInstance();
		this.secondHandVehicle=SecondHandVehicle.getInstance();
		this.tradeInVehicle=TradeInVehicle.getInstance();
		this.newVehicle=NewVehicle.getInstance();
		this.receivingPayments = ReceivingPayment.getInstance();
		
		this.newVehicleModels = new NewVehicleModelsCommand(frame);
		this.secondHandModels = new SecondHandModelsCommand(frame);
		this.tradeInModels = new TradeInModelsCommand(frame);

		this.tradeInVehicleInfoCommand = new TradeInVehicleInfoCommand(frame);
		this.newVehicleInfoCommand = new NewVehicleInfoCommand(frame);
		this.secondHandVehicleInfoCommand = new SecondHandVehicleInfoCommand(frame);

		this.customerReceivingCommand = new SoldCustomerReceivingCommand(frame);
		this.receivingButtonCommand=new SoldVReceivingButtonCommand(frame);

		this.deleteNewVehicleCommand = new DeleteNewVehicleCommand(frame);
		this.deleteSecondHandVehicleCommand = new DeleteSecondHandVehicleCommand(frame);
		this.deleteTradeInVehicleCommand = new DeleteTradeInVehicleCommand(frame);
		
		this.receivingPaymentCommand=new ReceivingPaymentForSoldVehicleCommand(frame);

	}

	public void execute() {
		fillFrameInstance();
		sale();
		setModels();
		setVehicleInfo();

	}

	private void fillFrameInstance() {
		frame.setVisible(true);
		mainFrame.desktopPane.add(frame);
		frame.toFront();
	}

	private void sale() {
		frame.saleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				customerReceivingCommand.execute();
				vehicle.setCustomerIdNo(Customer.getInstance().getIdNumber());
				customer.save();
				receivingButtonCommand.execute();
				vehicle.save();
				receivingPaymentCommand.execute();
				receivingPayments.savePayment();
				receivingPayments.setRemainingPaymentAmount();		
				
				
				if (getType().equals("Takas Araç")) {
				
					tradeInVehicle.deleteVehicle(vehicle.getLicensePlate());
				
				} else if (getType().equals("İkinci El Araç")) {

					secondHandVehicle.deleteVehicle(vehicle.getLicensePlate());
				
				} else if (getType().equals("Yeni Araç")) {
				
					newVehicle.deleteVehicle(vehicle.getChassisNo());
				
				}

			}
		});
	}

	private void setModels() {
		frame.vehicleTypeComboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				try {
					if (e.getStateChange() == ItemEvent.SELECTED) {

						frame.vehicleTypeComboBox.removeItemListener(this);
						frame.modelsComboBox.removeAllItems();
						clearVehicleInfo();

						setType(frame.vehicleTypeComboBox.getSelectedItem().toString());
						if (getType().equals("Takas Araç")) {
							tradeInModels.execute();
						} else if (getType().equals("İkinci El Araç")) {
							secondHandModels.execute();
						} else if (getType().equals("Yeni Araç")) {
							newVehicleModels.execute();
						}

						frame.vehicleTypeComboBox.addItemListener(this);
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
	}

	private void setVehicleInfo() {
		frame.modelsComboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				try {
					if (e.getStateChange() == ItemEvent.SELECTED) {

						frame.modelsComboBox.removeItemListener(this);
						clearVehicleInfo();
						setVehicleModel(frame.modelsComboBox.getSelectedItem().toString());

						if (getType().equals("Takas Araç")) {
							TradeInVehicle.getInstance().setVehicle(getVehicleModel());
							tradeInVehicleInfoCommand.execute();
						} else if (getType().equals("İkinci El Araç")) {
							SecondHandVehicle.getInstance().setVehicle(getVehicleModel());
							secondHandVehicleInfoCommand.execute();
						} else if (getType().equals("Yeni Araç")) {
							NewVehicle.getInstance().setVehicle(getVehicleModel());
							newVehicleInfoCommand.execute();
						}
						frame.modelsComboBox.addItemListener(this);
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}

		});
	}

	private void clearVehicleInfo() {
		frame.chassisNo.setText("");
		frame.year.setText("");
		frame.licensePlate.setText("");
		frame.dateArea.setText("");
		frame.receivingPrice.setText("");
		frame.salePrice.setText("");
		frame.explanation.setText("");

	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getVehicleModel() {
		return vehicleModel;
	}

	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}

}

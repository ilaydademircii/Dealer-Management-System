package command.VehicleCommands.saveVehicleCommand;

import javax.swing.JOptionPane;

import model.vehicles.NewVehicle;
import view.vehicles.NewVehicleFrame;

public class NewVReceivingButtonCommand implements VehicleReceivingButtonCommand{

	NewVehicleFrame frame;
	NewVehicle vehicle;
	
	public NewVReceivingButtonCommand(NewVehicleFrame frame) {
		super();
		this.frame = frame;
		this.vehicle = NewVehicle.getInstance();
	}

	@Override
	public void execute() {
		vehicle.setModel(frame.modell.getText().trim());
		vehicle.setYear(frame.year.getText().trim());
		vehicle.setChassisNo(frame.chassisNo.getText().trim());
		
		String formattedPrice =frame.price.getText().trim();
		String priceWithoutDot = formattedPrice.replace(".", "");
		vehicle.setPrice(priceWithoutDot);
		
		
		String rateText = frame.kdvRate.getText().trim();
		if (!rateText.isEmpty()) {
			try {
				Double rate = Double.parseDouble(rateText);
				vehicle.setKdvRate(rate);
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Geçerli bir kdv oranı giriniz.", " Hata ",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		vehicle.setExplanation(frame.explanation.getText().trim());
		
	}
	
	

}

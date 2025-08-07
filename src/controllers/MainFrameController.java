package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controllers.payments.AllRemainingPaymentsController;
import controllers.payments.PaymentController;
import controllers.payments.ReceivingPaymentController;
import controllers.vehicles.NewVehicleController;
import controllers.vehicles.SecondHandVehicleController;
import controllers.vehicles.SoldVehicleController;
import controllers.vehicles.TradeInVehicleController;
import view.MainFrame;

public class MainFrameController {
	public static void main(String[] args) {
		MainFrame mainFrame = new MainFrame();
		mainFrame.setVisible(true);

		mainFrame.tradeInVehicleMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TradeInVehicleController controller=new TradeInVehicleController(mainFrame);
				controller.execute();
			}
		});

		mainFrame.secondHandVehiclesMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SecondHandVehicleController controller=new SecondHandVehicleController(mainFrame);
				controller.execute();
			}
		});
		
		
		mainFrame.newVehiclesMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewVehicleController controller=new NewVehicleController(mainFrame);
				controller.execute();
			}
		});

		mainFrame.soldVehiclesMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SoldVehicleController controller=new SoldVehicleController(mainFrame);
				controller.execute();
			}
		});
		
		mainFrame.paymentMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PaymentController controller=new PaymentController(mainFrame);
				controller.execute();
			}
		});
		
		mainFrame.receivingPaymentMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReceivingPaymentController controller=new ReceivingPaymentController(mainFrame);
				controller.execute();
			}
		});

		mainFrame.remainingPaymentsMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AllRemainingPaymentsController controller=new AllRemainingPaymentsController(mainFrame);
				controller.execute();
			}
		});
		
	}

}
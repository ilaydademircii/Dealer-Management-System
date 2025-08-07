package controllers;

import model.Customer;

public class CustomerController {

	Customer customer;
	private static CustomerController instance;

	public CustomerController() {
		super();
		this.customer = Customer.getInstance();
	}
	
	
	public static CustomerController getInstance() {
		if (instance == null) {
			instance = new CustomerController();
		}
		return instance;
	}
	
//	public void execute() {
//		save();
//	}
//
//
//	public void save() {
//		customer.save();
//	}
}

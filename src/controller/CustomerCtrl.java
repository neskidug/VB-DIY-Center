package controller;

import model.ContactDetails;
import model.CustomerContainer;

/**
 * @Description Styrer alt der skal ske med kunderne i systemet.
 * @author Rasmus Gudiksen, Jakob Kjeldsteen, Christian Funder & Mark Drongesen
 * @Date 17/12/2021
 * @Version 1.0
 */
public class CustomerCtrl {
	private CustomerContainer customerContainer;

	/**
	 * Opretter CustomerCtrl og kalder en getInstance fra customerContainer
	 */
	public CustomerCtrl() {
		super();
		customerContainer = CustomerContainer.getInstance();
	}

	/**
	 * 
	 * @param customerID et id som en kunde får når de bliver oprettet i systemet
	 * @return ContactDetails på customeren der er blevet fundet via customerID.
	 */
	public ContactDetails findCustomer(int customerID) {
		return customerContainer.findCustomer(customerID);
	}

}

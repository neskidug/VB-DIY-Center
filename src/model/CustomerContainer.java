package model;

import java.util.ArrayList;
import java.util.List;

import exception.DuplicationException;

/**
 * @Description Indeholder alle kunder i systemet, både privat og virksomhedskunder
 * @author Rasmus Gudiksen, Jakob Kjeldsteen, Christian Funder & Mark Drongesen
 * @Date 17/12/2021
 * @Version 1.0
 */
public class CustomerContainer {
	private static CustomerContainer instance;
	private List<ContactDetails> customers;

	/**
	 * Opretter customerContaineren
	 */
	private CustomerContainer() {
		super();
		this.customers = new ArrayList<>();
	}

	public static CustomerContainer getInstance() {
		if (instance == null) {
			instance = new CustomerContainer();
		}
		return instance;
	}
	
	/**
	 * Finder en person i systemet ud fra deres ID
	 * @param customerID et id som en kunde får når de bliver oprettet i systemet
	 * @return CotactDetails på customeren der er blevet fundet via customerID
	 */
	public ContactDetails findCustomer(int customerID) {
		ContactDetails res = null;
		int i = 0;
		while (res == null && i < customers.size()) {
			if (customers.get(i).getID() == customerID) {
				res = customers.get(i);
			}
			i++;
		}
		return res;
	}
	
	/**
	 * Tilføjer personer til containeren.
	 * @param contactDetails er en instans er typen ContactDetails, det kan være både privat og virksomhedskunde
	 * @throws Exception hvis personens oplysninger allerede er i systemet kastes en exception
	 */
	public void addCustomer(ContactDetails contactDetails) throws Exception {
		boolean added = false;
		int i = 0;
		if (customers.size() == 0) {
			customers.add(contactDetails);
			added = true;
		} else if(i < customers.size()) {
			while (!added && i < customers.size()) {
				if (contactDetails.getEmail().equals(customers.get(i).getEmail())) {
					throw new DuplicationException("Indtastest Email eksisterer allerede.");
				} else if (contactDetails.getPhoneNo().equals(customers.get(i).getPhoneNo())) {
					throw new DuplicationException("Indtastest Telefonnummer eksisterer allerede");

				}
					i++;
			}

		}
		if(!added) {
			customers.add(contactDetails);
			added = true;
		}

	}
}

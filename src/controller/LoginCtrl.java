package controller;

import model.Employee;

/**
 * @Description Styrer alt der skal ske med medarbejderen der e logget ind.
 * @author Rasmus Gudiksen, Jakob Kjeldsteen, Christian Funder & Mark Drongesen
 * @Date 17/12/2021
 * @Version 1.0
 */
public class LoginCtrl {
	private static LoginCtrl instance;
	private Employee employee;

	/**
	 * Opretter en ny employee.
	 * 
	 */
	private LoginCtrl() {
		super();
		employee = new Employee();

	}

	/**
	 * Giver instansen af login controlleren.
	 * 
	 * @return instansen der er bliver opretter eller allerde er oprettet.
	 */

	public static LoginCtrl getInstance() {
		if (instance == null) {
			instance = new LoginCtrl();
		}
		return instance;
	}

	/**
	 * Giver den employee der ligger i instansen.
	 * 
	 * @return employeen der er i instansen.
	 */
	public Employee getEmployee() {
		return employee;
	}

}

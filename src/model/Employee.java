package model;

public class Employee extends ContactDetails {

	/**
	 * @Description Beskriver en ansat i systemet.
	 * @author Rasmus Gudiksen, Jakob Kjeldsteen, Christian Funder & Mark Drongesen
	 * @Date 17/12/2021
	 * @Version 1.0
	 */
	public Employee() {
		super("Gitte", "12345678", "Gitte@gmail.com", "Gittesvej 8");
		
	}
	
	public String getName() {
		return super.getName();
	}

}
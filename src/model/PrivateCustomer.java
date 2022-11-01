package model;

public class PrivateCustomer extends ContactDetails {
	/**
	 * @Description Beskriver en privatkunde i systemet.
	 * @author Rasmus Gudiksen, Jakob Kjeldsteen, Christian Funder & Mark Drongesen
	 * @Date 17/12/2021
	 * @Version 1.0
	 * */
	private int pcID;
	private double credit;
	
	/**
	 * Opretter en kunde i systemet ud fra givne parametre, den benytter samme parametre som
	 * superklassen ContactDetails
	 * @param pcID står for privateCustomerId og opdateres automatisk og bliver 1 højere hver gang man tilføjer en kunde.
	 * @param name navn på kunden
	 * @param phoneNo telefonnummer på kunden
	 * @param email emailadresse på kunden
	 * @param address kundens adresse
	 */
	public PrivateCustomer(String name, String phoneNo, String email, String address) {
		super(name, phoneNo, email, address);
		this.pcID += 1;
	}
	
	public double getCredit() {
		return credit;
	}
	public void setCredit(double credit) {
		this.credit = credit;
	}
	
	public int getID() {
		return pcID;
	}
	
	
}

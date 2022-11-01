package model;

/**
 * @Description Beskriver detaljerne på en virksomhedskunde
 * @author Rasmus Gudiksen, Jakob Kjeldsteen, Christian Funder & Mark Drongesen
 * @Date 17/12/2021
 * @Version 1.0
 */

public class Contractor extends ContactDetails {
	private int cvr;
	private double credit;
	private String contactName;

	public Contractor(String name, String phoneNo, String email, String address, int cvr, String contactName) {
		super(name, phoneNo, email, address);
		this.cvr = cvr;
		this.contactName = contactName;
		
	}

	public double getCredit() {
		return credit;
	}

	public void setCredit(double credit) {
		this.credit = credit;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	
	public int getID() {
		return cvr;
	}
	
	

	

}

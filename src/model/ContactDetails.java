package model;
/**
 * @Description Beskriver superklassen for alle personer i systemet.
 * @author Rasmus Gudiksen, Jakob Kjeldsteen, Christian Funder & Mark Drongesen
 * @Date 17/12/2021
 * @Version 1.0
 */
public abstract class ContactDetails {
	private String name;
	private String phoneNo;
	private String email;
	private String address;
	private PrivateCustomer customer;
	private Contractor contractor;

	/**
	 * 
	 * @param name navnet på den givne kunde
	 * @param phoneNo telefonnummer på givne kunde
	 * @param email emailadresse på kunden
	 * @param address fysiske adresse på kunden, enten privat eller virksomhedsadresse
	 */
	public ContactDetails(String name, String phoneNo, String email, String address) {
		super();
		this.name = name;
		this.phoneNo = phoneNo;
		this.email = email;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * 
	 * @return int i form af et ID-nummer, returnerer ID for privatkunde eller virksomhedskunde
	 */
	public int getID() {
		if (contractor.getID() > 10000000) {
			return contractor.getID();
		} else {

			return customer.getID();
		}
	}

}

package model;

public abstract class Item {
	/**
	 * @Description Beskriver den abstrakte superklasse Item, denne bruges til at kunne lave både pakker og enkelt items.
	 * @author Rasmus Gudiksen, Jakob Kjeldsteen, Christian Funder & Mark Drongesen
	 * @Date 17/12/2021
	 * @Version 1.0
	*/
	private String name;
	private String barcode;
	
	/**
	 * Opretter et item med følgende parametre
	 * @param name navnet på følgende item
	 * @param barcode stregkoden til følgende item
	 */
	public Item(String name, String barcode) {
		this.name = name;
		this.barcode = barcode;
		
	}
	
	public String getName() {
		return name;
	}
	
	public abstract double getPrice();

	public abstract String getProductDescription();

	public String getBarcode() {
		return barcode;
	}

	public abstract int getStock();

	/**
	 *
	 * Bruges til at opdatere lagerbeholdning når et item bliver solgt
	 * 
	 * @param quantity Antallet der skal fjernes fra en lagerbeholdning
	 */
	public abstract void removeStock(double quantity);

	public abstract void updateStock(double quantity);

	
}

package model;

public class SimpleProduct extends Product{
	/**
	 * @Description Beskriver simple produkter som går under massesalg, eksempelvis søm og skruer
	 * @author Rasmus Gudiksen, Jakob Kjeldsteen, Christian Funder & Mark Drongesen
	 * @Date 17/12/2021
	 * @Version 1.0
	 */
	private int stock;
	private String category;
	
	/**
	 * Et simpelt produkt oprettes
	 * @param name navn på produktet
	 * @param productDescription beskrivelse af produktet
	 * @param brand produktets brand
	 * @param barcode produktets stregkode
	 * @param price produktets pris
	 * @param stock produktets lagerbeholdning
	 * @param category produktets kategori
	 */
	public SimpleProduct(String name, String productDescription, String brand, String barcode, double price, int stock, String category) {
		super(name, productDescription, brand, barcode, price, category);
		this.stock = stock;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	/**
	 * Tilføj en mængde til lagerstatus
	 *
	 *@param quantity antallet der skal tilføjes til lagerbeholdningen.
	 */
	public void updateStock(double quantity) {
		this.stock += quantity;
	}
	
	/**
	 * Fjerner en mængde fra lagerstatus
	 * 
	 */
	public void removeStock(double quantity) {
		this.stock -= quantity;
	}
	
	
}

package model;

public class UniqueProduct extends Product{
	/**
	 * @Description Beskriver et unikt produkt som f.eks. en havetraktor
	 * @author Rasmus Gudiksen, Jakob Kjeldsteen, Christian Funder & Mark Drongesen
	 * @Date 17/12/2021
	 * @Version 1.0
	 */
	private int stock;
	private String category;
	
	/**
	 * Opretter et unikt produkt
	 * @param name navnet på produktet
	 * @param productDescription beskrivelse af produktet
	 * @param brand produktets brand
	 * @param barcode produktets stregkode
	 * @param price produktets pris
	 * @param category produktets kategori
	 */
	public UniqueProduct(String name, String productDescription, String brand, String barcode, double price, String category) {
		super(name, productDescription, brand, barcode, price, category);
		this.stock = 1;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	
	
	
}

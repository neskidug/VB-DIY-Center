package model;

public class Product extends Item {
	/**
	 * @Description Beskriver product som er en subklasse af Item
	 * @author Rasmus Gudiksen, Jakob Kjeldsteen, Christian Funder & Mark Drongesen
	 * @Date 17/12/2021
	 * @Version 1.0
	 * */
	private String productDescription;
	private String brand;
	private double price;
	private SimpleProduct sp;
	private String category;

	/**
	 * Product oprettes med de samme parametre som i superklassen item
	 * Derudover tilskrives en beskrivelse, et brand og en pris
	 * @param productDescription beskrivelse af produktet
	 * @param brand brandet på produktet
	 * @param price prisen på produktet.
	 * @param name navn på produktet
	 */
	public Product(String name, String productDescription, String brand, String barcode, double price, String category) {
		super(name, barcode);
		this.productDescription = productDescription;
		this.brand = brand;
		this.price = price;
		this.category = category;
	}

	public String getName() {
		return super.getName();
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	
	@Override
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	
	public int getStock() {
		return sp.getStock();
	}
	

	public String getBrand() {
		return brand;
	}

	public String getBarcode() {
		return super.getBarcode();
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	/**
	 * Kan fjerne en mængde af et produkt fra lagerstatus
	 */
	@Override
	public void removeStock(double quantity) {
		sp.removeStock(quantity);
	}

	@Override
	public void updateStock(double quantity) {
		sp.updateStock(quantity);
	}
	

}

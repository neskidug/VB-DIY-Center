package controller;

import java.util.List;

import model.Item;
import model.Pack;
import model.Pack.PackLine;
import model.ProductContainer;
import model.SimpleProduct;

/**
 * @Description Styrer alt der skal ske med produktet i systemet.
 * @author Rasmus Gudiksen, Jakob Kjeldsteen, Christian Funder & Mark Drongesen
 * @Date 17/12/2021
 * @Version 1.0
 */
public class ProductCtrl {
	private ProductContainer productContainer;
	private Pack pack;

	/**
	 * Opretter en ProductCtrl og henter instansen som er oprettet i product
	 * containeren
	 */
	public ProductCtrl() {
		super();
		productContainer = ProductContainer.getInstance();
	}
	
	public void createProduct(String name, String productDescription, String brand, String barcode, double price, int stock, String category) {
		Item newProduct = new SimpleProduct(name, productDescription, brand, barcode, price, stock, category);
		productContainer.addProduct(newProduct);
	}
	
	public void deleteProduct(Item item) {
		productContainer.deleteProduct(item);
	}
	
//	public void deletePackLine(PackLine packLine) {
//		productContainer.deleteProduct(packLine);
//	}

	/**
	 * Finder et produkt vha. en stregkode
	 * 
	 * @param barcode: En stregkode der skal bruges for at finde produktet i
	 *                 containeren.
	 * @return produktet der er fudnet vha. stregkoden.
	 */
	public Item findProduct(String barcode) {
			return productContainer.findProduct(barcode);
	}

	/**
	 * Finder hvor mange af et produkt der er på lager.
	 * 
	 * @param barcode: En stregkode der skal bruges for at finde ud af hvor mange af
	 *                 det produkt der er på lager.
	 * @return En <code>integer</code> som fortæller hvor mange der er på lager.
	 */
	public int getStock(String barcode) {
		return productContainer.findProduct(barcode).getStock();
	}

	public void removeStock(String barcode, double quantity) {
		productContainer.findProduct(barcode).removeStock(quantity);
	}
	
	public Pack createPack(String name, String barcode) {
		this.pack = new Pack(name, barcode);
		productContainer.addProduct(pack);
		return pack;
	}

	public void addItemToPack(String barcode, double quantity) {
		pack.addItem(findProduct(barcode), quantity);
		
		
	}
	public  List<PackLine> getPackLines() {
		return pack.getProducts();
	}
	
	public String getPackName() {
		return pack.getName();
	}
	
	public String getPackBarcode() {
		return pack.getBarcode();
	}
}

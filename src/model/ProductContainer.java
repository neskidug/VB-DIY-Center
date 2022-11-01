package model;

import java.util.ArrayList;
import java.util.List;

import exception.DuplicationException;

public class ProductContainer {
	/**
	 * @Description Styrer behandling og gemning af produkter.
	 * @author Rasmus Gudiksen, Jakob Kjeldsteen, Christian Funder & Mark Drongesen
	 * @Date 17/12/2021
	 * @Version 1.0
	 * */
	private static ProductContainer instance;
	private List<Item> products;

	/**
	 * Opretter containeren
	 */
	private ProductContainer() {
		super();
		this.products = new ArrayList<>();
	}

	public static ProductContainer getInstance() {
		if (instance == null) {
			instance = new ProductContainer();
		}
		return instance;
	}

	/**
	 * 
	 * @param barcode en stregkode som vi leder efter.
	 * @return Item et item med tilhørende stregkode
	 */
	public Item findProduct(String barcode) {
		Item res = null;
		int i = 0;
		while (res == null && i < products.size()) {
			if (products.get(i).getBarcode().equals(barcode)) {
				res = products.get(i);
			}
			i++;
		}
		return res;
	}

	/**
	 * Tilføjer et produkt
	 * @param item det item vi ønsker at tilføje til containeren
	 */
	public void addProduct(Item item) {
		boolean added = false;
		int i = 0;
		if (products.size() == 0) {
			products.add(item);
			added = true;
		} else if (i < products.size()) {
			while (!added && i < products.size()) {
				if (item.getBarcode().equals(products.get(i).getBarcode())) {
					throw new DuplicationException("Stregkoden eksisterer allerede.");
				}
				i++;
			}
			

		}

		if (!added) {
			products.add(item);
			added = true;
		}

	}
	
	public void deleteProduct(Item item) {
		products.remove(item);
	}
	
	


}

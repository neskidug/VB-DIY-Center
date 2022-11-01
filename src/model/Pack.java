package model;

import java.util.LinkedList;
import java.util.List;


/**
 * @Description En klasse der håndtere pakker i composite pattern.
 * @author Rasmus Gudiksen, Jakob Kjeldsteen, Christian Funder & Mark Drongesen
 * @Date 17/12/2021
 * @Version 1.0
 */
public class Pack extends Item {
	/**
	 * @Description En indre klasse der håndtere hvilke ting og hvor mange af de
	 *              ting der skal være i pakken.
	 * 
	 */
	public class PackLine {
		private Item item;
		private double quantity;

		/**
		 * Constructor i den indre klasse der opretter PackLine som tager et produkt og
		 * en mængde for at ligge det produkt og mængden af det produkt i en pakke
		 * 
		 * @param item     produktet der skal ligge i pakken
		 * @param quantity2 mængden af produktet som skal ligge i pakken.
		 */
		public PackLine(Item item, double quantity) {
			this.item = item;
			this.quantity = quantity;
		}
		
		public Item getPackLineItem() {
			return item;
		}
		
		public double getQuantity() {
			return quantity;
		}
	}

	private List<PackLine> items;

	/**
	 * Opretter en pakke med et navn og en stregkode.
	 * 
	 * @param name    navnet på pakken.
	 * @param barcode stregkoden på pakken.
	 */
	public Pack(String name, String barcode) {
		super(name, barcode);
		items = new LinkedList<>();
	}

	/**
	 * Tilføjer en PackLine til pakken, vha. et angivet produkt og mængde.
	 * 
	 * @param item     produktet vi gerne vil tilføje til pakken.
	 * @param quantity mængden af produktet vi gerne vil tilføe til pakken.
	 */
	public void addItem(Item item, double quantity) {
		if (item != null && quantity > 0) {
			items.add(new PackLine(item, quantity));
		}
	}

	/**
	 * En metode til at få en samlet pris på pakken, ved at plusse alle ting i
	 * pakkens pris sammen og hvor mange pakker man gerne vil købe.
	 * 
	 * @return Den samlet pris på pakken.
	 */
	@Override
	public double getPrice() {
		double res = 0d;
		for (PackLine packLineItem : items) {
			res += packLineItem.getQuantity() * packLineItem.getPackLineItem().getPrice();
		}
		return res;

	}

	/**
	 * En metode der returnere en string som beskriver produktet der er i en pakke.
	 * Samt prisen for en pakke.
	 */
	@Override
	public String getProductDescription() {
		String res = "Pakkenavn: " + super.getName() + "\n";
		for (PackLine packLineItem : items) {
			res += "    " + packLineItem.getQuantity() + " stk. " + packLineItem.getPackLineItem().getName() + ": ";
			res += "    " + packLineItem.getPackLineItem().getProductDescription() + "\n";
		}
		res += "\n    Pris pr. pakke: " + getPrice() + " kr.\n";
		return res;
	}

	@Override
	public String getBarcode() {
		return super.getBarcode();
	}

	/**
	 * Kigger på alle produkter i pakken og sammenligner hvor mange der er på lager
	 * i forhold til hvor mange der skal bruge til pakke. Tager det produkt med
	 * mindst lager i forhold til mængde i pakken for at finde ud af hvor mange
	 * pakker der er på lager.
	 */
	@Override
	public int getStock() {
		int temp = 0;
		int currTemp = (int) (items.get(0).getPackLineItem().getStock() / items.get(0).getQuantity());
		for (int i = 0; i < items.size(); i++) {
			temp = (int) (items.get(i).getPackLineItem().getStock() / items.get(i).getQuantity());
			if (currTemp > temp) {
				currTemp = temp;
			}

		}

		return currTemp;
	}

	/**
	 * Fjerner pakkens indhold i forhold til hvor mange pakker der købes.
	 */
	@Override
	public void removeStock(double quantity) {
		for (int i = 0; i < items.size(); i++) {
			items.get(i).getPackLineItem().removeStock(quantity * items.get(i).getQuantity());
		}
	}

	@Override
	public void updateStock(double quantity) {
		for (int i = 0; i < items.size(); i++) {
			items.get(i).getPackLineItem().updateStock(quantity * items.get(i).getQuantity());
		}
		
	}
	public List<PackLine> getProducts() {
		return items;
	}

}

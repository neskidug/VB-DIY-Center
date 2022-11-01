package model;

public class OrderLine {
	/**
	 * @Description Beskriver ordrelinjen
	 * @author Rasmus Gudiksen, Jakob Kjeldsteen, Christian Funder & Mark Drongesen
	 * @Date 17/12/2021
	 * @Version 1.0
	 * */
	private double quantity;
	private Item item;
	public OrderLine(Item item, double quantity) {
		super();
		this.item = item;
		this.quantity = quantity;
		
	}
	
	public Item getProduct() {
		return item;
	}

	public double getQuantity() {
		return quantity;
	}
	
	public String getBarcode() {
		return item.getBarcode();
	}

	public void addQuantity(double extraQuantity) {
		this.quantity += extraQuantity;
	}


}

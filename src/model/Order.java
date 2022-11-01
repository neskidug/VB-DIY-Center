package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import exception.ProductNotFoundException;

public class Order {
	/**
	 * @Description Beskriver ordren og styrer hvad der skal i den
	 * @author Rasmus Gudiksen, Jakob Kjeldsteen, Christian Funder & Mark Drongesen
	 * @Date 17/12/2021
	 * @Version 1.0
	 */
	private ContactDetails c;
	private int orderNumber;
	private static int totalOrders = 0;
	private Employee employee;
	private LocalDate orderDate;
	private List<OrderLine> products;

	public Order(Employee e) {
		super();
		this.employee = e;
		products = new ArrayList<>();
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber() {
		Order.totalOrders += 1;
		this.orderNumber = Order.totalOrders;
	}

	public void setOrderDate() {
		this.orderDate = LocalDate.now();
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	/**
	 * 
	 * Tilføjer en kunde
	 * 
	 * @param c kunden der skal tilføjes
	 */
	public void addCustomer(ContactDetails c) {
		this.c = c;
	}

	/**
	 * 
	 * Tilføjer et produkt via en ordrelinje
	 * 
	 * @param orderLine den orderLine med produkt og mængde der skal tilføjes til en
	 *                  ordre.
	 * 
	 * 
	 */
	public void addProduct(OrderLine orderLine) {
		try {
			OrderLine foundOrderLine = products.stream()
					.filter(product -> product.getBarcode().equals(orderLine.getBarcode())).findFirst().orElse(null);
			if (foundOrderLine != null) {
				foundOrderLine.addQuantity(orderLine.getQuantity());
			} else {
				products.add(orderLine);
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void removeProduct(String barcode) {
		products.remove(findOrderLine(barcode));
	}

	/**
	 * En metode som samler en beskrivelse af alle produkter på ordren, med
	 * tilhørende pris og antal
	 * 
	 * @return String af en beskrivelse af produkter på ordren.
	 */
	public String getProducts() {
		String res = "\n";
		for (int i = 0; i < products.size(); i++) {
			res += (int) products.get(i).getQuantity() + " stk: " + products.get(i).getProduct().getName() + "\n";
			res += "    Produkt beskrivelse: " + products.get(i).getProduct().getProductDescription() + "\n";
			if (products.get(i).getBarcode().charAt(0) == 'P') {
				res += "";
			} else {
				res += "    Pris: " + products.get(i).getQuantity() * products.get(i).getProduct().getPrice()
						+ " kr. \n";
				res += "        á " + products.get(i).getProduct().getPrice() + " kr. \n";
			}
		}
		return res;
	}

	/**
	 * Får en samlet pris på de forskellige produkter på ordren baseret på antallet
	 * af produkter der er tilføjet
	 * 
	 * @return double som er prisen på produkterne på ordren.
	 */
	public double getPrice() {
		double res = 0;
		for (int i = 0; i < products.size(); i++) {
			res += products.get(i).getQuantity() * products.get(i).getProduct().getPrice();
		}
		return res;
	}

	public ContactDetails getCustomer() {
		return c;
	}

	public List<OrderLine> getOrderLines() {
		return products;
	}
	
	public OrderLine findOrderLine(String barcode) {
		OrderLine foundOrderLine = products.stream()
				.filter(product -> product.getBarcode().equals(barcode)).findFirst().orElse(null);
		return foundOrderLine;
	}

}

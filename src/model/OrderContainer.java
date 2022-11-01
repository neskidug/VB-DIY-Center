package model;

import java.util.ArrayList;
import java.util.List;

public class OrderContainer {
	/**
	 * @Description Styrer behandling og gemning af ordre.
	 * @author Rasmus Gudiksen, Jakob Kjeldsteen, Christian Funder & Mark Drongesen
	 * @Date 17/12/2021
	 * @Version 1.0
	 * */
	private static OrderContainer instance;
	private List<Order> orders;
	
	private OrderContainer() {
		super();
		this.orders = new ArrayList<>();
	}
	
	public static OrderContainer getInstance() {
		if (instance == null) {
			instance = new OrderContainer();
		}
		return instance;
	}
	
	/**
	 * 
	 * Tilføjer ordren til containeren så den er gemt
	 * 
	 * @param order hvilken ordre der skal tilføjes til containeren.
	 */
	public void addOrder(Order order) {
		orders.add(order);
	}
	


}

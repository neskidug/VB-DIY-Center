package controller;

import java.time.LocalDate;
import java.util.List;

import exception.ProductNotFoundException;
import model.Item;
import model.Order;
import model.OrderContainer;
import model.OrderLine;


/**
 * @Description Styrer alt der skal ske med ordreren.
 * @author Rasmus Gudiksen, Jakob Kjeldsteen, Christian Funder & Mark Drongesen
 * @Date 17/12/2021
 * @Version 1.0
 */
public class OrderCtrl {
	private OrderContainer orderContainer;
	private Order o;
	private CustomerCtrl customerCtrl;
	private ProductCtrl productCtrl;
	private LoginCtrl loginCtrl;

	/**
	 * Constructor til Order Controlleren
	 */
	public OrderCtrl() {
		super();
		orderContainer = OrderContainer.getInstance();
		loginCtrl = LoginCtrl.getInstance();
		productCtrl = new ProductCtrl();
		customerCtrl = new CustomerCtrl();
	}

	/**
	 * Opretter en tom ordre
	 * 
	 * @return Den tomme ordre
	 */
	public Order createOrder() {
		this.o = new Order(loginCtrl.getEmployee());
		o.setOrderDate();
		return o;
	}

	/**
	 * Tilføjer en kunde til ordreren
	 * 
	 * @param customerID som er den kunde man gerne vil finde vha.
	 *                   <code>findCustomer</code> metoden fra customer controlleren
	 */
	public void addCustomer(int customerID) {
		o.addCustomer(customerCtrl.findCustomer(customerID));
	}

	/**
	 * Tilføjer et produkt til ordreren
	 * 
	 * @param barcode:  En stregkode man bruger til at finde det produkt man vil
	 *                  tilføje til produktet
	 * @param quantity: En parameter der fortæller hvor mange af et produkt man
	 *                  gerne vil have
	 * @throws Exception: Kaster en <code>Exception</code> hvis produktet man gerne
	 *                    vil tilføje ikke eksisterer
	 */
	public void addProduct(String barcode, double quantity) throws Exception {
		try {
			Item product = productCtrl.findProduct(barcode);
			o.addProduct(new OrderLine(product, quantity));
			product.removeStock(quantity);
			}
			catch(Exception e) {
				throw new ProductNotFoundException();
			}
		
			
		
	}
	
	public void removeProduct(String barcode, double quantity) {
		Item product = productCtrl.findProduct(barcode);
		if(product != null) {
			product.updateStock(quantity);
			o.removeProduct(barcode);
		}
		
	}

	/**
	 * Finder er produkt
	 * 
	 * @param barcode: En stregkode man bruger til at finde barcoden.
	 * @return Det produkt der er blevet fundet via stregkoden.
	 */
	public Item findProduct(String barcode) {
		if (productCtrl.findProduct(barcode) == null) {
			return null;
		} else {
			return productCtrl.findProduct(barcode);
		}
	}

	/**
	 * En metode der bliver kaldt når man vil færdiggøre en ordre. Metoden sætter en
	 * dato på for at vise hvornår ordren er oprettet og et ordre nummer på som er
	 * unikt. Tilføjer ordren til ordre containeren.
	 */
	public void endOrder() {
		o.setOrderNumber();
		orderContainer.addOrder(o);
	}

	/**
	 * Finder hvor mange af et produkt der er på lager.
	 * 
	 * @param barcode: Stregkode til at finde det produkt der skal findes stock på
	 * @return en <code>integer</code> som fortæller hvor mange der er på lager.
	 */
	public int getProductStock(String barcode) {
		return productCtrl.getStock(barcode);
	}

	/**
	 * Giver ordrenummeret på ordren der er i gang med at blive lavet.
	 * 
	 * @return en <code>integer</code> som er ordre nummeret på ordren.
	 */
	public int getOrderNumber() {
		return o.getOrderNumber();
	}

	/**
	 * Giver ordre datoen på ordren der er i gang med at blive lavet.
	 * 
	 * @return datoen(yy-mm-dd) som ordren har.
	 */
	public LocalDate getOrderDate() {
		return o.getOrderDate();
	}

	/**
	 * Giver produkterne som er ordren.
	 * 
	 * @return Alle produkter som er på ordren, samt informationer omkring
	 *         produkterne.
	 */
	public String getProducts() {
		return o.getProducts();
	}

	/**
	 * Giver medarbejderen som er på ordren.
	 * 
	 * @return
	 */
	public String getEmployee() {
		return loginCtrl.getEmployee().getName();
	}

	/**
	 * Giver den samlede pris på ordren.
	 * 
	 * @return en <code>double</code> som er prisen på odreren.
	 */
	public double getPrice() {
		return o.getPrice();
	}

	/**
	 * Finder kunden og tjekker om denne er <code>null</code>.
	 * @param customerID
	 * @return en <code>boolean</code> som tjekker om kunden eksisterer.
	 */
	public boolean findCustomer(int customerID) {
		if (customerCtrl.findCustomer(customerID) == null) {
			return false;
		} else {
			return true;
		}
		
	}

	/**
	 * Finder kundens navn
	 * @return returnerer enten navn på kunden eller butikskøb
	 */
	public String getCustomerName() {
		if(o.getCustomer() != null) {
			return o.getCustomer().getName();
		}else {
			return "Butikskøb";
		}
	}
	
	public List<OrderLine> getOrderLines() {
		return o.getOrderLines();
	}
	
	

}

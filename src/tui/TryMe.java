package tui;

import model.ContactDetails;
import model.Contractor;
import model.CustomerContainer;
import model.Item;
import model.OrderContainer;
import model.Pack;
import model.PrivateCustomer;
import model.ProductContainer;
import model.SimpleProduct;

public class TryMe {
	private static SimpleProduct product;
	private static ProductContainer productContainer;
	private static OrderTUI orderTui;
	private static CustomerContainer customerCon;
	private static OrderContainer orderCon;
	private static ContactDetails customer;

	public static void main(String[] args) throws Exception {
		Item havebord = new SimpleProduct("Havebord", "Et bord til haven", "VBBYG", "L003", 100d, 100, "Havemøbler");
		Item havestol = new SimpleProduct("Havestol", "En stol til haven", "VBBYG", "L004", 500d, 400, "Havemøbler");
		Pack havemøbelsæt = new Pack("Havemøbelsæt", "P001");
		havemøbelsæt.addItem(havebord, 1);
		havemøbelsæt.addItem(havestol, 40);
		System.out.println(havemøbelsæt.getProductDescription());
		productContainer = ProductContainer.getInstance();
		productContainer.addProduct(havebord);
		productContainer.addProduct(havestol);
		productContainer.addProduct(havemøbelsæt);
		customerCon = CustomerContainer.getInstance();
		orderCon = OrderContainer.getInstance();
		customer = new PrivateCustomer("Mark", "29110264", "mark@live.dk", "PP23");
		customerCon.addCustomer(customer);
		customer = new Contractor("Jakob", "214514231", "Jakob@live.dk", "PP23", 12345678, "Lisbeth");
		customerCon.addCustomer(customer);
		product = new SimpleProduct("Pladeskruer", "Skruer til plader", "VBBYG", "L001", 10d, 5, "Søm & Skruer");
		productContainer.addProduct(product);
		product = new SimpleProduct("Paps�m", "Søm til pap", "VBBYG", "L002", 1d, 10, "Søm & Skruer");
		productContainer.addProduct(product);
		orderTui = new OrderTUI();
		orderTui.createOrder();
		System.out.println("CustomerID: " + customerCon.findCustomer(58673905).getID());
	}

	public TryMe() throws Exception {
		Item havebord = new SimpleProduct("Havebord", "Et bord til haven", "VBBYG", "L003", 100d, 100, "Havemøbler");
		Item havestol = new SimpleProduct("Havestol", "En stol til haven", "VBBYG", "L004", 500d, 400, "Havemøbler");
		Pack havemøbelsæt = new Pack("Havemøbelsæt", "P001");
		havemøbelsæt.addItem(havebord, 1);
		havemøbelsæt.addItem(havestol, 40);
		System.out.println(havemøbelsæt.getProductDescription());
		productContainer = ProductContainer.getInstance();
		productContainer.addProduct(havebord);
		productContainer.addProduct(havestol);
		productContainer.addProduct(havemøbelsæt);
		customerCon = CustomerContainer.getInstance();
		orderCon = OrderContainer.getInstance();
		customer = new PrivateCustomer("Mark", "29110264", "mark@live.dk", "PP23");
		customerCon.addCustomer(customer);
		customer = new Contractor("Jakob", "214514231", "Jakob@live.dk", "PP23", 58673905, "Lisbeth");
		customerCon.addCustomer(customer);
		product = new SimpleProduct("Pladeskruer", "Skruer til plader", "VBBYG", "L001", 10d, 5, "Søm & Skruer");
		productContainer.addProduct(product);
		product = new SimpleProduct("Papsøm", "S�m til pap", "VBBYG", "L002", 1d, 10, "Søm & Skruer");
		productContainer.addProduct(product);
		System.out.println("CustomerID: " + customerCon.findCustomer(58673905).getID());
	}

}

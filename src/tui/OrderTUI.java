package tui;

import controller.OrderCtrl;
import exception.CustomerNotFoundException;
import exception.ProductNotFoundException;
import exception.stockException;

public class OrderTUI {
	/**
	 * @Description Styrer brugerens input i ordremenuen
	 * @author Rasmus Gudiksen, Jakob Kjeldsteen, Christian Funder & Mark Drongesen
	 * @Date 17/12/2021
	 * @Version 1.0
	 */
	private OrderCtrl orderCtrl;
	private TextInput input;

	/**
	 * Instantiering af klassen
	 */
	public OrderTUI() {
		super();
		this.orderCtrl = new OrderCtrl();
		this.input = new TextInput();
	}

	/**
	 * Metoden til at starte menuen
	 */
	public void start() throws Exception {
		boolean finished = false;
		while (!finished) {
			printOrderUI();
			int command = input.inputNumber();
			finished = choice(command);
		}

	}

	/**
	 * Metoden genererer et print til den tekstbaserede UI man ser først i
	 * ordremenuen
	 */
	private void printOrderUI() {
		System.out.println("\t* * *Ordremenu* * *");
		System.out.println("\t* (1) Opret odre  *");
		System.out.println("\t* (2) Find ordre  *");
		System.out.println("\t* (3) Tilbage     *");
		System.out.println("\t* * * * * * * * * *");

	}

	/**
	 * Metoden genererer et print til den tekstbaserede UI når man vil tilføje flere
	 * produkter eller afslutte
	 */
	private void printProductUI() {
		System.out.println("\t* * * * * * * * * * * * * * * *");
		System.out.println("\t* (1) Tilføj flere produkter  *");
		System.out.println("\t* (2) Afslut ordre            *");
		System.out.println("\t* * * * * * * * * * * * * * * *");
	}

	/**
	 * 
	 * Metoden til at styre brugerens valg i menuen
	 * 
	 * @param command er en int som bruges til at se hvilket input brugeren
	 *                indtaster
	 * @return boolean som bruges til at styre om programmet er færdig eller ej
	 */
	private boolean choice(int number) throws Exception {
		boolean wantToQuit = false;

		switch (number) {
		case 1:
			createOrder();
			break;
		case 3:
			wantToQuit = true;
			break;
		default:
			System.out.println("Dette er ikke en mulighed endnu");
			break;
		}
		return wantToQuit;
	}

	/**
	 * 
	 * Metoden til at styre brugerens valg i menuen til flere produkter eller afslut
	 * 
	 * @param command er en int som bruges til at se hvilket input brugeren
	 *                indtaster
	 * @return boolean som bruges til at styre om programmet er færdig eller ej
	 */
	private boolean addMoreProducts(int number) throws Exception {
		boolean wantToQuit = false;

		switch (number) {
		case 1:
			addProduct();
			wantToQuit = true;
			break;
		case 2:
			endOrder();
			wantToQuit = true;
			break;
		default:
			System.out.println("Dette er ikke en mulighed endnu");
			break;
		}
		return wantToQuit;
	}

	/**
	 * Metoden som bruges til at oprette en ordre, den kalder til orderCtrl som
	 * styrer ordren
	 * 
	 * @throws Exception
	 */
	public void createOrder() throws Exception {
		orderCtrl.createOrder();
		System.out.println("Logget på som " + orderCtrl.getEmployee());
		addCustomer();
		addProduct();

	}

	/**
	 * Metoden til at tilføje en kunde til ordren. Her benytter vi brugerens input
	 * via en scanner og læser, så søges der efter stregkode og mængde Tast 0 hvis
	 * der er tale om butikskøb
	 * 
	 * @throws Exception
	 */
	private void addCustomer() throws Exception {
		System.out.println("Indtast kundenummer: ");
		int customerID = input.inputNumber();
		if (customerID == 0) {
			System.out.println("Butikskøb");
		} else if (orderCtrl.findCustomer(customerID) == false) {
			try {
				throw new CustomerNotFoundException();
			} catch (CustomerNotFoundException e) {
				addCustomer();
			}
		} else {
			orderCtrl.addCustomer(customerID);
		}
	}

	/**
	 * Metoden til at tilføje produkter til ordren. Her benytter vi brugerens input
	 * via en scanner og læser, så søges der efter stregkode og mængde
	 * 
	 * @throws Exception
	 */
	public void addProduct() throws Exception {
		boolean finished = false;
		System.out.println("Indtast stregkode: ");
		String barcode = input.inputString();
		if (orderCtrl.findProduct(barcode) == null) {
			try {
				throw new ProductNotFoundException();
			} catch (ProductNotFoundException e) {
				addProduct();
				finished = true;
			}
		} else {
			System.out.println("Current stock: " + orderCtrl.getProductStock(barcode));
			System.out.println("Produkt tilføjet: " + barcode);
			System.out.println("Indtast mængde: ");
			double quantity = input.inputNumber();
			System.out.println("Antal: " + quantity + " stk");
			if (quantity <= 0) {
				try {
					throw new stockException("Antallet skal være minimum 1");
				} catch (Exception e) {
					finished = true;
					addProduct();
				}
			} else if (orderCtrl.findProduct(barcode).getStock() < quantity) {
				try {
					throw new stockException("Ikke nok på lager");
				} catch (Exception e) {
					addProduct();
					finished = true;
				}
			} else {
				orderCtrl.addProduct(barcode, quantity);
				printProductUI();
			}
		}
		while (!finished) {
			int command = input.inputNumber();
			finished = addMoreProducts(command);
		}
	}

	/**
	 * Metoden til at afslutte ordren, her printes også ordre resultatet
	 */
	public void endOrder() {
		System.out.println("Ordre oprettet: ");
		orderCtrl.endOrder();
		System.out.println("Kunde: " + orderCtrl.getCustomerName());
		System.out.println("Ordre nummer: " + orderCtrl.getOrderNumber());
		System.out.println("Ordre dato: " + orderCtrl.getOrderDate());
		System.out.println("Produkter: " + orderCtrl.getProducts());
		System.out.println("Total pris: " + orderCtrl.getPrice());
		System.out.println("Du blev ekspederet af " + orderCtrl.getEmployee());
	}

}

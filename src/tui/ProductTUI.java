package tui;

import controller.ProductCtrl;

public class ProductTUI {

	/**
	 * @Description Styrer brugerens input i produktmenuen
	 * @author Rasmus Gudiksen, Jakob Kjeldsteen, Christian Funder & Mark Drongesen
	 * @Date 17/12/2021
	 * @Version 1.0
	 */
	private ProductCtrl productCtrl;
	private TextInput input;

	/**
	 * Instantiering af klassen
	 */
	public ProductTUI() {
		super();
		this.productCtrl = new ProductCtrl();
		this.input = new TextInput();
	}

	/**
	 * Starter produkt menuen
	 */
	public void start() {

		boolean finished = false;
		while (!finished) {
			printProductMenu();
			int command = input.inputNumber();
			finished = choice(command);
		}
	}

	/**
	 * 
	 * Metoden til at styre brugerens valg i menuen
	 * 
	 * @param command er en int som bruges til at se hvilket input brugeren
	 *                indtaster
	 * @return boolean som bruges til at styre om programmet er færdig eller ej
	 */
	private boolean choice(int command) {
		boolean wantToQuit = false;

		switch (command) {
		case 1:
			createProduct();
			break;
		case 2:
			System.out.println("Denne er ikke implementeret endnu");
			break;
		case 4:
			wantToQuit = true;
			break;
		default:
			System.out.println("Denne er ikke implementeret endnu");
			break;
		}
		return wantToQuit;
	}

	private void createProduct() {
	}

	/**
	 * Metoden genererer et print til den tekstbaserede UI
	 */
	private void printProductMenu() {
		System.out.println("\t* * *Produktemenu * * *");
		System.out.println("\t* (1) Opret produkt   *");
		System.out.println("\t* (2) Opdater produkt *");
		System.out.println("\t* (3) Slet produkt    *");
		System.out.println("\t* (4) Tilbage         *");
		System.out.println("\t* * * * * * * * * * * *");
	}

}

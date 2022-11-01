package tui;

public class MainMenuTUI {

	/**
	 * @Description Styrer brugerens input til hovedmenuen
	 * @author Rasmus Gudiksen, Jakob Kjeldsteen, Christian Funder & Mark Drongesen
	 * @Date 17/12/2021
	 * @Version 1.0
	 */
	private static TextInput input;
	private static OrderTUI orderTUI;
	private static ProductTUI productTUI;
	private static TryMe tm;

	/**
	 * Her instantieres hele programmet
	 */
	public static void main(String[] args) throws Exception {
		input = new TextInput();
		orderTUI = new OrderTUI();
		productTUI = new ProductTUI();

		start();
	}

	/**
	 * Metoden til at starte menuen
	 */
	public static void start() throws Exception {

		boolean finished = false;
		while (!finished) {
			printMainMenuUI();
			int command = input.inputNumber();
			finished = choice(command);
		}
	}

	/**
	 * Metoden til at styre brugerens valg i menuen
	 * 
	 * @param command er en int som bruges til at se hvilket input brugeren
	 *                indtaster
	 * @return boolean som bruges til at styre om programmet er færdig eller ej
	 */
	private static boolean choice(int command) throws Exception {
		boolean wantToQuit = false;

		switch (command) {
		case 1:
			orderTUI.start();
			break;
		case 2:
			productTUI.start();
			break;
		case 3:
			System.out.println("Denne er ikke implementeret endnu");
			break;
		case 4:
			tm = new TryMe();
			System.out.println("Testdata genereret");
			break;
		case 5:
			System.out.println("Tak for denne gang");
			wantToQuit = true;
			break;
		default:
			System.out.println("Denne er ikke implementeret endnu");
			break;
		}
		return wantToQuit;
	}

	/*
	 * Metoden genererer et print til den tekstbaserede UI
	 */
	private static void printMainMenuUI() {
		System.out.println("\t* * * Hovedmenu * * * * * *");
		System.out.println("\t* (1) Ordremenu           *");
		System.out.println("\t* (2) Produktmenu         *");
		System.out.println("\t* (3) ContactsDetails     *");
		System.out.println("\t* (4) Testdata            *");
		System.out.println("\t* (5) Afslut              *");
		System.out.println("\t* * * * * * * * * * * * * *");
	}
}

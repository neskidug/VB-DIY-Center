package tui;

import java.util.Scanner;

/**
 * @Description Bruges til at tage input fra brugeren igennem konsollen
 * @author Rasmus Gudiksen, Jakob Kjeldsteen, Christian Funder & Mark Drongesen
 * @Date 5/11/2021
 * @Version 1.0
 */
public class TextInput {

	public TextInput() {

	}

	/**
	 * Tager et text input fra brugeren
	 * 
	 * @return inputtet brugeren gav som string.
	 */
	public static String inputString() {
		Scanner keyboard = new Scanner(System.in);
		return keyboard.nextLine();
	}

	/**
	 * Tager et tal input fra brugeren
	 * 
	 * @return inputtet fra brugeren som integer.
	 */
	public static int inputNumber() {
		Scanner keyboard = new Scanner(System.in);
		int number = 0;
		while (!keyboard.hasNextInt()) {
			System.out.println("Input skal være et tal - prøv igen");
			keyboard.nextLine();
		}
		number = keyboard.nextInt();
		return number;
	}
}
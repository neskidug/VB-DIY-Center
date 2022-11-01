package exception;

/**
 * @Description En exception til når man opretter nye medarbjeder eller kunder i
 *              systemet, hvis de skriver et telefonnummer eller email der
 *              allerede eksisterer i systemet.
 * @author Rasmus Gudiksen, Jakob Kjeldsteen, Christian Funder & Mark Drongesen
 * @Date 17/12/2021
 * @Version 1.0
 */
public class DuplicateMailPhoneException extends RuntimeException {

	/**
	 * Constructoren som bliver kaldt for at kaste en ny exception.
	 */
	public DuplicateMailPhoneException() {
		System.out.println("Den indtastet Email eller Telefonnummer eksistere allerede.");
	}
}

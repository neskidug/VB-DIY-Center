package exception;

/**
 * @Description En exception til når der ikke er nok på lager at et produkt.
 * @author Rasmus Gudiksen, Jakob Kjeldsteen, Christian Funder & Mark Drongesen
 * @Date 17/12/2021
 * @Version 1.0
 */
public class stockException extends RuntimeException {
	/**
	 * Constructoren som bliver kaldt når der ikke er nok på lager.
	 * 
	 * @param description den besked der bliver givet når constructeren bliver
	 *                    kaldt.
	 */
	public stockException(String description) {
		System.out.println(description);
	}
}

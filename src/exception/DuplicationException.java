package exception;

/**
 * @Description En exception til når man tilføjer et produkt eller en kunde til
 *              containeren for at se om objektet allerede ligger i containeren.
 * @author Rasmus Gudiksen, Jakob Kjeldsteen, Christian Funder & Mark Drongesen
 * @Date 17/12/2021
 * @Version 1.0
 */
public class DuplicationException extends RuntimeException {
	/**
	 * Constructoren som bliver kaldt når man prøver at tilføje noget til en
	 * container som allerde ligger i containeren.
	 * 
	 * @param description som er den besked der bliver givet når constructoren
	 *                    bliver kaldt
	 */
	public DuplicationException(String description) {
		System.out.println(description);
	}
}

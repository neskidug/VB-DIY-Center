package exception;
/**
 * @Description En exception til når man prøver at skrive en barcode til et produkt som ikke er i containeren.
 * @author Rasmus Gudiksen, Jakob Kjeldsteen, Christian Funder & Mark Drongesen
 * @Date 17/12/2021
 * @Version 1.0
 */
public class ProductNotFoundException extends Exception{
	/**
	 * Constructeren som bliver kaldt når systemet ikke kan finde et produkt i systemet.
	 */
	public ProductNotFoundException() {
		System.out.println("Produktet er ikke fundet i systemet");
	}
}

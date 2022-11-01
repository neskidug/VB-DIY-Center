package exception;

public class CustomerNotFoundException extends Exception {
	
	public CustomerNotFoundException() {
		System.out.println("Kunden kunne ikke findes.");
	}

}

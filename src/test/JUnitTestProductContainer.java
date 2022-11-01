package test;

import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Item;
import model.Product;
import model.ProductContainer;
import model.SimpleProduct;
import exception.DuplicationException;

class JUnitTestProductContainer {
	private static ProductContainer productCon;
	private static Item hammer;
	private static Item nails;
	private static Item screws;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		hammer = new SimpleProduct("Hammer", "En pind med en metal ende til at slå søm i med", "Bosch", "H001", 130d, 20, "Hammer");
		nails = new SimpleProduct("Søm", "Et stykke metal der bliver slået i med en hammer for at sætte to ting sammen",
				"Calvin Klein", "N001", 40d, 10, "Søm");
		screws = new SimpleProduct("Skruer", "Et søm med gevind som skal skrues i noget for at holde to ting sammen",
				"Gucci", "S001", 2000d, 10, "Skrue");
		productCon = ProductContainer.getInstance();
		productCon.addProduct(nails);
		productCon.addProduct(hammer);
		productCon.addProduct(screws);
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testFindProduct() {
		assertEquals(hammer, productCon.findProduct("H001"));
		assertEquals(nails, productCon.findProduct("N001"));
		assertNotEquals(hammer, productCon.findProduct("N001"));
		assertNotEquals(nails, productCon.findProduct("H001"));
	}


}

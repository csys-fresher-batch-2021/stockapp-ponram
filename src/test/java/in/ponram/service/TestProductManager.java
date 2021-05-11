package in.ponram.service;

import static org.junit.Assert.*;

import org.junit.Test;

import in.ponram.model.Product;

public class TestProductManager {

	@Test
	public void testValidStock() {
		
		Product product1 = new Product("it01","Nokia","9s","Mobile",9000,10);

		boolean success = ProductManager.addStock(product1);
		assertTrue(success);
	}
	
	@Test
	public void testInvalidStock() {
		
		Product product1 = new Product("it01"," ","9s","Mobile",9000,10);

		boolean success = ProductManager.addStock(product1);
		assertFalse(success);
	}

}

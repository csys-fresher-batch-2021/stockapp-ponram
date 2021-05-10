package in.ponram.service;

import static org.junit.Assert.*;

import org.junit.Test;

import in.ponram.model.Product;

public class TestProductManager {

	@Test
	public void testValidStock() {
		
		Product product1 = new Product("it01","Nokia","9s","Mobile",9000,10);
		Product product2 = new Product("it02","Iphone", "SE2020","Mobile",40000,10);
		Product product3 = new Product("it03","Asus","Laptop","X509UA",30000,10);
		Product product4 = new Product("it04","Boat","Heatset","Airdot935",2000,10);

		boolean success = ProductManager.addStock(product1, product2, product3, product4);
		assertTrue(success);
	}
	
	@Test
	public void testInvalidStock() {
		
		Product product1 = new Product("it01"," ","9s","Mobile",9000,10);

		boolean success = ProductManager.addStock(product1);
		assertFalse(success);
	}

}

package in.ponram.service;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import in.ponram.model.Product;

public class TestProductManager {

	@BeforeClass
	public static void setUp() throws Exception {

		Product product1 = new Product("it01","Nokia","9s","Mobile",9000,10);
		Product product2 = new Product("it02","Iphone", "SE2020","Mobile",40000,10);
		Product product3 = new Product("it03","Asus","Laptop","X509UA",30000,10);
		ProductManager.addStock(product1, product2, product3);
	}

	@Test
	public void testValidStock() {
		
		Product product = new Product("it04","Boat","Heatset","Airdot935",2000,10);

		boolean success = ProductManager.addStock(product);
		assertTrue(success);
	}
	
	@Test
	public void testInvalidStock() {
		
		Product product1 = new Product("it01"," ","9s","Mobile",9000,10);

		boolean success = ProductManager.addStock(product1);
		assertFalse(success);
	}
	
	/**
	 * Test case for try to delete the product present in stock
	 */
	@Test
	public void testDeleteProductPresentInStock() {
		
		try {
			
			boolean valid = ProductManager.deleteProduct("Nokia");
			assertTrue(valid);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	/**
	 * Test case for try to delete the product not present in stock
	 */
	@Test
	public void testDeleteProductNotPresentInStock() {
		
		try {
			
			ProductManager.deleteProduct("Nokia");
		} catch (Exception e) {
			
			assertEquals("Product not found", e.getMessage());
		}
	}

}

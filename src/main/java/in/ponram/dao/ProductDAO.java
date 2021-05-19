package in.ponram.dao;

import java.util.ArrayList;
import java.util.List;

import in.ponram.model.Product;

public class ProductDAO {

	private ProductDAO() {
		//Default constructor
	}
	private static List<Product> stockList = new ArrayList<>();

	/**
	 * This method is used to add the product in the ArrayList
	 * 
	 * @param product
	 * @throws Exception
	 */
	public static void addProduct(Product product) {
		stockList.add(product);
	}
	
	/**
	 * This method is used the get the product in another list
	 * 
	 * @return product ArrayList
	 */
	public static List<Product> getStock() {

		return stockList;
	}
	
	/**
	 * This method is used to remove the product from tha list
	 */
	public static void removeProduct(Product product) {
		stockList.remove(product);
	}
}

package in.ponram.service;

import java.util.ArrayList;
import java.util.List;

import in.ponram.model.Product;
import in.ponram.validator.ProductValidation;

public class ProductManager {

	private static List<Product> stockDetails = new ArrayList<>();

	private ProductManager() {
		//Default constructor
	}
	/**
	 * This method is used to add the product in the ArrayList
	 * 
	 * @param product
	 * @return 
	 */
	public static boolean addStock(Product... products) {

		boolean added = false;
		for (Product product : products) {
			{
				if(ProductValidation.isValidProduct(product)) {
				stockDetails.add(product);
				added = true;
				}
				else {
					System.err.println("Invalid Product Details");
				}
			}

		}
		return added;
	}


}



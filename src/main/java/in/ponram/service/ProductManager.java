package in.ponram.service;

import java.util.List;

import in.ponram.dao.ProductDAO;
import in.ponram.exception.UtilException;
import in.ponram.model.Product;
import in.ponram.validator.ProductValidation;

public class ProductManager {

	private ProductManager() {
		// Default constructor
	}

	/**
	 * This method is used to add the product in the ArrayList
	 * 
	 * @param product
	 * @throws Exception
	 */
	public static boolean addStock(Product... products) {

		boolean added = false;
		for (Product product : products) {
			if (ProductValidation.isValidProduct(product)) {
				ProductDAO.addProduct(product);
				added = true;
			}

		}
		return added;
	}

	/**
	 * This method is used to add the product in the ArrayList
	 * @param itemName
	 * @return
	 */
	public static boolean deleteProduct(String itemName){
		
		Product deleteProduct = null;
		boolean success = false;
		
		List<Product> getStock = ProductDAO.getStock();
		for(Product product: getStock) {
			if(product.getItemName().equalsIgnoreCase(itemName)) {
				
				deleteProduct = product;
				ProductDAO.removeProduct(deleteProduct);
				success = true;
				break;
			}
			else {
				throw new UtilException("Product not found");
			}
		}
		
		return success;
	}
}

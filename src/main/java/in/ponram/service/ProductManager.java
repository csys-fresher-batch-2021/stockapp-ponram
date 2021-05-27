package in.ponram.service;


import in.ponram.dao.ProductDAO;
import in.ponram.model.Product;
import in.ponram.util.StringValidator;
import in.ponram.validator.ProductValidation;

public class ProductManager {

	private final ProductDAO productDao = new ProductDAO();

	/**
	 * This method is used to add the product in the ArrayList
	 * 
	 * @param product
	 * @throws Exception
	 */
	public boolean addStock(Product product) {

		boolean added = false;
		if (ProductValidation.isValidProduct(product)) {
				productDao.save(product);

			added = true;
		}
		return added;
	}

	/**
	 * This method is used to add the product in the ArrayList
	 * 
	 * @param itemName
	 * @return
	 */
	public boolean deleteProduct(String productName) {

		boolean success = false;

		if (StringValidator.isValidString(productName, "Product name shouldn't be empty")) {
			productDao.delete(productName);
			success = true;
		}
		return success;
	}

}

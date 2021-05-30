package in.ponram.validator;

import in.ponram.model.Product;
import in.ponram.util.NumberValidator;
import in.ponram.util.StringValidator;

public class ProductValidation {

	private ProductValidation() {
		// Default constructor
	}

	/**
	 * This method is used to check whether, The item id,brand name,item name and
	 * category should not to be null and empty string input And quantity and rate
	 * of the product should not lesser than zero
	 * 
	 * @param product
	 * @return
	 */
	public static boolean isValidProduct(Product product) {
		boolean valid = false;
		boolean brandName = checkBrandName(product.getBrandName());
		boolean itemName = StringValidator.isValidString(product.getProductName(), "Item name is empty");
		boolean category = StringValidator.isValidString(product.getProductCategory(), "Item category is empty");
		boolean quantity = NumberValidator.isValidNumber(product.getQuantity(), "Invalid quantity");
		boolean rate = NumberValidator.isValidNumber(product.getRate(), "Invalid rate");

		if (brandName && itemName && category && quantity && rate) {

			valid = true;

		}

		return valid;
	}

	/**
	 * This method is used to validate brand name is valid string
	 * @param value
	 * @return true or false
	 */
	public static boolean checkBrandName(String value) {

		boolean valid = false;
		if (StringValidator.isValidString(value, "Brand name is empty")) {

			valid = true;
		}

		return valid;
	}

	/**
	 * This method is used to validate id is an valid integer
	 * This method is used to validate quantity is an valid integer
	 * @param value
	 * @return true or false
	 */
	public static boolean valid(int id, int quantity) {

		boolean isValidQuantity = NumberValidator.isValidNumber(quantity, "Invalid quantity");
		boolean isValidId = NumberValidator.isValidNumber(id, "Invalid product id");
		boolean valid = false;
		if (isValidQuantity && isValidId) {

			valid = true;
		}
		return valid;
	}
}

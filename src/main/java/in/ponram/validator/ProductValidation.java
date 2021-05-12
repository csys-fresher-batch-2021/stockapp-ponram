package in.ponram.validator;

import in.ponram.model.Product;
import in.ponram.util.NumberValidator;
import in.ponram.util.StringValidator;

public class ProductValidation {

	private ProductValidation() {
		//Default constructor
	}
	/**
	 * This method is used to check whether, 
	 * The item id,brand name,item name and category should not to be null and empty string input
	 * And quantity and rate of the product should not lesser than zero
	 * @param product
	 * @return
	 */
	public static boolean isValidProduct(Product product) {
		boolean valid = false;
		if (StringValidator.isValidString(product.getItemId()) 
				&& StringValidator.isValidString(product.getBrandName())
				&& StringValidator.isValidString(product.getItemName())
				&& StringValidator.isValidString(product.getItemCategory())
				&& NumberValidator.isValidNumber(product.getQuantity())
				&& NumberValidator.isValidNumber(product.getPrize())) {
			
			valid = true;
			
		}
		
		return valid;
	}
}

package in.ponram.validator;

import in.ponram.model.Product;
import in.ponram.util.NumberValidator;
import in.ponram.util.StringValidator;

public class ProductValidation {

	public static boolean isValidProduct(Product product) {
		boolean valid = false;
		if (StringValidator.isValidString(product.itemId) 
				&& StringValidator.isValidString(product.brandName)
				&& StringValidator.isValidString(product.itemName)
				&& StringValidator.isValidString(product.itemCategory)
				&& NumberValidator.isValidNumber(product.quantity)
				&& NumberValidator.isValidNumber(product.rate)) {
			valid = true;
			
		}
		
		return valid;
	}
}

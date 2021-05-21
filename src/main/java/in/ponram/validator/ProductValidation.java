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
		boolean itemId = StringValidator.isValidString(product.getItemId(),"Item id is empty") ;
		boolean brandName = StringValidator.isValidString(product.getBrandName(),"Brand name is empty");
		boolean itemName = StringValidator.isValidString(product.getItemName(),"Item name is empty");
		boolean category = StringValidator.isValidString(product.getItemCategory(),"Item category is empty");
		boolean quantity = NumberValidator.isValidNumber(product.getQuantity(),"Invalid quantity");
		boolean rate = NumberValidator.isValidNumber(product.getRate(),"Invalid rate");
		if (itemId && brandName && itemName && category && quantity && rate ) {
			
			valid = true;
			
		}
		
		return valid;
	}
}

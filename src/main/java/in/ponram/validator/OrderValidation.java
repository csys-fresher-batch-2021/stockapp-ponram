package in.ponram.validator;

import java.util.List;

//import in.ponram.dao.OrdarDAO;
import in.ponram.dao.ProductDAO;
import in.ponram.exception.ValidatorException;
import in.ponram.model.Order;
import in.ponram.model.OrderItem;
import in.ponram.model.Product;
import in.ponram.util.NumberValidator;

public class OrderValidation {

//	static private OrdarDAO orderDAO = new OrdarDAO();

	static ProductDAO productDetails = new ProductDAO();

	private OrderValidation() {
		// default constructor
	}

	/**
	 * This method is used to validate product id and check quantity is valid
	 * @param order
	 * @return
	 */
	public static boolean isValidIdAndQuantity(Order order) {

		// validation
		boolean isValid = false;
		for (OrderItem details : order.getOrderDetail()) {
			boolean isValidId = NumberValidator.isValidNumber(details.getProductId(), "Invalid Id");
			if ( isValidId) {
				boolean isValidQuantity = checkQuantity(details.getQuantity(),details.getProductId());
				if (isValidQuantity) {
					isValid = true;
				}
				else {
					throw new ValidatorException("Qunatity out of stock");
				}
			}
		}
		return isValid;
	}

	/**
	 * This method is to validate quantity and user enter quantity is present in stock
	 * @param quantity
	 * @param productId
	 * @return
	 */
	public static boolean checkQuantity(int quantity, int productId) {
		
		boolean isValid = false;
		if(NumberValidator.isValidNumber(quantity, "Invalid Qunatity")) {
			List<Product> products = productDetails.findAll();
			for (Product product : products) {
				if (product.getProductId() == productId && product.getQuantity() >= quantity) {
					isValid = true;
					break;
				}
			}
		}
		return isValid;
	}
	
	/**
	 * This method is used to get the rate from the stock using product id 
	 * @param productId
	 * @return
	 */
	public static int getRate(int productId) {
		int rate = 0;

		List<Product> products = productDetails.findAll();
		for (Product product : products) {
			if (product.getProductId() == productId) {
				rate = product.getRate();
				break;
			}
		}
		return rate;

	}

}

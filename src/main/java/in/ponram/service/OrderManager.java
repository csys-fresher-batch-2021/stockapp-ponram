package in.ponram.service;

import in.ponram.dao.OrdarDAO;
import in.ponram.dao.OrderItemDAO;
import in.ponram.dao.ProductDAO;
import in.ponram.model.Order;
import in.ponram.model.OrderItem;
import in.ponram.validator.OrderValidation;

public class OrderManager {

	private OrdarDAO orderDAO = new OrdarDAO();
	private ProductDAO productDao = new ProductDAO();

	public void orderProducts(Order order) {
		
		int total = 0;

		if(OrderValidation.isValidIdAndQuantity(order)) {
		
			Integer orderId = orderDAO.save(order);
			for (OrderItem details : order.getOrderDetails()) {
				
				OrderItemDAO orderItemDAO = new OrderItemDAO();
				int rate = OrderValidation.getRate(details.getProductId());
				details.setBillNumber(orderId);
				details.setRate(rate);
				details.setTotalAmount(rate * details.getQuantity());
				total = total + details.getTotalAmount();
				orderItemDAO.save(details);
				productDao.updateReduceQuantity(details.getProductId(), details.getQuantity());
			}

			orderDAO.updateBillAmount(orderId, total);
		}

	}
}

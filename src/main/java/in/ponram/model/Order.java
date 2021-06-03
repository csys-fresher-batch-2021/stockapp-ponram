package in.ponram.model;

import java.time.LocalDate;
import java.util.List;

public class Order {

	private int billNumber;
	private String customerName;
	private List<OrderItem> orderDetails;
	private OrderItem orderDetail;
	private int totalAmount;
	private LocalDate purchaseDate;
	
	public String getCustomerName() {
		return customerName;
	}
	public int getBillNumber() {
		return billNumber;
	}
	public int getTotalAmount() {
		return totalAmount;
	}
	public LocalDate getPurchaseDate() {
		return purchaseDate;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public void setBillNumber(int billNumber) {
		this.billNumber = billNumber;
	}
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
	public void setPurchaseDate() {
		this.purchaseDate = LocalDate.now();
	}
	
	public void setPurchaseDate1(LocalDate date) {
		this.purchaseDate = date;
	}
	public List<OrderItem> getOrderDetails() {
		return orderDetails;
	}
	public void setOrderDetails(List<OrderItem> purchase) {
		this.orderDetails = purchase;
	}
	public OrderItem getOrderDetail() {
		return orderDetail;
	}
	public void setOrderDetail(OrderItem orderDetail) {
		this.orderDetail = orderDetail;
	}
	@Override
	public String toString() {
		return "Order [billNumber=" + billNumber + ", customerName=" + customerName + ", orderDetail=" + orderDetail
				+ ", totalAmount=" + totalAmount + ", purchaseDate=" + purchaseDate + "]";
	}
	
}

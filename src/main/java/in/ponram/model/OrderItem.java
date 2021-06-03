package in.ponram.model;

public class OrderItem {

	private int billNumber;
	private int productId;
	private String brandName;
	private String productCategory;
	private String productName;
	private int rate;
	private int quantity;
	private int totalAmount;
	
	public int getBillNumber() {
		return billNumber;
	}
	public int getProductId() {
		return productId;
	}
	public int getRate() {
		return rate;
	}
	public int getQuantity() {
		return quantity;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	@Override
	public String toString() {
		return "OrderItem [billNumber=" + billNumber + ", productId=" + productId + ", brandName=" + brandName
				+ ", productCategory=" + productCategory + ", productName=" + productName + ", rate=" + rate
				+ ", quantity=" + quantity + ", totalAmount=" + totalAmount + "]";
	}
	public String getBrandName() {
		return brandName;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setBillNumber(int billNumber) {
		this.billNumber = billNumber;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	
}

package in.ponram.model;

import java.time.LocalDate;


public class Product {

	public Product(String brandName, String productName, String productCategory, int rate, int quantity) {
		this.brandName = brandName;
		this.productName = productName;
		this.productCategory = productCategory;
		arrivalDate = LocalDate.now();
		this.rate = rate;
		this.quantity = quantity;
	}

	private int productId;
	public Product(int productId, String brandName, String productName, String productCategory, LocalDate arrivalDate,
			int quantity,int rate) {
		this.productId = productId;
		this.brandName = brandName;
		this.productName = productName;
		this.productCategory = productCategory;
		this.arrivalDate = arrivalDate;
		this.rate = rate;
		this.quantity = quantity;
	}

	public Product() {
		//default constructor 
	}

	private String brandName;
	private String productName;
	private String productCategory;
	private LocalDate arrivalDate;
	private int rate;
	private int quantity;
	private int initialQuantity;
	private boolean status;
	public int getProductId() {
		return productId;
	}

	public String getBrandName() {
		return brandName;
	}

	public String getProductName() {
		return productName;
	}

	public String getProductCategory() {
		return productCategory;
	}
	
	public LocalDate getArrivalDate() {
		return arrivalDate;
	}

	public int getRate() {
		return rate;
	}

	public int getQuantity() {
		return quantity;
	}


	@Override
	public String toString() {
		return "Product [product Id=" + productId + ", brandName=" + brandName + ", Product Name=" + productName + ", Product Category="
				+ productCategory + ", arrivalDate=" + arrivalDate + ", rate=" + rate + ", quantity=" + quantity + "]";
	}

	public int getInitialQuantity() {
		return initialQuantity;
	}

	public void setInitialQuantity(int initialQuantity) {
		this.initialQuantity = initialQuantity;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public void setArrivalDate(LocalDate arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}

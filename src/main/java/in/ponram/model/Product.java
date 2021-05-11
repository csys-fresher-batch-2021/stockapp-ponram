package in.ponram.model;

public class Product {

	public Product(String itemId, String brandName, String itemName, String itemCategory, int rate, int quantity) {
		this.itemId = itemId;
		this.brandName = brandName;
		this.itemName = itemName;
		this.itemCategory = itemCategory;
		this.rate = rate;
		this.quantity = quantity;
		amount = rate * quantity;
	}

	private String itemId;
	private String brandName;
	private String itemName;
	private String itemCategory;
	private int rate;
	private int quantity;
	private int amount;

	public String getItemId() {
		return itemId;
	}

	public String getBrandName() {
		return brandName;
	}

	public String getItemName() {
		return itemName;
	}

	public String getItemCategory() {
		return itemCategory;
	}

	public int getRate() {
		return rate;
	}

	public int getQuantity() {
		return quantity;
	}

	public int getAmount() {
		return amount;
	}

	public String toString() {

		return "" + itemId + " " + brandName + " " + itemName + " " + itemCategory + " " + rate + " " + quantity + " "
				+ amount;

	}
}
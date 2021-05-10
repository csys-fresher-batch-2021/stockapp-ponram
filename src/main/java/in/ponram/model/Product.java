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

	public String itemId;
	public String brandName;
	public String itemName;
	public String itemCategory;
	public int rate;
	public int quantity;
	public int amount;

	public String toString() {

		return " " + itemId + " " + brandName + " " + itemCategory + " " + itemName + " " + rate + " " + quantity + " "
				+ amount;

	}
}

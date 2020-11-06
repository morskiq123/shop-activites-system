// Superclass for Mouse & Keyboard

public class Product {
	private int barcode;
	private String brand;
	private String colour;
	private Connectivity connectivityType;
	private double originalCost;
	private double retailPrice;
	private int quantity;
	
	//CONSTRUCTOR
	public Product(int barcode, String brand, String colour, Connectivity connectivityType,
				   double originalCost, double retailPrice, int quantity ) {
		this.barcode = barcode;
		this.brand = brand;
		this.colour = colour;
		this.connectivityType = connectivityType;
		this.originalCost = originalCost;
		this.retailPrice = retailPrice;
		this.quantity = quantity;
	}
	
	// GETTER METHODS
	public int getBarcode() {
		return this.barcode;
	}
	
	public String getBrand() {
		return this.brand;
	}
	
	public String getColour() {
		return this.colour;
	}
	
	public Connectivity getConnectivityType() {
		return this.connectivityType;
	}
	
	public double getOriginalCost() {
		return this.originalCost;
	}
	
	public double getRetailPrice() {
		return this.retailPrice;
	}
	
	public int getQuantity() {
		return this.quantity;
	}
	
	// SETTER METHODS
	public void setBarcode(int barcode) {
		this.barcode = barcode;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public void setColour(String colour) {
		this.colour = colour;
	}
	
	public void setConnectivityType(Connectivity connectivityType) {
		this.connectivityType = connectivityType;
	}
	
	public void setOriginalCost(double originalCost) {
		this.originalCost = originalCost;
	}
	
	public void setRetailPrice(double retailPrice) {
		this.retailPrice = retailPrice;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public boolean equals(Object prod) {
		if (this == prod) {
			return true;
		}else {
			return false;
		}
		
	}
}

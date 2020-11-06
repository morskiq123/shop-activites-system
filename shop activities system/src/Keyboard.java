public class Keyboard extends Product implements DefaultMethods{
	
	
	KeyboardType keyboardType;
	KeyboardLayout keyboardLayout;
	
	//CONSTRUCTOR
	public Keyboard(int barcode, String brand, String colour, Connectivity connectivityType, double originalCost,
					double retailPrice, int quantity, KeyboardType keyboardType, KeyboardLayout keyboardLayout) {
		super(barcode, brand, colour, connectivityType, originalCost, retailPrice, quantity);
		this.keyboardType = keyboardType;
		this.keyboardLayout = keyboardLayout;
	}
	
	// GETTER METHODS
	
	public KeyboardType getKeyboardType() {
		return this.keyboardType;
	}
	
	public KeyboardLayout getKeyboardLayout() {
		return this.keyboardLayout;
	}
		
	// SETTER METHODS
	
	// adds the number of received stock
	public void setKeyboardLayout(KeyboardLayout keyboardLayout) {
		this.keyboardLayout = keyboardLayout;
	}
	
	public void setKeyboardType(KeyboardType keyboardType) {
		this.keyboardType = keyboardType;
	}

	@Override
	public String toString() {
		return (getBarcode() + ", keyboard, " + getKeyboardType()  + ", " + getBrand() + ", " + getColour()  + ", " + 
				   getConnectivityType() + ", " + getQuantity() + ", " + getOriginalCost() + ", " + getRetailPrice()
				   + ", " + getKeyboardLayout());
	}
}

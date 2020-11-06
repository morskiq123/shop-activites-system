
public class Mouse extends Product implements DefaultMethods {
	
	private int numberOfButtons;
	private MouseType mouseType;
	
	// CONSTRUCTOR
	public Mouse(int barcode, String brand, String colour, Connectivity connectivityType, double originalCost,
				double retailPrice, int quantity, int numberOfButtons, MouseType mouseType){
		super(barcode, brand, colour, connectivityType, originalCost, retailPrice,quantity);
		
		this.numberOfButtons = numberOfButtons;
		this.mouseType = mouseType;
	}
	
	// GETTER METHODS
	
	public int getNumberOfButtons() {
		return this.numberOfButtons;
	}
	
	public MouseType getMouseType() {
		return this.mouseType;
	}
	
	// SETTER METHODS
	
	public void setNumberOfButtons(int numberOfButtons) {
		this.numberOfButtons = numberOfButtons;
	}
	
	public void setMouseType(MouseType mouseType) {
		this.mouseType = mouseType;
	}
	
	@Override
	public String toString() {
		return(getBarcode() + ", mouse, " + getMouseType()  + ", " + getBrand() + ", " + getColour()  + ", " + 
			   getConnectivityType() + ", " + getQuantity() + ", " + getOriginalCost() + ", " + getRetailPrice()
			   + ", " + getNumberOfButtons());
	}

}

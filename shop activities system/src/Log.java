public class Log implements DefaultMethods {
	
	private int userId;
	private String postcode;
	private int barcode;
	private double retailPrice;
	private int quantity;
	private OrderStatus orderStatus;
	private PaymentType paymentType;
	private String paymentTypeEmpty;
	private String date;

	// CONSTRUCTOR - PAYED 
	public Log(int userId, String postcode, int barcode, double retailPrice, int quantity, OrderStatus orderStatus,
				PaymentType paymentType, String date) {
		this.userId = userId;
		this.postcode = postcode;
		this.barcode = barcode;
		this.retailPrice = retailPrice;
		this.quantity = quantity;
		this.orderStatus = orderStatus;
		this.paymentType = paymentType;
		this.date = date;
	}
	
	// CONSTRUCTOR - CANCELLED / SAVED
	// STRING QUANTITY SET TO " "
	public Log(int userId, String postcode, int barcode, double retailPrice, int quantity, OrderStatus orderStatus, String paymentTypeEmpty ,String date) {
		this.userId = userId;
		this.postcode = postcode;
		this.barcode = barcode;
		this.retailPrice = retailPrice;
		this.quantity = quantity;
		this.orderStatus = orderStatus;
		this.paymentTypeEmpty = paymentTypeEmpty;
		this.date = date;
}
	
	
	// GETTERS
	public int getUserId() {
		return this.userId;
	}
	
	public String getPostcode() {
		return this.postcode;
	}
	
	public int getBarcode() {
		return this.barcode;
	}
	
	public double getRetailPrice() {
		return this.retailPrice;
	}
	
	public int getQuantity() {
		return this.quantity;
	}
	
	public OrderStatus getOrderStatus() {
		return this.orderStatus;
	}
	
	public PaymentType getPaymentType() {
		return this.paymentType;
	}
	
	public String getPaymentTypeEmpty() {
		return this.paymentTypeEmpty;
	}
	
	public String getDate() {
		return this.date;
		 
	}
	
	
	
	// finish this & figure out Stock.txt & ActivityLog.txt
	@Override
	public String toString() {
		if (this.orderStatus.equals(orderStatus.PURCHASED)) {		// ONLY IF A PURCHASE IS MADE
		 return (getUserId() + ", " + getPostcode() + ", " + getBarcode() + ", " + getRetailPrice() + ", " + getQuantity() + ", " 
				 + getOrderStatus() + ", " + getPaymentType() + ", " + getDate());
		}
		 else { // FOR CANCELLED / SAVED
			 return (getUserId() + ", " + getPostcode() + ", " + getBarcode() + ", " + getRetailPrice() + ", " + getQuantity() + ", " 
					 + getOrderStatus() + ", " + getPaymentTypeEmpty() + ", " + getDate());
		 }
		}
}
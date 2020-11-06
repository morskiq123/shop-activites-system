public class PaymentMethod {
	private PaymentType paymentType;
	private String cardNumber;
	private int securityCode;
	private String email;
	
	
	public PaymentMethod(PaymentType paymentType, String cardNumber, int securityCode) {
		this.paymentType = paymentType;
		this.cardNumber = cardNumber;
		this.securityCode = securityCode;
	}
	
	public PaymentMethod(PaymentType paymentType, String email) {
		this.paymentType = paymentType;
		this.email = email;
	}
	
	// GETTERS
	
	public PaymentType getPaymentType() {
		return this.paymentType;
	}
	
}
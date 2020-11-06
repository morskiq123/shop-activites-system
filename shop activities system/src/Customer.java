import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Customer extends User implements DefaultMethods{
	private UserType userType;
	private ArrayList<Product> shoppingBasket;
	private double amountToPay;
	
	
	public Customer(int userId, String username, String surname, int houseNumber, String postcode, 
					String townName, UserType userType,ArrayList<Product> shoppingBasket, double amountToPay) {
		super(userId, username, surname, houseNumber, postcode, townName);
		this.userType = userType;
		this.shoppingBasket = shoppingBasket;
		this.amountToPay = amountToPay; // always equal to 0 at the beginning!!! do not forget to set!!!!
	}
		// productList - populated productList with all of the products from Stock.txt
		// index - which row -> will be dynamic through use of buttons / rows i.e. index 0 is row 0
		// productList[0].getQuantity if quantity > 0 { check if its mouse or keyboard, then 
		// create the appropriate temporary class and add it to the shoppingBasket.
	
	
		public UserType getUserType() {
			return this.userType;
		}
		
		public ArrayList<Product> getShoppingBasket(){
			return this.shoppingBasket;
		}
		
		public double getAmountToPay() {
			return this.amountToPay;
		}
		
		private String getDate() {
			Date date= new Date();  
			SimpleDateFormat dateFormat= new SimpleDateFormat("dd-MM-yyyy");  
			String stringDate = dateFormat.format(date);
			return stringDate;
		}
		
		private void addAmount(double priceOfStock) {
			System.out.println("PRICE OF STOCK: " + priceOfStock);
			this.amountToPay += priceOfStock; 
			System.out.println("AMOUNT TO PAY: " + amountToPay);
		}
		
		public void addToBasket(ArrayList<Product> productList, int index, int quantityOfCustomer) {
			Mouse mouse = null;
			Keyboard keyboard = null;
			int quantityStock = productList.get(index).getQuantity();
			if (quantityOfCustomer > quantityStock) {
				System.out.println("You cannot take more than there is in stock");
			}
			else {
					if(productList.get(index) instanceof Mouse) { 
							mouse = new Mouse(productList.get(index).getBarcode(), productList.get(index).getBrand(),
											   productList.get(index).getColour(), productList.get(index).getConnectivityType(),
											   productList.get(index).getOriginalCost(), productList.get(index).getRetailPrice(),
											   quantityOfCustomer, ((Mouse) productList.get(index)).getNumberOfButtons(),
											   ((Mouse) productList.get(index)).getMouseType());
							
							  double priceOfStock = mouse.getRetailPrice();
							  addAmount(priceOfStock);
							  shoppingBasket.add(mouse);
							  quantityStock = quantityStock - quantityOfCustomer;
							  productList.get(index).setQuantity(quantityStock);
							  Writer writer = new Writer(productList);
							  writer.addStock();
					}else {
						 keyboard = new Keyboard(productList.get(index).getBarcode(), productList.get(index).getBrand(),
													 productList.get(index).getColour(), productList.get(index).getConnectivityType(),
													 productList.get(index).getOriginalCost(), productList.get(index).getRetailPrice(),
													 quantityOfCustomer, ((Keyboard) productList.get(index)).getKeyboardType(),
													 ((Keyboard) productList.get(index)).getKeyboardLayout());
						 
						  		double priceOfStock = keyboard.getRetailPrice();
						  		addAmount(priceOfStock);
						 		shoppingBasket.add(keyboard);
						 		quantityStock = quantityStock - quantityOfCustomer;
								productList.get(index).setQuantity(quantityStock);
								Writer writer = new Writer(productList);
								writer.addStock();
					}
			}
		}
		public void pay(ArrayList<Product> shoppingBasket, ArrayList<Log> logList, PaymentMethod paymentMethod, double amountToPay) {
			String file = "ActivityLog.txt";
			
			if (paymentMethod.getPaymentType().equals(PaymentType.PAYPAL)) {
				for(Product item: shoppingBasket) {
					Log log = new Log(getUserId(),getPostcode(), item.getBarcode(), item.getRetailPrice(), 
									item.getQuantity(), OrderStatus.PURCHASED, PaymentType.PAYPAL, getDate());
					logList.add(log);
				}
			}else{
					for(Product item: shoppingBasket) {
						Log log = new Log(getUserId(),getPostcode(), item.getBarcode(), item.getRetailPrice(), 
										item.getQuantity(), OrderStatus.PURCHASED, PaymentType.CREDIT_CARD, getDate());
						logList.add(log);
				}
				System.out.println('$' + amountToPay); // PLACEHOLDER
				Writer writer = new Writer(logList, file);
				writer.addLog();
				this.shoppingBasket.clear();
			}
		}
		
		public void cancel(ArrayList<Product> shoppingBasket, ArrayList<Log> logList) {
				String file = "ActivityLog.txt";
				String paymentTypeEmpty = " ";
				for(Product item: shoppingBasket) {
					Log log = new Log(getUserId(),getPostcode(), item.getBarcode(), item.getRetailPrice(), 
									  item.getQuantity(), OrderStatus.CANCELLED,  paymentTypeEmpty , getDate());
					logList.add(log);
					}
				Writer writer = new Writer(logList, file);
				writer.addLog();
				this.shoppingBasket.clear();
			
		}
		
		public void save(ArrayList<Product> shoppingBasket, ArrayList<Log> logList) {
				String file = "ActivityLog.txt";
				String paymentTypeEmpty = " ";
				for(Product item: shoppingBasket) {
					Log log = new Log(getUserId(),getPostcode(), item.getBarcode(), item.getRetailPrice(), 
									  item.getQuantity(), OrderStatus.SAVED,  paymentTypeEmpty , getDate());
						logList.add(log);
					}
				Writer writer = new Writer(logList, file);
				writer.addLog();
				this.shoppingBasket.clear();
			
	}
		
		@Override
		public String toString() {
			return(getUserId() + "," + getUsername() + "," + getSurname() + "," + getHouseNumber()+ "," +
					getPostcode() + "," + getTownName() +  "," + getUserType() + "," +
					getShoppingBasket() + "," + getAmountToPay());
		}
		
}

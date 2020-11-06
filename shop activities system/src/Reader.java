import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.BufferedReader;;


// Class that reads & populates two different Collections. 
// ArrayList<Product> is populated by Stock.txt
// HashMap<String,User> is populated by UserAccounts.txt

public class Reader {	
	private ArrayList<Product> productList;
	private ArrayList<User> userList;
	private int filler;
	private ArrayList<Log> logList;
	private String file;
	
	// CONSTRUCTORS
	public Reader(ArrayList<Product> productList) {
		this.productList = productList;
	}
	
	public Reader(ArrayList<User> userList, int filler) {
		this.userList = userList;
		this.filler = filler;
	}
	
	public Reader(ArrayList<Log> logList, String file) {
		this.logList = logList;
		this.file = file;
	}
	
	// READING & POPULATING FROM Stock.txt
	public void readStock() {
		Scanner scanner = null;
		try {
			File input = new File("Stock.txt");
			scanner = new Scanner(input);
			Mouse mouse = null;
			Keyboard keyboard = null;
			while (scanner.hasNextLine()) {
				String[] info = scanner.nextLine().split(",");
				
				 if (info[1].trim().equals("mouse")) {
					mouse = new Mouse(Integer.parseInt(info[0].trim()), 
									  info[3].trim(), info[4].trim(), 
								 	  Connectivity.valueOf(info[5].trim().toUpperCase()),
								 	  Double.parseDouble(info[7].trim()),
								 	  Double.parseDouble(info[8].trim()), 
								 	  Integer.parseInt(info[6].trim()), 
								 	  Integer.parseInt(info[9].trim()), 
								 	  MouseType.valueOf(info[2].trim().toUpperCase()));
						productList.add(mouse);
				 } else {
					 keyboard =	new Keyboard(Integer.parseInt(info[0].trim()), 
										     info[3].trim(), info[4].trim(), 
									 	     Connectivity.valueOf(info[5].trim().toUpperCase()),
									 	     Double.parseDouble(info[7].trim()),
									 	     Double.parseDouble(info[8].trim()), 
									 	     Integer.parseInt(info[6].trim()), 
									 	  	 KeyboardType.valueOf(info[2].trim().toUpperCase()),
									 	  	 KeyboardLayout.valueOf(info[9].trim().toUpperCase()));
					 	productList.add(keyboard);
				}
			} 
		}	catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		finally {
			scanner.close();
		}
	}
	// READING & POPULATING FROM UserAccounts.txt 
	public void readUsers() { 
		Scanner scanner = null;
		try {
			File input = new File("UserAccounts.txt");
			scanner = new Scanner(input);
			Admin admin = null;
			Customer customer = null;
			while (scanner.hasNextLine()) {
				String[] info = scanner.nextLine().split(",");
				if (info[6].trim().equals("admin")) {
					admin = new Admin(Integer.parseInt(info[0].trim()), 
									  info[1].trim(), info[2].trim(), 
									  Integer.parseInt(info[3].trim()),
									  info[4].trim(), info[5].trim(),
									  UserType.valueOf(info[6].trim().toUpperCase()));
					
				userList.add(admin);
				}else {
					ArrayList<Product> shoppingBasket = new ArrayList<Product>();
					double amountToPay = 0.0;
					customer = new Customer(Integer.parseInt(info[0].trim()),
											info[1].trim(), info[2].trim(),
											Integer.parseInt(info[3].trim()),
											info[4].trim(), info[5].trim(),
											UserType.valueOf(info[6].trim().toUpperCase()),
											shoppingBasket, amountToPay);
					userList.add(customer);
				}
			} 	
		}	catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		finally {
			scanner.close();
		}
	}
	
	public void readLogs() {
		Scanner scanner = null;
		try {
			File input = new File(file);
			scanner = new Scanner(input);
			Log log = null;
			while (scanner.hasNextLine()) {
				String[] info = scanner.nextLine().split(",");
				if (info[5].trim().equalsIgnoreCase("purchased")){
					if (info[6].trim().matches("Credit Card|CREDIT_CARD")){
						log = new Log(Integer.parseInt(info[0].trim()), 
									  info[1].trim(), Integer.parseInt(info[2].trim()),
									  Double.parseDouble(info[3].trim()),
									  Integer.parseInt(info[4].trim()),
									  OrderStatus.valueOf(info[5].toUpperCase().trim()),
									  PaymentType.CREDIT_CARD, info[7].trim());
						logList.add(log);
						
					}if (info[6].trim().matches("PayPal|PAYPAL")) {
						log = new Log(Integer.parseInt(info[0].trim()), 
								  info[1].trim(), Integer.parseInt(info[2].trim()),
								  Double.parseDouble(info[3].trim()),
								  Integer.parseInt(info[4].trim()),
								  OrderStatus.valueOf(info[5].toUpperCase().trim()),
								  PaymentType.PAYPAL, info[7].trim());
						logList.add(log);
					}
				}else {
					log = new Log(Integer.parseInt(info[0].trim()), 
								  info[1].trim(), Integer.parseInt(info[2].trim()),
								  Double.parseDouble(info[3].trim()),
								  Integer.parseInt(info[4].trim()),
								  OrderStatus.valueOf(info[5].toUpperCase().trim()),
								  info[6].trim(), info[7].trim());
					logList.add(log);
				}
				
				
			} 	
		}	catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		finally {
			scanner.close();
		}
	}
}

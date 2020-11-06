import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ConcurrentModificationException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;

public class CustomerWindow extends JFrame {

	private JPanel contentPane;
	private static String username;
	private DefaultTableModel dtmProduct;
	private JTable productTable;
	private JTable shoppingBasketTable;
	private DefaultTableModel dtmShoppingBasket;
	private ArrayList<Log> logList;
	private ArrayList<Product> productList;
	private ArrayList<Product> shoppingBasket;
	private Customer customer;
	private JTextField emailField;
	private JTextField creditCardNumberField;
	private JTextField securityCodeField;
	private int checker;
	private int emailChecker;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		//username = args[0]; 
		username = "user2"; // FOR TESTING PURPOSES  - DELETE LATER
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerWindow frame = new CustomerWindow();
					frame.setVisible(true);
					frame.setResizable(false);
					frame.setTitle("Customer mode");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private void populateJTableProduct() { // this one does not include original price
		productList.clear();
		dtmProduct.setRowCount(0);
		Reader readProducts = new Reader(productList);
		readProducts.readStock();

		for(Product product : productList) {
			if (product instanceof Mouse) {
				int barcode = product.getBarcode();
				String productType = "Mouse";
				MouseType mouseType = ((Mouse) product).getMouseType();
				String brand = product.getBrand();
				String colour = product.getColour();
				Connectivity connectivity = product.getConnectivityType();
				int quantity = product.getQuantity();
				double retailPrice = product.getRetailPrice();
				int numberOfButtons = ((Mouse) product).getNumberOfButtons();
				String layout = "N/A";
				Object[] rowData = new Object[] {barcode, productType, mouseType, brand, colour, connectivity, quantity,
												 retailPrice, numberOfButtons, layout};
				dtmProduct.addRow(rowData);
			}else{
				int barcode = product.getBarcode();
				String productType = "Keyboard";
				KeyboardType keyboardType = ((Keyboard) product).getKeyboardType();
				String brand = product.getBrand();
				String colour = product.getColour();
				Connectivity connectivity = product.getConnectivityType();
				int quantity = product.getQuantity();		
				double retailPrice = product.getRetailPrice();
				String numberOfButtons = "N/A";
				KeyboardLayout layout= ((Keyboard) product).getKeyboardLayout();
				Object[] rowData = new Object[] {barcode, productType, keyboardType, brand, colour, connectivity, quantity,
												 retailPrice, numberOfButtons, layout};
				dtmProduct.addRow(rowData); 
			}
		}
	}
	
	private void populateJTableShoppingBasket() {
		for(Product product : shoppingBasket) {
			if (product instanceof Mouse) {
				int barcode = product.getBarcode();
				String productType = "Mouse";
				MouseType mouseType = ((Mouse) product).getMouseType();
				String brand = product.getBrand();
				String colour = product.getColour();
				Connectivity connectivity = product.getConnectivityType();
				int quantity = product.getQuantity();
				double retailPrice = product.getRetailPrice();
				int numberOfButtons = ((Mouse) product).getNumberOfButtons();
				String layout = "N/A";
				Object[] rowData = new Object[] {barcode, productType, mouseType, brand, colour, connectivity, quantity,
												 retailPrice, numberOfButtons, layout};
				dtmShoppingBasket.addRow(rowData);
			}else{
				int barcode = product.getBarcode();
				String productType = "Keyboard";
				KeyboardType keyboardType = ((Keyboard) product).getKeyboardType();
				String brand = product.getBrand();
				String colour = product.getColour();
				Connectivity connectivity = product.getConnectivityType();
				int quantity = product.getQuantity();		
				double retailPrice = product.getRetailPrice();
				String numberOfButtons = "N/A";
				KeyboardLayout layout= ((Keyboard) product).getKeyboardLayout();
				Object[] rowData = new Object[] {barcode, productType, keyboardType, brand, colour, connectivity, quantity,
												 retailPrice, numberOfButtons, layout};
				dtmShoppingBasket.addRow(rowData); 
			}
		}
		
	}

	/**
	 * Create the frame.
	 */
	public CustomerWindow() {
		checker = 0;
		
		productList = new ArrayList<Product>();
		Reader readProducts = new Reader(productList);
		readProducts.readStock();
					
		
		// ArrayList for storing all users
		ArrayList <User> userList = new ArrayList<User>();
		// Populates the map with all users
		Reader readerUsers = new Reader(userList,0);
		readerUsers.readUsers();
		
		for (User user : userList) {
		if (user instanceof Customer && user.getUsername().contentEquals(username)){
			 customer = new Customer(user.getUserId(),user.getUsername(),user.getSurname(),user.getHouseNumber(),
		      				  		user.getPostcode(),user.getTownName(),((Customer)user).getUserType(), 
		      				  		((Customer)user).getShoppingBasket(),((Customer)user).getAmountToPay());
		    }
		}
		
		shoppingBasket = new ArrayList<Product>();		
		shoppingBasket = customer.getShoppingBasket();
		
		logList = new ArrayList<Log>();
		String file = "ActivityLog.txt";
		Reader logReader = new Reader(logList, file);
		logReader.readLogs();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1108, 890);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(184, 47, 908, 347);
		contentPane.add(scrollPane);
		
		// productTable
		productTable = new JTable();
		scrollPane.setViewportView(productTable);
		dtmProduct = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		dtmProduct.setColumnIdentifiers(new Object[] {"Barcode","Product","Type","Brand","Colour","Connectivity","Quantity",
													  "Retail Price","No. of Buttons", "Layout"});
		productTable.setModel(dtmProduct);
		scrollPane.setViewportView(productTable);
		
		// Initial population of the table from Stock.txt
		populateJTableProduct();
		
		productTable.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
               if (e.getClickCount() == 2) {  
                 JTable target = (JTable)e.getSource();
                 int index = productTable.getSelectedRow();
                 int quantCheck = productList.get(index).getQuantity();
                
                 if (quantCheck == 0) {
                     JOptionPane.showMessageDialog(null, "Out of stock");
                 }if(shoppingBasket.isEmpty()) {
                     customer.addToBasket(productList, index, 1);
                     populateJTableProduct();
                     populateJTableShoppingBasket();
                 }else {
                     try {
                         for(Product prod : shoppingBasket) {
                         if(prod.getBarcode() == productList.get(index).getBarcode()) {
                           int currentQuantity  = prod.getQuantity();
                           prod.setQuantity(currentQuantity+1);
                           ((DefaultTableModel)shoppingBasketTable.getModel()).setNumRows(0);
                           populateJTableProduct();
                           populateJTableShoppingBasket();
                         }else {
                             customer.addToBasket(productList, index, 1);
                             ((DefaultTableModel)shoppingBasketTable.getModel()).setNumRows(0);
                             populateJTableProduct();
                             populateJTableShoppingBasket();
                         }
                        }
                     }catch(ConcurrentModificationException error) {
                    	
                     }
                   }
                 }
              }  
         });
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(184, 514, 908, 164);
		contentPane.add(scrollPane_1);
		
		shoppingBasketTable = new JTable();
		scrollPane_1.setViewportView(shoppingBasketTable);
		dtmShoppingBasket = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		dtmShoppingBasket.setColumnIdentifiers(new Object[] {"Barcode","Product","Type","Brand","Colour","Connectivity","Quantity",
															 "Retail Price","No. of Buttons", "Layout"});
		shoppingBasketTable.setModel(dtmShoppingBasket);
		scrollPane_1.setViewportView(shoppingBasketTable);
		
		JLabel lblNewLabel_2 = new JLabel("Your shopping basket");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_2.setBounds(540, 481, 255, 30);
		contentPane.add(lblNewLabel_2);
	
		
		// CHANGE USER BUTTON
		JButton btnChangeUser = new JButton("Change user");
		btnChangeUser.setBounds(24, 47, 148, 41);
		btnChangeUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login loginFrame = new Login();
				loginFrame.setVisible(true);
				dispose();
			}
		});
		btnChangeUser.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(btnChangeUser);
		
		JLabel lblNewLabel = new JLabel("All products");
		lblNewLabel.setBounds(562, 0, 139, 48);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Double click on your desired item to add it to your basket");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(229, 396, 814, 48);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Save basket for later");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				customer.save(shoppingBasket, logList);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(35, 691, 217, 48);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel purchase");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				customer.cancel(shoppingBasket, logList);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(281, 691, 241, 48);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Pay with PayPal");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				emailChecker = 1;
				
				String email = emailField.getText();
				int emailLength = email.length();
				if (emailLength == 0) {
					JOptionPane.showMessageDialog(null, "Enter an email");
					checker += 1;
				}else {
					for (char ch: email.toCharArray()) {
						if (ch == '@') {
							emailChecker = 0;
						}
					}
					if (emailChecker == 1) {
						JOptionPane.showMessageDialog(null, "Invalid email");
					}
				}
				
				if (checker == 0 && emailChecker == 0) {
					if (shoppingBasket.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Add items in basket before paying");
					}else {
						PaymentType paymentType = PaymentType.PAYPAL;
						PaymentMethod paymentMethod = new PaymentMethod (paymentType,email);
						customer.pay(shoppingBasket, logList, paymentMethod, customer.getAmountToPay());
						int ammountPayed = (int) customer.getAmountToPay();
						JOptionPane.showMessageDialog(null, "Payed $" + ammountPayed + " by using PayPal");
						((DefaultTableModel)shoppingBasketTable.getModel()).setNumRows(0);
						shoppingBasket.clear();
					}
				}
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_2.setBounds(516, 757, 241, 24);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Pay with Credit card");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				String creditCardNumber = creditCardNumberField.getText();
				int creditCardLength = creditCardNumber.length();
				if (creditCardLength != 16) {
					JOptionPane.showMessageDialog(null, "Invalid credit card number");
					checker += 1;
				}
				
				int securityCode = Integer.parseInt(securityCodeField.getText());
				if(securityCode >= 999 && securityCode <= 100 || securityCode == 0) {
					JOptionPane.showMessageDialog(null, "Invalid security code");
					checker += 1;
				}
				
				if (checker == 0) {
					if (shoppingBasket.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Add items in basket before paying");
					}else {
						PaymentType paymentType = PaymentType.CREDIT_CARD;
						PaymentMethod paymentMethod = new PaymentMethod (paymentType,creditCardNumber,securityCode);
						customer.pay(shoppingBasket, logList, paymentMethod, customer.getAmountToPay());
						int ammountPayed = (int) customer.getAmountToPay();
						JOptionPane.showMessageDialog(null, "Payed $" + ammountPayed + " by using a credit card");
						((DefaultTableModel)shoppingBasketTable.getModel()).setNumRows(0);
						shoppingBasket.clear();
						checker = 0;
					}
				}
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_3.setBounds(785, 809, 241, 24);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel_3 = new JLabel("Enter your email");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(562, 691, 129, 24);
		contentPane.add(lblNewLabel_3);
		
		emailField = new JTextField();
		emailField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		emailField.setBounds(553, 720, 148, 24);
		contentPane.add(emailField);
		emailField.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Enter your credit card number");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(785, 691, 241, 30);
		contentPane.add(lblNewLabel_4);
		
		creditCardNumberField = new JTextField();
		creditCardNumberField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		creditCardNumberField.setBounds(785, 716, 241, 22);
		contentPane.add(creditCardNumberField);
		creditCardNumberField.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Enter the 3 digit security code");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_5.setBounds(785, 741, 241, 24);
		contentPane.add(lblNewLabel_5);
		
		securityCodeField = new JTextField();
		securityCodeField.setText("000");
		securityCodeField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		securityCodeField.setBounds(880, 778, 44, 22);
		contentPane.add(securityCodeField);
		securityCodeField.setColumns(10);
		
	}
}

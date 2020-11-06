import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class AdminWindow extends JFrame {

	private JPanel contentPane;
	private ArrayList<User> userList;
	private ArrayList<Product> productList;
	private static String username;
	private JTable productTable;
	private DefaultTableModel dtmProduct;
	private JTable keyboardTable;


	/**
	 * Launched from Login.java, otherwise will receive ArrayIndexOutOfBoundsException!!!!!
	 */
	public static void main(String[] args) {
		username = args[0]; 
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminWindow frame = new AdminWindow();
					frame.setVisible(true);
					frame.setResizable(false);
					frame.setTitle("Admin mode");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

		
	/**
	 * Create the frame.
	 * 
	 */
	private void populateJTable() {
		// ArrayList for storing all the products
		ArrayList<Product> productList = new ArrayList<Product>();
		// Populates the ArrayList with all the products
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
				double originalPrice = product.getOriginalCost();
				double retailPrice = product.getRetailPrice();
				int numberOfButtons = ((Mouse) product).getNumberOfButtons();
				String layout = "N/A";
				Object[] rowData = new Object[] {barcode, productType, mouseType, brand, colour, connectivity, quantity, originalPrice,
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
				double originalPrice = product.getOriginalCost();
				double retailPrice = product.getRetailPrice();
				String numberOfButtons = "N/A";
				KeyboardLayout layout= ((Keyboard) product).getKeyboardLayout();
				Object[] rowData = new Object[] {barcode, productType, keyboardType, brand, colour, connectivity, quantity, originalPrice,
												 retailPrice, numberOfButtons, layout};
				dtmProduct.addRow(rowData); 
			}
		}
	}
	
	public AdminWindow() {	
		// ArrayList for storing all users
		ArrayList <User> userList = new ArrayList<User>();
		// Populates the map with all users
		Reader readerUsers = new Reader(userList,0);
		readerUsers.readUsers();
		
		Admin admin = null;
		for (User user : userList) {
      	  if (user instanceof Admin && user.getUsername().contentEquals(username)){
      		  	  admin = new Admin(user.getUserId(),user.getUsername(),user.getSurname(),user.getHouseNumber(),
      					  			user.getPostcode(),user.getTownName(),((Admin)user).getUserType());
      	  		}
      	  }

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1096, 597);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(160, 47, 906, 347);
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
		dtmProduct.setColumnIdentifiers(new Object[] {"Barcode","Product","Type","Brand","Colour","Connectivity","Quantity","Original Price",
													  "Retail Price","No. of Buttons", "Layout"});
		productTable.setModel(dtmProduct);
		scrollPane.setViewportView(productTable);
		
		//Initial population of productTable from Stock.txt
		populateJTable();
		
		// ADD NEW PRODUCT BUTTONS
		JButton btnAddMouse = new JButton("Add new mouse");
		btnAddMouse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddMouse addMouseFrame = new AddMouse();
				addMouseFrame.setVisible(true);
				
			}
		});
		btnAddMouse.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAddMouse.setBounds(343, 404, 222, 51);
		contentPane.add(btnAddMouse);
		
		JButton btnAddKeyboard = new JButton("Add new keyboard");
		btnAddKeyboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddKeyboard addKeyboardFrame = new AddKeyboard();
				addKeyboardFrame.setVisible(true);
			}
		});
		btnAddKeyboard.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAddKeyboard.setBounds(602, 404, 222, 51);
		contentPane.add(btnAddKeyboard);
		
		// CHANGE USER BUTTON
		JButton btnChangeUser = new JButton("Change user");
		btnChangeUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login loginFrame = new Login();
				loginFrame.setVisible(true);
				dispose();
			}
		});
		btnChangeUser.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnChangeUser.setBounds(0, 47, 148, 41);
		contentPane.add(btnChangeUser);
		
		// REFRESH PRODUCTS
		JButton btnNewButton = new JButton("Refresh products");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dtmProduct.setRowCount(0);
				populateJTable();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(447, 468, 281, 51);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("All products");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(531, 0, 139, 48);
		contentPane.add(lblNewLabel);

	}
}

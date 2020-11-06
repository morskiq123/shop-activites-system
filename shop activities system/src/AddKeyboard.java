import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class AddKeyboard extends JFrame {

	private JPanel contentPane;
	private JTextField barcode;
	private final ButtonGroup keyboardType = new ButtonGroup();
	private JTextField brand;
	private JTextField colour;
	private final ButtonGroup connecitivtyType = new ButtonGroup();
	private JTextField quantity;
	private JTextField originalPrice;
	private JTextField retailPrice;
	private final ButtonGroup layoutType = new ButtonGroup();
	private int checker;
	private String keyboardTypeButton;
	private KeyboardType keyboardTypeNew;
	private String connecitivtyTypeButton;
	private Connectivity connectivityTypeNew;
	private String keyboardLayoutButton;
	private KeyboardLayout keyboardLayoutNew;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddKeyboard frame = new AddKeyboard();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddKeyboard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 220, 830);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblNewLabel = new JLabel("Barcode");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(12, 13, 96, 25);
		contentPane.add(lblNewLabel);
		
		JLabel validationBarcode = new JLabel("");
		validationBarcode.setForeground(Color.RED);
		validationBarcode.setFont(new Font("Tahoma", Font.PLAIN, 14));
		validationBarcode.setBounds(99, 37, 96, 22);
		contentPane.add(validationBarcode);
		
		barcode = new JTextField();
		barcode.setText("000000");
		barcode.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char input = e.getKeyChar();
				if ((input <'0' || input > '9') && input != '\b') {
					e.consume();
					validationBarcode.setText("Invalid input");	
				}else{
					validationBarcode.setText("");
				}
			}
		});
		barcode.setFont(new Font("Tahoma", Font.PLAIN, 15));
		barcode.setBounds(12, 37, 60, 22);
		contentPane.add(barcode);
		barcode.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Keyboard Type");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(12, 72, 127, 25);
		contentPane.add(lblNewLabel_1);
		
		JRadioButton standardType = new JRadioButton("Standard");
		keyboardType.add(standardType);
		standardType.setActionCommand("STANDARD"); // ACTION COMMAND
		standardType.setFont(new Font("Tahoma", Font.PLAIN, 15));
		standardType.setBounds(12, 94, 127, 24);
		contentPane.add(standardType);
		
		JRadioButton internetType = new JRadioButton("Internet");
		keyboardType.add(internetType);
		internetType.setActionCommand("INTERNET"); // ACTION COMMAND
		internetType.setFont(new Font("Tahoma", Font.PLAIN, 15));
		internetType.setBounds(12, 118, 127, 25);
		contentPane.add(internetType);
		
		JRadioButton gamingType = new JRadioButton("Gaming");
		keyboardType.add(gamingType);
		gamingType.setActionCommand("GAMING"); // ACTION COMMAND
		gamingType.setFont(new Font("Tahoma", Font.PLAIN, 15));
		gamingType.setBounds(12, 148, 127, 25);
		contentPane.add(gamingType);
		
		JRadioButton flexibleType = new JRadioButton("Flexible");
		keyboardType.add(flexibleType);
		flexibleType.setActionCommand("FLEXIBLE"); // ACTION COMMAND
		flexibleType.setFont(new Font("Tahoma", Font.PLAIN, 15));
		flexibleType.setBounds(12, 178, 127, 25);
		contentPane.add(flexibleType);
		
		brand = new JTextField();
		brand.setText("N/A");
		brand.setFont(new Font("Tahoma", Font.PLAIN, 15));
		brand.setBounds(12, 225, 116, 22);
		contentPane.add(brand);
		brand.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Brand name");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(12, 199, 116, 25);
		contentPane.add(lblNewLabel_2);
		
		colour = new JTextField();
		colour.setText("N/A");
		colour.setFont(new Font("Tahoma", Font.PLAIN, 15));
		colour.setBounds(12, 282, 82, 22);
		contentPane.add(colour);
		colour.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Colour");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(12, 260, 118, 22);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Connectivity");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(12, 317, 96, 25);
		contentPane.add(lblNewLabel_4);
		
		JRadioButton wiredType = new JRadioButton("Wired");
		connecitivtyType.add(wiredType);
		wiredType.setActionCommand("WIRED"); // ACTION COMMAND
		wiredType.setFont(new Font("Tahoma", Font.PLAIN, 15));
		wiredType.setBounds(12, 341, 127, 25);
		contentPane.add(wiredType);
		
		JRadioButton wirelessType = new JRadioButton("Wireless");
		connecitivtyType.add(wirelessType);
		wirelessType.setActionCommand("WIRELESS");// ACTION COMMAND
		wirelessType.setFont(new Font("Tahoma", Font.PLAIN, 15));
		wirelessType.setBounds(12, 371, 127, 25);
		contentPane.add(wirelessType);
		
		JLabel lblNewLabel_5 = new JLabel("Quantity");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_5.setBounds(12, 405, 96, 25);
		contentPane.add(lblNewLabel_5);
		
		JLabel validationQuantity = new JLabel("");
		validationQuantity.setForeground(Color.RED);
		validationQuantity.setFont(new Font("Tahoma", Font.PLAIN, 14));
		validationQuantity.setBounds(73, 400, 109, 20);
		contentPane.add(validationQuantity);
		
		quantity = new JTextField();
		quantity.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char input = e.getKeyChar();
				if ((input <'0' || input > '9') && input != '\b') {
					e.consume();
					validationQuantity.setText("Invalid input");	
				}else{
					validationQuantity.setText("");
				}
			}
		});
		quantity.setText("0");
		quantity.setFont(new Font("Tahoma", Font.PLAIN, 15));
		quantity.setBounds(12, 431, 49, 22);
		contentPane.add(quantity);
		quantity.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Original price");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_6.setBounds(12, 466, 116, 25);
		contentPane.add(lblNewLabel_6);
		
		JLabel validationOriginalPrice = new JLabel("");
		validationOriginalPrice.setForeground(Color.RED);
		validationOriginalPrice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		validationOriginalPrice.setBounds(84, 461, 98, 20);
		contentPane.add(validationOriginalPrice);
		
		originalPrice = new JTextField();
		originalPrice.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char input = e.getKeyChar();
				if ((input <'0' || input > '9') && input != '\b') {
					e.consume();
					validationOriginalPrice.setText("Invalid input");	
				}else{
					validationOriginalPrice.setText("");
				}
			}
		});
		originalPrice.setText("0.0");
		originalPrice.setFont(new Font("Tahoma", Font.PLAIN, 15));
		originalPrice.setBounds(12, 490, 60, 22);
		contentPane.add(originalPrice);
		originalPrice.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Retail price");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_7.setBounds(12, 525, 96, 25);
		contentPane.add(lblNewLabel_7);
		
		JLabel validationRetailPrice = new JLabel("");
		validationRetailPrice.setForeground(Color.RED);
		validationRetailPrice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		validationRetailPrice.setBounds(84, 528, 100, 22);
		contentPane.add(validationRetailPrice);
				
		retailPrice = new JTextField();
		retailPrice.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char input = e.getKeyChar();
				if ((input <'0' || input > '9') && input != '\b') {
					e.consume();
					validationRetailPrice.setText("Invalid input");	
				}else{
					validationRetailPrice.setText("");
				}
			}
		});
		retailPrice.setText("0.0");
		retailPrice.setFont(new Font("Tahoma", Font.PLAIN, 15));
		retailPrice.setBounds(12, 550, 60, 22);
		contentPane.add(retailPrice);
		retailPrice.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Keyboard Layout");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_8.setBounds(12, 585, 170, 25);
		contentPane.add(lblNewLabel_8);
		
		JRadioButton usLayout = new JRadioButton("US");
		layoutType.add(usLayout);
		usLayout.setActionCommand("US"); // ACTION COMMAND
		usLayout.setFont(new Font("Tahoma", Font.PLAIN, 15));
		usLayout.setBounds(12, 615, 127, 25);
		contentPane.add(usLayout);
		
		JRadioButton ukLayout = new JRadioButton("UK");
		layoutType.add(ukLayout);
		ukLayout.setActionCommand("UK"); // ACTION COMMAND
		ukLayout.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ukLayout.setBounds(12, 645, 127, 25);
		contentPane.add(ukLayout);
	
		JButton btnNewButton = new JButton("Add keyboard");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ArrayList for storing all the products
				ArrayList<Product> productList = new ArrayList<Product>();
				
				// Populates the ArrayList with all the products
				Reader readProducts = new Reader(productList);
				readProducts.readStock();
				
				checker = 0;
				
				int barcodeNew = Integer.parseInt(barcode.getText().trim());
				if (barcodeNew <= 99999 && barcodeNew >= 1000000 || barcodeNew == 0) {
					JOptionPane.showMessageDialog(null, "Invalid barcode");
					checker += 1;
				}
				
				try {
					keyboardTypeButton = keyboardType.getSelection().getActionCommand();
					
					if (keyboardTypeButton.contentEquals("STANDARD")) {
						keyboardTypeNew = KeyboardType.STANDARD;
					}if(keyboardTypeButton.contentEquals("INTERNET")){
						keyboardTypeNew = KeyboardType.INTERNET;
					}if(keyboardTypeButton.contentEquals("GAMING")) {
						keyboardTypeNew = KeyboardType.GAMING;
					}else{
						keyboardTypeNew = KeyboardType.FLEXIBLE;
					}
				}catch(NullPointerException error) {
					JOptionPane.showMessageDialog(null, "Select a keyboard type");
				}
				
				
				String brandNew = brand.getText().trim();
				if (brandNew == null || brandNew.isEmpty() || brandNew.contentEquals("N/A")) {
					JOptionPane.showMessageDialog(null, "Enter a brand name");
					checker += 1;
				}
				
				String colourNew = colour.getText().trim();
				if (colourNew == null || colourNew.isEmpty() || colourNew.contentEquals("N/A")) {
					JOptionPane.showMessageDialog(null, "Enter a colour");
					checker += 1;
				}
				
				try {
					connecitivtyTypeButton = connecitivtyType.getSelection().getActionCommand();
					if (connecitivtyTypeButton.contentEquals("WIRED")) {
						connectivityTypeNew = Connectivity.WIRED;
					}else{
						connectivityTypeNew = Connectivity.WIRELESS;
					}
				}catch(NullPointerException error) {
					JOptionPane.showMessageDialog(null, "Select a connectivity type");
				}	
			
				
				
				int quantityNew = Integer.parseInt(quantity.getText().trim());
				if (quantityNew == 0) {
					JOptionPane.showMessageDialog(null, "Enter a quantity");
					checker += 1;
				}
				
				double originalPriceNew = Double.parseDouble(originalPrice.getText().trim());
				if (originalPriceNew == 0.0) {
					JOptionPane.showMessageDialog(null, "Enter an original price");
					checker += 1;
				}
				
				double retailPriceNew = Double.parseDouble(retailPrice.getText().trim());
				if (retailPriceNew == 0.0) {
					JOptionPane.showMessageDialog(null, "Enter a retail price");
					checker += 1;
				}
				
				try {
					keyboardLayoutButton = layoutType.getSelection().getActionCommand();
					if (keyboardLayoutButton.contentEquals("US")) {
						keyboardLayoutNew = KeyboardLayout.US;
					}else{
						keyboardLayoutNew = KeyboardLayout.UK;
					}
				}catch(NullPointerException error) {
					JOptionPane.showMessageDialog(null, "Select a layout");
				}	
				
				if (checker == 0){
					Keyboard keyboard = new Keyboard(barcodeNew, brandNew, colourNew, connectivityTypeNew, originalPriceNew, retailPriceNew, 
													 quantityNew, keyboardTypeNew, keyboardLayoutNew);
					productList.add(keyboard);
					Writer writer = new Writer(productList);
					writer.addStock();
					dispose();
				}else {
					checker = 0;
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(12, 707, 170, 25);
		contentPane.add(btnNewButton);
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(12, 745, 169, 25);
		contentPane.add(btnNewButton_1);	
	}
}
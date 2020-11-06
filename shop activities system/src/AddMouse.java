import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.PlainDocument;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AddMouse extends JFrame {

	private JPanel contentPane;
	private JTextField barcode;
	private final ButtonGroup mouseType = new ButtonGroup();
	private JTextField brand;
	private JTextField colour;
	private final ButtonGroup connecitivtyType = new ButtonGroup();
	private JTextField quantity;
	private JTextField originalPrice;
	private JTextField retailPrice;
	private JTextField numberOfButtons;
	private int checker;
	private String mouseTypeButton;
	private MouseType mouseTypeNew;
	private String connecitivtyTypeButton;
	private Connectivity connectivityTypeNew;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddMouse frame = new AddMouse();
					frame.setVisible(true);
					frame.setTitle("Add new mouse");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	/**
	 * Create the frame.
	 */
	public AddMouse() {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 217, 755);
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
		
		JLabel lblNewLabel_1 = new JLabel("Mouse Type");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(12, 72, 96, 25);
		contentPane.add(lblNewLabel_1);
		
		JRadioButton gamingType = new JRadioButton("Gaming");
		mouseType.add(gamingType);
		gamingType.setActionCommand("GAMING"); // ACTION COMMAND
		gamingType.setFont(new Font("Tahoma", Font.PLAIN, 15));
		gamingType.setBounds(12, 106, 82, 24);
		contentPane.add(gamingType);
		
		JRadioButton standardType = new JRadioButton("Standard");
		mouseType.add(standardType);
		standardType.setActionCommand("STANDARD"); // ACTION COMMAND
		standardType.setFont(new Font("Tahoma", Font.PLAIN, 15));
		standardType.setBounds(12, 135, 96, 25);
		contentPane.add(standardType);
		
		brand = new JTextField();
		brand.setText("N/A");
		brand.setFont(new Font("Tahoma", Font.PLAIN, 15));
		brand.setBounds(12, 191, 116, 22);
		contentPane.add(brand);
		brand.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Brand name");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(12, 169, 116, 25);
		contentPane.add(lblNewLabel_2);
		
		colour = new JTextField();
		colour.setText("N/A");
		colour.setFont(new Font("Tahoma", Font.PLAIN, 15));
		colour.setBounds(12, 247, 82, 22);
		contentPane.add(colour);
		colour.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Colour");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(12, 226, 118, 22);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Connectivity");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(12, 283, 96, 25);
		contentPane.add(lblNewLabel_4);
		
		JRadioButton wiredType = new JRadioButton("Wired");
		connecitivtyType.add(wiredType);
		wiredType.setActionCommand("WIRED"); // ACTION COMMAND
		wiredType.setFont(new Font("Tahoma", Font.PLAIN, 15));
		wiredType.setBounds(12, 306, 127, 25);
		contentPane.add(wiredType);
		
		JRadioButton wirelessType = new JRadioButton("Wireless");
		connecitivtyType.add(wirelessType);
		wirelessType.setActionCommand("WIRELESS");// ACTION COMMAND
		wirelessType.setFont(new Font("Tahoma", Font.PLAIN, 15));
		wirelessType.setBounds(12, 336, 127, 25);
		contentPane.add(wirelessType);
		
		JLabel lblNewLabel_5 = new JLabel("Quantity");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_5.setBounds(12, 373, 96, 25);
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
		quantity.setBounds(12, 400, 49, 22);
		contentPane.add(quantity);
		quantity.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Original price");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_6.setBounds(12, 434, 116, 25);
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
		originalPrice.setBounds(12, 461, 60, 22);
		contentPane.add(originalPrice);
		originalPrice.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Retail price");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_7.setBounds(12, 499, 96, 25);
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
		retailPrice.setBounds(12, 528, 60, 22);
		contentPane.add(retailPrice);
		retailPrice.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Number of buttons");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_8.setBounds(12, 562, 150, 25);
		contentPane.add(lblNewLabel_8);
		
		JLabel validationNumberOfButtons = new JLabel("");
		validationNumberOfButtons.setForeground(Color.RED);
		validationNumberOfButtons.setFont(new Font("Tahoma", Font.PLAIN, 14));
		validationNumberOfButtons.setBounds(49, 592, 113, 20);
		contentPane.add(validationNumberOfButtons);
	
		numberOfButtons = new JTextField();
		numberOfButtons.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char input = e.getKeyChar();
				if ((input <'0' || input > '9') && input != '\b') {
					e.consume();
					validationNumberOfButtons.setText("Invalid input");	
				}else{
					validationNumberOfButtons.setText("");
				}
			}
		});
		numberOfButtons.setText("0");
		numberOfButtons.setFont(new Font("Tahoma", Font.PLAIN, 15));
		numberOfButtons.setBounds(12, 592, 25, 22);
		contentPane.add(numberOfButtons);
		numberOfButtons.setColumns(10);
		
		JButton btnNewButton = new JButton("Add mouse");
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
					mouseTypeButton = mouseType.getSelection().getActionCommand();
					if (mouseTypeButton.contentEquals("GAMING")) {
						mouseTypeNew = MouseType.GAMING;
					}else{
						mouseTypeNew = MouseType.STANDARD;
					}
				}catch(NullPointerException error) {
					JOptionPane.showMessageDialog(null, "Select a mouse type");
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
					JOptionPane.showMessageDialog(null, "Select a connection type");
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
				int numberOfButtonsNew = Integer.parseInt(numberOfButtons.getText().trim());
				if (numberOfButtonsNew == 0) {
					JOptionPane.showMessageDialog(null, "Enter number of buttons");
					checker += 1;
				}
				
				if (checker == 0){
					Mouse mouse = new Mouse(barcodeNew, brandNew, colourNew, connectivityTypeNew, originalPriceNew, retailPriceNew, 
												quantityNew, numberOfButtonsNew, mouseTypeNew);
					productList.add(mouse);
						
					Writer writer = new Writer(productList);
					writer.addStock();
					dispose();
				}
				else {
					checker = 0;
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(12, 627, 170, 25);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(12, 665, 169, 25);
		contentPane.add(btnNewButton_1);	
	
		}
}

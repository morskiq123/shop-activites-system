import java.awt.BorderLayout;
import java.util.Date;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTable loginTable;
	private ArrayList<User> userList;
	private DefaultTableModel dtmLogin;
	private JLabel lblLogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
					frame.setResizable(false);
					frame.setTitle("Login");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		// HashMap for storing all users
		ArrayList <User> userList = new ArrayList<User>();
		// Populates the map with all users
		Reader readerUsers = new Reader(userList,0);
		readerUsers.readUsers();
								
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 280, 179);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 41, 270, 90);
		contentPane.add(scrollPane);
		
		// Create table model and disable editing
		// This way it enables custom event 
		loginTable = new JTable();
		scrollPane.setViewportView(loginTable);
		dtmLogin = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		dtmLogin.setColumnIdentifiers(new Object[] {"Username"});
		loginTable.setModel(dtmLogin);
		scrollPane.setViewportView(loginTable);
		
		lblLogin = new JLabel("Double click your desired user");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLogin.setHorizontalAlignment(SwingConstants.LEFT);
		lblLogin.setBounds(12, 0, 242, 37);
		contentPane.add(lblLogin);
		
		// Populating the table from UserAccounts.txt
		dtmLogin.setRowCount(0);
		for(User user : userList) {
			String username = user.getUsername();
			Object[] rowData = new Object[] {username};
			dtmLogin.addRow(rowData);
	    }
		
		// Creating a mouse listener and event that gets value
		loginTable.addMouseListener(new MouseAdapter() {
	         public void mouseClicked(MouseEvent e) {
	            if (e.getClickCount() == 2) {     
	              JTable target = (JTable)e.getSource();
	              int row = target.getSelectedRow(); 
	              int column = target.getSelectedColumn(); 
	              //JOptionPane.showMessageDialog(null, loginTable.getValueAt(row, column)); - FOR TESTING
	              String value =  loginTable.getValueAt(row, column).toString();
	              for (User user : userList) {
	            	  if (user instanceof Admin && user.getUsername().contentEquals(value)){
	            			  String[] info = new String[1];
	            			  info[0] = user.getUsername();
	            			  AdminWindow.main(info); 
	            			  dispose();
	            			  break;
	            	 }if(user.getUsername().contentEquals(value)) {
			            	  String[] info = new String[1];
		           			  info[0] = user.getUsername();
	            			  CustomerWindow.main(info);
	            			  dispose();
	            			  break;
	            		  }
	            	  }
	              }
	           }   
	      });
	}	
}

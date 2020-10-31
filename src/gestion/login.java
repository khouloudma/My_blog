package gestion;

import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class login {

	private JFrame frame;
	private JTextField userd;
	private JPasswordField passwordd;
	private Connection myConn = null;
	private ResultSet myRs = null;
	private Statement myStmt = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
	}

	/**
	 * Create the application.
	 */
	public login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.inactiveCaption);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("log in");
		btnNewButton.setForeground(new Color(0, 0, 128));
		btnNewButton.setFont(new Font("Stencil", Font.PLAIN, 19));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Connection myConn = null;
				ResultSet myRs = null;
				Statement myStmt = null;

				
				String dbUrl = "jdbc:mysql://localhost:3306/new_schema?useSSL=false";
				String user = "student";		
				String pass = "student";

				try {
					// 1. Get a connection to database
					myConn = DriverManager.getConnection(dbUrl, user, pass);
					
					// 2. Create a statement
					myStmt = myConn.createStatement();
					
					// 3. Execute SQL query
					myRs = myStmt.executeQuery("select * from user");
					
					// 4. Process the result set
				finally {
					if (myRs != null) {
						
							myRs.close();
						
					}
					
					if (myStmt != null) {
							myStmt.close();
					}
					
					if (myConn != null) {
							myConn.close();
						
					}
				}
				try {
					int rowsAffected = myStmt.executeUpdate("insert into user " +"(username,password) " + "values " + "('khouloud','kikou')");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				// 4. Verify this by getting a list of employees
				try {
					myRs = myStmt.executeQuery("select * from employees order by last_name");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		btnNewButton.setBounds(197, 286, 201, 35);
		frame.getContentPane().add(btnNewButton);
		
		JLabel id = new JLabel("Name:");
		id.setFont(new Font("Stencil", Font.PLAIN, 19));
		id.setBounds(41, 69, 116, 29);
		frame.getContentPane().add(id);
		
		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setFont(new Font("Stencil", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(41, 150, 124, 46);
		frame.getContentPane().add(lblNewLabel_1);
		
		userd = new JTextField();
		userd.setBounds(225, 69, 214, 39);
		frame.getContentPane().add(userd);
		userd.setColumns(10);
		
		passwordd = new JPasswordField();
		passwordd.setBounds(225, 154, 214, 41);
		frame.getContentPane().add(passwordd);
		frame.setBounds(100, 100, 626, 390);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);}
		
	


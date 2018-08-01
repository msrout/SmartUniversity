package com.hmi.smartuni.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class LoginPage extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5972133640367759960L;
	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	private JLabel  lblInvalidCredentials;

	

	public LoginPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = this;
		frame.getContentPane().setBackground(new Color(255, 160, 122));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(245, 245, 245));
		panel.setBounds(10, 11, 416, 239);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblHeading = new JLabel("SMART UNIVERSITY LOGIN");
		lblHeading.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 29));
		lblHeading.setForeground(Color.BLUE);
		lblHeading.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeading.setBounds(6, 25, 393, 39);
		panel.add(lblHeading);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(28, 102, 97, 24);
		panel.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(28, 144, 97, 24);
		panel.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(148, 101, 130, 26);
		panel.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(148, 144, 130, 26);
		panel.add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBackground(new Color(0, 255, 0));
		btnLogin.setForeground(new Color(0, 0, 0));
		btnLogin.setBounds(302, 193, 78, 24);
		panel.add(btnLogin);
		
		lblInvalidCredentials = new JLabel("Invalid credentials");
		lblInvalidCredentials.setForeground(new Color(220, 20, 60));
		lblInvalidCredentials.setBounds(27, 201, 146, 16);
		lblInvalidCredentials.setVisible(false);
		panel.add(lblInvalidCredentials);
		
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				loginButtonActionPerformed(evt);
			}
		});
		
	}
	
	@SuppressWarnings("deprecation")
	private void loginButtonActionPerformed(ActionEvent evt) {                                         
		
		String userName = textField.getText();
		String password = passwordField.getText();
		boolean isValid = validate(userName, password);
		if (isValid) {
			lblInvalidCredentials.setVisible(false);
			frame.setVisible(false);
			HomePage homePage = new HomePage();
			homePage.setVisible(true);
		}
		else {
			lblInvalidCredentials.setVisible(true);
		}

	} 
	
	private boolean validate(String userName, String password) {
		boolean isValid = false;
		if ( (userName.equals("admin")) && (password.equals("1234"))) {
			isValid = true;
			
		}
		return isValid;
	}

}

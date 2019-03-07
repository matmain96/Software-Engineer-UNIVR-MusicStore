package View;

import Model.*;
import Controller.*;
import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
 
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.text.html.HTMLDocument.Iterator;

public class MyFrameLog extends JDialog  {
	

	private static String titolo = "Login";
	private static final JPanel panel = new JPanel();
	private static final int larghezza=400,altezza=200;
	private final JTextField userText = new JTextField(20);
	private final JPasswordField passwordText = new JPasswordField(20);
	public JButton loginButton = new JButton("login");
	public JButton registerButton = new JButton("register");

	public MyFrameLog(){
		this.setTitle(titolo);
		this.setSize(larghezza,altezza);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		Container CP= this.getContentPane();
		passwordText.setText("");
		userText.setText("");
		CP.add(panel);
		panel.setLayout(null);
		this.setAlwaysOnTop(true);


		JLabel userLabel = new JLabel("User");
		userLabel.setBounds(10, 10, 80, 25);
		panel.add(userLabel);

		userText.setBounds(100, 10, 160, 25);
		panel.add(userText);

		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(10, 40, 80, 25);
		panel.add(passwordLabel);

		passwordText.setBounds(100, 40, 160, 25);
		panel.add(passwordText);


		loginButton.setBounds(10, 80, 80, 25);
		panel.add(loginButton);


		registerButton.setBounds(180, 80, 80, 25);
		panel.add(registerButton);

		this.setVisible(true);

		
		loginButton.addActionListener(new LoginAction(this));
		

		registerButton.addActionListener(new LoginAction(this));

	}

	




	public JButton getLoginButton() {
		return loginButton;
	}
	public void setLoginButton(JButton loginButton) {
		this.loginButton = loginButton;
	}
	public JButton getRegisterButton() {
		return registerButton;
	}
	public void setRegisterButton(JButton registerButton) {
		this.registerButton = registerButton;
	}
	public JTextField getUserText() {
		return userText;
	}
	public JTextField getPasswordText() {
		return passwordText;
	}
}
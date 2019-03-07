package View;
import Controller.*;

import java.io.File;

import java.io.File;

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

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import Model.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyFrameRegister extends JFrame{


	private static String titolo = "Register";
	private static final JPanel panel = new JPanel();
	private static final int larghezza=400,altezza=300;
	private JTextField Telefonot = new JTextField(20);
	private JTextField passwordText = new JTextField(20);
	private JTextField Cittat = new JTextField(20);
	private JTextField userText = new JTextField(20);
	private JTextField CFT = new JTextField(20);
	private JTextField NomeT = new JTextField(20);
	private JTextField Cognomet = new JTextField(20);
	public JButton okButton = new JButton("OK");
	public JButton cancelButton = new JButton("ANNULLA");

	public MyFrameRegister(){
		super(titolo);
		this.setSize(larghezza,altezza);
		Container CP= this.getContentPane();

		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		CP.add(panel);
		panel.setLayout(null);

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

		JLabel CF = new JLabel("CF");
		CF.setBounds(10, 70, 80, 25);
		panel.add(CF);

		CFT.setBounds(100, 70, 160, 25);
		panel.add(CFT);

		JLabel Nome = new JLabel("Nome");
		Nome.setBounds(10, 100, 80, 25);
		panel.add(Nome);


		NomeT.setBounds(100, 100, 160, 25);
		panel.add(NomeT);

		JLabel Cognome = new JLabel("Cognome");
		Cognome.setBounds(10, 130, 80, 25);
		panel.add(Cognome);


		Cognomet.setBounds(100, 130, 160, 25);
		panel.add(Cognomet);

		JLabel Citta = new JLabel("Citta");
		Citta.setBounds(10, 160, 80, 25);
		panel.add(Citta);

		Cittat.setBounds(100, 160, 160, 25);
		panel.add(Cittat);

		JLabel Telefono = new JLabel("Telefono");
		Telefono.setBounds(10, 190, 80, 25);
		panel.add(Telefono);


		Telefonot.setBounds(100, 190, 160, 25);
		panel.add(Telefonot);



		okButton.setBounds(10, 230, 80, 25);
		panel.add(okButton);



		cancelButton.setBounds(180, 230, 80, 25);
		panel.add(cancelButton);
		
		okButton.addActionListener(new RegisterAction(this));
		cancelButton.addActionListener(new RegisterAction(this));

		this.setVisible(true);

	}

	public JTextField getTelefonot() {
		return Telefonot;
	}

	public void setTelefonot(JTextField telefonot) {
		Telefonot = telefonot;
	}

	public JTextField getPasswordText() {
		return passwordText;
	}

	public void setPasswordText(JTextField passwordText) {
		this.passwordText = passwordText;
	}

	public JTextField getCittat() {
		return Cittat;
	}

	public void setCittat(JTextField cittat) {
		Cittat = cittat;
	}

	public JTextField getUserText() {
		return userText;
	}

	public void setUserText(JTextField userText) {
		this.userText = userText;
	}

	public JTextField getCFT() {
		return CFT;
	}

	public void setCFT(JTextField cFT) {
		CFT = cFT;
	}

	public JTextField getNomeT() {
		return NomeT;
	}

	public void setNomeT(JTextField nomeT) {
		NomeT = nomeT;
	}

	public JTextField getCognomet() {
		return Cognomet;
	}

	public void setCognomet(JTextField cognomet) {
		Cognomet = cognomet;
	}

	public JButton getOkButton() {
		return okButton;
	}

	public void setOkButton(JButton okButton) {
		this.okButton = okButton;
	}

	public JButton getCancelButton() {
		return cancelButton;
	}

	public void setCancelButton(JButton cancelButton) {
		this.cancelButton = cancelButton;
	}

}



package Controller;
import View.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import Model.*;

public class RegisterAction implements ActionListener {
	
	private MyFrameRegister frame;
	public RegisterAction(MyFrameRegister frame){
		this.frame=frame;
	}
	
	public  void actionPerformed(ActionEvent e)  {

		if(e.getSource() == frame.getOkButton() ){
			//controls on the input
			if(frame.getCFT().getText()!=null &&  frame.getUserText().getText()!=null  && frame.getPasswordText().getText()!=null && frame.getNomeT().getText()!=null && frame.getCognomet().getText()!=null && frame.getCittat().getText()!=null &&  frame.getTelefonot().getText()!=null){
			
				boolean execute = false;
				if(frame.getCFT().getText().length() >= 10 && frame.getCFT().getText().length() <= 18){
					if(frame.getUserText().getText().length() >= 6 ){
						if(frame.getPasswordText().getText().length() >= 6){
							if(frame.getTelefonot().getText().length() == 10){
								if(frame.getCittat().getText().length() == 2){
									/** finiti i controlli sui campi, li scrivo sull'XML **/
									DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
							        DocumentBuilder dBuilder;
							        try{
							        	DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
							            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
							            Document document = documentBuilder.parse("C:\\Users\\Matteo Mainenti\\Desktop\\NegozioCD\\src\\users.xml");
							            Element root = document.getDocumentElement();
							            
							            /** creo l'effettivo utente su file xml */
							            
							            Element newUtente = document.createElement("utente");
							            
							            Element username = document.createElement("username");
							            username.appendChild(document.createTextNode(frame.getUserText().getText()));
							            newUtente.appendChild(username);
							            
							            Element psw = document.createElement("password");
							            psw.appendChild(document.createTextNode(frame.getPasswordText().getText()));
							            newUtente.appendChild(psw);
							            
							            Element CF = document.createElement("CF");
							            CF.appendChild(document.createTextNode(frame.getCFT().getText()));
							            newUtente.appendChild(CF);
							            
							            Element name = document.createElement("name");
							            name.appendChild(document.createTextNode(frame.getNomeT().getText()));
							            newUtente.appendChild(name);
							            
							            Element surname = document.createElement("surname");
							            surname.appendChild(document.createTextNode(frame.getCognomet().getText()));
							            newUtente.appendChild(surname);
							            
							            Element city = document.createElement("city");
							            city.appendChild(document.createTextNode(frame.getCittat().getText()));
							            newUtente.appendChild(city);
							            
							            Element telephone = document.createElement("telephone");
							            telephone.appendChild(document.createTextNode(frame.getTelefonot().getText()));
							            newUtente.appendChild(telephone);
							            
							            root.appendChild(newUtente);
	
							            DOMSource source = new DOMSource(document);
							            TransformerFactory transformerFactory = TransformerFactory.newInstance();
							            Transformer transformer = transformerFactory.newTransformer();
							            StreamResult result = new StreamResult("C:\\Users\\Matteo Mainenti\\Desktop\\NegozioCD\\src\\users.xml");
							            transformer.transform(source, result);
							            
							           
							            
							        }catch(Exception e1){
							        	e1.printStackTrace();
							        }
									Customer nuovo = new Customer(frame.getCFT().getText(), frame.getUserText().getText(),frame.getPasswordText().getText(), frame.getNomeT().getText(), frame.getCognomet().getText(), frame.getCittat().getText(), frame.getTelefonot().getText());
									ArrayCust.setChosen(nuovo);
									ArrayCust.getClienti().add(nuovo);
									System.out.println("Ho registrato: "+frame.getUserText().getText() + " psw: "+frame.getPasswordText().getText());
									frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
									Catalogue.setSwitched(0);
									Main newMain=new Main(nuovo);
									
									
								}else{
									JOptionPane.showMessageDialog(frame, "Insert only the 2 letters of your city!");
								}
							}else{
								JOptionPane.showMessageDialog(frame, "Please insert a valid telephone number: 10 digits");
							}
						}else{
							JOptionPane.showMessageDialog(frame, "Password needs to be at least 6 chars long!");
						}
					}else{
						JOptionPane.showMessageDialog(frame, "Username needs to be at least 6 chars long!");
					}
				}else{
					JOptionPane.showMessageDialog(frame, "CF needs to be between 10 and 18 chars long!");
				}
			}
		}
		if(e.getSource() == frame.getCancelButton()){
			frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
			MyFrameLog goBack = new MyFrameLog();

		}

	}




}




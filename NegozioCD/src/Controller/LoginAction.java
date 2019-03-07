package Controller;
import View.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import Model.*;
public class LoginAction implements ActionListener{
	
	private MyFrameLog frame;
	public LoginAction(MyFrameLog frame){
		this.frame=frame;
	}
	
	public void actionPerformed(ActionEvent e) {
		System.out.println("Controllo file XML");
		if(e.getSource() == frame.getLoginButton()){
			boolean ok=false;
			if(frame.getUserText().getText() != null && frame.getPasswordText().getText() != null){
					
				/******************************************* inizio a iterare l'XML */
				
				
						for(Customer c: ArrayCust.getClienti())
							if(c.getPsw().equals(frame.getPasswordText().getText() ) && c.getUsername().equals(frame.getUserText().getText()))
							{
								ArrayCust.setChosen(c);
								ok=true;
							}
		               
		               
				}
				
				/** fine iterazione file xml */
					if(ok){
						/** chiudo la finestra di reg e ri apro quella di log in */
						frame.setVisible(false);
						Catalogue.setSwitched(0);
						Main newMain= new Main(ArrayCust.getChosen());
						
					}
			
		}
	
		if(e.getSource() == frame.getRegisterButton()){
			frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
			frame.dispose();
			frame.setVisible(false);
			MyFrameRegister x = new MyFrameRegister();
		
		}
		
	}

}

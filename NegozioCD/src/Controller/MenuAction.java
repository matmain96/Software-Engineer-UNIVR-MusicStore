package Controller;
import View.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import Model.*;
public class MenuAction implements ActionListener{
	private Main frame;
	public MenuAction(Main frame){
		this.frame=frame;
		
	}

	public void actionPerformed(ActionEvent e)  {
		
		
		if(e.getSource() == frame.getAccess()){
			frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
			MyFrameLog login =new MyFrameLog();

		}
		if(e.getSource() == frame.getLogout()){
			Catalogue.setSwitched(0);
			ArrayCust.setChosen(null);
			Main toBegin = new Main();
			frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
			frame.dispose();
		}

		if(e.getSource() == frame.getCart()){
			System.out.println("hai aperto il cart");
			CartView cart= new CartView();

		}
		
		if(e.getSource()==frame.getSearch())
		{	
			SearchView view= new SearchView();
		}
		
		if(e.getSource() == frame.getBuy()){
			BuyView pay= new BuyView();
		}
		
	}




}

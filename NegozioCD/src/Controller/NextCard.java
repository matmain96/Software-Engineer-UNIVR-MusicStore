package Controller;
import View.*;
import Model.*;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class NextCard implements ActionListener {
	private final Main frame;
	public NextCard(Main frame){
		this.frame=frame;		
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==frame.getNext())
		{
			CardLayout card = (CardLayout) (frame.getPanelContain().getLayout());
			card.next(frame.getPanelContain());
			if(Catalogue.getSwitched()==Catalogue.getOrder().size()-1) Catalogue.setSwitched(0);
			else Catalogue.setSwitched(Catalogue.getSwitched() + 1);
		}
		if(e.getSource()==frame.getPrevious())
		{
			CardLayout card = (CardLayout) (frame.getPanelContain().getLayout());
			card.previous(frame.getPanelContain());
			if(Catalogue.getSwitched()==0) Catalogue.setSwitched(Catalogue.getOrder().size()-1);
			else Catalogue.setSwitched(Catalogue.getSwitched() - 1);
			frame.getPage().setText("Page: "+Catalogue.getSwitched()+"/"+Catalogue.getOrder().size());
			
		}
		if(e.getSource()==frame.getInfo())
		{
			System.out.println(Catalogue.getSwitched());
			CD k= Catalogue.getOrder().get(Catalogue.getSwitched());		
			JOptionPane.showMessageDialog(frame, "Info CD:\n Name: \t"+ k.getCDname() +"\n Band/Musician: \t" + k.getBand() + "\n Genre:\t" + k.getGenre() +"\n Code:\t " + k.getCode()
			+ "\n\n Tracklist:\n" + k.Tracks() + "\n Release:\t"+ k.getRelease() +"\n \n Price:\t " + k.getPrice()+"$" + "\n\n Pieces: " + Catalogue.getProducts().get(k)  );
			
			
			
		}
		
	}
	
}

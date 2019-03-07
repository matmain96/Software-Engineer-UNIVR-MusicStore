package Controller;

import View.*;
import java.awt.*;
import javax.swing.*;
import Model.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
public class AddRem implements ActionListener{
	private Main frame;
	public AddRem(Main frame){
		this.frame=frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()== frame.getAdd()){
			CD scelto=Catalogue.getOrder().get(Catalogue.getSwitched());
			if(Catalogue.getProducts().get(scelto)>0){ //se ci sono ancora pezzi disponibili
				if(ArrayCust.getChosen().getCart().getProducts().containsKey(scelto))
					ArrayCust.getChosen().getCart().getProducts().put(scelto, ArrayCust.getChosen().getCart().getProducts().get(scelto)+1); //se il CD è presente prendo la variabile legata al CD e l'aumento di 1
				else 
					ArrayCust.getChosen().getCart().getProducts().put(scelto, 1); //se non è presente la inizializzo
			
				Catalogue.getProducts().put(Catalogue.getOrder().get(Catalogue.getSwitched()), Catalogue.getProducts().get(Catalogue.getOrder().get(Catalogue.getSwitched()))-1 );
				ArrayCust.getChosen().getCart().increase(scelto.getPrice()); //modifico il prezzo totale del carrello
				JOptionPane.showMessageDialog(frame, "Hai aggiunto un CD!");
			}else JOptionPane.showMessageDialog(frame, "Sono finiti i CD disponibili!");
		}	//scelgo il cart del cliente e inserisco l'oggetto visualizzato grazie a catalogue.order.get(Catalogue.switched)
		
		if(e.getSource()== frame.getRemove()){
			
			CD scelto=Catalogue.getOrder().get(Catalogue.getSwitched());
			
				if(ArrayCust.getChosen().getCart().getProducts().containsKey(scelto)){
					ArrayCust.getChosen().getCart().getProducts().put(scelto, ArrayCust.getChosen().getCart().getProducts().get(scelto)-1); //se il CD è presente prendo la variabile legata al CD e l'aumento di 1
					Catalogue.getProducts().put(Catalogue.getOrder().get(Catalogue.getSwitched()), Catalogue.getProducts().get(Catalogue.getOrder().get(Catalogue.getSwitched()))+1 );
					ArrayCust.getChosen().getCart().decrease(scelto.getPrice());
					if(ArrayCust.getChosen().getCart().getProducts().get(scelto)==0)
						ArrayCust.getChosen().getCart().getProducts().remove(scelto);
					

					JOptionPane.showMessageDialog(frame, "Hai rimosso un CD!");
				}
				else JOptionPane.showMessageDialog(frame, "Non sono presenti CD di questo tipo nel tuo carrello!");
		}
			
	}
	

}

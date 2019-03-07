package Controller;
import View.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import Model.*;
public class SearchControl implements ActionListener{
	private SearchView frame;
	public SearchControl(SearchView frame){
		this.frame=frame;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		

			
		
			if(e.getSource()==frame.getSearch())
			{		/*
				if(ArrayCust.getChosen()!=null){
					Catalogue.getOrder().clear();
					int i=0;
					if(((String) frame.getCb().getSelectedItem()).equals("Genre")){
						for(CD k: Catalogue.getProducts().keySet()){
							if(k.getGenre().equals((String) frame.getOption().getSelectedItem())){
								Catalogue.getOrder().put(i++, k);
							}
						}
						Main fine = new Main(ArrayCust.getChosen(), (String) frame.getCb().getSelectedItem() , (String) frame.getOption().getSelectedItem());
					}
				
				}
			*/
			
		 ResultView fine = new ResultView( (String) frame.getCb().getSelectedItem() , (String) frame.getOption().getSelectedItem());
		
		}else if(frame.getCb().getSelectedItem().equals("Genre"))
		{
			frame.getOption().setModel(new DefaultComboBoxModel<String>(frame.getGenre()));
			
		}
		
		else if(frame.getCb().getSelectedItem().equals("Artist"))
		{

			frame.getOption().setModel(new DefaultComboBoxModel<String>(frame.getArtist()));
	
		}
		
		else if(frame.getCb().getSelectedItem().equals("Price"))
		{
			
			frame.getOption().setModel(new DefaultComboBoxModel<String>(frame.getPrice()));
		}
		
	}
		
	
}

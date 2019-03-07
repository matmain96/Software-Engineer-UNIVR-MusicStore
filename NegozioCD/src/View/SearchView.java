package View;

import java.awt.BorderLayout;
import java.awt.Container;
import java.util.TreeSet;

import javax.swing.*;
import java.awt.*;

import Controller.*;
import Model.*;

public class SearchView extends JDialog{
	
	private static final JLabel sezione = new JLabel("SearchMode");
	private static  JPanel nord ;

	private static final int larghezza=300,altezza=200;
	private final JPanel PanelContain = new JPanel();
	private final JScrollPane acq= new JScrollPane(PanelContain);
	private final String[] Arguments= new String[]{"Genre", "Artist", "Price" };
	private final JComboBox<String> cb= new JComboBox(Arguments);

	private TreeSet<String> generi= new TreeSet<String>();
	{
		for(CD k: Catalogue.getProducts().keySet())
			generi.add(k.getGenre());
			
	}
	private final String[] Genre= generi.toArray(new String[generi.size()]);
	private TreeSet<String> Artisti= new TreeSet<String>();
	{
		for(CD k: Catalogue.getProducts().keySet())
			Artisti.add(k.getBand());
			
	}
	private final String[] Artist= Artisti.toArray(new String[Artisti.size()]);

	private TreeSet<String> prezzi= new TreeSet<String>();
	{
		for(CD k: Catalogue.getProducts().keySet())
			prezzi.add(String.valueOf(k.getPrice()));
			
	}
	private final String[] Price = prezzi.toArray(new String[prezzi.size()]);

	private JComboBox<String> option = new JComboBox(Genre);
	private final JPanel button= new JPanel();
	private final JButton search = new JButton("Search");
	
	public SearchView(){
		
		this.setTitle("Search");
		this.setModal(true);
		this.setAlwaysOnTop(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(larghezza,altezza);
		nord=new JPanel();
		nord.add(sezione);
		Container CP= this.getContentPane();
		
		CP.add(nord, BorderLayout.NORTH);
		
		PanelContain.add(cb, BorderLayout.CENTER);
		PanelContain.add(option, BorderLayout.CENTER);
		
		button.add(search);
		cb.addActionListener(new SearchControl(this));
		search.addActionListener(new SearchControl(this));
		CP.add(PanelContain, BorderLayout.CENTER);
		CP.add(button, BorderLayout.SOUTH);
		
		this.setVisible(true);
	}

	public JButton getSearch() {
		return search;
	}

	public JComboBox<String> getOption() {
		return option;
	}


	public JComboBox<String> getCb() {
		return cb;
	}
	
	public String[] getGenre() {
		return Genre;
	}

	public String[] getArtist() {
		return Artist;
	}

	public String[] getPrice() {
		return Price;
	}

}



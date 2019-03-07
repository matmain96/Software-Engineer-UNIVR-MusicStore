package View;
import Model.*;
import Controller.*;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.ScrollPane;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class CartView extends JDialog{
	
	private static final JLabel sezione = new JLabel("YOUR CART");
	private static  JPanel nord ;

	private static final int larghezza=400,altezza=300;
	private static JLabel pricefinal=new JLabel();
	private final JPanel PanelContain = new JPanel();
	private final JScrollPane acq= new JScrollPane(PanelContain);
	public CartView(){
		
		this.setTitle("Cart");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(larghezza,altezza);
		nord=new JPanel();
		nord.add(sezione);
		
		Container CP= this.getContentPane();
		CP.add(nord, BorderLayout.NORTH);
		PanelContain.setLayout((new BoxLayout(PanelContain, BoxLayout.Y_AXIS)));
		int price=0;
		for(CD k:  ArrayCust.getChosen().getCart().getProducts().keySet())
		{
			JPanel rnd = new JPanel();
			JLabel rnd2 = new JLabel();
			JLabel qt=new JLabel("Quantità: " + ArrayCust.getChosen().getCart().getProducts().get(k));
			rnd2.setIcon(k.getPic());
			rnd.add(rnd2);
			rnd.add(qt);
			System.out.println(k.getCDname());
			price+=k.getPrice()*ArrayCust.getChosen().getCart().getProducts().get(k);
			PanelContain.add(rnd);
		}
		this.setModal(true);
		this.setAlwaysOnTop(true);
		pricefinal= new JLabel(" TOTAL PRICE: "+ price);
		nord.add(pricefinal);
		CP.add(acq, BorderLayout.CENTER);		
		this.setVisible(true);
	}
}

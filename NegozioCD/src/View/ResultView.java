package View;
import Controller.*;
import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Controller.AddRem;
import Model.CD;
import Model.Catalogue;

public class ResultView extends JDialog{
	
	

	private static final JLabel sezione = new JLabel("Result");
	private static  JPanel nord = new JPanel() ;

	private static final int larghezza=400,altezza=300;
	private static JLabel pricefinal=new JLabel();
	private final JPanel PanelContain = new JPanel();
	private final JScrollPane fine= new JScrollPane(PanelContain);
	
	public ResultView(String arg1, String arg2){
		
	
		this.setTitle("Search result");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(larghezza,altezza);
		this.setModal(true);
		this.setAlwaysOnTop(true);
		nord.add(sezione);

		PanelContain.setLayout((new BoxLayout(PanelContain, BoxLayout.Y_AXIS)));
		Container CP= this.getContentPane();
		CP.add(nord, BorderLayout.NORTH);

		System.out.println(arg1+" "+arg2);
		if(arg1.equals("Genre")){
			for(CD k: Catalogue.getProducts().keySet()){
				if(k.getGenre().equals(arg2)){
					JPanel rnd = new JPanel();
					JLabel rnd2 = new JLabel();
					
					rnd2.setIcon(k.getPic());
					rnd.add(rnd2);
					PanelContain.add(rnd);
				}
			}
			
			}
		if(arg1.equals("Artist")){
			for(CD k: Catalogue.getProducts().keySet()){
				if(k.getBand().equals(arg2)){
					JPanel rnd = new JPanel();
					JLabel rnd2 = new JLabel();
					
					rnd2.setIcon(k.getPic());
					rnd.add(rnd2);
					PanelContain.add(rnd);
				}
			}
			
		}
		if(arg1.equals("Price")){
			for(CD k: Catalogue.getProducts().keySet()){
				if(k.getPrice()==(Integer.parseInt(arg2))){
					JPanel rnd = new JPanel();
					JLabel rnd2 = new JLabel();
					
					rnd2.setIcon(k.getPic());
					rnd.add(rnd2);
					//rnd.addActionListener(new AddRem(this));
					PanelContain.add(rnd);
				}
			}
		}
		
		CP.add(fine, BorderLayout.CENTER);
		this.setVisible(true);
	}
	
	
	
}
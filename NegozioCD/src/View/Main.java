package View;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import Controller.*;
import Model.*;
import View.*;

public class Main extends JFrame {
	private static String titolo = "E-commerce";

	private static final int larghezza=400,altezza=350;
	
	private final JMenuBar bar = new JMenuBar();
	
	private final JMenuItem search = new JMenuItem("Search");
	private final JMenuItem access = new JMenuItem("Access");
	private final JMenuItem cart = new JMenuItem("Cart");
	private final JMenuItem logout=new JMenuItem("Logout");
	private final JMenuItem buy = new JMenuItem("Buy");
	private  JLabel page=new JLabel("Page: 1/"+ Catalogue.getOrder().size());


	private static final JLabel sezione = new JLabel("Catalogue");
	private static final JPanel nord = new JPanel();

	
	private final JPanel PanelContain = new JPanel();
	private final JPanel NextPanel = new JPanel();
	private final JPanel PreviousPanel = new JPanel();
	private final JPanel InfoPanel = new JPanel();
	
	
	private final JPanel West = new JPanel();
	private final JPanel South = new JPanel();
	private final JPanel East = new JPanel();
	
	private final JButton remove = new JButton("Remove");
	private final JButton next = new JButton("NEXT");
	private final JButton previous = new JButton("PREV");
	private final JButton add= new JButton("ADD");
	private final JButton info = new JButton("INFO");
	private final JPanel pagepanel= new JPanel();
	public Main(){
		super(titolo);

		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(400,300);
		this.nord.add(sezione);
		Container CP= this.getContentPane();
		
		
		PanelContain.setLayout((new CardLayout()));
		
		
		West.setLayout(new BorderLayout());
		East.setLayout(new BorderLayout());
		South.setLayout((new FlowLayout(FlowLayout.CENTER)));
		NextPanel.setLayout(new BoxLayout(NextPanel, BoxLayout.X_AXIS));
		next.setAlignmentX(Component.CENTER_ALIGNMENT);
		NextPanel.add(next);
		PreviousPanel.setLayout(new BoxLayout(PreviousPanel, BoxLayout.X_AXIS));
		previous.setAlignmentX(Component.CENTER_ALIGNMENT);
		PreviousPanel.add(previous);
		
		
		South.add(InfoPanel, BorderLayout.CENTER);
		InfoPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		InfoPanel.add(info);
		info.setAlignmentX(Component.CENTER_ALIGNMENT);
		info.addActionListener(new NextCard(this));
		East.add(NextPanel, BorderLayout.WEST);
		West.add(PreviousPanel, BorderLayout.EAST);
		page.setAlignmentX(RIGHT_ALIGNMENT);
	
		
		for(Integer n: Catalogue.getOrder().keySet())
		{
			CD k= Catalogue.getOrder().get(n);
			JPanel rnd = new JPanel();
			JLabel rnd2 = new JLabel();
			rnd2.setIcon(k.getPic());
			rnd.add(rnd2);
			PanelContain.add(rnd);
		}
		
		
		next.addActionListener(new NextCard(this));
		previous.addActionListener(new NextCard(this));
		access.addActionListener(new MenuAction(this));
		search.addActionListener(new MenuAction(this));
		this.setJMenuBar(bar);
		bar.add(access);
		bar.add(search);
		this.setLocationRelativeTo(null);
		CP.add(East, BorderLayout.EAST);
		CP.add(PanelContain, BorderLayout.CENTER);
		CP.add(South, BorderLayout.SOUTH);
		CP.add(nord, BorderLayout.NORTH);
		CP.add(West, BorderLayout.WEST);
		this.setResizable(false);
		this.setVisible(true); 


	}



	public Main(Customer c){
		super(titolo);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(400,300);
		this.nord.add(sezione);
		Container CP= this.getContentPane();
		
		
		
		PanelContain.setLayout((new CardLayout()));
		West.setLayout(new BorderLayout());
		East.setLayout(new BorderLayout());
		South.setLayout((new BorderLayout()));
		InfoPanel.setSize(150,100);
		NextPanel.setLayout(new BoxLayout(NextPanel, BoxLayout.X_AXIS));
		next.setAlignmentX(Component.CENTER_ALIGNMENT);
		NextPanel.add(next);
		PreviousPanel.setLayout(new BoxLayout(PreviousPanel, BoxLayout.X_AXIS));
		previous.setAlignmentX(Component.CENTER_ALIGNMENT);
		PreviousPanel.add(previous);
		
		
		South.add(InfoPanel, BorderLayout.CENTER);
	//	South.add(page);
		InfoPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		InfoPanel.add(info);
		info.setAlignmentX(Component.CENTER_ALIGNMENT);
		InfoPanel.add(remove);
		InfoPanel.add(add);
		info.addActionListener(new NextCard(this));
		East.add(NextPanel, BorderLayout.WEST);
		West.add(PreviousPanel, BorderLayout.EAST);
		
		for(Integer n: Catalogue.getOrder().keySet())
		{
			CD k= Catalogue.getOrder().get(n);
			JPanel rnd = new JPanel();
			JLabel rnd2 = new JLabel();
			
			rnd2.setIcon(k.getPic());
			rnd.add(rnd2);
			PanelContain.add(rnd, k.getCDname());
		}
		
		search.addActionListener(new MenuAction(this));
		next.addActionListener(new NextCard(this));
		previous.addActionListener(new NextCard(this));
		add.addActionListener(new AddRem(this));
		remove.addActionListener(new AddRem(this));
		this.setJMenuBar(bar);
		
		CP.add(East, BorderLayout.EAST);
		CP.add(PanelContain, BorderLayout.CENTER);
		CP.add(South, BorderLayout.SOUTH);
		CP.add(nord, BorderLayout.NORTH);
		CP.add(West, BorderLayout.WEST);

		logout.addActionListener(new MenuAction(this));
		cart.addActionListener(new MenuAction(this));
		buy.addActionListener(new MenuAction(this));
		this.setJMenuBar(bar);
		bar.add(logout);
		bar.add(cart);
		bar.add(buy);
		bar.add(search);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setResizable(false);



	}
	
	
	
	
	/*
	public Main(Customer c, String arg1, String arg2){
		
		
		super(titolo);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(400,300);
		this.nord.add(sezione);
		Container CP= this.getContentPane();
		
		
		
		PanelContain.setLayout((new CardLayout()));
		West.setLayout(new BorderLayout());
		East.setLayout(new BorderLayout());
		South.setLayout((new BorderLayout()));
		InfoPanel.setSize(150,100);
		NextPanel.setLayout(new BoxLayout(NextPanel, BoxLayout.X_AXIS));
		next.setAlignmentX(Component.CENTER_ALIGNMENT);
		NextPanel.add(next);
		PreviousPanel.setLayout(new BoxLayout(PreviousPanel, BoxLayout.X_AXIS));
		previous.setAlignmentX(Component.CENTER_ALIGNMENT);
		PreviousPanel.add(previous);
		
		
		South.add(InfoPanel, BorderLayout.CENTER);
	//	South.add(page);
		InfoPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		InfoPanel.add(info);
		info.setAlignmentX(Component.CENTER_ALIGNMENT);
		InfoPanel.add(remove);
		InfoPanel.add(add);
		info.addActionListener(new NextCard(this));
		East.add(NextPanel, BorderLayout.WEST);
		West.add(PreviousPanel, BorderLayout.EAST);
		
		for(Integer n: Catalogue.getOrder().keySet())
		{
			CD k= Catalogue.getOrder().get(n);
			JPanel rnd = new JPanel();
			JLabel rnd2 = new JLabel();
			
			rnd2.setIcon(k.getPic());
			rnd.add(rnd2);
			PanelContain.add(rnd, k.getCDname());
		}
		
		
		search.addActionListener(new MenuAction(this));
		next.addActionListener(new NextCard(this));
		previous.addActionListener(new NextCard(this));
		add.addActionListener(new AddRem(this));
		remove.addActionListener(new AddRem(this));
		this.setJMenuBar(bar);
		
		CP.add(East, BorderLayout.EAST);
		CP.add(PanelContain, BorderLayout.CENTER);
		CP.add(South, BorderLayout.SOUTH);
		CP.add(nord, BorderLayout.NORTH);
		CP.add(West, BorderLayout.WEST);

		logout.addActionListener(new MenuAction(this));
		cart.addActionListener(new MenuAction(this));
		buy.addActionListener(new MenuAction(this));
		this.setJMenuBar(bar);
		bar.add(logout);
		bar.add(cart);
		bar.add(buy);
		bar.add(search);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setResizable(false);

		
		
		
	}
	
	
*/


	public JMenuItem getSearch() {
		return search;
	}

	public JButton getInfo() {
		return info;
	}
	
	public JButton getRemove() {
			return remove;
		}
	
	
	public JMenuItem getAccess() {
		return access;
	}
	
	public JMenuItem getCart() {
		return cart;
	}
	
	public JMenuItem getLogout() {
		return logout;
	}
	
	public JMenuItem getBuy() {
		return buy;
	}
	
	public JPanel getPanelContain() {
		return PanelContain;
	}
	
	public JPanel getSouth() {
		return South;
	}
	
	public JButton getNext() {
		return next;
	}
	
	public JButton getPrevious() {
		return previous;
	}
	
	public JButton getAdd() {
		return add;
	}
	public JLabel getPage() {
		return page;
	}

}

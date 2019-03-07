package View;

import javax.swing.*;
import java.awt.*;
import Controller.*;
import Model.*;
public class BuyView extends JDialog{
	
	private static final JLabel sezione = new JLabel("Buy!");
	private static  JPanel nord = new 	JPanel() ;

	private static final int larghezza=300,altezza=175;
	private static JLabel pricefinal=new JLabel();
	private final JPanel PanelContain = new JPanel();
	private final JButton confirm=new JButton("Confirm");
	private  JLabel total;
	private final JCheckBox opt1= new JCheckBox("Paga alla consegna");
	private final JCheckBox opt2= new JCheckBox("Paypal");
	private final JPanel button=new JPanel();
	private final JPanel price= new JPanel();
	private final JPanel check= new JPanel();
	public BuyView(){
		
		this.setTitle("Buy!");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(larghezza,altezza);
		nord.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		nord.add(sezione);
		button.add(confirm);
		PanelContain.setLayout(new BorderLayout());
		price.setLayout(new BorderLayout());
		total= new JLabel("Prezzo: " + ArrayCust.getChosen().getCart().getPrice());
		price.add(total);
		check.add(opt1);
		check.add(opt2);
		PanelContain.add(price, BorderLayout.NORTH);
		PanelContain.add(check, BorderLayout.CENTER);
		
		Container CP= this.getContentPane();
		CP.add(nord, BorderLayout.NORTH);
		CP.add(PanelContain, BorderLayout.CENTER);
		CP.add(button, BorderLayout.SOUTH);
		confirm.addActionListener(new PayControl(this));
		
		this.setModal(true);
		this.setAlwaysOnTop(true);
		this.setVisible(true);

	}
	public JButton getConfirm() {
		return confirm;
	}
	public JCheckBox getOpt1() {
		return opt1;
	}
	public JCheckBox getOpt2() {
		return opt2;
	}
}

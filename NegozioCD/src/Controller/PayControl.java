package Controller;
import View.*;
import Model.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class PayControl implements ActionListener{
	private BuyView frame;
	public PayControl(BuyView frame)
	{
		this.frame=frame;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		 
		if(e.getSource()==frame.getConfirm())
		{
			if((ArrayCust.getChosen().getCart().getPrice()!=0)&&((frame.getOpt1().isSelected() && !frame.getOpt2().isSelected()) || (!frame.getOpt1().isSelected()) && frame.getOpt2().isSelected())){
				JOptionPane.showMessageDialog(frame, "HAI COMPLETATO L'ACQUISTO!!");
				ArrayCust.getChosen().getCart().getProducts().clear();
				ArrayCust.getChosen().getCart().decrease(ArrayCust.getChosen().getCart().getPrice());
				frame.setVisible(false);
				
			}
		}
		
	}

}

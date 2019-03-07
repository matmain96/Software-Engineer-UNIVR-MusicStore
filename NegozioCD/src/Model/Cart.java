package Model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Cart{
	private int totprice;
	private HashMap<CD,Integer> products= new HashMap<CD,Integer>();
	public Cart() {
		this.totprice=0;
	}	
	
	public int getPrice(){
		return totprice;
	}
	public void setPrice(int newprice){
		this.totprice= newprice;
	}


	public  HashMap<CD, Integer> getProducts() {
		return products;
	}

	public void increase(int price){
		this.totprice+=price;
	}
	public void decrease(int price){
		this.totprice-=price;
	}
	public String getCartResume(){
		String res="";
		for(CD k: this.getProducts().keySet()){
			res+="\t" + k.getCDname()+"\tx"+this.products.get(k);
		}
		return res;
	}
}

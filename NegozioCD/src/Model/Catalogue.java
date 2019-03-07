package Model;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Catalogue {
	private static HashMap<CD,Integer> products= new HashMap<CD,Integer>();
	private static int switched=0;	
	private static HashMap<Integer,CD> order= new HashMap<Integer,CD>();
	//private static HashMap<Integer,CD> Search = new HashMap<Integer,CD>();
	public static HashMap<CD, Integer> getProducts() {
		return products;
	}
	public static void setProducts(HashMap<CD, Integer> products) {
		Catalogue.products = products;
	}
	public static int getSwitched() {
		return switched;
	}
	public static void setSwitched(int switched) {
		Catalogue.switched = switched;
	}
	public static HashMap<Integer, CD> getOrder() {
		return order;
	}
	public static void setOrder(HashMap<Integer, CD> order) {
		Catalogue.order = order;
	}

}



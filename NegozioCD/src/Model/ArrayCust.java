package Model;
import java.util.ArrayList;

public class ArrayCust {
	private static ArrayList<Customer> clienti = new ArrayList<Customer>();
	private static Customer chosen;
	public static ArrayList<Customer> getClienti() {
		return clienti;
	}
	public static void setClienti(ArrayList<Customer> clienti) {
		ArrayCust.clienti = clienti;
	}
	public static Customer getChosen() {
		return chosen;
	}
	public static void setChosen(Customer chosen) {
		ArrayCust.chosen = chosen;
	}
}

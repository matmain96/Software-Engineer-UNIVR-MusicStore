package Model;

public class Customer {
	private String CF,username,psw,name,surname,city,telephone;
	private Cart cart = new Cart();
	

	public String getUsername() {
		return username;
	}


	public String getPsw() {
		return psw;
	}

	public Cart getCart() {
		return cart;
	}

	public Customer(String CF, String username, String psw, String name, String surname, String city, String telephone) {
		
		this.CF = CF;
		this.username = username;
		this.psw = psw;
		this.name = name;
		this.surname = surname;
		this.city = city;
		this.telephone = telephone;
	}

}

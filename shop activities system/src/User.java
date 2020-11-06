// Superclass for Customer & Admin

public class User {
	private int userId;
	private String username;
	private String surname;
	private int houseNumber;
	private String postcode;
	private String townName;
	
	
	//CONSTRUCTOR
	public User(int userId, String username, String surname, int houseNumber, String postcode, String townName) {
		this.userId = userId;
		this.username = username;
		this.surname = surname;
		this.houseNumber = houseNumber;
		this.postcode = postcode;
		this.townName = townName;
		
	}
	
	// GETTER METHODS
	public int getUserId() {
		return this.userId;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public String getSurname() {
		return this.surname;
	}
	
	public int getHouseNumber() {
		return this.houseNumber;
	}
	
	public String getPostcode() {
		return this.postcode;
	}
	
	public String getTownName() {
		return this.townName;
	}
	
	// SETTER METHODS
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setHouseNumber(int houseNumber) {
		this.houseNumber = houseNumber;
	}
	
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	
	public void setTownName(String townName) {
		this.townName = townName;
	}

}


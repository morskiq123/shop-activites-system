public class Admin extends User implements DefaultMethods {
	private UserType userType;
		
	public Admin(int userId, String username, String surname, int houseNumber, String postcode, String townName, UserType userType) {
		super(userId, username, surname, houseNumber, postcode, townName);
		this.userType = userType;
	}
	
	// GETTERS
	public UserType getUserType() {
		return this.userType;
	}
	
	@Override
	public String toString() {
		return(getUserId() + ","+ getUsername() + "," + 
				getSurname() + "," + getHouseNumber()+ "," +
				getPostcode() + "," + getTownName() +  "," + getUserType());
	}
}

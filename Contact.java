package App_Service;

public class Contact {
	private String id;
	private String firstName;
	private String lastName;
	private String Number;
	private String Address;
	
	public Contact(String id, String firstName, String lastName, String Number, String Address) {
	
		if (firstName == null || lastName == null || firstName.length() > 10 || lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid Name");
		}
		if (Number == null || Number.length() != 10) {
			throw new IllegalArgumentException("Invalid Number");
		}
		if (Address == null || Address.length() > 30) {
			throw new IllegalArgumentException("Invalid Address");
		}
		if (id == null || id.length() > 10) {
			throw new IllegalArgumentException("Invalid ID");
		}
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
		this.Number = Number;
		this.Address = Address;
	}

	// Getter
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getId() {
		return id;
	}
	public String getNumber() {
		return Number;
	}
	public String getAddress() {
		return Address;
	}
		
	// Setter
	public void setId(String newId) {
		if (newId == null || newId.length() > 10) {
			throw new IllegalArgumentException("Invalid contact ID");
		}
		id = newId;
	}
	
	public void setFirstName(String newFirstName) {
		if (newFirstName == null || newFirstName.length() > 10) {
			throw new IllegalArgumentException("Invalid first name");
		}
		firstName = newFirstName;
	}
	
	public void setLastName (String newLastName) {
		if (newLastName == null || newLastName.length() > 10) {
			throw new IllegalArgumentException("Invalid last name");
		}
		lastName = newLastName;
	}
	
	public void setNumber(String newNumber) {
		if (newNumber == null || newNumber.length() != 10) {
			throw new IllegalArgumentException("Invalid phone number");
		}
		Number = newNumber;
	}
	
	public void setAddress(String newAddress) {
		if (newAddress == null || newAddress.length() > 30) {
			throw new IllegalArgumentException("Invalid address");
		}
		Address = newAddress;
	}
	
	
}



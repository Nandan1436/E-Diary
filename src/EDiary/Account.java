package EDiary;

public class Account {
	private String firstName;
	private String lastName;
	private String dateOfBirth;
	private String userName;
	private String password;
	
	public Account(String firstName, String lastName, String dateOfBirth, String userName, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.userName = userName;
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}
	
	
	
}

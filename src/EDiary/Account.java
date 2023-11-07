package EDiary;

public class Account {
	private String firstName;
	private String lastName;
	private String dateOfBirth;
	private String email;
	private String password;
	
	public Account(String firstName, String lastName, String dateOfBirth, String email, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
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

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}
	
	
	
	
}

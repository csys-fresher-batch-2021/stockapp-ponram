package in.ponram.model;

public class User {

	public User(String userName, long mobileNumber, String address, String gender, String email, String password) {
		this.userName = userName;
		this.mobileNumber = mobileNumber;
		this.address = address;
		this.gender = gender;
		this.email = email;
		this.password = password;
	}

	private String userName;
	private long mobileNumber;
	private String gender;
	private String address;
	private String email;
	private String password;

	public String getUserName() {
		return userName;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}
	public String getAddress() {
		return address;
	}
	public String getGender() {
		return gender;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
}

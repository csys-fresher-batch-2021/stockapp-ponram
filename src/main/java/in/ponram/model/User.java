package in.ponram.model;

public class User {

	public User(String userName, long mobileNumber, String address, String gender, String email, String password) {
		this.userName = userName;
		this.mobileNumber = mobileNumber;
		this.address = address;
		this.gender = gender;
		this.email = email;
		this.password = password;
		admin = false;
	}
	
	public User(String userName, long mobileNumber, String address, String gender, Boolean admin, String email, String password) {
		this.userName = userName;
		this.mobileNumber = mobileNumber;
		this.address = address;
		this.gender = gender;
		this.email = email;
		this.password = password;
		this.admin = admin;
	}

	private String userName;
	private long mobileNumber;
	private String gender;
	private String address;
	private String email;
	private String password;
	private boolean admin;

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
	public boolean getAdmin() {
		return admin;
	}
	@Override
	public String toString() {
		return "User [userName=" + userName + ", mobileNumber=" + mobileNumber + ", gender=" + gender + ", address="
				+ address + ", email=" + email + ", password=" + password + ", admin=" + admin + "]";
	}

}

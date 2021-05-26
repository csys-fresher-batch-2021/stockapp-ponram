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
	
	public User(String userName, long mobileNumber, String address, String gender, boolean admin, String email, String password) {
		this.userName = userName;
		this.mobileNumber = mobileNumber;
		this.address = address;
		this.gender = gender;
		this.email = email;
		this.password = password;
		this.admin = admin;
	}

	public User() {
		//Default constructor
	}

	private String userName;
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

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

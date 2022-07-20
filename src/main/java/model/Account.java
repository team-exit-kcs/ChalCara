package model;

public class Account {
	final private String USER_ID;
	final private String PASS;
	
	public Account(String UserID, String PASS) {
		this.USER_ID = UserID;
		this.PASS = PASS;
	}

	public String getUSER_ID() {
		return USER_ID;
	}

	public String getPASS() {
		return PASS;
	}
	
}

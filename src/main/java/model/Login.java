package model;

public class Login {
	final private String USER_ID;
	final private String PASS;
	
	public Login(String UserID, String PASS) {
		this.USER_ID = UserID;
		this.PASS = PASS;
	}

	public String getUserID() {
		return USER_ID;
	}

	public String getPASS() {
		return PASS;
	}
	
}

package model;

public class User {
	final private String USER_ID;
	private boolean loginSts;
	
	public User(String UserID, boolean loginSts) {
		this.USER_ID = UserID;
		this.loginSts=loginSts;
	}
	
	public User(String UserID) {
		this.USER_ID = UserID;
		this.loginSts=false;
	}

	public String getUserID() {
		return USER_ID;
	}

	public boolean isLoginSts() {
		return this.loginSts;
	}

	public void setLoginSts(boolean loginSts) {
		this.loginSts = loginSts;
	}
}

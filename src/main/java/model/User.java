package model;

public class User {
	final private String USER_ID;
	private boolean LOGIN_STS;
	
	public User(String UserID, boolean LoginSts) {
		this.USER_ID = UserID;
		this.setLOGIN_STS(LoginSts);
	}
	
	public User(String UserID) {
		this.USER_ID = UserID;
		this.setLOGIN_STS(false);
	}

	public String getUSER_ID() {
		return USER_ID;
	}

	public boolean isLOGIN_STS() {
		return LOGIN_STS;
	}

	public void setLOGIN_STS(boolean lOGIN_STS) {
		LOGIN_STS = lOGIN_STS;
	}
}

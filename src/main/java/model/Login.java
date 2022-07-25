package model;

public class Login {
	final private String USER_ID;	//ユーザID
	final private String PASS;		//ハッシュ化されたパスワード
	
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

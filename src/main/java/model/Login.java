package model;

import java.io.Serializable;

public class Login implements Serializable{
	final private String userID;	//ユーザID
	final private String PASS;		//ハッシュ化されたパスワード
	
	public Login(String UserID, String PASS) {
		this.userID = UserID;
		this.PASS = PASS;
	}

	public String getUserID() {
		return userID;
	}

	public String getPASS() {
		return PASS;
	}
	
}

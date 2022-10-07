package model.data;

import java.io.Serializable;
import java.security.NoSuchAlgorithmException;

import model.Hash;

public class Login implements Serializable{
	final private String userID;	//ユーザID
	final private String PASS;		//ハッシュ化されたパスワード
	
	public Login(String userID, String PASS) throws NoSuchAlgorithmException {
		Hash hash = new Hash();
		this.userID = userID;
		this.PASS = hash.createHash(PASS);
	}

	public String getUserID() {
		return userID;
	}

	public String getPASS() {
		return PASS;
	}
	
}

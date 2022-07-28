package model;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Login {
	final private String userID;	//ユーザID
	final private String PASS;		//ハッシュ化されたパスワード
	
	public Login(String UserID, String PASS) throws NoSuchAlgorithmException {
		this.userID = UserID;
		
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		byte[] hashPASS = md.digest(PASS.getBytes());
		this.PASS = String.format("%040x", new BigInteger(1, hashPASS));
	}

	public String getUserID() {
		return userID;
	}

	public String getPASS() {
		return PASS;
	}
	
}

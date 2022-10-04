package model;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {
	public String createHash(String str) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(str.getBytes(StandardCharsets.UTF_8));
		byte[] hash = md.digest();
		return String.format("%040x", new BigInteger(1,hash));
	}
}

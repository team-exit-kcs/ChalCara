package model;

import java.io.Serializable;

public class Account implements Serializable{
	final private String userID;	//ユーザID
	final private String profile;	//ユーザプロフィール文
	final private String icon;		//ユーザアイコンパス
	
	public Account(String userID,String profile,String icon) {
		this.userID=userID;
		this.profile=profile;
		this.icon=icon;
	}
	
	public String getUserID() {
		return userID;
	}
	public String getProfile() {
		return profile;
	}
	public String getIcon() {
		return icon;
	}
}

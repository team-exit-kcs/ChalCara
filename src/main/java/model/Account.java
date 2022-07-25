package model;

public class Account {
	final private String USER_ID;	//ユーザID
	final private String PROFILE;	//ユーザプロフィール文
	final private String ICON;		//ユーザアイコンパス
	
	public Account(String userID,String profile,String icon) {
		this.USER_ID=userID;
		this.PROFILE=profile;
		this.ICON=icon;
	}
	
	public String getUserID() {
		return USER_ID;
	}
	public String getProfile() {
		return PROFILE;
	}
	public String getIcon() {
		return ICON;
	}
}

package model;

public class Account {
	final private String USER_ID;
	final private String PROFILE;
	final private String ICON;
	
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

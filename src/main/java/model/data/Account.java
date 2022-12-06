package model.data;

import java.io.Serializable;

public class Account implements Serializable{
	final private String userID;			//ユーザID
	final private String profile;			//ユーザプロフィール文
	final private String icon;				//ユーザアイコンパス
	final private boolean UseInfoDefault;	//デフォルト情報提供可否
	
	
	public Account(String userID, String profile, String icon, boolean useInfoDefault) {
		super();
		this.userID = userID;
		this.profile = profile;
		this.icon = icon;
		UseInfoDefault = useInfoDefault;
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
	public boolean isUseInfoDefault() {
		return UseInfoDefault;
	}
}

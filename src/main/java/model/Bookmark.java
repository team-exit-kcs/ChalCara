package model;

import java.util.List;

public class Bookmark {
	final private String userID;				//ブックマークをしたユーザのユーザーID
	final private List<String> examIDList;		//ブックマークされた試験IDのリスト
	
	public Bookmark(String userID,List<String> examIDList) {
		this.userID = userID;
		this.examIDList = examIDList;
	}
	
	public String getUserID() {
		return userID;
	}

	public List<String> getExamIDList() {
		return examIDList;
	}
	
}

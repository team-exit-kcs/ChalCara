package model;

import java.io.Serializable;
import java.util.List;

public class Bookmark implements Serializable{
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

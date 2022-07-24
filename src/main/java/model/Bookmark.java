package model;

import java.util.List;

public class Bookmark {
	final private String USER_ID;
	final private List<String> EXAM_ID_LIST;
	
	public Bookmark(String userID,List<String> examIDList) {
		this.USER_ID = userID;
		this.EXAM_ID_LIST = examIDList;
	}
	
	public String getUserID() {
		return USER_ID;
	}

	public List<String> getExamIDList() {
		return EXAM_ID_LIST;
	}
	
}

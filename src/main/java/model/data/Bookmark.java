package model.data;

import java.io.Serializable;
import java.util.List;

public class Bookmark implements Serializable{
	final private String userID;				//ブックマークをしたユーザのユーザーID
	final private List<Exam> examList;		//ブックマークされた試験のリスト
	
	public Bookmark(String userID,List<Exam> examList) {
		this.userID = userID;
		this.examList = examList;
	}
	
	public String getUserID() {
		return userID;
	}

	public List<Exam> getExamList() {
		return examList;
	}
	
}

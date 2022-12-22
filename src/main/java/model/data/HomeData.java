package model.data;

import java.io.Serializable;
import java.util.List;

public class HomeData implements Serializable{
	final private List<Exam> newExamList;
	final private List<Exam> monthlytopExamList;
	final private List<Exam> bookmarkExamList;
	
	public HomeData(List<Exam> newExamList, List<Exam> monthlytopExamList, List<Exam> bookmarkExamList) {
		super();
		this.newExamList = newExamList;
		this.monthlytopExamList = monthlytopExamList;
		this.bookmarkExamList = bookmarkExamList;
	}

	public List<Exam> getNewExamList() {
		return newExamList;
	}

	public List<Exam> getMonthlytopExamList() {
		return monthlytopExamList;
	}

	public List<Exam> getBookmarkExamList() {
		return bookmarkExamList;
	}

}

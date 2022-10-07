package model.data;

import java.io.Serializable;
import java.util.List;

public class Mypage implements Serializable {
	/*要素
	 * 作成試験名リスト
	 * ブックマーク試験名リスト
	 * レポートリスト
	 */
	final private List<Exam> examList;
	final private List<Exam> bookmarkList;
	final private List<Report> reportList;
	
	public Mypage(List<Exam> examList, List<Exam> bookmarkList, List<Report> reportList) {
		this.examList = examList;
		this.bookmarkList = bookmarkList;
		this.reportList = reportList;
	}

	public List<Exam> getExamList() {
		return examList;
	}

	public List<Exam> getBookmarkList() {
		return bookmarkList;
	}

	public List<Report> getReportList() {
		return reportList;
	}
	
}

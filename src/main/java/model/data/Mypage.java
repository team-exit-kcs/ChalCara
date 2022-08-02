package model.data;

import java.io.Serializable;
import java.util.List;

public class Mypage implements Serializable {
	/*要素
	 * 作成試験名リスト
	 * ブックマーク試験名リスト
	 * レポートリスト
	 */
	final private List<String> examList;
	final private List<String> bookmarkList;
	final private List<Report> reportList;
	
	public Mypage(List<String> examList, List<String> bookmarkList, List<Report> reportList) {
		this.examList = examList;
		this.bookmarkList = bookmarkList;
		this.reportList = reportList;
	}

	public List<String> getExamList() {
		return examList;
	}

	public List<String> getBookmarkList() {
		return bookmarkList;
	}

	public List<Report> getReportList() {
		return reportList;
	}
	
}

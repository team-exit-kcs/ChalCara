package model.data;

import java.io.Serializable;
import java.util.List;

public class ExamListPage implements Serializable {

	/*要素
	 * 1ページの表示数
	 * 現在のページ
	 * 最大ページ数
	 * リスト
	 */
	final private int STEP = 20; //１ページの表示数
	
	final private String userID;
	final private int page;
	final private int maxPage;
	final private List<Exam> examList;
	
	

	public ExamListPage(String userID, int page, List<Exam> examList) {
		super();
		this.userID = userID;
		this.page = page;
		this.maxPage = (int) Math.ceil(examList.size() / (double)this.STEP);
		this.examList = examList;
	}

	public int getSTEP() {
		return STEP;
	}

	public int getPage() {
		return page;
	}

	public int getMaxPage() {
		return maxPage;
	}

	public List<Exam> getExamList() {
		return examList;
	}

	public String getUserID() {
		return userID;
	}
}

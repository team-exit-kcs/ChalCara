package model.data;

import java.io.Serializable;
import java.util.List;

public class ExaminationPage implements Serializable {
	/*要素
	 * 登録試験
	 * 試験問題形式　大問０(初期値)　小問１
	 * 登録試験
	 */
	final private Exam exam;
	final private int questionFormat;
	final private List<BigQuestion> bigQuestionList;
	final private boolean bookmark;
	
	public ExaminationPage(Exam exam, int questionFormat, List<BigQuestion> bigQuestionList, boolean bookmark) {
		super();
		this.exam = exam;
		this.questionFormat = questionFormat;
		this.bigQuestionList = bigQuestionList;
		this.bookmark = bookmark;
	}

	public Exam getExam() {
		return exam;
	}

	public int getQuestionFormat() {
		return questionFormat;
	}

	public List<BigQuestion> getBigQuestionList() {
		return bigQuestionList;
	}

	public boolean isBookmark() {
		return bookmark;
	}
	
	
	
}

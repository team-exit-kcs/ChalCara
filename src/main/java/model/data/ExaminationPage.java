package model.data;

import java.io.Serializable;
import java.util.List;

public class ExaminationPage implements Serializable {
	/*要素
	 * 登録試験
	 * 登録試験
	 * ブックマーク
	 * やり直し問題か　true やり直しではない false　やり直し
	 */
	final private Exam exam;
	final private List<BigQuestion> bigQuestionList;
	final private boolean bookmark;
	final private boolean notRedoExam;
	
	public ExaminationPage(Exam exam, List<BigQuestion> bigQuestionList, boolean bookmark,
			boolean notRedoExam) {
		super();
		this.exam = exam;
		this.bigQuestionList = bigQuestionList;
		this.bookmark = bookmark;
		this.notRedoExam = notRedoExam;
	}

	public Exam getExam() {
		return exam;
	}

	public List<BigQuestion> getBigQuestionList() {
		return bigQuestionList;
	}

	public boolean isBookmark() {
		return bookmark;
	}

	public boolean isNotRedoExam() {
		return notRedoExam;
	}
	
}

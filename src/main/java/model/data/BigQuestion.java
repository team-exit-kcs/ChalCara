package model.data;

import java.io.Serializable;
import java.util.List;

public class BigQuestion implements Serializable {
	/*要素
	 * 試験ID
	 * 大問ID
	 * 大問問題文
	 * 小問リスト
	 */
	final private String examID;
	final private int bigQuestionID;
	final private String bigQuestionSentence;
	final private List<Question> questionList;
	
	public BigQuestion(String examID, int bigQuestionID, String bigQuestionSentence, List<Question> questionList) {
		this.examID = examID;
		this.bigQuestionID = bigQuestionID;
		this.bigQuestionSentence = bigQuestionSentence;
		this.questionList = questionList;
	}

	public String getExamID() {
		return examID;
	}

	public int getBigQuestionID() {
		return bigQuestionID;
	}

	public String getBigQuestionSentence() {
		return bigQuestionSentence;
	}

	public List<Question> getQuestionList() {
		return questionList;
	}
	
}

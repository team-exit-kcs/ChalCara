package model.data;

import java.io.Serializable;
import java.util.List;

public class BigQuestionSts implements Serializable{
	/*要素
	 * 試験ID
	 * 大問ID
	 * 正誤判定リスト
	 */
	final private String examID;
	final private int bigQuestionID;
	final private String bigQuestionSentence;
	final private List<QuestionSts> questionStsList;
	
	public BigQuestionSts(String examID, int bigQuestionID, String bigQuestionSentence,
			List<QuestionSts> questionStsList) {
		super();
		this.examID = examID;
		this.bigQuestionID = bigQuestionID;
		this.bigQuestionSentence = bigQuestionSentence;
		this.questionStsList = questionStsList;
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

	public List<QuestionSts> getQuestionStsList() {
		return questionStsList;
	}
	
}

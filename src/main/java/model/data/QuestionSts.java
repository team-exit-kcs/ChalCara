package model.data;

import java.io.Serializable;
import java.util.List;

public class QuestionSts implements Serializable {
	/*要素
	 * 小問ID
	 * 問題文
	 * 答え
	 * 解説
	 * 配点
	 * 選択肢リスト
	 */
	final private String examID;
	final private int bigQuestionID;
	final private int questionID;
	final private String questionSentence;
	final private int answer;
	final private String questionExplanation;
	final private double allocationOfPoint;
	final private List<ChoicesSts> choicesList;
	
	public QuestionSts(String examID, int bigQuestionID, int questionID, String questionSentence, int answer,
			String questionExplanation, double allocationOfPoint, List<ChoicesSts> choicesList) {
		super();
		this.examID = examID;
		this.bigQuestionID = bigQuestionID;
		this.questionID = questionID;
		this.questionSentence = questionSentence;
		this.answer = answer;
		this.questionExplanation = questionExplanation;
		this.allocationOfPoint = allocationOfPoint;
		this.choicesList = choicesList;
	}

	public String getExamID() {
		return examID;
	}
	public int getBigQuestionID() {
		return bigQuestionID;
	}
	public int getQuestionID() {
		return questionID;
	}
	public String getQuestionSentence() {
		return questionSentence;
	}
	public int getAnswer() {
		return answer;
	}
	public String getQuestionExplanation() {
		return questionExplanation;
	}
	public double getAllocationOfPoint() {
		return allocationOfPoint;
	}
	public List<ChoicesSts> getChoicesList() {
		return choicesList;
	}
}

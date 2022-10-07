package model.data;

import java.io.Serializable;
import java.util.List;

public class CheckAns implements Serializable {
	/*要素
	 * 大問ID
	 * 小問ID
	 * 問題文
	 * 答え
	 * ユーザの答え 0は未選択
	 * T/F
	 * 解説
	 * 配点
	 * 選択肢リスト
	 */
	final private int bigQuestionID;
	final private int questionID;
	final private String questionSentence;
	final private int answer;
	final private int userAnswer;
	final private boolean tf;
	final private String questionExplanation;
	final private double allocationOfPoint;
	final private List<Choices> choicesList;

	public CheckAns(int bigQuestionID, int questionID, String questionSentence, int answer, int userAnswer, boolean tf,
			String questionExplanation, double allocationOfPoint, List<Choices> choicesList) {
		this.bigQuestionID = bigQuestionID;
		this.questionID = questionID;
		this.questionSentence = questionSentence;
		this.answer = answer;
		this.userAnswer = userAnswer;
		this.tf = tf;
		this.questionExplanation = questionExplanation;
		this.allocationOfPoint = allocationOfPoint;
		this.choicesList = choicesList;
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

	public int getUserAnswer() {
		return userAnswer;
	}

	public boolean isTf() {
		return tf;
	}

	public String getQuestionExplanation() {
		return questionExplanation;
	}

	public List<Choices> getChoicesList() {
		return choicesList;
	}

	public double getAllocationOfPoint() {
		return allocationOfPoint;
	}
	
}

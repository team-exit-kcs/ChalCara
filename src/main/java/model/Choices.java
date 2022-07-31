package model;

import java.io.Serializable;

public class Choices implements Serializable{
	/*要素
	 * 試験ID
	 * 大問ID
	 * 小問ID
	 * 選択肢ID
	 * 選択肢
	 */
	final private String examID;
	final private int bigQuestionID;
	final private int questionID;
	final private int choicesID;
	final private String choices;
	
	public Choices(String examID, int bigQuestionID, int questionID, int choicesID, String choices) {
		this.examID = examID;
		this.bigQuestionID = bigQuestionID;
		this.questionID = questionID;
		this.choicesID = choicesID;
		this.choices = choices;
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
	public int getChoicesID() {
		return choicesID;
	}
	public String getChoices() {
		return choices;
	}

}

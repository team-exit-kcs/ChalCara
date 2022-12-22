package model.data;

import java.io.Serializable;

public class UserAns implements Serializable{
	/*要素
	 * ユーザID
	 * レポートID
	 * 大問ID
	 * 小問ID
	 * 回答
	 * 正誤
	 */
	final private String userID;
	final private int reportID;
	final private int bigQuestionID;
	final private int questionID;
	final private int userAns;
	final private boolean tf;

	public UserAns(String userID, int reportID, int bigQuestionID, int questionID, int userAns, boolean tf) {
		super();
		this.userID = userID;
		this.reportID = reportID;
		this.bigQuestionID = bigQuestionID;
		this.questionID = questionID;
		this.userAns = userAns;
		this.tf = tf;
	}

	public String getUserID() {
		return userID;
	}

	public int getReportID() {
		return reportID;
	}

	public int getBigQuestionID() {
		return bigQuestionID;
	}

	public int getQuestionID() {
		return questionID;
	}

	public int getUserAns() {
		return userAns;
	}

	public boolean isTf() {
		return tf;
	}
}

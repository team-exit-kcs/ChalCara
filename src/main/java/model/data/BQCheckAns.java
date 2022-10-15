package model.data;

import java.io.Serializable;
import java.util.List;

public class BQCheckAns implements Serializable {
	/*要素
	 * 大問ID
	 * 正誤判定リスト
	 */
	final private int bigQuestionID;
	final private String bigQuestionSentence;
	final private List<CheckAns> checkAnsList;

	public BQCheckAns(int bigQuestionID, String bigQuestionSentence, List<CheckAns> checkAnsList) {
		this.bigQuestionID = bigQuestionID;
		this.bigQuestionSentence = bigQuestionSentence;
		this.checkAnsList = checkAnsList;
	}

	public int getBigQuestionID() {
		return bigQuestionID;
	}

	public List<CheckAns> getCheckAnsList() {
		return checkAnsList;
	}

	public String getBigQuestionSentence() {
		return bigQuestionSentence;
	}
}

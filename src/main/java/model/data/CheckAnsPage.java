package model.data;

import java.io.Serializable;
import java.util.List;

public class CheckAnsPage implements Serializable {
	/*要素
	 * 試験ID
	 * 点数
	 * 正誤判定リスト
	 */
	final private String examID;
	final private double score;
	final private List<CheckAns> checkAnsList;
	
	public CheckAnsPage(String examID, double score, List<CheckAns> checkAnsList) {
		this.examID = examID;
		this.score = score;
		this.checkAnsList = checkAnsList;
	}

	public String getExamID() {
		return examID;
	}

	public List<CheckAns> getCheckAnsList() {
		return checkAnsList;
	}

	public double getScore() {
		return score;
	}
	
}

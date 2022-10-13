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
	final private int score;
	final private List<BQCheckAns> BQCheckAnsList;
	
	public CheckAnsPage(String examID, int score, List<BQCheckAns> BQCheckAnsList) {
		this.examID = examID;
		this.score = score;
		this.BQCheckAnsList = BQCheckAnsList;
	}

	public String getExamID() {
		return examID;
	}

	public List<BQCheckAns> getBQCheckAnsList() {
		return BQCheckAnsList;
	}

	public int getScore() {
		return score;
	}
	
}

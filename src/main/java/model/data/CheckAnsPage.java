package model.data;

import java.io.Serializable;
import java.util.List;

public class CheckAnsPage implements Serializable {
	/*要素
	 * 試験ID
	 * 点数
	 * 正誤判定リスト
	 * 誤答数
	 * 試験後かどうか？　試験後true/履歴からfalse
	 */
	final private String examID;
	final private int score;
	final private List<BQCheckAns> BQCheckAnsList;
	final private int miss;

	public CheckAnsPage(String examID, int score, List<BQCheckAns> bQCheckAnsList, int miss) {
		super();
		this.examID = examID;
		this.score = score;
		BQCheckAnsList = bQCheckAnsList;
		this.miss = miss;
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

	public int getMiss() {
		return miss;
	}
	
}

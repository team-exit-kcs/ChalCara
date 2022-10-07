package model.data;

import java.io.Serializable;
import java.util.List;

public class UserPage implements Serializable {
	/*要素
	 * ユーザアカウント
	 * 作成試験名リスト
	 */
	final private Account user;
	final private List<Exam> examList;
	
	public UserPage(Account user, List<Exam> examList) {
		this.user = user;
		this.examList = examList;
	}

	public Account getUser() {
		return user;
	}

	public List<Exam> getExamList() {
		return examList;
	}
}

package model;

import java.util.Date;
import java.util.List;

public class Exam {
	/*要素
	 * 試験ID
	 * 製作者ユーザID
	 * ジャンル
	 * 試験名
	 * 制作日
	 * 更新日
	 * 合格点
	 * 試験時間
	 * 試験概要
	 * 公開範囲
	 * タグリスト
	 * 実行回数
	 * ブックマーク数
	 */
	final private String EXAM_ID;
	final private String USER_ID;
	final private String GENRE_NAME;
	final private String EXAM_NAME;
	final private Date CREATE_DATE;
	final private Date UPDATE_DATE;
	final private int PASSING_SCORE;
	final private int EXAM_TIME;
	final private String EXAM_EXPLANATION;
	final private int DISCLOSURE_RANGE;
	final private List<String> TAG;
	final private int EXE_COUNT;
	final private int BOOKMARK_COUNT;
	
	public Exam(String examID, String userID, String genreName, String examName, Date createDate, Date updateDate,
			int passingScore, int examTime, String examExplanation, int disclosureRange,
			List<String> tag, int exeCount, int bookmarkCount) {
		EXAM_ID = examID;
		USER_ID = userID;
		GENRE_NAME = genreName;
		EXAM_NAME = examName;
		CREATE_DATE = createDate;
		UPDATE_DATE = updateDate;
		PASSING_SCORE = passingScore;
		EXAM_TIME = examTime;
		EXAM_EXPLANATION = examExplanation;
		DISCLOSURE_RANGE = disclosureRange;
		TAG = tag;
		EXE_COUNT = exeCount;
		BOOKMARK_COUNT = bookmarkCount;
	}

	public String getExamID() {
		return EXAM_ID;
	}

	public String getUserID() {
		return USER_ID;
	}

	public String getGenreName() {
		return GENRE_NAME;
	}

	public String getExamName() {
		return EXAM_NAME;
	}

	public Date getCreateDate() {
		return CREATE_DATE;
	}

	public Date getUpdateDate() {
		return UPDATE_DATE;
	}

	public int getPassingScore() {
		return PASSING_SCORE;
	}

	public int getExamTime() {
		return EXAM_TIME;
	}

	public String getExamExplanation() {
		return EXAM_EXPLANATION;
	}

	public int getDisclosureRange() {
		return DISCLOSURE_RANGE;
	}

	public List<String> getTag() {
		return TAG;
	}

	public int getExeCount() {
		return EXE_COUNT;
	}

	public int getBookmarkCount() {
		return BOOKMARK_COUNT;
	}

}

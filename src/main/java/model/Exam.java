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
	final private String examID;
	final private String userID;
	final private String examName;
	final private Date createDate;
	final private Date updateDate;
	final private int passingScore;
	final private int examTime;
	final private String examExplanation;
	final private int disclosureRange;
	final private String genreName;
	final private List<String> tagList;
	final private int exeCount;
	final private int bookmarkCount;
	
	public Exam(String examID, String userID, String examName, Date createDate, Date updateDate, int passingScore,
			int examTime, String examExplanation, int disclosureRange, String genreName, List<String> tagList,
			int exeCount, int bookmarkCount) {
		
		this.examID = examID;
		this.userID = userID;
		this.examName = examName;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.passingScore = passingScore;
		this.examTime = examTime;
		this.examExplanation = examExplanation;
		this.disclosureRange = disclosureRange;
		this.genreName = genreName;
		this.tagList = tagList;
		this.exeCount = exeCount;
		this.bookmarkCount = bookmarkCount;
	}

	public String getExamID() {
		return examID;
	}

	public String getUserID() {
		return userID;
	}

	public String getExamName() {
		return examName;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public int getPassingScore() {
		return passingScore;
	}

	public int getExamTime() {
		return examTime;
	}

	public String getExamExplanation() {
		return examExplanation;
	}

	public int getDisclosureRange() {
		return disclosureRange;
	}

	public String getGenreName() {
		return genreName;
	}

	public List<String> getTagList() {
		return tagList;
	}

	public int getExeCount() {
		return exeCount;
	}

	public int getBookmarkCount() {
		return bookmarkCount;
	}
	

}

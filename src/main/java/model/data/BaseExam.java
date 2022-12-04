package model.data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class BaseExam implements Serializable{
	/*要素
	 * 試験ID
	 * 製作者ユーザID
	 * ジャンルID
	 * 試験名
	 * 制作日
	 * 更新日
	 * 合格点
	 * 試験時間
	 * 試験概要
	 * 公開範囲
	 * タグリスト
	 * ゲーム使用可否
	 * 情報収集可否
	 * 試験問題形式　大問０(初期値)　小問１
	 */
	final private String examID;
	final private String userID;
	final private int genreID;
	final private String examName;
	final private Date createDate;
	final private Date updateDate;
	final private int passingScore;
	final private int examTime;
	final private String examExplanation;
	final private int disclosureRange;
	final private List<String> tagList;
	final private boolean useGame;
	final private boolean getInfo;
	final private int questionFormat;
	
	public BaseExam(String examID, String userID, int genreID, String examName, Date createDate, Date updateDate,
			int passingScore, int examTime, String examExplanation, int disclosureRange, List<String> tagList, boolean useGame, boolean getInfo, int questionFormat) {
		this.examID = examID;
		this.userID = userID;
		this.genreID = genreID;
		this.examName = examName;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.passingScore = passingScore;
		this.examTime = examTime;
		this.examExplanation = examExplanation;
		this.disclosureRange = disclosureRange;
		this.tagList = tagList;
		this.useGame = useGame;
		this.getInfo = getInfo;
		this.questionFormat = questionFormat;
	}

	public String getExamID() {
		return examID;
	}

	public String getUserID() {
		return userID;
	}

	public int getGenreID() {
		return genreID;
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

	public List<String> getTagList() {
		return tagList;
	}

	public int getQuestionFormat() {
		return questionFormat;
	}

	public boolean isGetInfo() {
		return getInfo;
	}

	public boolean isUseGame() {
		return useGame;
	}

}

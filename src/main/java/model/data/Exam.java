package model.data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Exam extends BaseExam implements Serializable{
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
	 * ジャンル名
	 * 実行回数
	 * ブックマーク数
	 */
	final private String genreName;
	final private int exeCount;
	final private int bookmarkCount;
	
	public Exam(String examID, String userID, int genreID, String examName, Date createDate, Date updateDate,
			int passingScore, int examTime, String examExplanation, int disclosureRange, List<String> tagList,
			boolean useGame, int questionFormat, String genreName, int exeCount, int bookmarkCount) {
		super(examID, userID, genreID, examName, createDate, updateDate, passingScore, examTime, examExplanation,
				disclosureRange, tagList, useGame, questionFormat);
		this.genreName = genreName;
		this.exeCount = exeCount;
		this.bookmarkCount = bookmarkCount;
	}

	public String getGenreName() {
		return genreName;
	}

	public int getExeCount() {
		return exeCount;
	}

	public int getBookmarkCount() {
		return bookmarkCount;
	}
	
}

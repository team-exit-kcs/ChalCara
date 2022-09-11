package model.data;

import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;

import model.DisclosureRange;
import model.Hash;

public class EntryExam extends BaseExam implements DisclosureRange, Serializable {
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
	 * 限定公開PASS　限定公開以外はNULL
	 */
	final private String limitedPassword;

	public EntryExam(String examID, String userID, int genreID, String examName, Date createDate, Date updateDate,
			int passingScore, int examTime, String examExplanation, int disclosureRange, List<String> tagList,
			String limitedPassword) throws NoSuchAlgorithmException {
		super(examID, userID, genreID, examName, createDate, updateDate, passingScore, examTime, examExplanation,
				disclosureRange, tagList);
		if(disclosureRange == LIMITED) {
			Hash hash = new Hash();
			this.limitedPassword = hash.createHash(limitedPassword);
		}else {
			this.limitedPassword = null;
		}
	}

	public EntryExam(String examID, String userID, int genreID, String examName, Date createDate, Date updateDate,
			int passingScore, int examTime, String examExplanation, int disclosureRange, List<String> tagList) {
		super(examID, userID, genreID, examName, createDate, updateDate, passingScore, examTime, examExplanation,
				disclosureRange, tagList);
		this.limitedPassword = null;
	}

	public String getLimitedPassword() {
		return limitedPassword;
	}

}

package model.data;

import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;

import dao.ExamDAO;
import model.DisclosureRangeLogic;
import model.Hash;

public class EntryExam extends BaseExam implements Serializable {
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
	 * 試験問題形式　大問０(初期値)　小問１
	 * 限定公開PASS　限定公開以外はNULL
	 */
	final private String limitedPassword;

	public EntryExam(String userID, int genreID, String examName, Date createDate, Date updateDate,
			int passingScore, int examTime, String examExplanation, int disclosureRange, List<String> tagList,
			boolean useGame, int questionFormat, String limitedPassword) throws NoSuchAlgorithmException {
		
		super(createExamID(userID, examName), userID, genreID, examName, createDate, updateDate, passingScore, examTime, examExplanation,
				disclosureRange, tagList, useGame, questionFormat);
		
		Hash hash = new Hash();
		DisclosureRangeLogic DR = new DisclosureRangeLogic();
		if(DR.isLimited(disclosureRange)) {
			this.limitedPassword = hash.createHash(limitedPassword);
		}else {
			this.limitedPassword = null;
		}
	}
	
	public EntryExam(String examID, String userID, int genreID, String examName, Date createDate, Date updateDate,
			int passingScore, int examTime, String examExplanation, int disclosureRange, List<String> tagList,
			boolean useGame, int questionFormat, String limitedPassword) throws NoSuchAlgorithmException {
		super(examID, userID, genreID, examName, createDate, updateDate, passingScore, examTime, examExplanation,
				disclosureRange, tagList, useGame, questionFormat);
		
		Hash hash = new Hash();
		DisclosureRangeLogic DR = new DisclosureRangeLogic();
		if(DR.isLimited(disclosureRange)) {
			this.limitedPassword = hash.createHash(limitedPassword);
		}else {
			this.limitedPassword = null;
		}
	}

	public EntryExam(String userID, int genreID, String examName, Date createDate, Date updateDate,
			int passingScore, int examTime, String examExplanation, int disclosureRange, List<String> tagList,
			boolean useGame, int questionFormat) throws NoSuchAlgorithmException {
		super(createExamID(userID, examName), userID, genreID, examName, createDate, updateDate, passingScore, examTime, examExplanation,
				disclosureRange, tagList, useGame, questionFormat);
		this.limitedPassword = null;
	}
	
	private static String createExamID(String userID, String examName) throws NoSuchAlgorithmException {
		ExamDAO examDAO = new ExamDAO();
		Hash hash = new Hash();
		
		int i=0;
		String examID = hash.createHash(userID+examName);
		while(examDAO.isID(examID)) {
			examID = hash.createHash(userID+examName+i);
			i++;
		}
		return examID;
	}

	public String getLimitedPassword() {
		return limitedPassword;
	}

}

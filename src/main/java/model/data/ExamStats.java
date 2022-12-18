package model.data;

import java.io.Serializable;
import java.util.List;

public class ExamStats implements Serializable {
	/*要素
	 * 試験概要
	 * 情報提供者数
	 * 平均点
	 * 平均時間
	 * 正誤情報リスト
	 */
	final private Exam exam;
	final private int infoUserCnt;
	final private double avgScore;
	final private int avgTime;
	final private List<BigQuestionSts> bqStsList;
	
	public ExamStats(Exam exam, int infoUserCnt, double avgScore, int avgTime, List<BigQuestionSts> bqStsList) {
		super();
		this.exam = exam;
		this.infoUserCnt = infoUserCnt;
		this.avgScore = avgScore;
		this.avgTime = avgTime;
		this.bqStsList = bqStsList;
	}

	public Exam getExam() {
		return exam;
	}

	public int getInfoUserCnt() {
		return infoUserCnt;
	}

	public double getAvgScore() {
		return avgScore;
	}

	public int getAvgTime() {
		return avgTime;
	}

	public List<BigQuestionSts> getBqStsList() {
		return bqStsList;
	}
}

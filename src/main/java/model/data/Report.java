package model.data;

import java.io.Serializable;
import java.util.Date;

public class Report implements Serializable{
	/*要素
	 * レポートID
	 * ユーザID
	 * 試験ID
	 * 受験日
	 * 経過時間
	 * 点数
	 * 正答率
	 * 試験名
	 * 合格点
	 */
	final private int reportID;
	final private String userID;
	final private String examID;
	final private Date examDate;
	final private Date elapsedTime;
	final private int score;
	final private double correctAnswerRate;
	final private String examName;
	final private int passingScore;
	
	public Report(int reportID, String userID, String examID, Date examDate, Date elapsedTime, int score,
			double correctAnswerRate, String examName, int passingScore) {
		this.reportID = reportID;
		this.userID = userID;
		this.examID = examID;
		this.examDate = examDate;
		this.elapsedTime = elapsedTime;
		this.score = score;
		this.correctAnswerRate = correctAnswerRate;
		this.examName = examName;
		this.passingScore = passingScore;
	}

	public int getReportID() {
		return reportID;
	}

	public String getUserID() {
		return userID;
	}

	public String getExamID() {
		return examID;
	}

	public Date getExamDate() {
		return examDate;
	}

	public Date getElapsedTime() {
		return elapsedTime;
	}

	public int getScore() {
		return score;
	}

	public double getCorrectAnswerRate() {
		return correctAnswerRate;
	}

	public String getExamName() {
		return examName;
	}

	public int getPassingScore() {
		return passingScore;
	}

}

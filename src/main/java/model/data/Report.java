package model.data;

import java.io.Serializable;
import java.util.Date;

public class Report implements Serializable{
	/*要素
	 * レポートID
	 * ユーザID
	 * 試験ID
	 * 受験日
	 * 点数
	 * 正答率
	 * 試験名
	 * 合格点
	 * やり直し問題か　true やり直しではない false　やり直し
	 */
	final private int reportID;
	final private String userID;
	final private String examID;
	final private Date examDate;
	final private int score;
	final private double correctAnswerRate;
	final private String examName;
	final private int passingScore;
	final private int useTime;
	final private boolean useInfo;
	final private boolean notRedoExam;

	public Report(int reportID, String userID, String examID, Date examDate, int score, double correctAnswerRate,
			String examName, int passingScore, int useTime, boolean useInfo, boolean notRedoExam) {
		super();
		this.reportID = reportID;
		this.userID = userID;
		this.examID = examID;
		this.examDate = examDate;
		this.score = score;
		this.correctAnswerRate = correctAnswerRate;
		this.examName = examName;
		this.passingScore = passingScore;
		this.useTime = useTime;
		this.useInfo = useInfo;
		this.notRedoExam = notRedoExam;
	}
	
	

	public int getUseTime() {
		return useTime;
	}

	public boolean isUseInfo() {
		return useInfo;
	}
	
	public boolean isNotRedoExam() {
		return notRedoExam;
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

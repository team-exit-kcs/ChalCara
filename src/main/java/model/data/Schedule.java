package model.data;

import java.io.Serializable;
import java.util.Date;

public class Schedule implements Serializable {
	/* 要素
	 * ユーザID
	 * 試験ID
	 * 受験予定日
	 */
	final private String userID;
	final private String examID;
	final private Date scheduleDate;
	
	public Schedule(String userID, String examID, Date scheduleDate) {
		super();
		this.userID = userID;
		this.examID = examID;
		this.scheduleDate = scheduleDate;
	}

	public String getUserID() {
		return userID;
	}

	public String getExamID() {
		return examID;
	}

	public Date getScheduleDate() {
		return scheduleDate;
	}
}

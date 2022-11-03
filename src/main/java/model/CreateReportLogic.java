package model;

import java.util.Date;

import dao.ReportDAO;
import model.data.Account;
import model.data.CheckAnsPage;
import model.data.Exam;
import model.data.Report;

public class CreateReportLogic {
	public Report execute(CheckAnsPage cap, Exam exam, Account user, boolean NotRedoExam) {
		ReportDAO reportDAO = new ReportDAO();
		int reportID = 0;
		String userID = null;
		
		if(user != null) {
			userID = user.getUserID();
			reportID = reportDAO.getMAXReportID(userID) + 1;
		}
		
		double correctAnswerRate = ((int)((cap.getScore() / (double)exam.getPassingScore()) * 10000)) / 100.0;
		Report newReport = new Report(reportID, userID, cap.getExamID(), new Date(), cap.getScore(), correctAnswerRate, exam.getExamName(), exam.getPassingScore() ,NotRedoExam);
		
		if(reportID > 0 && NotRedoExam) {
			reportDAO.setReport(newReport);
		}
		
		return newReport;
	}
}

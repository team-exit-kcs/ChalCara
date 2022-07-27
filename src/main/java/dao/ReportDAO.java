package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Exam;
import model.Report;

public class ReportDAO extends Database {
	final private String TABLE = "Report";
	final private String REPORT_ID = "ReportID";
	final private String EXAM_ID = "ExamID";
	final private String USER_ID = "UserID";
	final private String EXAM_DATE = "ExamDate";
	final private String ELAPSED_TIME = "ElapsedTime";
	final private String SCORE = "Score";
	final private String CORRECT_ANSWER_RATE = "CorrectAnswerRate";
	
	public Report findReportInfo(int reportID) {
		ExamDAO examDAO = new ExamDAO();
		Report report = null;
		
		try(Connection conn = DriverManager.getConnection(super.JDBC_URL, super.DB_USER, super.DB_PASS)){
			String sql = "SELECT * FROM " + TABLE + " WHERE " + REPORT_ID + " = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, reportID);
			
			ResultSet rs = pStmt.executeQuery();
			
			if(rs.next()) {
				String userID = rs.getString(USER_ID);
				String examID = rs.getString(EXAM_ID);
				Date examDate = rs.getDate(EXAM_DATE);
				Date elapsedTime = rs.getTime(ELAPSED_TIME);
				int score = rs.getInt(SCORE);
				double correctAnswerRate = rs.getDouble(CORRECT_ANSWER_RATE);
				
				Exam exam = examDAO.findExamInfo(examID);
				String examName = exam.getExamName();
				int passingScore = exam.getPassingScore();
				
				report = new Report(reportID, userID, examID, examDate, elapsedTime, score, correctAnswerRate,
						examName, passingScore);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return report;
	}
	
	public List<Integer> findUserReport(String userID) {
		List<Integer> reportIDList = new ArrayList<>();
		
		try(Connection conn = DriverManager.getConnection(super.JDBC_URL, super.DB_USER, super.DB_PASS)){
			String sql = "SELECT "+ REPORT_ID + " FROM " + TABLE + " WHERE " + USER_ID + " = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, userID);
			
			ResultSet rs = pStmt.executeQuery();
			
			while(rs.next()) {
				int reportID = rs.getInt(REPORT_ID);
				reportIDList.add(reportID);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return reportIDList;
	}
	
	public int getUserCount(String examID) {
		int cnt=0;
		
		try(Connection conn = DriverManager.getConnection(super.JDBC_URL, super.DB_USER, super.DB_PASS)){
			String sql = "SELECT COUNT("+ EXAM_ID + ") AS cnt FROM " + TABLE + " WHERE " + EXAM_ID + " = ? GROUP BY " + EXAM_ID;
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, examID);
			
			ResultSet rs = pStmt.executeQuery();
			
			if(rs.next()) {
				cnt = rs.getInt("cnt");
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return cnt;
		}
		
		return cnt;
	}
	
	public int getExamCount(String userID) {
		int cnt=0;
		
		try(Connection conn = DriverManager.getConnection(super.JDBC_URL, super.DB_USER, super.DB_PASS)){
			String sql = "SELECT COUNT("+ USER_ID + ") AS cnt FROM " + TABLE + " WHERE " + USER_ID + " = ? GROUP BY " + USER_ID;
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, userID);
			
			ResultSet rs = pStmt.executeQuery();
			
			if(rs.next()) {
				cnt = rs.getInt("cnt");
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return cnt;
		}
		
		return cnt;
	}
	
}

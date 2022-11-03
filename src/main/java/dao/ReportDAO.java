package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.DisclosureRangeLogic;
import model.data.Exam;
import model.data.Report;



public class ReportDAO extends Database {
	final private String TABLE = "Report";
	final private String REPORT_ID = "ReportID";
	final private String USER_ID = "UserID";
	final private String EXAM_ID = "ExamID";
	final private String EXAM_DATE = "ExamDate";
	final private String SCORE = "Score";
	final private String CORRECT_ANSWER_RATE = "CorrectAnswerRate";
	
	public Report findReportInfo(String userID, int reportID) {
		ExamDAO examDAO = new ExamDAO();
		Report report = null;
		
		try(Connection conn = DriverManager.getConnection(super.JDBC_URL, super.DB_USER, super.DB_PASS)){
			String sql = "SELECT * FROM " + TABLE + " WHERE " + USER_ID + " = ? AND " + REPORT_ID + " = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, userID);
			pStmt.setInt(2, reportID);
			
			ResultSet rs = pStmt.executeQuery();
			
			if(rs.next()) {
				String examID = rs.getString(EXAM_ID);
				Date examDate = rs.getDate(EXAM_DATE);
				int score = rs.getInt(SCORE);
				double correctAnswerRate = rs.getDouble(CORRECT_ANSWER_RATE);
				
				Exam exam = examDAO.findExamInfo(examID);
				String examName = exam.getExamName();
				int passingScore = exam.getPassingScore();
				
				report = new Report(reportID, userID, examID, examDate, score, correctAnswerRate,
						examName, passingScore ,true);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return report;
	}
	
	public int getMAXReportID(String userID) {
		int id=0;
		
		try(Connection conn = DriverManager.getConnection(super.JDBC_URL, super.DB_USER, super.DB_PASS)){
			String sql = "SELECT MAX("+ REPORT_ID + ") AS max FROM " + TABLE + " WHERE " + USER_ID + " = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, userID);
			
			ResultSet rs = pStmt.executeQuery();
			
			if(rs.next()) {
				id = rs.getInt("max");
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return -1;
		}
		
		return id;
	}

	public List<Exam> findMonthlyExeTopExam() {
		DisclosureRangeLogic DR = new DisclosureRangeLogic();
		ExamDAO examDAO = new ExamDAO();
		List<Exam> ExamList = new ArrayList<>();
		
		try(Connection conn = DriverManager.getConnection(super.JDBC_URL, super.DB_USER, super.DB_PASS)){
			String sql = "SELECT " + EXAM_ID + " FROM " + TABLE + " WHERE " + EXAM_DATE + " >= (NOW() - INTERVAL 30 DAY) GROUP BY " + EXAM_ID + " ORDER BY count(*) DESC";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			ResultSet rs = pStmt.executeQuery();
			
			while(rs.next() || ExamList.size() <= 10) {
				Exam exam = examDAO.findExamInfo(rs.getString(EXAM_ID));
				if(exam.getDisclosureRange() == DR.getOPEN()) {
					ExamList.add(exam);
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return ExamList;
	}

	public List<Integer> findUserReport(String userID) {
		List<Integer> reportIDList = new ArrayList<>();
		
		try(Connection conn = DriverManager.getConnection(super.JDBC_URL, super.DB_USER, super.DB_PASS)){
			String sql = "SELECT "+ REPORT_ID + " FROM " + TABLE + " WHERE " + USER_ID + " = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, userID);
			
			ResultSet rs = pStmt.executeQuery();
			
			int reportID;
			while(rs.next()) {
				reportID = rs.getInt(REPORT_ID);
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
	
	public boolean setReport(Report report) {
		boolean resultSts=false;
		
		try(Connection conn = DriverManager.getConnection(super.JDBC_URL, super.DB_USER, super.DB_PASS)){
			String sql = "INSERT INTO " + TABLE + " VALUES(?,?,?,?,?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, report.getReportID());
			pStmt.setString(2, report.getUserID());
			pStmt.setString(3, report.getExamID());
			pStmt.setDate(4, new java.sql.Date(report.getExamDate().getTime()));
			pStmt.setInt(5, report.getScore());
			pStmt.setDouble(6, report.getCorrectAnswerRate());
			
			int result = pStmt.executeUpdate();
			if(result>0) {
				resultSts=true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		return resultSts;
	}
}

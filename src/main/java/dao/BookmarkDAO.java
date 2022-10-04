package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.DisclosureRange;
import model.data.Bookmark;
import model.data.Exam;

public class BookmarkDAO extends Database implements DisclosureRange{
	
	final private String TABLE = "Bookmark";
	final private String EXAM_ID = "ExamID";
	final private String USER_ID = "UserID";
	
	public Bookmark findBookmark(String userID) {
		Bookmark bookmark = null;
		List<String> examIDList = new ArrayList<>();
		
		try(Connection conn = DriverManager.getConnection(super.JDBC_URL, super.DB_USER, super.DB_PASS)){
			String sql = "SELECT "+ EXAM_ID + " FROM " + TABLE + " WHERE " + USER_ID + " = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, userID);
			
			ResultSet rs = pStmt.executeQuery();
			
			while(rs.next()) {
				String examID = rs.getString(EXAM_ID);
				examIDList.add(examID);
			}
			bookmark = new Bookmark(userID,examIDList);
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return bookmark;
	}
	
	public List<Exam> findBookmarkTopExam() {
		ExamDAO examDAO = new ExamDAO();
		List<Exam> ExamList = new ArrayList<>();
		
		try(Connection conn = DriverManager.getConnection(super.JDBC_URL, super.DB_USER, super.DB_PASS)){
			String sql = "SELECT " + EXAM_ID + " FROM " + TABLE + " GROUP BY " + EXAM_ID + " ORDER BY count(*) DESC";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			ResultSet rs = pStmt.executeQuery();
			
			while(rs.next() || ExamList.size() <= 10) {
				Exam exam = examDAO.findExamInfo(rs.getString(EXAM_ID));
				if(exam.getDisclosureRange() == OPEN) {
					ExamList.add(exam);
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return ExamList;
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

package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.DisclosureRangeLogic;
import model.data.Bookmark;
import model.data.Exam;

public class BookmarkDAO extends Database{
	
	final private String TABLE = "Bookmark";
	final private String EXAM_ID = "ExamID";
	final private String USER_ID = "UserID";
	
	public Bookmark findBookmark(String userID) {
		ExamDAO examDAO = new ExamDAO();
		Bookmark bookmark = null;
		List<Exam> examList = new ArrayList<>();
		
		try(Connection conn = DriverManager.getConnection(super.JDBC_URL, super.DB_USER, super.DB_PASS)){
			String sql = "SELECT "+ EXAM_ID + " FROM " + TABLE + " WHERE " + USER_ID + " = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, userID);
			
			ResultSet rs = pStmt.executeQuery();
			
			while(rs.next()) {
				String examID = rs.getString(EXAM_ID);
				examList.add(examDAO.findExamInfo(examID));
			}
			bookmark = new Bookmark(userID,examList);
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return bookmark;
	}
	

	public List<Exam> findBookmarkTopExam() {
		DisclosureRangeLogic DR = new DisclosureRangeLogic();
		ExamDAO examDAO = new ExamDAO();
		List<Exam> ExamList = new ArrayList<>();
		
		try(Connection conn = DriverManager.getConnection(super.JDBC_URL, super.DB_USER, super.DB_PASS)){
			String sql = "SELECT " + EXAM_ID + " FROM " + TABLE + " GROUP BY " + EXAM_ID + " ORDER BY count(*) DESC";
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

	public boolean isBookmark(String examID,String userID) {
		boolean result = false;
		
		try(Connection conn = DriverManager.getConnection(super.JDBC_URL, super.DB_USER, super.DB_PASS)){
			String sql = "SELECT * FROM " + TABLE + " WHERE " + EXAM_ID + " = ? AND " + USER_ID + " = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, examID);
			pStmt.setString(2, userID);
			
			ResultSet rs = pStmt.executeQuery();
			
			while(rs.next()) {
				result = true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		return result;
	}
	
	public boolean setBookmark(String examID,String userID) {
		boolean result = false;
		
		try(Connection conn = DriverManager.getConnection(super.JDBC_URL, super.DB_USER, super.DB_PASS)){
			String sql = "INSERT INTO " + TABLE + " VALUES(?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, examID);
			pStmt.setString(2, userID);
			
			int rs = pStmt.executeUpdate();
			if(rs>0) {
				result=true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		return result;
	}
	
	public boolean deleteBookmark(String examID,String userID) {
		boolean result = false;
		
		try(Connection conn = DriverManager.getConnection(super.JDBC_URL, super.DB_USER, super.DB_PASS)){
			String sql = "DELETE FROM " + TABLE + " WHERE " + EXAM_ID + " = ? AND " + USER_ID + " = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, examID);
			pStmt.setString(2, userID);
			
			int rs = pStmt.executeUpdate();
			if(rs>0) {
				result=true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		return result;
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

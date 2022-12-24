package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.DisclosureRangeLogic;
import model.data.Exam;

public class TagDAO extends Database {
	final private String TABLE = "Tag";
	final private String EXAM_ID = "ExamID";
	final private String TAG = "Tag";
	
	public List<String> findTag(String examID){
		List<String> tagList = new ArrayList<>();
		
		try(Connection conn = DriverManager.getConnection(super.JDBC_URL, super.DB_USER, super.DB_PASS)){
			String sql = "SELECT "+ TAG + " FROM " + TABLE + " WHERE " + EXAM_ID + " = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, examID);
			
			ResultSet rs = pStmt.executeQuery();
			
			while(rs.next()) {
				String tag = rs.getString(TAG);
				tagList.add(tag);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return tagList;
	}
	
	public List<String> findAll(){
		List<String> tagList = new ArrayList<>();
		
		try(Connection conn = DriverManager.getConnection(super.JDBC_URL, super.DB_USER, super.DB_PASS)){
			String sql = "SELECT DISTINCT "+ TAG + " FROM " + TABLE + " ORDER BY " + TAG;
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			ResultSet rs = pStmt.executeQuery();
			
			while(rs.next()) {
				String tag = rs.getString(TAG);
				tagList.add(tag);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return tagList;
	}
	
	public List<Exam> findSearchTagExam(String tag) {
		ExamDAO examDAO = new ExamDAO();
		DisclosureRangeLogic DR = new DisclosureRangeLogic();
		List<Exam> examList = new ArrayList<>();
		
		try(Connection conn = DriverManager.getConnection(super.JDBC_URL, super.DB_USER, super.DB_PASS)){
			String sql = "SELECT " + EXAM_ID + " FROM " + TABLE + " WHERE " + TAG + " LIKE ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, tag);
			
			ResultSet rs = pStmt.executeQuery();
			
			while(rs.next()) {
				String examID = rs.getString(EXAM_ID);
				Exam exam = examDAO.findExamInfo(examID);
				
				if(DR.isOpen(exam.getDisclosureRange())) {
					examList.add(exam);
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return examList;
	}
	
	public void deleteTags(String examID) {
		try(Connection conn = DriverManager.getConnection(super.JDBC_URL, super.DB_USER, super.DB_PASS)){
			String sql = "DELETE FROM " + TABLE + " WHERE " + EXAM_ID + " = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, examID);
			
			pStmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean setTag(String examID,List<String> tagList) {
		if(tagList == null || tagList.isEmpty()) {
			return true;
		}else {
			boolean resultSts=false;
		
			try(Connection conn = DriverManager.getConnection(super.JDBC_URL, super.DB_USER, super.DB_PASS)){
				int result=0;
			
				String sql = "INSERT INTO " + TABLE + " VALUES(?, ?)";
				PreparedStatement pStmt = conn.prepareStatement(sql);
			
				pStmt.setString(1, examID);
				
				for(String tag: tagList) {
					pStmt.setString(2, tag);
					result += pStmt.executeUpdate();
				}
			
				if(result>=tagList.size()) {
					resultSts=true;
				}
			}catch(SQLException e) {
				e.printStackTrace();
				return false;
			}
		
			return resultSts;
		}
	}
}

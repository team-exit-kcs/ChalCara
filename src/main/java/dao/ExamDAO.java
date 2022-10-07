package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.DisclosureRange;
import model.data.EntryExam;
import model.data.Exam;

public class ExamDAO extends Database {
	final private String TABLE = "Exam";
	final private String EXAM_ID = "ExamID";
	final private String USER_ID = "UserID";
	final private String GENRE_ID = "GenreID";
	final private String EXAM_NAME = "ExamName";
	final private String CREATE_DATE = "CreateDate";
	final private String UPDATE_DATE = "UpdateDate";
	final private String PASSING_SCORE = "PassingScore";
	final private String EXAM_TIME = "ExamTime";
	final private String EXAM_EXPLANATION = "ExamExplanation";
	final private String DISCLOSURE_RANGE = "DisclosureRange";
	//final private String LIMITED_PASS = "LimitedPassword";
	
	public Exam findExamInfo(String examID) {
		GenreDAO genreDAO = new GenreDAO();
		TagDAO tagDAO = new TagDAO();
		ReportDAO reportDAO = new ReportDAO();
		BookmarkDAO bookmarkDAO = new BookmarkDAO();
		Exam exam = null;
		
		try(Connection conn = DriverManager.getConnection(super.JDBC_URL, super.DB_USER, super.DB_PASS)){

			String sql = "SELECT "+ USER_ID + ", " + GENRE_ID + ", " + EXAM_NAME + ", " + CREATE_DATE + ", " + UPDATE_DATE + ", " + PASSING_SCORE + ", " + 
					EXAM_TIME + ", " + EXAM_EXPLANATION + ", " + DISCLOSURE_RANGE + " FROM " + TABLE + " WHERE " + EXAM_ID + " = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, examID);
			
			ResultSet rs = pStmt.executeQuery();
			
			if(rs.next()) {
				String userID = rs.getString(USER_ID); 
				String examName = rs.getString(EXAM_NAME);
				Date createDate = rs.getDate(CREATE_DATE);
				Date updateDate = rs.getDate(UPDATE_DATE);
				int passingScore = rs.getInt(PASSING_SCORE);
				int examTime = rs.getInt(EXAM_TIME);
				String examExplanation = rs.getString(EXAM_EXPLANATION);
				int disclosureRange = rs.getInt(DISCLOSURE_RANGE);
				int genreID = rs.getInt(GENRE_ID);
				String genreName = genreDAO.findGenreName(genreID);
				List<String> tagList = tagDAO.findTag(examID);
				int exeCount = reportDAO.getUserCount(examID);
				int bookmarkCount = bookmarkDAO.getUserCount(examID);
				
				exam = new Exam(examID, userID, genreID, examName, createDate, updateDate, passingScore, examTime, examExplanation,
						disclosureRange,  tagList, genreName, exeCount, bookmarkCount);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return exam;
	}
	
	public boolean isID(String id){
		boolean resultSts=false;
		
		try(Connection conn = DriverManager.getConnection(super.JDBC_URL, super.DB_USER, super.DB_PASS)){
			String sql = "SELECT " + EXAM_ID + " FROM " + TABLE + " WHERE " + EXAM_ID + " = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, id);
			
			ResultSet rs = pStmt.executeQuery();
			
			if(rs.next()) {
				resultSts=true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		return resultSts;
	}
	
	public List<Exam> findNewExam() {
		DisclosureRange DR = new DisclosureRange();
		List<Exam> ExamList = new ArrayList<>();
		
		try(Connection conn = DriverManager.getConnection(super.JDBC_URL, super.DB_USER, super.DB_PASS)){
			String sql = "SELECT " + EXAM_ID + " FROM " + TABLE + " WHERE " + DISCLOSURE_RANGE + " = " + DR.OPEN + " ORDER BY " + CREATE_DATE + " DESC LIMIT 10";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			ResultSet rs = pStmt.executeQuery();
			
			while(rs.next()) {
				ExamList.add(this.findExamInfo(rs.getString(EXAM_ID)));
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return ExamList;
	}
	

	public List<Exam> findSearchExam(String word) {
		DisclosureRange DR = new DisclosureRange();
		List<Exam> examIDList = new ArrayList<>();
		
		try(Connection conn = DriverManager.getConnection(super.JDBC_URL, super.DB_USER, super.DB_PASS)){
			String sql = "SELECT " + EXAM_ID + " FROM " + TABLE + " WHERE " + DISCLOSURE_RANGE + " != "  + DR.CLOSE + " AND ( " + EXAM_NAME + " LIKE ? OR " + EXAM_EXPLANATION + " LIKE ? )";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, "%" + word + "%");
			pStmt.setString(2, "%" + word + "%");
			
			ResultSet rs = pStmt.executeQuery();
			
			while(rs.next()) {
				String examID = rs.getString(EXAM_ID);
				examIDList.add(this.findExamInfo(examID));
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return examIDList;
	}
	
	public List<Exam> findSearchUserExam(String userID) {
		DisclosureRange DR = new DisclosureRange();
		List<Exam> examList = new ArrayList<>();
		
		try(Connection conn = DriverManager.getConnection(super.JDBC_URL, super.DB_USER, super.DB_PASS)){
			String sql = "SELECT "+ EXAM_ID + " FROM " + TABLE + " WHERE " + DISCLOSURE_RANGE + " != "  + DR.CLOSE + " AND " + USER_ID + " = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, userID);
			
			ResultSet rs = pStmt.executeQuery();
			
			while(rs.next()) {
				String examID = rs.getString(EXAM_ID);
				examList.add(this.findExamInfo(examID));
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return examList;
	}
	
	public List<Exam> findUserExam(String userID) {
		List<Exam> examIDList = new ArrayList<>();
		
		try(Connection conn = DriverManager.getConnection(super.JDBC_URL, super.DB_USER, super.DB_PASS)){
			String sql = "SELECT "+ EXAM_ID + " FROM " + TABLE + " WHERE " + USER_ID + " = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, userID);
			
			ResultSet rs = pStmt.executeQuery();
			
			while(rs.next()) {
				String examID = rs.getString(EXAM_ID);
				examIDList.add(this.findExamInfo(examID));
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return examIDList;
	}
	
	public boolean setExam(EntryExam exam) {
		boolean resultSts=false;
		TagDAO tagDAO = new TagDAO();
		
		try(Connection conn = DriverManager.getConnection(super.JDBC_URL, super.DB_USER, super.DB_PASS)){
			String sql = "INSERT INTO " + TABLE + " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, exam.getExamID());
			pStmt.setString(2, exam.getUserID());
			pStmt.setInt(3, exam.getGenreID());
			pStmt.setString(4, exam.getExamName());
			pStmt.setDate(5, new java.sql.Date(exam.getCreateDate().getTime()));
			pStmt.setDate(6, new java.sql.Date(exam.getUpdateDate().getTime()));
			pStmt.setInt(7, exam.getPassingScore());
			pStmt.setInt(8, exam.getExamTime());
			pStmt.setString(9, exam.getExamExplanation());
			pStmt.setInt(10, exam.getDisclosureRange());
			pStmt.setString(11, exam.getLimitedPassword());
			
			int result = pStmt.executeUpdate();
			
			boolean tagResult = tagDAO.setTag(exam.getExamID(),exam.getTagList());
			
			if(result>0 && tagResult) {
				resultSts=true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		return resultSts;
	}
}

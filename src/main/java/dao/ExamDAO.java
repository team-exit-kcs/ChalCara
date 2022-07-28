package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import model.Exam;

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
			String sql = "SELECT "+ GENRE_ID + EXAM_NAME + CREATE_DATE + UPDATE_DATE + PASSING_SCORE + 
					EXAM_TIME + EXAM_EXPLANATION + DISCLOSURE_RANGE + " FROM " + TABLE + " WHERE " + EXAM_ID + " = ?";
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
				
				exam = new Exam(examID, userID, examName, createDate, updateDate, passingScore, examTime, examExplanation,
						disclosureRange, genreID, genreName, tagList, exeCount, bookmarkCount);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return exam;
	}
	
	public boolean setExam(Exam exam) {
boolean resultSts=false;
		
		try(Connection conn = DriverManager.getConnection(super.JDBC_URL, super.DB_USER, super.DB_PASS)){
			String sql = "INSERT INTO " + TABLE + "VALUES(?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
//			pStmt.setString(1, );
//			pStmt.setString(2, );
			
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

package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.data.BQCheckAns;
import model.data.CheckAns;
import model.data.Choices;
import model.data.Exam;
import model.data.UserAns;

public class UserAnsDAO extends Database {
	final private String TABLE = "UserAnser";
	final private String REPORT_ID = "ReportID";
	final private String USER_ID = "UserID";
	final private String BIG_QUESTION_ID = "BigQuestionID";
	final private String QUESTION_ID = "QuestionID";
	final private String USER_ANS = "UserAns";
	final private String TF = "tf";
	
	final private String REPORT_TABLE = "Report";
	final private String EXAM_ID = "ExamID";
	final private String USE_INFO = "UseInfo";
	final private String EXAM_DATE = "ExamDate";
	
	public List<UserAns> findUserAns(String userID, int reportID){
		List<UserAns> userAnsList = new ArrayList<>();
		
		try(Connection conn = DriverManager.getConnection(super.JDBC_URL, super.DB_USER, super.DB_PASS)){
			String sql = "SELECT " + BIG_QUESTION_ID + "," + QUESTION_ID + "," + USER_ANS + "," + TF + " FROM " + TABLE + 
					" WHERE " + USER_ID + " = ? AND " + REPORT_ID + " = ?";
			
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, userID);
			pStmt.setInt(2, reportID);
			
			ResultSet rs = pStmt.executeQuery();
			
			while(rs.next()) {
				int bigQuestionID = rs.getInt(BIG_QUESTION_ID);
				int questionID = rs.getInt(QUESTION_ID);
				int userAns = rs.getInt(USER_ANS);
				boolean tf = rs.getBoolean(TF);
				userAnsList.add(new UserAns(userID, reportID, bigQuestionID, questionID, userAns, tf));
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return userAnsList;
	}
	
	public int getAnsCount(Exam exam, Choices choices) {
		int cnt=0;
		
		try(Connection conn = DriverManager.getConnection(super.JDBC_URL, super.DB_USER, super.DB_PASS)){
			String sql = "SELECT COUNT(*) AS cnt FROM " + TABLE + " AS UA JOIN " + REPORT_TABLE + " AS R ON UA." + REPORT_ID + " = R." + REPORT_ID +
					" WHERE R." + EXAM_ID + " = ? AND R." + USE_INFO + " = true AND R." + EXAM_DATE + " >= ? AND UA."
					+ BIG_QUESTION_ID + " = ? AND UA."+ QUESTION_ID + " = ? AND UA." + USER_ANS + " = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, choices.getExamID());
			pStmt.setDate(2, new java.sql.Date(exam.getUpdateDate().getTime()));
			pStmt.setInt(3, choices.getBigQuestionID());
			pStmt.setInt(4, choices.getQuestionID());
			pStmt.setInt(5, choices.getChoicesID());
			
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
	
	public boolean setUserAns(String userID, int reportID, List<BQCheckAns> BQCheckAnsList) {
		boolean resultSts=false;
		
		try(Connection conn = DriverManager.getConnection(super.JDBC_URL, super.DB_USER, super.DB_PASS)){
			String sql = "INSERT INTO " + TABLE + " VALUES(?,?,?,?,?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			int result = 0;
			pStmt.setString(1, userID);
			pStmt.setInt(2, reportID);
			for(BQCheckAns bca : BQCheckAnsList) {
				for(CheckAns ca : bca.getCheckAnsList()) {
					
					pStmt.setInt(3, bca.getBigQuestionID());
					pStmt.setInt(4, ca.getQuestionID());
					pStmt.setInt(5, ca.getUserAnswer());
					pStmt.setBoolean(6, ca.isTf());
					
					result += pStmt.executeUpdate();
				}
			}
			
			if(result>=BQCheckAnsList.size()) {
				resultSts=true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		return resultSts;
	}
}

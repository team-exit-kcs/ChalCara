package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.data.BigQuestion;
import model.data.Question;

public class BigQuestionDAO extends Database {
	final private String TABLE = "BigQuestion";
	final private String EXAM_ID = "ExamID";
	final private String BIG_QUESTION_ID = "BigQuestionID";
	final private String BIG_QUESTION_SENTENCE = "BigQuestionSentence";
	
	public List<BigQuestion> findBigQuestion(String examID){
		List<BigQuestion> bigQuestionList = new ArrayList<>();
		QuestionDAO questionDAO = new QuestionDAO();
		
		try(Connection conn = DriverManager.getConnection(super.JDBC_URL, super.DB_USER, super.DB_PASS)){
			String sql = "SELECT "+ BIG_QUESTION_ID + "," + BIG_QUESTION_SENTENCE + " FROM " + TABLE + 
					" WHERE " + EXAM_ID + " = ?";
			
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, examID);
			
			ResultSet rs = pStmt.executeQuery();
			
			while(rs.next()) {
				int bigQuestionID = rs.getInt(BIG_QUESTION_ID);
				String bigQuestionSentence = rs.getString(BIG_QUESTION_SENTENCE);
				
				List<Question> questionList = questionDAO.findQuestion(examID, bigQuestionID);
						
				bigQuestionList.add(new BigQuestion(examID, bigQuestionID, bigQuestionSentence, questionList));
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return bigQuestionList;
	}
	
	public boolean setBigQuestion(List<BigQuestion> bigQuestionList) {
		if(bigQuestionList == null || bigQuestionList.isEmpty()) {
			return true;
		}else {
			boolean resultSts=false;
			boolean questionResult=true;
			QuestionDAO questionDAO = new QuestionDAO();
		
			try(Connection conn = DriverManager.getConnection(super.JDBC_URL, super.DB_USER, super.DB_PASS)){
				int result=0;
			
				String sql = "INSERT INTO " + TABLE + " VALUES(?, ?, ?)";
				PreparedStatement pStmt = conn.prepareStatement(sql);
			
				for(BigQuestion bigQuestion: bigQuestionList) {
					pStmt.setString(1, bigQuestion.getExamID());
					pStmt.setInt(2, bigQuestion.getBigQuestionID());
					pStmt.setString(3, bigQuestion.getBigQuestionSentence());
					result += pStmt.executeUpdate();
					
					 if(!(questionDAO.setQuestion(bigQuestion.getQuestionList()))){
						 questionResult = false;
					 }
					
				}
			
				if(result>=bigQuestionList.size() && questionResult) {
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

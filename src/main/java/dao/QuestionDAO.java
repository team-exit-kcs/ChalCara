package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.data.Choices;
import model.data.Question;

public class QuestionDAO extends Database {
	final private String TABLE = "Question";
	final private String EXAM_ID = "ExamID";
	final private String BIG_QUESTION_ID = "BigQuestionID";
	final private String QUESTION_ID = "QuestionID";
	final private String QUESTION_SENTENCE = "QuestionSentence";
	final private String ANSWER = "ExamAnswer";
	final private String QUESTION_EXPLANATION = "QuestionExplanation";
	final private String ALLOCATION_OF_POINT = "AllocationOfPoint";
	
	public List<Question> findQuestion(String examID, int bigQuestionID){
		List<Question> questionList = new ArrayList<>();
		ChoicesDAO choicesDAO = new ChoicesDAO();
		
		try(Connection conn = DriverManager.getConnection(super.JDBC_URL, super.DB_USER, super.DB_PASS)){
			String sql = "SELECT "+ QUESTION_ID + "," + QUESTION_SENTENCE + "," + ANSWER + "," + QUESTION_EXPLANATION +
					"," + ALLOCATION_OF_POINT +" FROM " + TABLE + 
					" WHERE " + EXAM_ID + " = ? AND " + BIG_QUESTION_ID + " = ?";
			
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, examID);
			pStmt.setInt(2, bigQuestionID);
			
			ResultSet rs = pStmt.executeQuery();
			
			while(rs.next()) {
				int questionID = rs.getInt(QUESTION_ID);
				String questionSentence = rs.getString(QUESTION_SENTENCE);
				int answer = rs.getInt(ANSWER);
				String questionExplanation = rs.getString(QUESTION_EXPLANATION);
				double allocationOfPoint = rs.getDouble(ALLOCATION_OF_POINT);
				
				List<Choices> choicesList = choicesDAO.findChoices(examID, bigQuestionID, questionID);
						
				questionList.add(new Question(examID, bigQuestionID, questionID, questionSentence, answer, questionExplanation, allocationOfPoint, choicesList));
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return questionList;
	}
	
	public Question findQuestion(String examID, int bigQuestionID, int questionID){
		Question question = null;
		ChoicesDAO choicesDAO = new ChoicesDAO();
		
		try(Connection conn = DriverManager.getConnection(super.JDBC_URL, super.DB_USER, super.DB_PASS)){
			String sql = "SELECT " + QUESTION_SENTENCE + "," + ANSWER + "," + QUESTION_EXPLANATION +
					"," + ALLOCATION_OF_POINT + " FROM " + TABLE + 
					" WHERE " + EXAM_ID + " = ? AND " + BIG_QUESTION_ID + " = ? AND " + QUESTION_ID + " = ?";
			
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, examID);
			pStmt.setInt(2, bigQuestionID);
			
			ResultSet rs = pStmt.executeQuery();
			
			if(rs.next()) {
				String questionSentence = rs.getString(QUESTION_SENTENCE);
				int answer = rs.getInt(ANSWER);
				String questionExplanation = rs.getString(QUESTION_EXPLANATION);
				double allocationOfPoint = rs.getDouble(ALLOCATION_OF_POINT);
				
				List<Choices> choicesList = choicesDAO.findChoices(examID, bigQuestionID, questionID);
					
				question = new Question(examID, bigQuestionID, questionID, questionSentence, answer, questionExplanation, allocationOfPoint, choicesList);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return question;
	}
	
	public boolean setQuestion(List<Question> questionList) {
		if(questionList == null || questionList.isEmpty()) {
			return true;
		}else {
			boolean resultSts = false;
			boolean choicesResult = true;
			ChoicesDAO choicesDAO = new ChoicesDAO();
		
			try(Connection conn = DriverManager.getConnection(super.JDBC_URL, super.DB_USER, super.DB_PASS)){
				int result=0;
			
				String sql = "INSERT INTO " + TABLE + " VALUES(?, ?, ?, ?, ?, ?, ?)";
				PreparedStatement pStmt = conn.prepareStatement(sql);
			
				for(Question question: questionList) {
					pStmt.setString(1, question.getExamID());
					pStmt.setInt(2, question.getBigQuestionID());
					pStmt.setInt(3, question.getQuestionID());
					pStmt.setString(4, question.getQuestionSentence());
					pStmt.setInt(5, question.getAnswer());
					pStmt.setString(6, question.getQuestionExplanation());
					pStmt.setDouble(7, question.getAllocationOfPoint());
					result += pStmt.executeUpdate();
					
					if(!(choicesDAO.setChoices(question.getChoicesList()))) {
						choicesResult = false;
					}
				}
			
				if(result>=questionList.size() && choicesResult) {
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

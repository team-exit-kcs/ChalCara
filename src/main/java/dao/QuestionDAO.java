package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import model.Question;

public class QuestionDAO extends Database {
	final private String TABLE = "Question";
//	final private String EXAM_ID = "ExamID";
//	final private String BIG_QUESTION_ID = "BigQuestionID";
//	final private String QUESTION_ID = "QuestionID";
//	final private String QUESTION_SENTENCE = "QuestionSentence";
//	final private String ANSWER = "ExamAnswer";
//	final private String QUESTION_EXPLANATION = "QuestionExplanation";
//	final private String ALLOCATION_OF_POINT = "AllocationOfPoint";
	
	public boolean setQuestion(List<Question> questionList) {
		if(questionList == null || questionList.isEmpty()) {
			return true;
		}else {
			boolean resultSts = false;
			boolean choicesResult = true;
			ChoicesDAO choicesDAO = new ChoicesDAO();
		
			try(Connection conn = DriverManager.getConnection(super.JDBC_URL, super.DB_USER, super.DB_PASS)){
				int result=0;
			
				String sql = "INSERT INTO " + TABLE + "VALUES(?, ?, ?, ?, ?, ?, ?)";
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

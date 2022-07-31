package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import model.Choices;

public class ChoicesDAO extends Database {
	final private String TABLE = "Choices";
//	final private String EXAM_ID = "ExamID";
//	final private String BIG_QUESTION_ID = "BigQuestionID";
//	final private String QUESTION_ID = "QuestionID";
//	final private String CHOICES_ID = "ChoicesID";
//	final private String CHOICES = "Choices";
	
	public boolean setChoices(List<Choices> choicesList) {
		if(choicesList == null || choicesList.isEmpty()) {
			return true;
		}else {
			boolean resultSts=false;
		
			try(Connection conn = DriverManager.getConnection(super.JDBC_URL, super.DB_USER, super.DB_PASS)){
				int result=0;
			
				String sql = "INSERT INTO " + TABLE + "VALUES(?, ?, ?, ?, ?)";
				PreparedStatement pStmt = conn.prepareStatement(sql);
			
				for(Choices choices: choicesList) {
					pStmt.setString(1, choices.getExamID());
					pStmt.setInt(2, choices.getBigQuestionID());
					pStmt.setInt(3, choices.getQuestionID());
					pStmt.setInt(4, choices.getChoicesID());
					pStmt.setString(5, choices.getChoices());
					result += pStmt.executeUpdate();
				}
			
				if(result>=choicesList.size()) {
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

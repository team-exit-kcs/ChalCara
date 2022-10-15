package model;

import java.util.List;

import dao.AccountDAO;
import dao.ExamDAO;
import model.data.Account;
import model.data.Exam;
import model.data.UserPage;

public class UserPageLogic {
	public UserPage exequte(String userID) {
		AccountDAO accountDAO = new AccountDAO();
		ExamDAO examDAO = new ExamDAO();
		
		UserPage pageData = null;
		
		if(userID != null) {
			Account user = accountDAO.findByAccount(userID);
			
			if(user != null) {
				List<Exam> examList = examDAO.findSearchUserExam(userID);
				pageData = new UserPage(user, examList);
			}
		}
		
		return pageData;
	}
}

package model;

import java.util.List;

import dao.BigQuestionDAO;
import dao.BookmarkDAO;
import dao.ExamDAO;
import model.data.Account;
import model.data.BigQuestion;
import model.data.Exam;
import model.data.ExaminationPage;

public class ExaminationLogic {
	public ExaminationPage exequte(String examID,Account user) {
		ExamDAO examDAO = new ExamDAO();
		BigQuestionDAO bigQuestionDAO = new BigQuestionDAO();
		BookmarkDAO bookmarkDAO = new BookmarkDAO();
		
		ExaminationPage pageData = null;
		boolean useInfo = false;
		boolean bookmark = false;
		
		if(examID != null) {
			Exam exam = examDAO.findExamInfo(examID);
			List<BigQuestion> bigQuestionList = bigQuestionDAO.findBigQuestion(examID);
			
			if(user != null) {
				useInfo = user.isUseInfoDefault();
				bookmark = bookmarkDAO.isBookmark(examID, user.getUserID());
			}
			
			if(exam != null) {
				pageData = new ExaminationPage(exam,bigQuestionList,bookmark,useInfo,true);
			}
		}
		
		return pageData;
	}
}

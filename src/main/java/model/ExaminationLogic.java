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
		boolean bookmark = false;
		
		if(examID != null) {
			Exam exam = examDAO.findExamInfo(examID);
			List<BigQuestion> bigQuestionList = bigQuestionDAO.findBigQuestion(examID);
			
			if(user != null) {
				bookmark = bookmarkDAO.isBookmark(examID, user.getUserID());
			}
			
			if(exam != null) {
				/*大問０(初期値)　小問１  大問の問題文がnullの場合は小問のみのため問題文の値で判定*/
				int questionFormat = (bigQuestionList.get(0).getBigQuestionSentence() == null ? 1 : 0);
				pageData = new ExaminationPage(exam,questionFormat,bigQuestionList,bookmark, true);
			}
		}
		
		return pageData;
	}
}

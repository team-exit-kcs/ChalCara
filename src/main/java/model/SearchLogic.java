package model;

import java.util.ArrayList;
import java.util.List;

import dao.AccountDAO;
import dao.ExamDAO;
import model.data.Account;
import model.data.Exam;
import model.data.Search;
import model.data.SearchResult;

public class SearchLogic {
	public SearchResult exequte(int format, String word) {
		ExamDAO examDAO = new ExamDAO();
		DisclosureRange DR = new DisclosureRange();
		List<Search> resultList = new ArrayList<>();
		
		switch(format) {
		case 1:
			List<Exam> examList = examDAO.findSearchExam(word);
			for(Exam exam : examList) {
				resultList.add(new Search("/ExamPlatform/img/exam.png", "/ExamPlatform/ExaminationServlet?examID=" + exam.getExamID(), exam.getExamName()));
			}
			break;
			
		case 2:
			Exam exam = examDAO.findExamInfo(word);
			if(exam != null && DR.isNotClose(exam.getDisclosureRange())) {
				resultList.add(new Search("/ExamPlatform/img/exam.png", "/ExamPlatform/ExaminationServlet?examID=" + exam.getExamID(), exam.getExamName()));
			}
			
			break;
			
		case 3:
			AccountDAO accountDAO = new AccountDAO();
			
			Account account = accountDAO.findByAccount(word);
			if(account != null) {
				resultList.add(new Search(account.getIcon(), "/ExamPlatform/UserPageServlet?userID=" + account.getUserID(), account.getUserID()));
			}
			
			List<String> examIDList = examDAO.findUserExam(word);
			for(String id : examIDList) {
				Exam userExam = examDAO.findExamInfo(id);
				if(DR.isNotClose(userExam.getDisclosureRange())) {
					resultList.add(new Search("/ExamPlatform/img/exam.png", "/ExamPlatform/ExaminationServlet?examID=" + userExam.getExamID(), userExam.getExamName()));
				}
			}
			break;
		}
		return new SearchResult(1,resultList);
	}
}

package model;

import java.util.ArrayList;
import java.util.List;

import dao.AccountDAO;
import dao.ExamDAO;
import dao.TagDAO;
import model.data.Account;
import model.data.Exam;
import model.data.Search;
import model.data.SearchResult;

public class SearchLogic {
	public SearchResult exequte(int format, String word) {
		ExamDAO examDAO = new ExamDAO();
		AccountDAO accountDAO = new AccountDAO();
		TagDAO tagDAO = new TagDAO();
		
		DisclosureRangeLogic DR = new DisclosureRangeLogic();
		List<Search> resultList = new ArrayList<>();
		
		switch(format) {
		case 1:
			List<Exam> examList1 = examDAO.findSearchExam(word);
			for(Exam exam : examList1) {
				resultList.add(new Search("/ExamPlatform/img/exam.png", "/ExamPlatform/ExaminationServlet?examID=" + exam.getExamID(), exam.getExamName()));
			}
			break;
			
		case 2:
			Exam exam2 = examDAO.findExamInfo(word);
			if(exam2 != null && DR.isNotClose(exam2.getDisclosureRange())) {
				resultList.add(new Search("/ExamPlatform/img/exam.png", "/ExamPlatform/ExaminationServlet?examID=" + exam2.getExamID(), exam2.getExamName()));
			}
			
			break;
			
		case 3:
			Account account = accountDAO.findByAccount(word);
			if(account != null) {
				resultList.add(new Search(account.getIcon(), "/ExamPlatform/UserPageServlet?userID=" + account.getUserID(), account.getUserID()));
			}
			
			List<Exam> examList3 = examDAO.findSearchUserExam(word);
			for(Exam exam : examList3) {
				resultList.add(new Search("/ExamPlatform/img/exam.png", "/ExamPlatform/ExaminationServlet?examID=" + exam.getExamID(), exam.getExamName()));
			}
			break;
			
		case 4:
			List<Exam> examList4 = tagDAO.findSearchTagExam(word);
			for(Exam exam : examList4) {
				resultList.add(new Search("/ExamPlatform/img/exam.png", "/ExamPlatform/ExaminationServlet?examID=" + exam.getExamID(), exam.getExamName()));
			}
			break;
			
		case 5:
			List<Exam> examList5 = examDAO.findSearchGenreExam(Integer.parseInt(word));
			for(Exam exam : examList5) {
				resultList.add(new Search("/ExamPlatform/img/exam.png", "/ExamPlatform/ExaminationServlet?examID=" + exam.getExamID(), exam.getExamName()));
			}
			break;
		}
		return new SearchResult(1,resultList,format,word);
	}
}

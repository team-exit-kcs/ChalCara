package model;

import java.util.List;

import dao.BookmarkDAO;
import dao.ExamDAO;
import dao.ReportDAO;
import model.data.Exam;
import model.data.Mypage;
import model.data.Report;

public class MypageLogic {
	public Mypage exequte(String userID) {
		ExamDAO ed = new ExamDAO();
		BookmarkDAO bd = new BookmarkDAO();
		ReportDAO rd = new ReportDAO();
		List<Exam> examList = ed.findUserExam(userID);
		List<Exam> bookmarkExamList = bd.findBookmark(userID).getExamList();
		List<Report> reportList = rd.findUserReport(userID);
		
		return new Mypage(examList,bookmarkExamList,reportList);
	}
}

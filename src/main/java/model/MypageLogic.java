package model;

import java.util.ArrayList;
import java.util.List;

import dao.BookmarkDAO;
import dao.ExamDAO;
import dao.ReportDAO;
import model.data.Mypage;
import model.data.Report;

public class MypageLogic {
	public Mypage exequte(String userID) {
		ExamDAO ed = new ExamDAO();
		BookmarkDAO bd = new BookmarkDAO();
		ReportDAO rd = new ReportDAO();
		List<String> examIDList = ed.findUserExam(userID);
		List<String> bookmarkIDList = bd.findBookmark(userID).getExamIDList();
		List<Integer> reportIDList = rd.findUserReport(userID);
		
		List<String> examNameList = new ArrayList<>();
		for(String examID:examIDList) {
			examNameList.add(ed.findExamInfo(examID).getExamName());
		}
		
		List<String> bookmarkNameList = new ArrayList<>();
		for(String bookmarkID:bookmarkIDList) {
			bookmarkNameList.add(ed.findExamInfo(bookmarkID).getExamName());
		}
		
		List<Report> reportList = new ArrayList<>();
		for(int reportID:reportIDList) {
			reportList.add(rd.findReportInfo(reportID));
		}
		
		return new Mypage(examNameList,bookmarkNameList,reportList);	}
}

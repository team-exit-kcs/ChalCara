package model;

import java.util.ArrayList;
import java.util.List;

import dao.BigQuestionDAO;
import dao.ExamDAO;
import dao.UserAnsDAO;
import model.data.BQCheckAns;
import model.data.BigQuestion;
import model.data.CheckAns;
import model.data.CheckAnsPage;
import model.data.Exam;
import model.data.Question;
import model.data.Report;
import model.data.UserAns;

public class CheckAnsPageLogic {
	public CheckAnsPage execute(String userID, Report report) {
		CheckAnsPage checkAnsPage = null;
		ExamDAO examDAO = new ExamDAO();
		
		Exam exam = examDAO.findExamInfo(report.getExamID());
		
		if(exam.getUpdateDate().before(report.getExamDate())) {
			BigQuestionDAO BQDAO = new BigQuestionDAO();
			UserAnsDAO userAnsDAO = new UserAnsDAO();
			
			List<BQCheckAns> BQCheckAnsList = new ArrayList<>();
			List<BigQuestion> bigQuestionList = BQDAO.findBigQuestion(report.getExamID());
			List<UserAns> userAnsList = userAnsDAO.findUserAns(userID, report.getReportID());
			
			if(!userAnsList.isEmpty()) {
				double score = 0;
				int miss = 0;
				
				for(BigQuestion bq : bigQuestionList) {
					List<CheckAns> checkAnsList = new ArrayList<>();
					for(Question q : bq.getQuestionList()) {
						UserAns userAns = userAnsList.stream()
								  .filter(c -> c.getBigQuestionID() == q.getBigQuestionID() && c.getQuestionID() == q.getQuestionID())
								  .findFirst()
								  .orElse(null);
						
						if(userAns != null) {
							CheckAns result = new CheckAns(q.getQuestionID(), q.getQuestionSentence(), q.getAnswer(), userAns.getUserAns(),
															userAns.isTf(), q.getQuestionExplanation(), q.getAllocationOfPoint(), q.getChoicesList());
							
							if(result.isTf()) {
								score += result.getAllocationOfPoint();
							}else {
								miss++;
							}
						
							checkAnsList.add(result);
						}
					}
					
					if(!checkAnsList.isEmpty()) {
						BQCheckAnsList.add(new BQCheckAns(bq.getBigQuestionID(), bq.getBigQuestionSentence(), checkAnsList));
					}
				}
				
				if(!BQCheckAnsList.isEmpty()) {
					checkAnsPage = new CheckAnsPage(report.getExamID(), (int)score, BQCheckAnsList, miss);
				}
			}
		}
		
		return checkAnsPage;
	}
}

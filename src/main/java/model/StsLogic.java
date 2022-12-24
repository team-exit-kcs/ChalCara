package model;

import java.util.ArrayList;
import java.util.List;

import dao.BigQuestionDAO;
import dao.ReportDAO;
import dao.UserAnsDAO;
import model.data.BigQuestion;
import model.data.BigQuestionSts;
import model.data.Choices;
import model.data.ChoicesSts;
import model.data.Exam;
import model.data.ExamStats;
import model.data.Question;
import model.data.QuestionSts;
import model.data.Report;

public class StsLogic {
	public ExamStats execute(Exam exam) {
		ExamStats sts = null;
		
		if(exam != null) {
			ReportDAO rd = new ReportDAO();
			BigQuestionDAO BQDAO = new BigQuestionDAO();
			
			List<Report> reportList = rd.getUseInfoReport(exam);
			
			int infoUserCnt = reportList.size();
			double avgScore = ScoreAvg(reportList);
			int avgTime = TimeAvg(reportList);
			
			List<BigQuestion> bigQuestionList = BQDAO.findBigQuestion(exam.getExamID());
			List<BigQuestionSts> bqStsList = createBQSts(exam, bigQuestionList, infoUserCnt);
			
			sts = new ExamStats(exam, infoUserCnt, avgScore, avgTime, bqStsList);
		}
		
		return sts;
	}
	
	private double ScoreAvg(List<Report> reportList) {
		double scoreTotal = 0;
		for(Report report : reportList) {
			scoreTotal += report.getScore();
		}
		
		double scoreAvg = 0;
		if(scoreTotal > 0) {
			scoreAvg = ((int)(scoreTotal/reportList.size()*100))/100;
		}
		return scoreAvg;
	}
	
	private int TimeAvg(List<Report> reportList) {
		int timeTotal = 0;
		for(Report report : reportList) {
			timeTotal += report.getUseTime();
		}
		
		int timeAvg = 0;
		if(timeTotal > 0) {
			timeAvg = timeTotal/reportList.size();
		}
		
		return timeAvg;
	}
	
	private List<BigQuestionSts> createBQSts(Exam exam, List<BigQuestion> bqList, int infoUserCnt){
		UserAnsDAO uad = new UserAnsDAO();
		
		List<BigQuestionSts> bqStsList = new ArrayList<>();
		for(BigQuestion bq : bqList) {
			List<QuestionSts> qStsList = new ArrayList<>();
			for(Question q : bq.getQuestionList()) {
				List<ChoicesSts> cStsList = new ArrayList<>();
				
				if(!q.getChoicesList().isEmpty()) {
					Choices noChoices = new Choices(exam.getExamID(), q.getBigQuestionID(), q.getQuestionID(), 0, "未選択");
					int ansCnt = uad.getAnsCount(exam,noChoices);
					double selectRate = 0;
					if(ansCnt > 0) {
						selectRate = ((int)((double)ansCnt/infoUserCnt*1000.0))/10.0;
					}
					cStsList.add(new ChoicesSts(noChoices, selectRate, ansCnt));
				}
				
				for(Choices choices : q.getChoicesList()) {
					int ansCnt = uad.getAnsCount(exam,choices);
					double selectRate = 0;
					if(ansCnt > 0) {
						selectRate = ((int)((double)ansCnt/infoUserCnt*1000.0))/10.0;
					}
					cStsList.add(new ChoicesSts(choices, selectRate, ansCnt));
				}
				
				if(!cStsList.isEmpty()) {
					qStsList.add(new QuestionSts(bq.getExamID(), bq.getBigQuestionID(), q.getQuestionID(), q.getQuestionSentence(),
							q.getAnswer(), q.getQuestionExplanation(), q.getAllocationOfPoint(), cStsList));
				}
			}
			
			if(!qStsList.isEmpty()) {
				bqStsList.add(new BigQuestionSts(bq.getExamID(), bq.getBigQuestionID(), bq.getBigQuestionSentence(), qStsList));
			}
		}
		
		return bqStsList;
	}
}

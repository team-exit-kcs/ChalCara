package model;

import java.util.ArrayList;
import java.util.List;

import model.data.BQCheckAns;
import model.data.BigQuestion;
import model.data.CheckAns;
import model.data.CheckAnsPage;
import model.data.ExaminationPage;
import model.data.Question;

public class RedoExamLogic {
	public ExaminationPage exequte(ExaminationPage examinationPage, CheckAnsPage checkAnsPage) {
		ExaminationPage newExaminationPage = null;
		
		if(examinationPage != null && checkAnsPage != null) {
			String examID=examinationPage.getExam().getExamID();
			List<BigQuestion> newBigQuestionList = new ArrayList<>();
			
			for(BQCheckAns bqAns : checkAnsPage.getBQCheckAnsList()) {
				List<Question> questionList = new ArrayList<>();
				for(CheckAns checkAns: bqAns.getCheckAnsList() ) {
					if(!checkAns.isTf()) {
						questionList.add(new Question(examID, bqAns.getBigQuestionID(), checkAns.getQuestionID(), checkAns.getQuestionSentence(),
								checkAns.getAnswer(), checkAns.getQuestionExplanation(), checkAns.getAllocationOfPoint(), checkAns.getChoicesList()));
					}
				}
				if(!questionList.isEmpty()) {
					newBigQuestionList.add(new BigQuestion(examID, bqAns.getBigQuestionID(), bqAns.getBigQuestionSentence(), questionList));
				}
			}
			
			newExaminationPage = new ExaminationPage(examinationPage.getExam(), newBigQuestionList, examinationPage.isBookmark(),false, false);
		}
		return newExaminationPage;
	}
}

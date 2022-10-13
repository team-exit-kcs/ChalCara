package model;

import model.data.CheckAns;
import model.data.Question;

public class CheckAnsLogic {
	public CheckAns exequte(Question q, String strAns) {
		boolean tf = false;
		
		int userAns = 0;
		
		if(strAns != null) {
			userAns = Integer.parseInt(strAns);
			if(userAns == q.getAnswer()) {
				tf = true;
			}
		}
		
		return new CheckAns(q.getBigQuestionID(), q.getQuestionID(), q.getQuestionSentence(), q.getAnswer(), userAns, tf, q.getQuestionExplanation(), q.getAllocationOfPoint(), q.getChoicesList());
	}
}

package model;

import java.util.List;

import dao.BigQuestionDAO;
import dao.ExamDAO;
import model.data.BigQuestion;
import model.data.EntryExam;

public class ExamCreateLogic {
	public void exequte(EntryExam EE, List<BigQuestion> BQList) {
		ExamDAO EDAO = new ExamDAO();
		BigQuestionDAO BQDAO = new BigQuestionDAO();
		
		EDAO.setExam(EE);
		BQDAO.setBigQuestion(BQList);
	}
}

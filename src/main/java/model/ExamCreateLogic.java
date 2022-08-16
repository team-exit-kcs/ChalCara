package model;

import dao.ExamDAO;
import model.data.EntryExam;

public class ExamCreateLogic {
	public void exequte(EntryExam EE) {
		ExamDAO EDAO = new ExamDAO();
		
		EDAO.setExam(EE);
	}
}

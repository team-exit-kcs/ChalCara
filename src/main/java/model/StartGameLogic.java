package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import dao.BigQuestionDAO;
import dao.ExamDAO;
import model.data.BigQuestion;
import model.data.Exam;
import model.data.Game;
import model.data.Question;

public class StartGameLogic {
	public Game execute(List<Integer> genreIDFilterList,List<String> tagFilterList) {
		final int MAX_Q = 20;
		
		Game game=null;
		ExamDAO examDAO =new ExamDAO();
		BigQuestionDAO bqd = new BigQuestionDAO();
		List<Exam> examList = examDAO.findGameExam();
		List<Question> questionList = new ArrayList<>();
		
		for(Exam exam : examList) {
			if(!genreIDFilterList.isEmpty() && !genreIDFilterList.contains(exam.getGenreID())) {
				continue;
			}
			
			boolean tagContinue=false;
			for(String tagFilter : tagFilterList) {
				tagContinue=true;
				if(exam.getTagList().contains(tagFilter)) {
					tagContinue=false;
					break;
				}
			}
			if(tagContinue) {
				continue;
			}
			
			List<BigQuestion> bqList = bqd.findBigQuestion(exam.getExamID());
			questionList.addAll(bqList.get(0).getQuestionList());
		}
		
		List<Question> newQuestionList = new ArrayList<>();
		if(questionList.size()>MAX_Q) {
			Collections.shuffle(questionList);
			newQuestionList = questionList.subList(0, 19);
		}else {
			newQuestionList = questionList;
		}
		game = new Game(newQuestionList);
		return game;
	}
}

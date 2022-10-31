package model;

import java.util.ArrayList;
import java.util.List;

import dao.BigQuestionDAO;
import model.data.Exam;
import model.data.SearchFilterData;

public class SearchFilterLogic {
	public List<Exam> exequte(List<Exam> examList, SearchFilterData searchFilter){
		List<Exam> newExamList = new ArrayList<>();
		for(Exam exam : examList) {
			if(!searchFilter.getGenreIDFilterList().isEmpty() && !searchFilter.getGenreIDFilterList().contains(exam.getGenreID())) {
				continue;
			}
			
			if(!searchFilter.getUserIDFilterList().isEmpty() && !searchFilter.getUserIDFilterList().contains(exam.getUserID())) {
				continue;
			}
			
			boolean tagContinue=false;
			for(String tagFilter : searchFilter.getTagFilterList()) {
				tagContinue=true;
				if(exam.getTagList().contains(tagFilter)) {
					tagContinue=false;
					break;
				}
			}
			if(tagContinue) {
				continue;
			}
			
			if(searchFilter.getExamFormatFilter() != -1) {
				BigQuestionDAO bqDAO = new BigQuestionDAO();
				int examFormat = bqDAO.findBigQuestion(exam.getExamID()).get(0).getBigQuestionSentence()==null ? 1 : 0;
				if(searchFilter.getExamFormatFilter() != examFormat) {
					continue;
				}
			}
			
			newExamList.add(exam);
		}
		
		return newExamList;
	}
}

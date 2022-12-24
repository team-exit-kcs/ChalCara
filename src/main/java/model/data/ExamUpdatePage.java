package model.data;

import java.io.Serializable;
import java.util.List;

public class ExamUpdatePage implements Serializable{

	 final private List<Genre> genreList;
		final private List<String> tagList;
		final private Exam exam;
		final private List<BigQuestion> bigQuestionList;

	    public ExamUpdatePage(List<Genre> genreList, List<String> tagList, Exam exam,
				List<BigQuestion> bigQuestionList) {
			this.genreList = genreList;
			this.tagList = tagList;
			this.exam = exam;
			this.bigQuestionList = bigQuestionList;
		}

		public List<Genre> getGenreList() {
			return genreList;
		}
		public List<String> getTagList() {
			return tagList;
		}

		public Exam getExam() {
			return exam;
		}

		public List<BigQuestion> getBigQuestionList() {
			return bigQuestionList;
		}
}

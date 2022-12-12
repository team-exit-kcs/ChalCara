package model.data;

import java.io.Serializable;
import java.util.List;

public class ExamUpdatePage implements Serializable{

	 final private List<Genre> genreList;
		final private List<String> tagList;
		final private Exam exam;
		final private int questionFormat;
		final private List<BigQuestion> bigQuestionList;
		
		/*public ExamUpdatepage(List<Genre> genreList, List<String> tagList) {
			this.genreList = genreList;
			this.tagList = tagList;
			this.exam = null;
			this.questionFormat = 0;
			this.bigQuestionList = new ArrayList<>();
		}
     */
	        public ExamUpdatePage(List<Genre> genreList, List<String> tagList, Exam exam, int questionFormat,
				List<BigQuestion> bigQuestionList) {
			this.genreList = genreList;
			this.tagList = tagList;
			this.exam = exam;
			this.questionFormat = questionFormat;
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

		public int getQuestionFormat() {
			return questionFormat;
		}
}

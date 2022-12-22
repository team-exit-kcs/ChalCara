package model.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ExamCreatePage implements Serializable{
	/*要素
	 * ジャンルリスト
	 * タグリスト
	 * 登録試験概要
	 * 選択大問番号　初期値　１
	 * 登録試験問題
	 */
	final private List<Genre> genreList;
	final private List<String> tagList;
	final private EntryExam entryExam;
	final private List<BigQuestion> bigQuestionList;
	
	public ExamCreatePage(List<Genre> genreList, List<String> tagList) {
		this.genreList = genreList;
		this.tagList = tagList;
		this.entryExam = null;
		this.bigQuestionList = new ArrayList<>();
	}

	public ExamCreatePage(ExamCreatePage examCreatePage, EntryExam entryExam) {
		this.genreList = examCreatePage.getGenreList();
		this.tagList = examCreatePage.getTagList();
		this.entryExam = entryExam;
		this.bigQuestionList = new ArrayList<>();
	}

	public ExamCreatePage(ExamCreatePage examCreatePage, List<BigQuestion> bigQuestion) {
		this.genreList = examCreatePage.getGenreList();
		this.tagList = examCreatePage.getTagList();
		this.entryExam = examCreatePage.getEntryExam();
		this.bigQuestionList = bigQuestion;
	}

	public ExamCreatePage(List<Genre> genreList, List<String> tagList, EntryExam entryExam, 
			List<BigQuestion> bigQuestionList) {
		this.genreList = genreList;
		this.tagList = tagList;
		this.entryExam = entryExam;
		this.bigQuestionList = bigQuestionList;
	}

	public List<Genre> getGenreList() {
		return genreList;
	}
	public List<String> getTagList() {
		return tagList;
	}

	public EntryExam getEntryExam() {
		return entryExam;
	}

	public List<BigQuestion> getBigQuestionList() {
		return bigQuestionList;
	}
	
}

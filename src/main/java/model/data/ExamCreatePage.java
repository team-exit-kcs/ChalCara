package model.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ExamCreatePage implements Serializable{
	/*要素
	 * ジャンルリスト
	 * タグリスト
	 * 登録試験概要
	 * 試験問題形式　大問０(初期値)　小問１
	 * 選択大問番号　初期値　１
	 * 登録試験問題
	 */
	final private List<Genre> genreList;
	final private List<String> tagList;
	final private EntryExam entryExam;
	final private int questionFormat;
	final private List<BigQuestion> bigQuestionList;
	
	public ExamCreatePage(List<Genre> genreList, List<String> tagList) {
		this.genreList = genreList;
		this.tagList = tagList;
		this.entryExam = null;
		this.questionFormat = 0;
		this.bigQuestionList = new ArrayList<>();
	}

	public ExamCreatePage(ExamCreatePage examCreatePage, EntryExam entryExam, int questionFormat) {
		this.genreList = examCreatePage.getGenreList();
		this.tagList = examCreatePage.getTagList();
		this.entryExam = entryExam;
		this.questionFormat = questionFormat;
		this.bigQuestionList = new ArrayList<>();
	}

	public ExamCreatePage(ExamCreatePage examCreatePage, List<BigQuestion> bigQuestion) {
		this.genreList = examCreatePage.getGenreList();
		this.tagList = examCreatePage.getTagList();
		this.entryExam = examCreatePage.getEntryExam();
		this.questionFormat = examCreatePage.getQuestionFormat();
		this.bigQuestionList = bigQuestion;
	}

	public ExamCreatePage(List<Genre> genreList, List<String> tagList, EntryExam entryExam, int questionFormat,
			List<BigQuestion> bigQuestionList) {
		this.genreList = genreList;
		this.tagList = tagList;
		this.entryExam = entryExam;
		this.questionFormat = questionFormat;
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

	public int getQuestionFormat() {
		return questionFormat;
	}
	
}

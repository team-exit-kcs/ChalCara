package model.data;

import java.io.Serializable;
import java.util.List;

public class ExamCreatePage implements Serializable{
	/*要素
	 * ジャンルリスト
	 * タグリスト
	 */
	final private List<Genre> genreList;
	final private List<String> tagList;
	
	public ExamCreatePage(List<Genre> genreList, List<String> tagList) {
		this.genreList = genreList;
		this.tagList = tagList;
	}
	
	public List<Genre> getGenreList() {
		return genreList;
	}
	public List<String> getTagList() {
		return tagList;
	}
	
}

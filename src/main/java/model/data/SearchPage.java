package model.data;

import java.io.Serializable;
import java.util.List;

import dao.GenreDAO;
import dao.TagDAO;

public class SearchPage implements Serializable {
	/*要素 
	 * ジャンルリスト
	 * タグリスト
	 */
	
	final private List<Genre> genreList;
	final private List<String> tagList;
	
	public SearchPage() {
		TagDAO td = new TagDAO();
		GenreDAO gd = new GenreDAO();
		this.genreList = gd.findAll();
		this.tagList = td.findAll();
	}

	public List<Genre> getGenreList() {
		return genreList;
	}

	public List<String> getTagList() {
		return tagList;
	}
	
}

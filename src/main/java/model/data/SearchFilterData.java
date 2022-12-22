package model.data;

import java.io.Serializable;
import java.util.List;

public class SearchFilterData implements Serializable {
	/*要素 
	 * 絞り込みジャンルIDリスト
	 * 絞り込みタグリスト
	 * 絞り込みユーザリスト
	 * 絞り込み問題形式　指定なし−１　大問０　小問１
	 */
	
	final private List<Integer> genreIDFilterList;
	final private List<String> tagFilterList;
	final private List<String> userIDFilterList;
	final private int examFormatFilter;
	
	public SearchFilterData(List<Integer> genreIDFilterList, List<String> tagFilterList, List<String> userIDFilterList,
			int examFormatFilter) {
		this.genreIDFilterList = genreIDFilterList;
		this.tagFilterList = tagFilterList;
		this.userIDFilterList = userIDFilterList;
		this.examFormatFilter = examFormatFilter;
	}

	public List<Integer> getGenreIDFilterList() {
		return genreIDFilterList;
	}

	public List<String> getTagFilterList() {
		return tagFilterList;
	}

	public List<String> getUserIDFilterList() {
		return userIDFilterList;
	}

	public int getExamFormatFilter() {
		return examFormatFilter;
	}
}

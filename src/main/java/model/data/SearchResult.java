package model.data;

import java.io.Serializable;
import java.util.List;

public class SearchResult implements Serializable {
	/*要素
	 * 1ページの表示数
	 * 現在のページ
	 * 最大ページ数
	 * 検索結果リスト
	 * 検索区分
	 * 検索ワード
	 */
	final private int STEP = 20; //１ページの表示数
	
	final private int page;
	final private int maxPage;
	final private List<Search> resultList;
	final private int searchFormat;
	final private String searchWord;
	
	
	public SearchResult(int page, List<Search> resultList, int searchFormat, String searchWord) {
		this.page = page;
		this.maxPage = (resultList.size() / (this.STEP + 1)) + 1;
		this.resultList = resultList;
		this.searchFormat = searchFormat;
		this.searchWord = searchWord;
	}

	public int getSTEP() {
		return STEP;
	}

	public int getPage() {
		return page;
	}

	public List<Search> getResultList() {
		return resultList;
	}

	public int getMaxPage() {
		return maxPage;
	}

	public int getSearchFormat() {
		return searchFormat;
	}

	public String getSearchWord() {
		return searchWord;
	}
	
}

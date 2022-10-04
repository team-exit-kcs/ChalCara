package model.data;

import java.io.Serializable;
import java.util.List;

public class SearchResult implements Serializable {
	final private int STEP = 20; //１ページの表示数
	
	final private int page;
	final private List<Search> resultList;
	
	public SearchResult(int page, List<Search> resultList) {
		this.page = page;
		this.resultList = resultList;
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
	
}

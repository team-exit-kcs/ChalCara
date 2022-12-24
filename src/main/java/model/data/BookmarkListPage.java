package model.data;

import java.io.Serializable;
import java.util.List;

public class BookmarkListPage implements Serializable {

	/*要素
	 * 1ページの表示数
	 * 現在のページ
	 * 最大ページ数
	 * リスト
	 */
	final private int STEP = 20; //１ページの表示数
	
	final private int page;
	final private int maxPage;
	final private List<Exam> bookmarkList;
	
	

	public BookmarkListPage(int page, List<Exam> bookmarkList) {
		super();
		this.page = page;
		this.maxPage = (int) Math.ceil(bookmarkList.size() / (double)this.STEP);
		this.bookmarkList = bookmarkList;
	}

	public int getSTEP() {
		return STEP;
	}

	public int getPage() {
		return page;
	}

	public int getMaxPage() {
		return maxPage;
	}

	public List<Exam> getBookmarkList() {
		return bookmarkList;
	}
}

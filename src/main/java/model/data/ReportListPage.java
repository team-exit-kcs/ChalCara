package model.data;

import java.io.Serializable;
import java.util.List;

public class ReportListPage implements Serializable {

	/*要素
	 * 1ページの表示数
	 * 現在のページ
	 * 最大ページ数
	 * リスト
	 */
	final private int STEP = 20; //１ページの表示数
	
	final private int page;
	final private int maxPage;
	final private List<Report> reportList;
	
	

	public ReportListPage(int page, List<Report> reportList) {
		super();
		this.page = page;
		this.maxPage = (int) Math.ceil(reportList.size() / (double)this.STEP);
		this.reportList = reportList;
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

	public List<Report> getReportList() {
		return reportList;
	}
}

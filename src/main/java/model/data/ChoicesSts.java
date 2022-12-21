package model.data;

import java.io.Serializable;

public class ChoicesSts implements Serializable {
	/*要素
	 * 試験ID
	 * 大問ID
	 * 小問ID
	 * 選択肢ID
	 * 選択肢
	 */
	final private Choices chioces;
	final private double selectRate;
	final private int ansCnt;

	public ChoicesSts(Choices chioces, double selectRate, int ansCnt) {
		super();
		this.chioces = chioces;
		this.selectRate = selectRate;
		this.ansCnt = ansCnt;
	}

	public int getAnsCnt() {
		return ansCnt;
	}

	public Choices getChioces() {
		return chioces;
	}

	public double getSelectRate() {
		return selectRate;
	}
}

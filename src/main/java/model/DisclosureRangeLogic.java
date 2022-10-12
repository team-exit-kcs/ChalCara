package model;

public class DisclosureRangeLogic {
	private final int OPEN = 0;
	private final int LIMITED = 1;
	private final int CLOSE = 2;
	
	public boolean isLimited(int disclosureRange) {
		return this.LIMITED == disclosureRange;
	}
	
	public boolean isNotClose(int disclosureRange) {
		return this.CLOSE != disclosureRange;
	}

	public int getOPEN() {
		return OPEN;
	}

	public int getLIMITED() {
		return LIMITED;
	}

	public int getCLOSE() {
		return CLOSE;
	}
	
	
}

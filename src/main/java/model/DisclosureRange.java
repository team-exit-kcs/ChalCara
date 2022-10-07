package model;

public class DisclosureRange {
	public final int OPEN = 0;
	public final int LIMITED = 1;
	public final int CLOSE = 2;
	
	public boolean isLimited(int disclosureRange) {
		return this.LIMITED == disclosureRange;
	}
	
	public boolean isNotClose(int disclosureRange) {
		return this.CLOSE != disclosureRange;
	}
}

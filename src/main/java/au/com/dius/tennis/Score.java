package au.com.dius.tennis;

public enum Score {
	ZERO("0"), FIFTEEN("15"), THIRTY("30"), FORTY("40");

	private Score(String text) {
		this.text = text;
	}

	private String text;

	@Override
	public String toString() {
		return text;
	}

	/**
	 * Returns score following the current one. Eg. FIFTEEN.addPoint() returns
	 * THIRTY
	 */
	public Score addPoint() {
		if (isMax()) {
			return this;
		} else {
			return values()[ordinal() + 1];
		}
	}

	/**
	 * Returns true on last deffined (maximum) score only. Otherwise returns
	 * false
	 */
	public boolean isMax() {
		return ordinal() == values().length - 1;
	}

	/**
	 * Returns difference in point between two scores
	 */
	public int getPointDiff(Score score) {
		return Math.abs(this.ordinal() - score.ordinal());
	}
}
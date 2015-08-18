public enum Heading {
	N, E, S, W;

	private int value;

	private Heading (){
		this.value = ordinal();
	}

	public static int normalise(int prenormalised) {
		int headingSize = Heading.values().length;
		return prenormalised % headingSize < 0 ? ((prenormalised % headingSize) + headingSize) : prenormalised % headingSize;
	}

	public int getValue() {
		return value;
	}
}
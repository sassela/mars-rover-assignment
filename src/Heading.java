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

	static Heading parseHeading(String position) {
		// TODO catch exception.
		return Heading.valueOf(position.split(" ")[2]);
	}

	public int getValue() {
		return value;
	}
}
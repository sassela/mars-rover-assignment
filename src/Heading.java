/**
 * @author Abby Sassel
 * @since 18.08.2015
 *
 * ThoughtWorks Mars Rover Assignment
 * - Deploy and control a squad of robotic rovers on a plateau on Mars
 * - Input plateau size, rover position and a sequence of instructions
 * - Receive updated rover position as a result
 */

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
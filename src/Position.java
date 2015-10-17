/**
 * @author Abby Sassel
 * @since 18.08.2015
 *
 * ThoughtWorks Mars Rover Assignment
 * - Deploy and control a squad of robotic rovers on a plateau on Mars
 * - Input plateau size, rover position and a sequence of instructions
 * - Receive updated rover position as a result
 */

public class Position {

	Heading heading;
	Coordinates coordinates;

	Position(Coordinates coordinates, Heading heading) {
		this.coordinates = coordinates;
		this.heading = heading;
	}

	@Override
	public String toString() {
		return coordinates.toString() + " " + heading.toString();
	}

	static Position parsePosition(String s) {
		String[] positionArray = s.split(" ");
		Coordinates coord = Coordinates.parseCoordinates(positionArray[0], positionArray[1]);
		Heading head = Heading.valueOf(positionArray[2]);
		return new Position(coord, head);
	}

	/**
	 * Checks the user input is valid according to the plateau size and required format
	 * @param input user input
	 * @return variable indicating whether the format is valid
	 */
	static boolean positionInputValid(Plateau plateau, String input) {
		int inputX = parsePosition(input).getCoordinates().getX();
		int inputY = parsePosition(input).getCoordinates().getY();
		Heading inputHeading = parsePosition(input).getHeading();

		boolean inputXIsValid = inputX < plateau.getWidth();
		boolean inputYIsValid = inputY < plateau.getHeight();

		boolean inputHeadingIsValid = false;
		for (Heading heading : Heading.values()) if (inputHeading == heading) inputHeadingIsValid = true;

		return (inputXIsValid && inputYIsValid && inputHeadingIsValid);
	}

	public Coordinates getCoordinates() {
		return coordinates;
	}

	public Heading getHeading() {
		return heading;
	}
}

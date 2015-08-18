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

	Position() {
		this.coordinates = new Coordinates(0, 0);
		this.heading = Heading.N;
	}

	@Override
	public String toString() {
		return coordinates.toString() + " " + heading.toString();
	}

	Position parsePosition(String s) {
		String[] positionArray = s.split(" ");
		Coordinates coord = coordinates.parseCoordinates(positionArray[0], positionArray[1]);
		Heading head = Heading.valueOf(positionArray[2]);
		return new Position(coord, head);
	}

	public Coordinates getCoordinates() {
		return coordinates;
	}

	public Heading getHeading() {
		return heading;
	}
}

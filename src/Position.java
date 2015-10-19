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

	public Coordinates getCoordinates() {
		return coordinates;
	}

	public Heading getHeading() {
		return heading;
	}
}

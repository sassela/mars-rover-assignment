/**
 * @author Abby Sassel
 * @since 18.08.2015
 *
 * ThoughtWorks Mars Rover Assignment
 * - Deploy and control a squad of robotic rovers on a plateau on Mars
 * - Input plateau size, rover position and a sequence of instructions
 * - Receive updated rover position as a result
 */

public class Coordinates {

	int x;
	int y;

	Coordinates(int x, int y) {
		this.x = x;
		this.y = y;
	}

	Coordinates parseCoordinates(String x, String y) {
		return new Coordinates(Integer.parseInt(x), Integer.parseInt(y));
	}

	@Override
	public String toString() {
		return x + " " + y;
	}

	public void incrementX() {
		this.x++;
	}

	public void incrementY() {
		this.y++;
	}

	public void decrementX() {
		this.x--;
	}

	public void decrementY() {
		this.y--;
	}

	public int getY() {
		return y;
	}

	public int getX() {
		return x;
	}

}

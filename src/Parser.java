/**
 * Created by abby on 19/10/15.
 */
public class Parser {

	//TODO add exceptions to all of these
	static Coordinates parseCoordinates(String x, String y) {
		return new Coordinates(Integer.parseInt(x), Integer.parseInt(y));
	}

	static Heading parseHeading(String s) {
		return Heading.valueOf(s.toUpperCase());
	}

	static Position parsePosition(String s) {
		String[] positionArray = s.split(" ");
		Coordinates coordinates = parseCoordinates(positionArray[0], positionArray[1]);
		Heading heading = parseHeading(positionArray[2]);
		return new Position(coordinates, heading);
	}

	static int[] parsePlateauSize(String[] s) {
		return new int[] {Integer.parseInt(s[0]), Integer.parseInt(s[1])};
	}
}

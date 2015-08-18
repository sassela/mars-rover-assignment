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
		// TODO catch exception.
		String[] positionArray = s.split(" ");
		Coordinates c = coordinates.parseCoordinates(positionArray[0], positionArray[1]);
		// TODO catch exception.
		Heading h = Heading.valueOf(positionArray[2]);
		return new Position(c, h);
	}

	public Coordinates getCoordinates() {
		return coordinates;
	}

	public Heading getHeading() {
		return heading;
	}
}

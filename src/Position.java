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
		int x = Integer.parseInt(positionArray[0]);
		int y = Integer.parseInt(positionArray[1]);
		Coordinates c = new Coordinates(x, y);
		// TODO catch exception.
		Heading h = Heading.valueOf(s.split(" ")[2]);
		return new Position(c, h);

	}
}

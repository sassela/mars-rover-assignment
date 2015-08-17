public class Coordinates {

	int x;
	int y;

	Coordinates(int x, int y) {
		this.x = x;
		this.y = y;
	}

	Coordinates parseCoordinates(String str) {
		// TODO catch exception.
		String[] positionArray = str.split(" ");
		x = Integer.parseInt(positionArray[0]);
		y = Integer.parseInt(positionArray[1]);
		return new Coordinates(x, y);
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

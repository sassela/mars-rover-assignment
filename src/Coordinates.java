public class Coordinates {

	int x;
	int y;

	Coordinates(int x, int y) {
		this.x = x;
		this.y = y;
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

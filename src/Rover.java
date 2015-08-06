import java.security.InvalidParameterException;

public class Rover {

	int[] location;
	int currentHeadingInt;
	String currentHeadingStr;
	String[] directions = {"N", "E", "S", "W"};

	public Rover(int[] location) {
		currentHeadingInt = 0;
	}

	public void turn(String direction) {
		try {
			switch (direction) {
				case "L":
					currentHeadingInt -= 1;
					break;
				case "R":
					currentHeadingInt += 1;
					break;
			}
		} catch (InvalidParameterException e) {
			System.err.println("Caught Exception: "
					+  e.getMessage());
		}
	}

	public int[] getLocation() {
		return location;
	}

	public void setLocation(int[] location) {
		this.location = location;
	}

	public String getCurrentHeadingStr() {
		currentHeadingStr = directions[currentHeadingInt];
		return currentHeadingStr;
	}
}

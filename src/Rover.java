import java.security.InvalidParameterException;

public class Rover {

	int[] currentLocation;
	int currentHeadingInt;
	String currentHeadingStr;
	String[] directions = {"N", "E", "S", "W"};

	public Rover(int[] location) {
		currentLocation = location;
		currentHeadingInt = 0;
	}

	public void move() {
		if(currentHeadingInt == 1 || currentHeadingInt == 3){
			this.currentLocation[0] += 1;
		} else this.currentLocation[1] += 1;

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

	public int[] getCurrentLocation() {
		return currentLocation;
	}

	public void setCurrentLocation(int[] currentLocation) {
		this.currentLocation = currentLocation;
	}

	public String getCurrentHeadingStr() {
		currentHeadingStr = directions[currentHeadingInt];
		return currentHeadingStr;
	}
}

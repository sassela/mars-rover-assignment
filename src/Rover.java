import java.security.InvalidParameterException;

public class Rover {

	int[] currentCoordinates;
	int currentHeadingInt;
	String currentHeadingStr;
	String[] directions = {"N", "E", "S", "W"};

	public Rover(int[] location) {
		currentCoordinates = location;
		currentHeadingInt = 0;
	}

	public void move() {
		if(currentHeadingInt == 1 || currentHeadingInt == 3){
			this.currentCoordinates[0] += 1;
		} else this.currentCoordinates[1] += 1;

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
			System.err.println("Caught Exception: " +  e.getMessage());
		}
	}

	public int[] getCurrentCoordinates() {
		return currentCoordinates;
	}

	public void setCurrentCoordinates(int[] currentCoordinates) {
		this.currentCoordinates = currentCoordinates;
	}

	public String getCurrentHeadingStr() {
		currentHeadingStr = directions[currentHeadingInt];
		return currentHeadingStr;
	}
}

import java.security.InvalidParameterException;

public class Rover {
	Plateau plateau;
	int[] currentCoordinates;
	int currentHeading;
	String currentPosition;

	public Rover(Plateau plateau, int[] location) {
		this.plateau = plateau;
		currentCoordinates = location;
		currentHeading = 0;
	}

	public void instruct(String instructionsInput) {
		String[] instructions = instructionsInput.split(" ");
		for (String instruction : instructions) {
			switch (instruction) {
				case "M":
					this.move();
					break;
				default:
					this.turn(instruction);
					break;
			}
		}
	}

	public void move() {
		if(currentHeading == 1 || currentHeading == 3){
			if(currentCoordinates[0] >= 0 && currentCoordinates[0] < plateau.getSize()[0]) {
				this.currentCoordinates[0]++;
			}
		} else if(currentCoordinates[1] >= 0 && currentCoordinates[1] < plateau.getSize()[1]) {
			this.currentCoordinates[1]++;
		}

	}

	public void turn(String direction) {
		try {
			switch (direction) {
				case "L":
					currentHeading--;
					break;
				case "R":
					currentHeading++;
					break;
			}
		} catch (InvalidParameterException e) {
			System.err.println("Caught Exception: " +  e.getMessage());
		}
	}

	public String parseCoordinates(int[] array) {
		return array[0] + " " + array[1];
	}

	public int[] getCurrentCoordinates() {
		return currentCoordinates;
	}

	public void setCurrentCoordinates(int[] currentCoordinates) {
		this.currentCoordinates = currentCoordinates;
	}

	public int getCurrentHeading() {
		return currentHeading;
	}

	public String parseHeading(int currentHeading) {
		String[] directions = {"N", "E", "S", "W"};
		return directions[currentHeading];
	}

	public String getCurrentPosition() {
		currentPosition = parseCoordinates(currentCoordinates) + " " + parseHeading(currentHeading);
		return currentPosition;
	}
}

import java.security.InvalidParameterException;

public class Rover {
	Plateau plateau;
	int[] currentCoordinates;
	int currentHeading;
	String currentPosition;
	String[] headingsOptions;

	public Rover(Plateau plateau, int[] currentCoordinates, int currentHeading) {
		this.plateau = plateau;
		this.currentCoordinates = currentCoordinates;
		this.currentHeading = currentHeading;
		headingsOptions = new String[] {"N", "E", "S", "W"};
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
		int headingIndex = (currentHeading < 0 ? (currentHeading % headingsOptions.length) + 4 : currentHeading % headingsOptions.length);
		return headingsOptions[headingIndex];
	}

	public String getCurrentPosition() {
		currentPosition = parseCoordinates(currentCoordinates) + " " + parseHeading(currentHeading);
		return currentPosition;
	}
}

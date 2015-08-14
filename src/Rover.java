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
		//TODO enum type
		headingsOptions = new String[] {"N", "E", "S", "W"};
	}

	public void instruct(String instructionsInput) {
		char[] instructions = instructionsInput.toCharArray();
		for (char instruction : instructions) {
			switch (instruction) {
				case 'M':
					this.move();
					break;
				default:
					this.turn(instruction);
					break;
			}
		}
	}

	public void move() {
		if (isWithinPlateauLimits()) {
			String heading = parseHeading(currentHeading);
			switch (heading) {
				case "N":
					this.currentCoordinates[1]++;
					break;
				case "E":
					this.currentCoordinates[0]++;
					break;
				case "S":
					this.currentCoordinates[1]--;
					break;
				case "W":
					this.currentCoordinates[0]--;
					break;
			}
		}
	}

	public void turn(char direction) {
		try {
			switch (direction) {
				case 'L':
					currentHeading--;
					break;
				case 'R':
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
		int headingIndex = (currentHeading % headingsOptions.length < 0 ? ((currentHeading % headingsOptions.length) + 4) : currentHeading % headingsOptions.length);
		return headingsOptions[headingIndex];
	}

	public String getCurrentPosition() {
		currentPosition = parseCoordinates(currentCoordinates) + " " + parseHeading(currentHeading);
		return currentPosition;
	}

	private boolean isWithinPlateauLimits() {
		boolean withinLimits = false;
		String heading = parseHeading(currentHeading);
		switch (heading) {
			case "N":
				if (currentCoordinates[1] < this.plateau.getSize()[1]) {
					withinLimits = true;
				}
				break;
			case "E":
				if (currentCoordinates[0] < this.plateau.getSize()[0]) {
					withinLimits = true;
				}
				break;
			case "S":
				if (currentCoordinates[1] > 0) {
					withinLimits = true;
				}
				break;
			case "W":
				if (currentCoordinates[0] > 0) {
					withinLimits = true;
				}
				break;
		}
		return withinLimits;
	}
}

import java.security.InvalidParameterException;

public class Rover {
	Plateau plateau;
	int[] currentCoordinates;
	Heading currentHeading;
	String currentPosition;

	public Rover(Plateau plateau, int[] currentCoordinates, Heading currentHeading) {
		this.plateau = plateau;
		this.currentCoordinates = currentCoordinates;
		this.currentHeading = currentHeading;
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
			switch (currentHeading) {
				case N:
					this.currentCoordinates[1]++;
					break;
				case E:
					this.currentCoordinates[0]++;
					break;
				case S:
					this.currentCoordinates[1]--;
					break;
				case W:
					this.currentCoordinates[0]--;
					break;
			}
		}
	}

	public void turn(char direction) {
		int heading = this.currentHeading.getValue();
		try {
			switch (direction) {
				case 'L':
					heading--;
					break;
				case 'R':
					heading++;
					break;
			}
			this.currentHeading = Heading.values()[Heading.normalise(heading)];

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

	public Heading getCurrentHeading() {
		return currentHeading;
	}

	public String getCurrentPosition() {
		currentPosition = parseCoordinates(currentCoordinates) + " " + currentHeading.toString();
		return currentPosition;
	}

	private boolean isWithinPlateauLimits() {
		boolean withinLimits = false;
		switch (currentHeading) {
			case N:
				if (currentCoordinates[1] < this.plateau.getSize()[1]) {
					withinLimits = true;
				}
				break;
			case E:
				if (currentCoordinates[0] < this.plateau.getSize()[0]) {
					withinLimits = true;
				}
				break;
			case S:
				if (currentCoordinates[1] > 0) {
					withinLimits = true;
				}
				break;
			case W:
				if (currentCoordinates[0] > 0) {
					withinLimits = true;
				}
				break;
		}
		return withinLimits;
	}
}

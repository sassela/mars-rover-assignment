import java.security.InvalidParameterException;

public class Rover {
	Plateau plateau;
	Coordinates currentCoordinates;
	Heading currentHeading;
	String currentPosition;

	public Rover(Plateau plateau, Coordinates currentCoordinates, Heading currentHeading) {
		this.plateau = plateau;
		this.currentCoordinates = currentCoordinates;
		this.currentHeading = currentHeading;
	}

	// TODO use Command pattern
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
					this.currentCoordinates.incrementY();
					break;
				case E:
					this.currentCoordinates.incrementX();
					break;
				case S:
					this.currentCoordinates.decrementY();
					break;
				case W:
					this.currentCoordinates.decrementX();
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

	public Coordinates getCurrentCoordinates() {
		return currentCoordinates;
	}

	public Heading getCurrentHeading() {
		return currentHeading;
	}

	public String getCurrentPosition() {
		currentPosition = currentCoordinates.toString() + " " + currentHeading.toString();
		return currentPosition;
	}

	private boolean isWithinPlateauLimits() {
		boolean withinLimits = false;
		int x = currentCoordinates.getX();
		int y = currentCoordinates.getY();

		switch (currentHeading) {
			case N:
				if (y < this.plateau.getSize()[1]) withinLimits = true;
				break;
			case E:
				if (x < this.plateau.getSize()[0]) withinLimits = true;
				break;
			case S:
				if (y > 0) withinLimits = true;
				break;
			case W:
				if (x > 0) withinLimits = true;
				break;
		}
		return withinLimits;
	}
}

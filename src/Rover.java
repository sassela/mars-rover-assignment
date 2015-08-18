public class Rover {
	Plateau plateau;
	Coordinates currentCoordinates;
	Heading currentHeading;
	Position currentPosition;

	public Rover(Plateau plateau, Position currentPosition) {
		this.plateau = plateau;
		this.currentCoordinates = currentPosition.getCoordinates();
		this.currentHeading = currentPosition.getHeading();
		this.currentPosition = currentPosition;
	}

	public void instruct(String instructionsInput) {
		char[] instructions = instructionsInput.toCharArray();
		try {
			for (char instruction : instructions) {
				switch (Character.toUpperCase(instruction)) {
					case 'M':
						this.move();
						break;
					case 'L':case 'R':
						this.turn(instruction);
						break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
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
			updatePosition();
		}
	}

	public void turn(char direction) {
		int headingValue = this.currentHeading.getValue();
			switch (Character.toUpperCase(direction)) {
				case 'L':
					headingValue--;
					break;
				case 'R':
					headingValue++;
					break;
			}
			this.currentHeading = Heading.values()[Heading.normalise(headingValue)];
			updatePosition();
	}

	public Coordinates getCurrentCoordinates() {
		return currentCoordinates;
	}

	public Heading getCurrentHeading() {
		return currentHeading;
	}

	public String getCurrentPosition() {
		return currentPosition.toString();
	}

	public void updatePosition() {
		this.currentPosition = new Position(currentCoordinates, currentHeading);
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

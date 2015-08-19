/**
 * @author Abby Sassel
 * @since 18.08.2015
 *
 * ThoughtWorks Mars Rover Assignment
 * - Deploy and control a squad of robotic rovers on a plateau on Mars
 * - Input plateau size, rover position and a sequence of instructions
 * - Receive updated rover position as a result
 */

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

	/**
	 * Breaks down a series of instructions and determines what action the rover should take for each instruction
	 * @param instructionsInput series of instructions
	 */
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

	/**
	 * Moves the rover forward one grid point depending on its current heading
	 */
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

	/**
	 * Rotates the rover left or right
	 * @param direction updated rover direction
	 */
	public void turn(char direction) {
		int angleUnit = this.currentHeading.getValue();
		switch (Character.toUpperCase(direction)) {
			case 'L':
				angleUnit--;
				break;
			case 'R':
				angleUnit++;
				break;
		}
		// converts the angle unit integer value into the corresponding heading
		this.currentHeading = Heading.values()[Heading.normalise(angleUnit)];
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

	/**
	 * Checks that the carrying out of an instruction does not take the rover outside of the plateau limits
	 * @return variable that indicates whether the above would occur
	 */
	private boolean isWithinPlateauLimits() {
		boolean withinLimits = false;
		int x = currentCoordinates.getX();
		int y = currentCoordinates.getY();

		switch (currentHeading) {
			case N:
				if (y < this.plateau.getHeight()) withinLimits = true;
				break;
			case E:
				if (x < this.plateau.getWidth()) withinLimits = true;
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

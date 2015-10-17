/**
 * @author Abby Sassel
 * @since 18.08.2015
 *
 * ThoughtWorks Mars Rover Assignment
 * - Deploy and control a squad of robotic rovers on a plateau on Mars
 * - Input plateau size, rover position and a sequence of instructions
 * - Receive updated rover position as a result
 */

import java.util.ArrayList;

public class Plateau {

	int[] size;
	ArrayList<Rover> rovers;

	public Plateau(int[] size) {
		this.size = size;
		rovers = new ArrayList<>();
	}

	public void setSize(int[] size) {
		// returns 0 if either coordinate is negative
		for(int i = 0; i < size.length; i++){
			size[i] = size[i] < 0 ? 0 : size[i];
		}
		this.size = size;
	}


	static Plateau setPlateauSizeFromInput(String[] sizeInput) {
		int width = Integer.parseInt(sizeInput[0]);
		int height = Integer.parseInt(sizeInput[1]);
		return new Plateau(new int[] {width, height});
	}

	boolean roverExistsAt(String position) {
		return this.getRoverAt(position) != null;
	}

	Rover deployRover(String position){
		Rover rover = new Rover(this, Position.parsePosition(position));
		this.addRover(rover);
		return rover;
	}

	public int getWidth() {
		return size[0];
	}

	public int getHeight() {
		return size[1];
	}

	public void addRover(Rover rover) {
		rovers.add(rover);
	}

	public Rover getRoverAt(String position) {
		Rover roverAtPosition = null;
		for (Rover rover : rovers) {
			if (rover.getCurrentPosition().equals(position)) {
				roverAtPosition = rover;
			}
		}
		return roverAtPosition;
	}
}
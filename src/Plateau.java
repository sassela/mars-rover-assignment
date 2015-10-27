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
	ArrayList<String> beacons;

	public Plateau(int[] size) {
		this.size = size;
		rovers = new ArrayList<>();
		beacons = new ArrayList<>();
	}

	public void setSize(int[] size) {
		// returns 0 if either coordinate is negative
		for(int i = 0; i < size.length; i++){
			size[i] = size[i] < 0 ? 0 : size[i];
		}
		this.size = size;
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

	Rover deployRoverAt(String position) {
		Rover rover = new Rover(this, Parser.parsePosition(position));
		this.addRover(rover);
		return rover;
	}

	void setBeaconAt(Coordinates c) {
		String coordinates = c.toString();
		beacons.add(coordinates);
	}

	boolean beaconExistsAt(Coordinates c) {
		String coordinates = c.toString();
		return beacons.contains(coordinates);
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

}
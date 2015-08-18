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
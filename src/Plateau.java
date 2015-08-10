import java.util.ArrayList;

public class Plateau {

	int[] size;
	ArrayList<Rover> rovers;

	public Plateau(int[] size) {
		this.size = size;
		rovers = new ArrayList<Rover>();
	}

	public int[] getSize() {
		return size;
	}

	public void setSize(int[] size) {
		// returns 0 if either coordinate is negative
		for(int i = 0; i < size.length; i++){
			if(size[i] < 0){
				size[i] = 0;
			}
		}
		this.size = size;
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
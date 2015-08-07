import java.util.ArrayList;

public class Plateau {

	int[] size;
	ArrayList<String> roverPositions;
	String[] directions;

	public Plateau(int[] size) {
		this.size = size;
		roverPositions = new ArrayList<String>();
		directions = new String[] {"N", "E", "S", "W"};
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

	public void deployRover(String position) {
		roverPositions.add(position);
	}

	public boolean isRoverAt(String position) {
		for (int i = 0; i < roverPositions.size(); i++) {
			if (roverPositions.get(i).equals(position)) {
				return true;
			}
		}
		return false;
	}

	public Rover parsePosition(String position) {
		String[] positionArray = position.split(" ");
		int[] coordinates = {Integer.parseInt(positionArray[0], Integer.parseInt(positionArray[1]))};
		int heading = Integer.parseInt(positionArray[2]);
		return(new Rover(this, coordinates, heading));
	}

	public String[] getDirections() {
		return directions;
	}
}
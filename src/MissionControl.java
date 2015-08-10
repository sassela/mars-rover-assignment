public class MissionControl {

	Plateau plateau;
	String[] headingsOptions = new String[] {"N", "E", "S", "W"};

	public void deployRover(Plateau plateau, String position){
		if(plateau.getRoverAt(position) == null) {
			Rover rover = createRoverAtPosition(position);
			plateau.addRover(rover);
		}
	}

	public Rover createRoverAtPosition(String position) {
		String[] positionArray = position.split(" ");
		int[] coordinates = new int[]{Integer.parseInt(positionArray[0]),Integer.parseInt(positionArray[1])};
		int heading = parseHeading(positionArray[2]);
		Rover rover = new Rover(plateau, coordinates, heading);
		return(rover);
	}

	//todo delete
	public int parseHeading(String currentHeading) {
		int headingInt = 0;
		for(int i = 0; i < currentHeading.length(); i++){
			if (headingsOptions[i].equals(currentHeading)) headingInt = i;
		}
		return headingInt;
	}

}

import java.util.Arrays;
import java.util.Scanner;

public class MissionControl {

	static Plateau plateau;
	//TODO enum type
	static String[] headingsOptions = new String[] {"N", "E", "S", "W"};


	public static void main (String[] args){
		Scanner in = new Scanner(System.in);
		System.out.println("Welcome to the Mars Rover Mission Control. Enter the desired plateau size, in the format \"x y\"");
		String plateauSizeStr = in.nextLine();
		String[] plateauSize = plateauSizeStr.split(" ");
		plateau = new Plateau(new int[] {Integer.parseInt(plateauSize[0]), Integer.parseInt(plateauSize[1])});
		System.out.println(Arrays.toString(plateau.getSize()));
		System.out.println("Plateau size had been set as "+plateau.getSize()[0]+" "+plateau.getSize()[1]+".");
		// TODO refactor this abomination.
		while(true){
			System.out.println("Enter the rover's position eg. \"1 2 N\"");
			String positionString = in.nextLine();
			System.out.println("Enter the rover's instructions eg. \"LMLMLMLMM\"");
			String instructionsString = in.nextLine();
			System.out.println(positionString+" "+instructionsString);
			deployRover(plateau, positionString);
			Rover r = plateau.getRoverAt(positionString);
			r.instruct(instructionsString);
			System.out.println("Rover position: " + r.getCurrentPosition());
		}
	}

	public static void deployRover(Plateau plateau, String position){
		if(plateau.getRoverAt(position) == null) {
			Rover rover = createRoverAtPosition(position);
			plateau.addRover(rover);
		}
	}

	public static Rover createRoverAtPosition(String position) {
		// TODO create Position class
		String[] positionArray = position.split(" ");
		int[] coordinates = new int[]{Integer.parseInt(positionArray[0]),Integer.parseInt(positionArray[1])};
		int heading = parseHeading(positionArray[2]);
		return new Rover(plateau, coordinates, heading);
	}

	//todo delete or rename
	public static int parseHeading(String currentHeading) {
		int headingInt = 0;
		for(int i = 0; i < headingsOptions.length; i++){
			if (headingsOptions[i].equals(currentHeading)) headingInt = i;
		}
		return headingInt;
	}

}

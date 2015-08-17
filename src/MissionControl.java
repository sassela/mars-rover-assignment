import java.util.Scanner;

public class MissionControl {

	static Plateau plateau;
	static Scanner in = new Scanner(System.in);


	public static void main (String[] args){
		printWelcomeMessage();
		setPlateauSize(requestPlateauSizeInput());
		do { runMission(); } while(!missionTerminated());
		in.close();
		printClosingMessage();
	}

	private static void printWelcomeMessage() {
		System.out.println("Welcome to the Mars Rover Mission Control. Enter \"X\" at any point to terminate the mission\"");
	}

	private static void printClosingMessage() {
		System.out.println("Mission Terminated");
	}

	private static String[] requestPlateauSizeInput(){
		System.out.println("Enter the desired plateau size, in the format \"x y\". ");
		return in.nextLine().split(" ");
	}

	private static void setPlateauSize(String[] sizeInput) {
		int width = Integer.parseInt(sizeInput[0]);
		int height = Integer.parseInt(sizeInput[1]);
		plateau = new Plateau(new int[] {width, height});
		System.out.println("Plateau size had been set as "+plateau.getSize()[0]+" by "+plateau.getSize()[1]+".");
	}

	private static void runMission() {
		System.out.println("Enter the rover's position eg. \"1 2 N\"");
		String positionInput = in.nextLine();
		System.out.println("Enter the rover's instructions eg. \"LMLMLMLMM\"");
		String instructionInput = in.nextLine();
		// deploy a new rover at the given position if none exists there already
		Rover existingRover = plateau.getRoverAt(positionInput);
		Rover rover = existingRover == null ? deployRover(plateau, positionInput) : existingRover;
		rover.instruct(instructionInput);
		System.out.println("Rover moved from: " + positionInput + " to " + rover.getCurrentPosition());
	}

	private static boolean missionTerminated() {
		return in.nextLine().equals("X");
	}

	static Rover deployRover(Plateau plateau, String position){
		Rover rover = createRoverAtPosition(position);
		plateau.addRover(rover);
		return rover;
	}

	private static Rover createRoverAtPosition(String position) {
		// TODO create Position class. catch exception. split into position parsing method
		String[] positionArray = position.split(" ");
		int[] coordinates = new int[]{Integer.parseInt(positionArray[0]),Integer.parseInt(positionArray[1])};
		Heading heading = Heading.valueOf(positionArray[2]);
		return new Rover(plateau, coordinates, heading);
	}
}

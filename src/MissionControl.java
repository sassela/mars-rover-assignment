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
		System.out.println("Welcome to the Mars Rover Mission Control.");
	}

	private static void printClosingMessage() {
		System.out.println("Mission Terminated");
	}

	private static String[] requestPlateauSizeInput(){
		String input;
		do {
			System.out.println("Enter the desired plateau size, in the format \"x y\". ");
			input = in.nextLine();
		} while (!(input.matches("^\\d+\\s\\d+")));
		String[] size = input.split(" ");
		return size;
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
		String instructionInput;
		do {
			System.out.println("Enter the rover's instructions eg. \"LMLMLMLMM\"");
			instructionInput = in.nextLine();
		} while (!instructionInputValid(instructionInput));

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
		Rover rover = new Rover(plateau, new Position().parsePosition(position));
		plateau.addRover(rover);
		return rover;
	}

	private static boolean instructionInputValid(String input) {
		return input.matches("^[a-zA-Z]+$");
	}
}

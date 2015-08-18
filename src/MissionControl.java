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
		} while (!plateauSizeInputValid(input));
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
		String positionInput = requestPositionInput();
		String instructionInput = requestInstructionInput();
		// deploy a new rover at the given position if none exists there already
		Rover rover = roverExistsAt(positionInput) ? plateau.getRoverAt(positionInput) : deployRover(plateau, positionInput);
		rover.instruct(instructionInput);
		System.out.println("Rover moved from: " + positionInput + " to " + rover.getCurrentPosition());
		System.out.println("Press \"X\" to terminate mission or any other key to run again");
	}

	private static boolean missionTerminated() {
		return in.nextLine().equals("X");
	}

	private static String requestPositionInput() {
		String positionInput;
		do {
			System.out.println("Enter the rover's position eg. \"1 2 N\"");
			positionInput = in.nextLine();
		} while (!positionInputValid(positionInput));
		return positionInput;
	}

	private static String requestInstructionInput() {
		String instructionInput;
		do {
			System.out.println("Enter the rover's instructions eg. \"LMLMLMLMM\"");
			instructionInput = in.nextLine();
		} while (!instructionInputValid(instructionInput));
		return instructionInput;
	}

	private static boolean roverExistsAt(String position) {
		return plateau.getRoverAt(position) != null;
	}

	static Rover deployRover(Plateau plateau, String position){
		Rover rover = new Rover(plateau, new Position().parsePosition(position));
		plateau.addRover(rover);
		return rover;
	}

	private static boolean plateauSizeInputValid(String input) {
		return input.matches("^\\d+\\s\\d+$");
	}

	private static boolean positionInputValid(String input) {
		String headingOptions = "";
		int width = plateau.getSize()[0];
		int height = plateau.getSize()[1];
		for(Heading heading : Heading.values()){
			headingOptions += heading.toString();
		}
		return input.matches("^[0-"+width+"]+\\s[0-"+height+"]+\\s["+headingOptions+"]$");
	}

	private static boolean instructionInputValid(String input) {
		return input.matches("^[LRMlrm]+$");
	}
}

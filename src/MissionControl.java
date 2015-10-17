/**
 * @author Abby Sassel
 * @since 18.08.2015
 *
 * ThoughtWorks Mars Rover Assignment
 * - Deploy and control a squad of robotic rovers on a plateau on Mars
 * - Input plateau size, rover position and a sequence of instructions
 * - Receive updated rover position as a result
 */

import java.util.Scanner;

public class MissionControl {

	static Plateau plateau;
	static Scanner in = new Scanner(System.in);

	public static void main (String[] args){
		printUserMessage("welcome");
		plateau = Plateau.setPlateauSizeFromInput(requestPlateauSizeInput());
		printUserMessage("plateau size");
		do { runMission(); } while(!missionTerminated());
		in.close();
		printUserMessage("close");
	}

	private static void printUserMessage(String userMessageType) {
		switch (userMessageType) {
			case "welcome":
				System.out.println("Welcome to the Mars Rover Mission Control.");
				break;
			case "close":
				System.out.println("Mission Terminated.");
				break;
			case "plateau size":
				System.out.println("Plateau size had been set as "+plateau.getWidth()+" by "+plateau.getHeight()+".");
				break;
			case "invalid input":
				System.out.println("Invalid input.");
		}
	}

	private static String[] requestPlateauSizeInput(){
		String input;
		do {
			System.out.println("Enter the desired plateau size, in the format \"x y\", where x and y are positive integers.");
			input = in.nextLine();
			if (!Instructions.plateauSizeInputValid(input)) printUserMessage("invalid input");
		} while (!Instructions.plateauSizeInputValid(input));
		return input.split(" ");
	}

	/**
	 * Runs the Mars Rover instruction sequences until termination is requested by the user
	 */
	private static void runMission() {
		String positionInput = requestPositionInput();
		String instructionInput = requestInstructionInput();
		// deploys a new rover at the given position if none exists there already
		Rover rover = plateau.roverExistsAt(positionInput) ? plateau.getRoverAt(positionInput) : plateau.deployRover(positionInput);
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
			if(!Position.positionInputValid(plateau, positionInput)) printUserMessage("invalid input");
		} while (!Position.positionInputValid(plateau, positionInput));
		return positionInput;
	}

	private static String requestInstructionInput() {
		String instructionInput;
		do {
			System.out.println("Enter the rover's instructions eg. \"LMLMLMLMM\"");
			instructionInput = in.nextLine();
			if (!Instructions.instructionInputValid(instructionInput)) printUserMessage("invalid input");
		} while (!Instructions.instructionInputValid(instructionInput));
		return instructionInput;
	}
}

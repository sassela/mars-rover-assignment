import java.util.Scanner;

/**
 * Created by abby on 17/10/15.
 */
public class UserInput {
	static Scanner in = new Scanner(System.in);

	static boolean plateauSizeInputValid(String input) {
		return input.matches("^\\d+\\s\\d+\\s?$");
	}

	/**
	 * Checks the user positionInput is valid according to the plateau size and required format
	 * @param positionInput user positionInput
	 * @return variable indicating whether the format is valid
	 */
	static boolean positionInputValid(Plateau plateau, String positionInput) {
		int inputX = Parser.parsePosition(positionInput).getCoordinates().getX();
		int inputY = Parser.parsePosition(positionInput).getCoordinates().getY();
		Heading inputHeading = Parser.parsePosition(positionInput).getHeading();

		boolean inputXIsValid = inputX >= 0 && inputX < plateau.getWidth();
		boolean inputYIsValid = inputY >= 0 && inputY < plateau.getHeight();

		boolean inputHeadingIsValid = false;
		for (Heading heading : Heading.values()) if (inputHeading == heading) inputHeadingIsValid = true;

		return (inputXIsValid && inputYIsValid && inputHeadingIsValid);
	}

	static boolean instructionInputValid(String input) {
		return input.matches("^[LRMlrm]+$");
	}

	static String[] requestPlateauSizeInput(){
		String input;
		do {
			System.out.println("Enter the desired plateau size, in the format \"x y\", where x and y are positive integers.");
			input = in.nextLine();
			if (!plateauSizeInputValid(input)) invalidInputMessage();
		} while (!plateauSizeInputValid(input));
		return input.split(" ");
	}

	static String requestPositionInput(Plateau plateau) {
		String positionInput;
		do {
			System.out.println("Enter the rover's position eg. \"1 2 N\"");
			positionInput = in.nextLine();
			if(!positionInputValid(plateau, positionInput)) invalidInputMessage();
		} while (!positionInputValid(plateau, positionInput));
		return positionInput;
	}

	static String requestInstructionInput() {
		String instructionInput;
		do {
			System.out.println("Enter the rover's instructions eg. \"LMLMLMLMM\"");
			instructionInput = in.nextLine();
			if (!instructionInputValid(instructionInput)) invalidInputMessage();
		} while (!instructionInputValid(instructionInput));
		return instructionInput;
	}

	static void invalidInputMessage() { System.out.println("Invalid input."); }

	static boolean missionTerminated() {
		boolean terminationRequested = in.nextLine().equals("X");
		if (terminationRequested) {
			in.close();
			System.out.println("Mission Terminated.");
		}
		return terminationRequested;
	}
}

/**
 * @author Abby Sassel
 * @since 18.08.2015
 *
 * ThoughtWorks Mars Rover Assignment
 * - Deploy and control a squad of robotic rovers on a plateau on Mars
 * - Input plateau size, rover position and a sequence of instructions
 * - Receive updated rover position as a result
 */


public class MissionControl {

	static Plateau plateau;

	public static void main (String[] args){
		System.out.println("Welcome to the Mars Rover Mission Control.");
		setPlateauSizeFromInput();
		do { runMission(); } while(!Instructions.missionTerminated());
	}

	private static void setPlateauSizeFromInput() {
		plateau = Parser.parsePlateauSize(Instructions.requestPlateauSizeInput());
		System.out.println("Plateau size had been set as "+plateau.getWidth()+" by "+plateau.getHeight()+".");
	}

	/**
	 * Runs the Mars Rover instruction sequences until termination is requested by the user
	 */
	private static void runMission() {
		String positionInput = Instructions.requestPositionInput(plateau);
		String instructionInput = Instructions.requestInstructionInput();
		// deploys a new rover at the given position if none exists there already
		Rover rover = plateau.roverExistsAt(positionInput) ? plateau.getRoverAt(positionInput) : plateau.deployRover(positionInput);
		rover.instruct(instructionInput);
		System.out.println("Rover moved from: " + positionInput + " to " + rover.getCurrentPosition());
		System.out.println("Press \"X\" to terminate mission or any other key to run again");
	}

}

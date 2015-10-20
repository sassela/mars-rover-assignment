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

	static Plateau plateau = new Plateau(new int[] {0, 0});

	public static void main (String[] args){
		System.out.println("Welcome to the Mars Rover Mission Control.");
		plateau.setSize(Parser.parsePlateauSize(UserInput.requestPlateauSizeInput()));
		System.out.println("Plateau size had been set as "+plateau.getWidth()+" by "+plateau.getHeight()+".");
		do { runMission(); } while(!UserInput.missionTerminated());
	}

	/**
	 * Runs the Mars Rover instruction sequences until termination is requested by the user
	 */
	private static void runMission() {
		String positionInput = UserInput.requestPositionInput(plateau);
		String instructionInput = UserInput.requestInstructionInput();
		// deploys a new rover at the given position if none exists there already
		Rover rover = plateau.getRoverAt(positionInput) == null ? plateau.deployRoverAt(positionInput) : plateau.getRoverAt(positionInput);
		rover.instruct(instructionInput);
		System.out.println("Rover moved from: " + positionInput + " to " + rover.getCurrentPosition());
		System.out.println("Press \"X\" to terminate mission or any other key to run again");
	}

}

/**
 * Created by abby on 17/10/15.
 */
public class Instructions {

	static boolean plateauSizeInputValid(String input) {
		return input.matches("^\\d+\\s\\d+$");
	}


	static boolean instructionInputValid(String input) {
		return input.matches("^[LRMlrm]+$");
	}
}

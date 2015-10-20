import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UserInputTest {

	@Test
	public void testPlateauSizeInputValid() {
		assertFalse(UserInput.plateauSizeInputValid("X Y"));
		assertFalse(UserInput.plateauSizeInputValid("54, 92"));
		assertFalse(UserInput.plateauSizeInputValid("1 2 3"));
		assertFalse(UserInput.plateauSizeInputValid("10 10 N"));
		assertFalse(UserInput.plateauSizeInputValid("5w4 !324"));

		assertTrue(UserInput.plateauSizeInputValid("0 0"));
		assertTrue(UserInput.plateauSizeInputValid("10 10"));
		assertTrue(UserInput.plateauSizeInputValid("543 210 "));
	}

	@Test
	public void testPositionInputValid() {
		Plateau p = new Plateau(new int[] {10, 10});
		assertFalse(UserInput.positionInputValid(p, "12 12 N"));
		assertFalse(UserInput.positionInputValid(p, "10 10 E"));
		assertFalse(UserInput.positionInputValid(p, "-2 -2 W"));

		assertTrue(UserInput.positionInputValid(p, "0 0 S"));
		assertTrue(UserInput.positionInputValid(p, "9 9 N"));
	}

	@Test
	public void testInstructionInputValid() {
		assertFalse(UserInput.instructionInputValid("0"));
		assertFalse(UserInput.instructionInputValid("5 5 M"));
		assertFalse(UserInput.instructionInputValid("53R"));
		assertFalse(UserInput.instructionInputValid("M M R"));

		assertTrue(UserInput.instructionInputValid("R"));
		assertTrue(UserInput.instructionInputValid("l"));
		assertTrue(UserInput.instructionInputValid("MMR"));
	}

}
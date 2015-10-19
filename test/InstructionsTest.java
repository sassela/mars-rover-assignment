import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class InstructionsTest {

	@Test
	public void testPlateauSizeInputValid() {

		assertFalse(Instructions.plateauSizeInputValid("X Y"));
		assertFalse(Instructions.plateauSizeInputValid("54, 92"));
		assertFalse(Instructions.plateauSizeInputValid("1 2 3"));
		assertFalse(Instructions.plateauSizeInputValid("10 10 N"));
		assertFalse(Instructions.plateauSizeInputValid("5w4 !324"));

		assertTrue(Instructions.plateauSizeInputValid("0 0"));
		assertTrue(Instructions.plateauSizeInputValid("10 10"));
		assertTrue(Instructions.plateauSizeInputValid("543 210 "));
	}

	@Test
	public void testPositionInputValid() {
		Plateau p = new Plateau(new int[] {10, 10});
		assertFalse(Instructions.positionInputValid(p, "12 12 N"));
		assertFalse(Instructions.positionInputValid(p, "10 10 E"));

		// negative coordinate values are converted to 0
		assertTrue(Instructions.positionInputValid(p, "0 0 S"));
		assertTrue(Instructions.positionInputValid(p, "-2 -2 W"));
		assertTrue(Instructions.positionInputValid(p, "9 9 N"));
	}

	@Test
	public void testInstructionInputValid() {
		assertFalse(Instructions.instructionInputValid("0"));
		assertFalse(Instructions.instructionInputValid("5 5 M"));
		assertFalse(Instructions.instructionInputValid("53R"));
		assertFalse(Instructions.instructionInputValid("M M R"));

		assertTrue(Instructions.instructionInputValid("R"));
		assertTrue(Instructions.instructionInputValid("l"));
		assertTrue(Instructions.instructionInputValid("MMR"));
	}

}
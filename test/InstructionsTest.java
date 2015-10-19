import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class InstructionsTest {
	@Test
	public void testPositionInputValid() {
		Plateau p = new Plateau(new int[] {10, 10});
		assertFalse(Instructions.positionInputValid(p, "12 12 N"));
		assertFalse(Instructions.positionInputValid(p, "10 10 E"));

		// negative coordinate values are converted to 0
		assertTrue(Instructions.positionInputValid(p, "-2 -2 W"));
		assertTrue(Instructions.positionInputValid(p, "9 9 N"));
	}

}
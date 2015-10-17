import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PositionTest {

	@Test
	public void testPositionInputValid() {
		Plateau p = new Plateau(new int[] {10, 10});
		assertFalse(Position.positionInputValid(p, "12 12 N"));
		assertFalse(Position.positionInputValid(p, "10 10 E"));
		
		// negative coordinate values are converted to 0
		assertTrue(Position.positionInputValid(p, "-2 -2 W"));
		assertTrue(Position.positionInputValid(p, "9 9 N"));
	}

	@Test
	public void testParsePosition() {
		assertEquals(new Position(new Coordinates(5, 5), Heading.N).toString(), Position.parsePosition("5 5 N").toString());
	}
}
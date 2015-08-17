import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class PositionTest {

	@Test
	public void testParsePosition() {
		Position p = new Position();
		assertEquals(new Position(new Coordinates(5, 5), Heading.N).toString(), p.parsePosition("5 5 N").toString());
	}
}
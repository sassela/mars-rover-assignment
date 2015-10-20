import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class PositionTest {
	@Test
	public void testToString() throws Exception {
		assertEquals("0 2 N", new Position (new Coordinates(0, 2), Heading.N).toString());
		assertEquals("10 10 E", new Position(new Coordinates(10, 10), Heading.E).toString());
		assertEquals("457 765 S", new Position(new Coordinates(457, 765), Heading.S).toString());
	}

}
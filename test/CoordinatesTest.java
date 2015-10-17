import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CoordinatesTest {
	Coordinates c = new Coordinates(0, 0);

	@Test
	public void testParseCoordinates() {
		c = c.parseCoordinates("1", "5");
		assertEquals(1, c.getX());
		assertEquals(5, c.getY());

		c = c.parseCoordinates("10", "10");
		assertEquals(10, c.getX());
		assertEquals(10, c.getY());

		c = c.parseCoordinates("100", "100");
		assertEquals(100, c.getX());
		assertEquals(100, c.getY());
	}
}

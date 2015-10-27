import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CoordinatesTest {
	@Test
	public void testToString() {
		assertEquals("0 0", new Coordinates(0, 0).toString());
		assertEquals("5 5", new Coordinates(5, 5).toString());
		assertEquals("934 762", new Coordinates(934, 762).toString());
	}
}

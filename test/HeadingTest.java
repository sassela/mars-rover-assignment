import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class HeadingTest {

	@Test
	public void testNormalise() {
		assertEquals(0, Heading.normalise(4));
		assertEquals(2, Heading.normalise(2));
		assertEquals(3, Heading.normalise(-1));
	}

	@Test
	public void testParseHeading() {
		assertEquals(Heading.E, Heading.parseHeading("0 0 E"));
	}
}
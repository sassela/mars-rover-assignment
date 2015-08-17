import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class HeadingTest {
	@Test
	public void testValue() {
		assertEquals(0, Heading.N.getValue());
	}

	@Test
	public void testName() {
		assertEquals("N", Heading.N.name());
	}

}
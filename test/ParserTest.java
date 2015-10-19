import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by abby on 19/10/15.
 */
public class ParserTest {

	@Test
	public void testParsePosition() {
		assertEquals(new Position(new Coordinates(0, 0), Heading.N).toString(), Parser.parsePosition("0 0 N").toString());
		assertEquals(new Position(new Coordinates(5, 5), Heading.E).toString(), Parser.parsePosition("5 5 E").toString());
		assertEquals(new Position(new Coordinates(50, 50), Heading.S).toString(), Parser.parsePosition("50 50 S").toString());
		assertEquals(new Position(new Coordinates(12345, 6789), Heading.W).toString(), Parser.parsePosition("12345 6789 W").toString());
	}
}

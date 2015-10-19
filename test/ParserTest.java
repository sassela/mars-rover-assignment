import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by abby on 19/10/15.
 */
public class ParserTest {

	@Test
	public void testParseCoordinates() {
		assertEquals(new Coordinates(0, 0).toString(), Parser.parseCoordinates("0", "0").toString());
		assertEquals(new Coordinates(10, 5).toString(), Parser.parseCoordinates("10", "5").toString());
		assertEquals(new Coordinates(321, 534).toString(), Parser.parseCoordinates("321", "534").toString());
		assertEquals(new Coordinates(8, 9).toString(), Parser.parseCoordinates("8", "9").toString());
	}

	@Test
	public void testParseHeading() {
		assertEquals(Heading.N, Parser.parseHeading("n"));
		assertEquals(Heading.E, Parser.parseHeading("E"));
		assertEquals(Heading.S, Parser.parseHeading("s"));
		assertEquals(Heading.W, Parser.parseHeading("W"));
	}

	@Test
	public void testParsePosition() {
		assertEquals(new Position(new Coordinates(0, 0), Heading.N).toString(), Parser.parsePosition("0 0 N").toString());
		assertEquals(new Position(new Coordinates(5, 5), Heading.E).toString(), Parser.parsePosition("5 5 E").toString());
		assertEquals(new Position(new Coordinates(50, 50), Heading.S).toString(), Parser.parsePosition("50 50 S").toString());
		assertEquals(new Position(new Coordinates(12345, 6789), Heading.W).toString(), Parser.parsePosition("12345 6789 W").toString());
	}

	//FIXME
//	@Test
//	public void testParsePlateauSize() {
//		assertEquals(new Plateau (new int[] {0,0}).toString(), Parser.parsePlateauSize(new String[] {"0","0"}).toString());
//		assertEquals(new Plateau (new int[] {50,50}).toString(), Parser.parsePlateauSize(new String[] {"50","50"}).toString());
//		assertEquals(new Plateau (new int[] {11,5}).toString(), Parser.parsePlateauSize(new String[] {"11","5"}).toString());
//		assertEquals(new Plateau (new int[] {0,345}).toString(), Parser.parsePlateauSize(new String[] {"0","345"}).toString());
//	}
}

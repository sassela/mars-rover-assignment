public class CoordinatesTest {
	Coordinates c = new Coordinates(0, 0);

	@Test
	public void testParseCoordinates() {
		c.parseCoordinates("1 5");
		assertEquals(1, c.getX());
		assertEquals(5, c.getY());
	}
}

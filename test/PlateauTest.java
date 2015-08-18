import org.junit.Test;
import static org.junit.Assert.*;

public class PlateauTest {

	@Test
	public void testSetSize(){
		int[] singleCell = {0, 0};
		Plateau p = new Plateau(singleCell);

		p.setSize(new int[] {5, 5});
		assertEquals(5, p.getWidth());
		assertEquals(5, p.getHeight());

		p.setSize(new int[] {-50, 50});
		assertEquals(0, p.getWidth());
		assertEquals(50, p.getHeight());

		p.setSize(new int[] {-500, -500});
		assertEquals(0, p.getWidth());
		assertEquals(0, p.getHeight());
	}

	@Test
	public void testGetRoverAt() {
		Plateau plateau = new Plateau(new int[] {5,5});
		Position position = new Position(new Coordinates(5, 5), Heading.E);
		Rover r = new Rover(plateau, position);

		assertEquals(null, plateau.getRoverAt("5 5 E"));

		plateau.addRover(r);
		assertEquals(r, plateau.getRoverAt("5 5 E"));
	}
}
import org.junit.Test;
import static org.junit.Assert.*;

public class PlateauTest {

	@Test
	public void testSetSize(){
		int[] singleCell = {0, 0};
		Plateau p = new Plateau(singleCell);

		p.setSize(new int[] {5, 5});
		assertArrayEquals(new int[] {5, 5}, p.getSize());

		p.setSize(new int[] {-50, 50});
		assertArrayEquals(new int[] {0, 50}, p.getSize());

		p.setSize(new int[] {-500, -500});
		assertArrayEquals(singleCell, p.getSize());

		p.setSize(singleCell);
		assertArrayEquals(singleCell, p.getSize());
	}

	@Test
	public void testisRoverAt() {
		Plateau p = new Plateau(new int[] {5,5});
		p.addRover(new Rover(p, new int[] {3,3}, 0));

		assertEquals(true, p.isRoverAt("3 3 N"));
	}

	@Test
	public void testGetRoverAt() {
		Plateau p = new Plateau(new int[] {5,5});
		Rover r = new Rover(p, new int[] {5,5}, 1);

		assertEquals(null, p.getRoverAt("5 5 E"));

		p.addRover(r);
		assertEquals(r, p.getRoverAt("5 5 E"));
	}
}
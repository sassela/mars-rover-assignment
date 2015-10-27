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

		p.setSize(new int[] {10, 10});
		assertEquals(10, p.getWidth());
		assertEquals(10, p.getHeight());

		// negative coordinate values are converted to 0
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

	@Test
	public void testDeployRoverAt() {
		Plateau p = new Plateau(new int[] {5, 5});

		assertEquals(null, p.getRoverAt("0 0 N"));

		Rover rover = p.deployRoverAt("0 0 N");
		assertEquals("0 0 N", rover.getCurrentPosition());
		assertEquals(null, p.getRoverAt("0 0 E"));

	}

	@Test
	public void testSetBeaconAt() {
		Plateau p = new Plateau(new int[] {5, 5});

		assertTrue(p.beacons.isEmpty());
		p.setBeaconAt(new Coordinates(3, 3));

		assertEquals(new Coordinates(3,3).toString(), p.beacons.get(0));

	}

	@Test
	public void beaconExistsAt() {
		Plateau p = new Plateau(new int[] {5, 5});

		assertTrue(p.beacons.isEmpty());
		p.setBeaconAt(new Coordinates(0, 0));
		p.setBeaconAt(new Coordinates(1, 3));
		p.setBeaconAt(new Coordinates(5, 0));

		assertFalse(p.beaconExistsAt(new Coordinates(5, 5)));
		assertTrue(p.beaconExistsAt(new Coordinates(0, 0)));
		assertTrue(p.beaconExistsAt(new Coordinates(1, 3)));
		assertTrue(p.beaconExistsAt(new Coordinates(5, 0)));


	}

}
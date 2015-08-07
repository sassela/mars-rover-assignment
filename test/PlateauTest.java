import org.junit.Test;
import static org.junit.Assert.*;

public class PlateauTest {

	@Test
	public void testSetSize(){
		Plateau p = new Plateau();
		int[] singleCell = {0, 0};

		assertArrayEquals(singleCell, p.getSize());

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
	public void deployRover() {
		Plateau p = new Plateau(new int[] {5, 5});

		assertEquals(false, isRoverAt("0 0 N"));

		deployRover("0 0 N");
		assertEquals(true, isRoverAt("0 0 N"));
		assertEquals(false, isRoverAt("0 0 E"));

	}
}
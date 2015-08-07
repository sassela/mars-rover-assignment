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
	public void testDeployRover() {
		Plateau p = new Plateau(new int[] {5, 5});

		assertEquals(false, p.isRoverAt("0 0 N"));

		p.deployRover("0 0 N");
		assertEquals(true, p.isRoverAt("0 0 N"));
		assertEquals(false, p.isRoverAt("0 0 E"));

	}
}
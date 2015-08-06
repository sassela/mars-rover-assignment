import org.junit.Test;
import static org.junit.Assert.*;

public class RoverTest {
	@Test
	public void testInstruct(){
		fail();
	}

	@Test
	public void testTurn(){
		Rover r = new Rover(new int[] {0, 0});

		assertEquals("N", r.getCurrentHeadingStr());

		r.turn("R");
		assertEquals("E", r.getCurrentHeadingStr());

		r.turn("L");
		assertEquals("N", r.getCurrentHeadingStr());
	}

	@Test
	public void testMove(){
		Rover r = new Rover(new int[] {0, 0});

		assertArrayEquals(new int[]{0, 0}, r.getCurrentLocation());

		r.move();
		assertArrayEquals(new int[] {0, 1}, r.getCurrentLocation());
	}
}
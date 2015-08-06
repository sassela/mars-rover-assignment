import org.junit.Test;
import static org.junit.Assert.*;

public class RoverTest {
	Plateau p = new Plateau(new int[] {5, 5});

	@Test
	public void testInstruct(){
		Rover r = new Rover(p, new int[] {0, 0});

		assertEquals("0 0 N", r.getCurrentPosition());

		r.instruct("M M M");
		assertEquals("0 3 N", r.getCurrentPosition());

		r.instruct("R L L");
		assertEquals("0 3 W", r.getCurrentPosition());

		r.instruct("R R L R M");
		assertEquals("1 3 E", r.getCurrentPosition());

		r.instruct("L M M M R M R");
		assertEquals("2 5 S", r.getCurrentPosition());
	}

	@Test
	public void testTurn(){
		Rover r = new Rover(p, new int[] {0, 0});

		assertEquals(0, r.getCurrentHeading());

		r.turn("R");
		assertEquals(1, r.getCurrentHeading());

		r.turn("L");
		assertEquals(0, r.getCurrentHeading());
	}

	@Test
	public void testMove(){
		Rover r = new Rover(p, new int[] {0, 0});

		assertArrayEquals(new int[]{0, 0}, r.getCurrentCoordinates());

		r.move();
		assertArrayEquals(new int[] {0, 1}, r.getCurrentCoordinates());
	}
}
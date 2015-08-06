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

		assertEquals(r.getHeading(), "N");

		r.turn("R");
		assertEquals(r.getHeading(), "E");

		r.turn("LL");
		assertEquals(r.getHeading(), "W");

		r.turn("RLL");
		assertEquals(r.getHeading(), "S");
	}

	@Test
	public void testMove(){
		fail();
	}

}
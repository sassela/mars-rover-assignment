import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class RoverTest {
	Plateau p = new Plateau(new int[] {5, 5});
	Coordinates bottomLeft = new Coordinates(0, 0);

	@Test
	public void testInstruct(){
		Rover r = new Rover(p, bottomLeft, Heading.N);

		assertEquals("0 0 N", r.getCurrentPosition());

		r.instruct("MMM");
		assertEquals("0 3 N", r.getCurrentPosition());

		r.instruct("RLL");
		assertEquals("0 3 W", r.getCurrentPosition());

		r.instruct("RRLRM");
		assertEquals("1 3 E", r.getCurrentPosition());

		r.instruct("LMMMRMR");
		assertEquals("2 5 S", r.getCurrentPosition());

		r.instruct("MMMMMMMMM");
		assertEquals("2 0 S", r.getCurrentPosition());
	}

	@Test
	public void testTurn(){
		Rover r = new Rover(p, bottomLeft, Heading.N);

		r.turn('R');
		assertEquals(Heading.E, r.getCurrentHeading());

		r.turn('L');
		assertEquals(Heading.N, r.getCurrentHeading());
	}

	@Test
	public void testMove(){
		Rover r = new Rover(p, bottomLeft, Heading.N);

		r.move();
		assertEquals(new Coordinates(0, 1).toString(), r.getCurrentCoordinates().toString());
	}
}
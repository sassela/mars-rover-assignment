import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MissionControlTest {

	@Test
	public void testDeployRover() {
		Plateau p = new Plateau(new int[] {5, 5});

		assertEquals(null, p.getRoverAt("0 0 N"));

		Rover rover = MissionControl.deployRover(p, "0 0 N");
		assertEquals("0 0 N", rover.getCurrentPosition());
		assertEquals(null, p.getRoverAt("0 0 E"));

	}

}
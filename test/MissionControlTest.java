import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MissionControlTest {
	MissionControl missionControl = new MissionControl();

	@Test
	public void testDeployRover() {
		Plateau p = new Plateau(new int[] {5, 5});

		assertEquals(false, missionControl.isRoverAt(p, "0 0 N"));

		missionControl.deployRover(p, "0 0 N");
		assertEquals(true, missionControl.isRoverAt(p, "0 0 N"));
		assertEquals(false, missionControl.isRoverAt(p, "0 0 E"));

	}

}
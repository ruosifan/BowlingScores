import static org.junit.Assert.*;

import org.junit.Test;


public class FrameTest {

	@Test
	public void shouldDetermineTypeOfFrameGutterball() {
		Frame frame = new Frame(0, 0);
		assertEquals("regular", frame.typeOfFrame());
	}
	
	@Test
	public void shouldGetFirstSecondAndTypeOfFrameStrike() {
		Frame frame = new Frame(10, 6);
		assertEquals("strike", frame.typeOfFrame());
		assertEquals(10, frame.getFirst());
		assertEquals(0, frame.getSecond());
	}

}

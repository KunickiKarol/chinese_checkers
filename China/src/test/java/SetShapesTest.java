import Client.Frame.CIRCLE;
import Client.Frame.SQUARE;
import Client.Frame.SetShapes;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class SetShapesTest {
	
	@Test
	public void returnShape() {
		
		assertTrue(SetShapes.returnShape("Circle",2,2,6,6) instanceof CIRCLE);
		assertEquals(Color.white,SetShapes.returnShape("Circle",2,2,6,6).getColor());
		assertTrue(SetShapes.returnShape("Rectangle",2,2,6,6) instanceof SQUARE);
		assertEquals(Color.white,SetShapes.returnShape("Rectangle",2,2,6,6).getColor());
		
		Exception exception = assertThrows(IllegalArgumentException.class, () -> SetShapes.returnShape("kot",2,2,6,6));
		
		String expectedMessage = "Unknown type kot";
		String actualMessage = exception.getMessage();
		
		assertTrue(actualMessage.contains(expectedMessage));
	}
}
import Client.Frame.SetBoardShape;
import Client.Frame.SquareBoard;
import Client.Frame.StarBoard;
import org.junit.Test;

import static org.junit.Assert.*;

public class SetBoardShapeTest {
	
	@Test
	public void returnBoardShape() {
		
		assertTrue(SetBoardShape.returnBoardShape("Classical") instanceof StarBoard);
		assertEquals(2,SetBoardShape.returnBoardShape("Classical").returnTables().size());
		assertTrue(SetBoardShape.returnBoardShape("Square") instanceof SquareBoard);
		
		Exception exception = assertThrows(IllegalArgumentException.class, () -> SetBoardShape.returnBoardShape("kot"));
		
		String expectedMessage = "Unknown type kot";
		String actualMessage = exception.getMessage();
		
		assertTrue(actualMessage.contains(expectedMessage));
	}
}
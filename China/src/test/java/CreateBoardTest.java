import Client.Frame.Classical;
import Client.Frame.CreateBoard;
import Client.Frame.RectangleBoard;
import org.junit.Test;

import static org.junit.Assert.*;

public class CreateBoardTest {
	
	@Test
	public void boardProperties() {
		
		assertTrue(CreateBoard.boardProperties("Classical") instanceof Classical);
		assertEquals(6,CreateBoard.boardProperties("Classical").giveHouses().size());
		assertEquals(17,CreateBoard.boardProperties("Classical").giveSize().length);
		assertTrue(CreateBoard.boardProperties("Square") instanceof RectangleBoard);
		
		Exception exception = assertThrows(IllegalArgumentException.class, () -> CreateBoard.boardProperties("kot"));
		
		String expectedMessage = "Unknown board kot";
		String actualMessage = exception.getMessage();
		
		assertTrue(actualMessage.contains(expectedMessage));
	}
}
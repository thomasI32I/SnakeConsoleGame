package snake;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Point;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import snake.data.Snake;

/**
 * 
 *
 */
public class Test1 {
	
	@Test
	public void equalGameItemTest1() {
		//when you create string literals, the objects point to the same value since
		//they are in constant pool, where as when you use the new operator,
		//separate objects are created and stored in heap.
//		String player1 = "player1";
//		String player2 = new String("player1");
//		
//		GameItem item1 = new GameItem(Figure.PLAYER, player1, new Point(1, 2));
//		GameItem item2 = new GameItem(Figure.PLAYER, player2, new Point(1, 2));
//		
//		GameItem item3 = new GameItem(Figure.PLAYER, "player1", new Point(3, 2));
//		GameItem item4 = new GameItem(Figure.SNAKE, player2, new Point(1, 2));
//		
//		assertTrue(item1.equals(item2));
//		assertFalse(item1.equals(item3));
//		assertFalse(item1.equals(item4));
	}
	
	@Test
	public void shiftSnake() {
		Snake snake = new Snake("Cobra", new Point(1,1), 5);
		
		System.out.println(Arrays.toString(snake.getPositions()));
		
	}
	
	
	@Test
	public void placeGameItemTest1() {
		
		GameItemManager manager = new GameItemManager();
		
		assertEquals(4, manager.getOccupiedPoints().size());
	}
	
	
	@Test
	public void drawTest1() {
		
		Gui gui =  new Gui(new GameItemManager());		
		
		gui.draw();		
		gui.movePlayer();
		gui.draw();
		
	}

	

}

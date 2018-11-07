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

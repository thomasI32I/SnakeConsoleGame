package snake;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import snake.GameItemManager;
import snake.Gui;

/**
 * Tests the movement behaviour via console for the player 
 * 
 */
public class PlayerMovementTest {
	
	@Test
	public void movePlayerUpTest() {
		
		GameItemManager manager = new GameItemManager();
		int playerXPosition = manager.getPlayer().getPosition().x;
		int playerYPosition = manager.getPlayer().getPosition().y;
		
		Gui gui = new Gui(manager);
		
		//press "w" button in console and press enter
		gui.movePlayer();
		assertEquals(playerXPosition, manager.getPlayer().getPosition().x);	
		assertEquals(Math.max(0, playerYPosition - 1), manager.getPlayer().getPosition().y);	
	}
	
	@Test
	public void movePlayerDownTest() {
		
		GameItemManager manager = new GameItemManager();
		int playerXPosition = manager.getPlayer().getPosition().x;
		int playerYPosition = manager.getPlayer().getPosition().y;
		
		Gui gui = new Gui(manager);
		
		//press "s" button in console and press enter
		gui.movePlayer();
		assertEquals(playerXPosition, manager.getPlayer().getPosition().x);
		assertEquals(Math.min(manager.getMaxYValue(), playerYPosition + 1), manager.getPlayer().getPosition().y);
	}
	
	@Test
	public void movePlayerLeftTest() {
		
		GameItemManager manager = new GameItemManager();
		int playerXPosition = manager.getPlayer().getPosition().x;
		int playerYPosition = manager.getPlayer().getPosition().y;
		
		Gui gui = new Gui(manager);
		
		//press "a" button in console and press enter
		gui.movePlayer();
		assertEquals(Math.max(0, playerXPosition - 1), manager.getPlayer().getPosition().x);
		assertEquals(playerYPosition, manager.getPlayer().getPosition().y);
	}
	
	@Test
	public void movePlayerRightTest() {
		
		GameItemManager manager = new GameItemManager();
		int playerXPosition = manager.getPlayer().getPosition().x;
		int playerYPosition = manager.getPlayer().getPosition().y;
		
		Gui gui = new Gui(manager);
		
		//press "d" button in console and press enter
		gui.movePlayer();
		assertEquals(Math.min(manager.getMaxXValue(), playerXPosition + 1), manager.getPlayer().getPosition().x);
		assertEquals(playerYPosition, manager.getPlayer().getPosition().y);
	}

}

package snake;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import snake.data.Door;
import snake.data.Figure;
import snake.data.GameItem;
import snake.data.Gold;
import snake.data.Player;
import snake.data.PlayerMove;
import snake.data.Snake;

/**
 * This class generates {@link GameItem}s and places them on a random
 * {@link Point} within the game area.
 */
public class GameItemManager {

	/**
	 * Reference to Gui class
	 */
	private Gui gui;
	/**
	 * List of all GameItems
	 */
	private List<GameItem> gameItems = new ArrayList<>();
	/**
	 * Stores all existing points corresponding to all game items.
	 */
	private List<Point> occupiedPoints = new ArrayList<>();

	/**
	 * Number of player movements before snake moves one time
	 */
	private static final int PLAYER_SNAKE_MOVEMENT_RATIO = 2;
	private int movementCounter;

	/**
	 * Game items for a regular game
	 */
	private final Player player;
	private final Snake snake1;
//	private final GameItem snake2;
	private final GameItem door;
	private final GameItem gold1;
	// extended
	private final GameItem gold2;

	private boolean isGoldCollected = false;

	/**
	 * Size data of a game area
	 */
	private enum GameAreaCoordinate {
		MIN_X(0), MAX_X(39), MIN_Y(0), MAX_Y(9);

		private final int value;

		GameAreaCoordinate(final int newValue) {
			value = newValue;
		}

		public int getValue() {
			return value;
		}
	}

	/**
	 * Message for game events.
	 */
	private enum GameState {
		WIN("Gewonnen!"), LOSING("ZZZZZZZ. Die Schlange hat dich!");

		private final String value;

		private GameState(final String newValue) {
			value = newValue;
		}

		public String getValue() {
			return value;
		}
	}

	/**
	 * Constructor
	 */
	public GameItemManager() {

		movementCounter = 0;

		// initialize 4 game items
		player = new Player("Franz", getAvailableCoordinate());
		gameItems.add(player);
		snake1 = new Snake("Cobra", getAvailableCoordinate(), 5);
		gameItems.add(snake1);
//		snake2 = new GameItem(Figure.SNAKE, "Python", getAvailableCoordinate());
//		gameItems.add(snake2);
		door = new Door("Door", getAvailableCoordinate());
		gameItems.add(door);
		gold1 = new Gold("Gold1", getAvailableCoordinate());
		gameItems.add(gold1);
		gold2 = new Gold("Gold2", getAvailableCoordinate());
		gameItems.add(gold2);

	}

	/**
	 * Generates a random coordinate within the game area.
	 * 
	 * @return Returns a random coordinate of the game area. If all coordinates are
	 *         occupied a null point is returned.
	 */
	private Point getAvailableCoordinate() {

		Point generatedPoint = null;

		if (occupiedPoints.isEmpty()) {
			generatedPoint = generateRandomPoint();
			occupiedPoints.add(generatedPoint);

		} else {
			for (Point existingPoint : occupiedPoints) {
				generatedPoint = generateRandomPoint();

				if (!generatedPoint.equals(existingPoint)) {
					occupiedPoints.add(generatedPoint);
					return generatedPoint;
				}
			}
			// in this cased all points are already occupied on the game area
		}

		return generatedPoint;
	}

	private Point generateRandomPoint() {

		int xValue = ThreadLocalRandom.current().nextInt(GameAreaCoordinate.MIN_X.getValue(),
				GameAreaCoordinate.MAX_X.getValue());
		int yValue = ThreadLocalRandom.current().nextInt(GameAreaCoordinate.MIN_Y.getValue(),
				GameAreaCoordinate.MAX_Y.getValue());

		return new Point(xValue, yValue);
	}

	/**
	 * Checks the current status/position of all game items and forwards
	 * corresponding messages to the Gui.
	 */
	boolean isGameFinished() {

		boolean isFinished = false;
		// check status
		if (isGoldCollected && player.getPosition().equals(door.getPosition())) {
			gui.printGameState(GameState.WIN.getValue());
			// stop game here
			isFinished = true;
		}

		if (player.getPosition().equals(snake1.getPosition())
//				|| player.getPosition().equals(snake2.getPosition())
		) {
			gui.printGameState(GameState.LOSING.getValue());
			// stop game here
			isFinished = true;
		}

		if (player.getPosition().equals(gold1.getPosition())) {
			// gold1 was collected, game continues
			gold1.getPosition().setLocation(-1, -1);
		}

		if (player.getPosition().equals(gold2.getPosition())) {
			// gold2 was collected, game continues
			gold2.getPosition().setLocation(-1, -1);
		}

		if (gold1.getPosition().equals(new Point(-1, -1)) && gold1.getPosition().equals(new Point(-1, -1))) {
			isGoldCollected = true;
		}

		return isFinished;
	}

	/**
	 * Changes the position of player according to movment input.
	 * 
	 * @param movement
	 */
	void movePlayer(String movement) {

		if (movement.equalsIgnoreCase(PlayerMove.UP.getValue())) {
			player.getPosition().y = Math.max(0, player.getPosition().y - 1);
		} else if (movement.equalsIgnoreCase(PlayerMove.DOWN.getValue())) {
			player.getPosition().y = Math.min(GameAreaCoordinate.MAX_Y.getValue(), player.getPosition().y + 1);
		} else if (movement.equalsIgnoreCase(PlayerMove.LEFT.getValue())) {
			player.getPosition().x = Math.max(0, player.getPosition().x - 1);
		} else if (movement.equalsIgnoreCase(PlayerMove.RIGHT.getValue())) {
			player.getPosition().x = Math.min(GameAreaCoordinate.MAX_X.getValue(), player.getPosition().x + 1);
		}

		movementCounter++;

		if (movementCounter == PLAYER_SNAKE_MOVEMENT_RATIO) {
			
			snake1.moveAccordingTo(player.getPosition());
			
			movementCounter = 0;
		}
	}

	private void updateSnakePositions() {

		// snake2 moves towards player - x direction
//		if (player.getPosition().x < snake2.getPosition().x)
//			snake2.getPosition().x--;
//		else if (player.getPosition().x > snake2.getPosition().x)
//			snake2.getPosition().x++;
//		// snake moves towards player - y direction
//		if (player.getPosition().y < snake2.getPosition().y)
//			snake2.getPosition().y--;
//		else if (player.getPosition().y > snake2.getPosition().y)
//			snake2.getPosition().y++;
	}

	/**
	 * Used by app class to set the properties
	 */
	void setProperties(Gui guiToSet) {
		gui = guiToSet;
	}

	/**
	 * Getter and setter methods
	 */
	public GameItem getPlayer() {
		return player;
	}

	public int getMaxXValue() {
		return GameAreaCoordinate.MAX_X.getValue();
	}

	public int getMaxYValue() {
		return GameAreaCoordinate.MAX_Y.getValue();
	}

	public List<Point> getOccupiedPoints() {
		return occupiedPoints;
	}

	public List<GameItem> getGameItems() {
		return gameItems;
	}

}

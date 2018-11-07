package snake;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import snake.data.GameItem;
import snake.data.PlayerMove;
import snake.data.Snake;

/**
 * Class to draw the game on the console.
 */
public class Gui {

	/**
	 * Reference to gameManager
	 */
	private GameItemManager gameManager;

	/**
	 * Constructor
	 * 
	 * @param manager
	 */
	public Gui(GameItemManager manager) {
		this.gameManager = manager;
	}

	/**
	 * Draws current state of the game. Display size is requested by gameManager.
	 */
	void draw() {
		for (int y = 0; y < gameManager.getMaxYValue() + 1; y++) {
			for (int x = 0; x < gameManager.getMaxXValue() + 1; x++) {
				Point currentPointToDraw = new Point(x, y);
				ArrayList<GameItem> list = (ArrayList<GameItem>) gameManager.getGameItems();

				char symbolToDraw = '.';
				for (GameItem item : list) {
					if (item instanceof Snake) { // check here all snake positions						
						Snake snake = (Snake) item;
						if (Arrays.asList(snake.getPositions()).contains(currentPointToDraw)) {
							symbolToDraw = snake.getType().getValue();
							break;
						}
					} else { // check positions of other items
						if ((item.getPosition().equals(currentPointToDraw))) {
							symbolToDraw = item.getType().getValue();
							break;
						}
					}
				}
				// print each row pixel
				System.out.print(symbolToDraw);
			}
			// shift to next line
			System.out.println();
		}
	}

	/**
	 * Moves player according to console input.
	 */
	void movePlayer() {

		Scanner scanner = new Scanner(System.in);
		String consoleInput = scanner.next();

		if (consoleInput.equalsIgnoreCase(PlayerMove.UP.getValue())
				|| consoleInput.equalsIgnoreCase(PlayerMove.DOWN.getValue())
				|| consoleInput.equalsIgnoreCase(PlayerMove.LEFT.getValue())
				|| consoleInput.equalsIgnoreCase(PlayerMove.RIGHT.getValue())) {

			gameManager.movePlayer(consoleInput);

		} else {
			movePlayer();
		}
	}

	/**
	 * Prints game state message on console.
	 * 
	 * @param message
	 */
	void printGameState(String message) {
		System.out.println(message);
	}

}

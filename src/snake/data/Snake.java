package snake.data;

import java.awt.Point;

/**
 * 
 */
public class Snake extends GameItem {

	Point[] positions;
	int snakeIdx = 0;
	static final int MIN_SIZE = 1;
	static final int MAX_SIZE = 10;

	/**
	 * 
	 * @param name
	 * @param size
	 */
	public Snake(String name, Point headPosition, int size) {
		super(name);
		type = Figure.SNAKE;
		
		//generate size of snake
		if (size > MIN_SIZE && size < MAX_SIZE) {
			positions = new Point[size];
		} else {
			positions = new Point[MIN_SIZE];
		}
		
		//to assign
		positions[snakeIdx] = headPosition;
	}
	
	/**
	 * 
	 * @param newPlayerPosition
	 */
	public void moveAccordingTo(Point newPlayerPosition) {
		
		Point headPosition = new Point(positions[snakeIdx].x, positions[snakeIdx].y);
		
		// snake1 moves towards player - x direction
		if (newPlayerPosition.x < headPosition.x)
			headPosition.x--;
		else if (newPlayerPosition.x > headPosition.x)
			headPosition.x++;
		// snake moves towards player - y direction
		if (newPlayerPosition.y < headPosition.y)
			headPosition.y--;
		else if (newPlayerPosition.y > headPosition.y)
			headPosition.y++;
		
		//calculation of snakeIdx as array index functions as ring memory
		snakeIdx = (snakeIdx + 1) % positions.length;
		positions[snakeIdx] = headPosition;
	}
	
	@Override
	public Point getPosition() {		
		return positions[snakeIdx];
	}
	
	public Point[] getPositions() {
		return positions;
	}
}

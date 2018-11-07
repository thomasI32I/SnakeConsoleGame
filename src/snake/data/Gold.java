package snake.data;

import java.awt.Point;

/**
 * 
 *
 */
public class Gold extends GameItem {

	Point position;
	
	public Gold(String name, Point pos) {
		super(name);
		
		type = Figure.GOLD;
		position = pos;
	}

	
	@Override
	public Point getPosition() {
		return position;
	}

}

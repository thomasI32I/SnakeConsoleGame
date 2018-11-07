package snake.data;

import java.awt.Point;

/**
 *
 */
public class Door extends GameItem {

	Point position;
	
	public Door(String name, Point pos) {
		super(name);
		type = Figure.DOOR;
		position = pos;
	}

	@Override
	public Point getPosition() {
		return position;
	}

}

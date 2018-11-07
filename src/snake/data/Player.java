package snake.data;

import java.awt.Point;

public class Player extends GameItem {
	
	Point position;

	public Player(String name, Point position) {
		super(name);
		
		this.position = position;
		type = Figure.PLAYER;
	}
	
	
	public Point getPosition() {
		return position;
	}

}

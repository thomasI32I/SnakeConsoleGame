package snake.data;

import java.awt.Point;

/**
 * This class represents a game item.
 */
public abstract class GameItem {

	/**
	 * Member variables
	 */
	String name;
	Figure type;
	
	/**
	 * Constructor
	 * 
	 * @param type
	 * @param name
	 * @param position
	 */
	public GameItem(String name) {
		this.name = name;;
	}

//	/**
//	 * Compares to {@link GameItem}s
//	 */
//	@Override
//	public boolean equals(Object o) {
//		if (o == this)
//			return true;
//		if (!(o instanceof GameItem))
//			return false;
//		//Check if content of this object and other object is equal
//		GameItem item = (GameItem)o;
//		
//		return item.name.equals(name) && item.type.equals(type)
//				&& item.position.equals(position);
//	}
	
	public Figure getType() {
		return type;
	}

	public String getName() {
		return name;
	}
	
	public abstract Point getPosition();
}

package snake.data;

/**
 * 
 *
 */
public enum Figure {

	PLAYER('&'),
	SNAKE('S'),
	GOLD('$'),
	DOOR('#'),
	UNKNOWN('-');
	
	private final char value;

	Figure(final char newValue) {
		value = newValue;
	}

	public char getValue() {
		return value;
	}

}

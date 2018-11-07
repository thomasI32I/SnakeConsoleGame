package snake.data;

/**
 * 
 * 
 */
public enum PlayerMove {
	
	UP("w"),
	DOWN("s"),
	LEFT("a"),
	RIGHT("d");
	
	private final String value;

	PlayerMove(final String newValue) {
		value = newValue;
	}

	public String getValue() {
		return value;
	}

}

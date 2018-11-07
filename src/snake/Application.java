package snake;

/**
 * This class encapsulates the logic of the hole snake program, so the program
 * itself.
 *
 */
public class Application {

	/**
	 * member variables
	 */
	private GameItemManager manager;
	private Gui gui;	
	
	/**
	 * Constructor, initializing of each application module.
	 */
	public Application() {		
		manager = new GameItemManager();		
		gui = new Gui(manager);
		manager.setProperties(gui);
	}
	
	/**
	 * Starts the application in an endless loop. The program stops when
	 * it achieves a certain point itself.
	 */
	public void start() {
		
		boolean isFinished = false;		
		while (true) {			
			//draw game
			gui.draw();
			//check if programm is finished
			isFinished = manager.isGameFinished();
			if (isFinished) {
				return;
			}
			//receive movment command. internally the movement
			//is forwarded to manager.
			gui.movePlayer();
		}
	}
}

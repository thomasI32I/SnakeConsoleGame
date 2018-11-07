package snake.example;

import java.awt.Point;
import java.util.Scanner;

import snake.data.Figure;

public class Main {

	public static void main(String[] args) {
		
		Point playerPosition = new Point(10, 9);
		Point snakePosition = new Point(30, 2);
		Point goldPosition = new Point(6, 6);
		Point doorPosition = new Point(0, 5);
		boolean goldCollected = false;

		// Endlosschleife
		while (true) {
			
			// Raster mit Figuren zeichnen --> GUI
			for (int y = 0; y < 10; y++) {
				for (int x = 0; x < 40; x++) {
					// check each point on the game area
					Point p = new Point(x, y);

					
					if (playerPosition.equals(p))
						System.out.print(Figure.PLAYER.getValue());
					else if (snakePosition.equals(p))
						System.out.print(Figure.SNAKE.getValue());
					else if (goldPosition.equals(p))
						System.out.print(Figure.GOLD.getValue());
					else if (doorPosition.equals(p))
						System.out.print(Figure.DOOR.getValue());
					else
						System.out.print('.');
				}
				System.out.println();
			}
			
			

			// Status feststellen --> GameItemManager
			if (goldCollected && playerPosition.equals(doorPosition)) {
				System.out.println("Gewonnen!");
				break;
			}
			if (playerPosition.equals(snakePosition)) {
				System.out.println("ZZZZZZZ. Die Schlange hat dich!");
				break;
			}
			if (playerPosition.equals(goldPosition)) {
				goldCollected = true;
				goldPosition.setLocation(-1, -1);

			}

			// Konsoleneingabe und Spielerposition verändern --> GUI, GameItemManager		
			switch (new Scanner(System.in).next()) {
			
			case "w": 
				playerPosition.y = Math.max(0, playerPosition.y - 1);
				break;
			case "s": 
				playerPosition.y = Math.min(9, playerPosition.y + 1);
				break;
			case "a": 
				playerPosition.x = Math.max(0, playerPosition.x - 1);
				break;
			case "d": 
				playerPosition.x = Math.min(39, playerPosition.x + 1);
				break;
			default:
				System.out.println(new Scanner(System.in).next());

			}

			// Schlange bewegt sich in Richtung Spieler --> GameItemManager
			if (playerPosition.x < snakePosition.x)
				snakePosition.x--;
			else if (playerPosition.x > snakePosition.x)
				snakePosition.x++;
			if (playerPosition.y < snakePosition.y)
				snakePosition.y--;
			else if (playerPosition.y > snakePosition.y)
				snakePosition.y++;
		} // end while
	}



}

/**
 * 
 */
package com.game.rockpaperscissors;

/**
 * @author attilio
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();

		if ((args.length == 1) && isNumeric(args[0])) {
				RockPaperScissors game = new RockPaperScissors();
				game.setPlayerName("PC1",1);
				game.setPlayerName("PC2",2);
				game.setMatchesToPlay(Integer.parseInt(args[0]));
				game.setPlayerDefaultShape(Shape.ROCK, 1);
				game.startGame();
				System.out.println(game.toString());
		}
		else System.out.println("Usage: java -jar technicaltest.jar number_of_matches");

		long stopTime = System.currentTimeMillis();
		long elapsedTime = stopTime - startTime;
		System.out.println("The task has been completed in: " + elapsedTime + " ms");
	}

	public static boolean isNumeric(String s) {  
		return s.matches("[-+]?\\d*");  
	} 
}

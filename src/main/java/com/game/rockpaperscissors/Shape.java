package com.game.rockpaperscissors;

/**
 * Enumerative shape for the game: Rock, Paper, Scissors and None
 * @author attilio
 *
 */
public enum Shape {
	ROCK, PAPER, SCISSORS, NONE;
	
	/**
	 * Get a random shape
	 * @return Shape - random shape generated
	 */
	public static Shape randomShape() {
		int randomIndex = (int) (Math.random() * (values().length -1));
		Shape randomShape = values()[randomIndex];
		return randomShape; 
	}
}

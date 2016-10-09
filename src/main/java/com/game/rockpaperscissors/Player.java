package com.game.rockpaperscissors;

import com.game.exceptions.HumanPlayerNotAvailable;
import com.game.models.AbstractPlayer;

/**
 * Implementation of a player for the game: Rock, Paper, Scissors
 * @author attilio
 *
 */
public class Player extends AbstractPlayer {

	/**
	 * Default choice in case of interactive human player
	 */
	private Shape defaultChoice = Shape.NONE;
	/**
	 * Matches won by the player
	 */
	private int matchesWon = 0;
	/**
	 * Matches lost by the player
	 */
	private int matchesLost = 0;
	
	/**
	 * Play a shape
	 * @return Shape: can be a DefaultChoice or RandomChoice 
	 */
	public Shape play() {
		if (isDefaultChoice()) return defaultChoice;
		if (isHuman()) throw new HumanPlayerNotAvailable();
		return Shape.randomShape();
	}

	/**
	 * Check the flag is the player is in default choice
	 * @return
	 */
	public boolean isDefaultChoice(){
		return defaultChoice != Shape.NONE;
	}
	
	/**
	 * Increment the matches won by the player
	 */
	public void incrementMatchesWon() {
		this.matchesWon++;
	}

	/**
	 * Increment the matches lost by the player
	 */
	public void incrementMatchesLost() {
		this.matchesLost++;
	}
	
	/**
	 * Get the default choice 
	 * @return
	 */
	public Shape getDefaultChoice() {
		return defaultChoice;
	}

	/**
	 * Set a default choice
	 * @param defaultChoice
	 */
	public void setDefaultChoice(Shape defaultChoice) {
		this.defaultChoice = defaultChoice;
	}

	/**
	 * Get the matches won by the player
	 * @return int - number of the matches won
	 */
	public int getMatchesWon() {
		return matchesWon;
	}

	/**
	 * Get the matches lost by the player
	 * @return int - number of the matches lost
	 */
	public int getMatchesLost() {
		return matchesLost;
	}
}

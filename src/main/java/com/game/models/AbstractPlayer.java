package com.game.models;

/**
 * Abstract class of the Player
 * @author attilio
 *
 */
public abstract class AbstractPlayer {
	/**
	 * Name of the player
	 */
	private String name;
	/**
	 * Human or Robot
	 */
	protected boolean isHuman = false;

	/**
	 * Checking if the player is human
	 * @return True - is human
	 */
	public boolean isHuman() {
		return isHuman;
	}

	/**
	 * Set the type of the player
	 * @param isHuman - false by default
	 */
	public void setHuman(boolean isHuman) {
		this.isHuman = isHuman;
	}

	/**
	 * Get the name of the player
	 * @return String - name of the player
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set a new name of the player
	 * @param name - string
	 */
	public void setName(String name) {
		this.name = name;
	}
}

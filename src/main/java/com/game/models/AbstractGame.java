package com.game.models;

import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Abstract game class
 * @author attilio
 *
 */
public abstract class AbstractGame {
	
	/**
	 * Logger
	 */
	protected static final Logger logger = LoggerFactory.getLogger(AbstractGame.class);
	
	/**
	 * Array of players
	 */
	private AbstractPlayer [] players;
	
	/**
	 * i18n internationalization
	 */
	private ResourceBundle resources;
    
	/**
	 * Get the array of the participants to the game
	 * @return Player - abstract class
	 */
	public AbstractPlayer [] getPlayers() {
		return players;
	}

	/**
	 * Set a new array of the participants to the game
	 * @param players - abstract
	 */
	public void setPlayers(AbstractPlayer [] players) {
		this.players = players;
	}

	/**
	 * Get messages bundle
	 * @return ResourceBundle
	 */
	public ResourceBundle getResources() {
		return resources;
	}

	/**
	 * Set a new messages bundle
	 * @param resources
	 */
	public void setResources(ResourceBundle resources) {
		this.resources = resources;
	}
}

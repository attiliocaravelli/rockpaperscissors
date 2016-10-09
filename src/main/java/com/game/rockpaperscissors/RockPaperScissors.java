package com.game.rockpaperscissors;

import java.util.ResourceBundle;

import com.game.models.AbstractGame;

/**
 * Implementation of the game: Rock, Paper and Scissors
 * between machines 
 * @author attilio
 *
 */
public final class RockPaperScissors extends AbstractGame {

	/**
	 * Message bundle key for the final report
	 */
	private final String INFO_REPORT_KEY = "info.report";
	/**
	 * Counter of the number of matches to play yet
	 */
	private int matchesToPlay = 1;
	/**
	 * Counter of the games in tie
	 */
	private int gamesDraw = 0;

	/**
	 * Constructor  
	 */
	public RockPaperScissors() {
		initPlayers(); // Only 2 Players per round are permitted in this game
		setResources(ResourceBundle.getBundle(Constants.MESSAGE_BUNDLE_FILENAME)); 	
	}

	/**
	 * Algorithm to find the winner Shape 
	 * @param firstShape
	 * @param secondShape
	 * @return int 0 - tie, 1 - firstShape is the winner, 2 -secondShape is the winner or NUMERIC_ERRORS if one or both shapes are not valid
	 */
	public int getShapeWinner(Shape firstShape, Shape secondShape) {
		if (!isValidShape(firstShape) ||
			!isValidShape(secondShape)) return Constants.NUMERIC_ERRORS;
		int firstChoice = getShapeOrdinal(firstShape);
		int secondChoice = getShapeOrdinal(secondShape);
		int winnerShape = (Constants.POSSIBLE_PLAYER_CHOICES + firstChoice - secondChoice) % Constants.POSSIBLE_PLAYER_CHOICES;
		return winnerShape;
	}
	
	/**
	 * Get the ordinal number of the shape
	 * @param shape
	 * @return int - ordinal number of the shape given
	 */
	public int getShapeOrdinal(Shape shape) {
		if (!isValidShape(shape)) return Constants.NUMERIC_ERRORS;
		return shape.ordinal();
	}
	
	/**
	 * Get the player from the array
	 * @param idPlayer
	 * @return Player selected or PLAYER_ERRORS if the idPlayer is not valid
	 */
	public Player getPlayer(int idPlayer) {
		if (!isValidIdPlayer(idPlayer)) return Constants.PLAYER_ERRORS;
		return (Player)super.getPlayers()[idPlayer];
	}
	
	/**
	 * Set a default choice for a player
	 */
	/**
	 * Get a default choice for a player
	 * @param idPlayer
	 * @return Default shape of the player selected or SHAPE_ERRORS if the idPlayer is not valid
	 */
	public Shape getPlayerDefaultShape(int idPlayer) {
		Player player = getPlayer(idPlayer);
		if (!isValidPlayer(player)) return Constants.SHAPE_ERRORS;
		return player.getDefaultChoice();
	}
	
	/**
	 * Get Player matches won
	 * @param idPlayer
	 * @return number of matches lost or NUMERIC_ERRORS if the idPlayer is not valid
	 */
	public int getPlayerMatchesWon(int idPlayer) {
		Player player = getPlayer(idPlayer);
		if (!isValidPlayer(player)) return Constants.NUMERIC_ERRORS;
		return player.getMatchesWon();
	}
	
	/**
	 * Get Player matches lost
	 * @param idPlayer
	 * @return number of matches lost or NUMERIC_ERRORS if the idPlayer is not valid
	 */
	public int getPlayerMatchesLost(int idPlayer) {
		Player player = getPlayer(idPlayer);
		if (!isValidPlayer(player)) return Constants.NUMERIC_ERRORS;
		return player.getMatchesLost();
	}
	
	/**
	 * Get the player name
	 * @param idPlayer - index of the player into general array
	 * @return String - Name of the player or REPORT_ERRORS if the idPlayer is not valid
	 */
	public String getPlayerName(int idPlayer) {
		Player player = getPlayer(idPlayer);
		if (!isValidPlayer(player)) return Constants.REPORT_ERRORS;
		return player.getName();
	}
	
	/**
	 * Get the number of the matches in draw
	 * @return number of the matches draw
	 */
	public int getMatchesDraw() {
		return gamesDraw;
	}

	/**
	 * Get the number of the matches to play in a game
	 * @return int - number of the matches
	 */
	public int getMatchesToPlay() {
		return matchesToPlay;
	}
	
	/**
	 * Set a default choice for a player
	 * @param shape - choice for the player
	 * @param numberOfPlayer - index of the player into general array
	 */
	public void setPlayerDefaultShape(Shape shape, int numberOfPlayer) {
		Player player = getPlayer(numberOfPlayer);
		if (player != Constants.PLAYER_ERRORS) player.setDefaultChoice(shape);
	}
	
	/**
	 * Set the name of a player
	 * @param name - String
	 * @param numberOfPlayer - index of the player into general array
	 */
	public void setPlayerName(String name, int idPlayer) {
		Player player = getPlayer(idPlayer);
		if (isValidPlayer(player)) player.setName(name);
	}

	/**
	 * Set the number of the matches to play in a game
	 * @param numberOfMatchesToPlay 
	 */
	public void setMatchesToPlay(int matchesToPlay) {
		this.matchesToPlay = matchesToPlay;
	}
	
	/**
	 * Is the game over?
	 * @return True - if the number Of matches to play is < 1
	 */
	public boolean isGameOver(int matchesToPlay) {
		return matchesToPlay <= 0;
	}
	
	/**
	 * Validation of the player index for this game 
	 * @param index of the player 0..1
	 * @return True if it is valid
	 */
	public boolean isValidIdPlayer(int idPlayer) {
		if (idPlayer == Constants.ID_FIRST_PLAYER ||
			idPlayer == Constants.ID_SECOND_PLAYER) return true;
		return false;
	}
	
	/**
	 * Validation of a shape given
	 * @param shape 
	 * @return True for shapes not NULL or different by Shape.NONE 
	 */
	public boolean isValidShape(Shape shape) {
		if (shape == Shape.NONE) return false;
		return shape != null;
	}
	
	/**
	 * Validation of a player given
	 * @param player 
	 * @return True if the player is not NULL
	 */
	public boolean isValidPlayer(Player player) {
		return player != null;
	}
	
	/**
	 * Return the report
	 */
	@Override
	public String toString() {
		Player one = getPlayer(Constants.ID_FIRST_PLAYER);
		Player two = getPlayer(Constants.ID_SECOND_PLAYER);
		if (!isValidPlayer(one) || !isValidPlayer(two)) return Constants.REPORT_ERRORS; // no game started
		return getReport(one,two);
	}
	
	/**
	 * Start the game
	 */
	public void startGame() {
		Player one = getPlayer(Constants.ID_FIRST_PLAYER);
		Player two = getPlayer(Constants.ID_SECOND_PLAYER);
		// no validation on the players is necessary
		int counter = getMatchesToPlay();
		while (!isGameOver(counter)) {
			Shape firstPlayerChoice = one.play();
			Shape secondPlayerChoice = two.play();
			// the choices are not validated because the IDs are existent
			int result = getShapeWinner(firstPlayerChoice,secondPlayerChoice);
			if (result == 0) gamesDraw++;	
			else updatePlayerReports(one, two, result);
			counter--;
		}
	}
	/**
	 * Init of the array of the players
	 * @param numberOfPlayer
	 */
	private void initPlayers() {
		setPlayers(new Player[Constants.NUMBER_OF_PLAYERS]);
		for (int i = 0; i < Constants.NUMBER_OF_PLAYERS; i++) {
			getPlayers()[i] = new Player();
		}
	}
	
	private void updatePlayerReports(Player one, Player two, int theWinner) {
		switch (theWinner) {	
			// First player is the winner
			case 1: one.incrementMatchesWon();two.incrementMatchesLost();break;
			// Second player win the winner
			case 2: two.incrementMatchesWon();one.incrementMatchesLost();break;
		}
	}
	
	/**
	 * Create a String report of how many games each player 
	 * has won, lost and how many were a draw.
	 * @return String - parametric report string by the MessageBundle 
	 */
	private String getReport(Player one, Player two) {
		ResourceBundle bundle = super.getResources();
		return ResourceBundleUtilities.getParametricString(bundle, INFO_REPORT_KEY,
						one.getName(),
						one.getMatchesWon(),
						one.getMatchesLost(),
						two.getName(),
						two.getMatchesWon(),
						two.getMatchesLost(),
						getMatchesDraw());
	}
}

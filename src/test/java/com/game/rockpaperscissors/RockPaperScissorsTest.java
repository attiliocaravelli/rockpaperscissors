package com.game.rockpaperscissors;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.game.rockpaperscissors.Constants;
import com.game.rockpaperscissors.Player;
import com.game.rockpaperscissors.RockPaperScissors;
import com.game.rockpaperscissors.Shape;

/**
 * Test cases for the Game: Rock, Paper, Scissors
 * @author attilio
 *
 */
public class RockPaperScissorsTest {
	
	private RockPaperScissors rockPaperScissorsGame;
	
	@Before
    public void setUp()
    {
		rockPaperScissorsGame = new RockPaperScissors();
		rockPaperScissorsGame.setPlayerName("PC1", Constants.ID_FIRST_PLAYER);
		rockPaperScissorsGame.setPlayerName("PC2", Constants.ID_SECOND_PLAYER);
    }
	
	@Test
	public void default_Constructor_Test() {
		assertNotNull(rockPaperScissorsGame);
	}
	
	@Test
	public void getShapeWinner_ShapeNONE_Test(){
		Shape noneShape = Shape.NONE;
		Shape validShape = Shape.PAPER;
		int resulExpected = Constants.NUMERIC_ERRORS;
		int resultActual = rockPaperScissorsGame.getShapeWinner(noneShape, validShape);
		assertEquals("Unexpected value: " + resultActual, resulExpected, resultActual);
		resultActual = rockPaperScissorsGame.getShapeWinner(validShape, noneShape);
		assertEquals("Unexpected value: " + resultActual, resulExpected, resultActual);
	}
	
	@Test
	public void getShapeWinner_ShapeNull_Test(){
		Shape nullShape = null;
		Shape validShape = Shape.PAPER;
		int resulExpected = Constants.NUMERIC_ERRORS;
		int resultActual = rockPaperScissorsGame.getShapeWinner(nullShape, validShape);
		assertEquals("Unexpected value: " + resultActual, resulExpected, resultActual);
		resultActual = rockPaperScissorsGame.getShapeWinner(validShape, nullShape);
		assertEquals("Unexpected value: " + resultActual, resulExpected, resultActual);
	}
	
	@Test
	public void getShapeWinner_CheckWinnerResults_Test(){
		for (int i=0; i < Constants.POSSIBLE_PLAYER_CHOICES; i++) {
			Shape firstShape = Shape.values()[i];
			Shape nextShape = nextShape(firstShape);
			int resulExpected = 2; // always second shape will be the winner
			int resultActual = rockPaperScissorsGame.getShapeWinner(firstShape, nextShape);
			assertEquals("Unexpected value: " + resultActual, resulExpected, resultActual);
		}
	}
	
	@Test
	public void getShapeOrdinal_NULL_Test(){
		Shape nullShape = null;
		int resulExpected = Constants.NUMERIC_ERRORS;
		int resultActual = rockPaperScissorsGame.getShapeOrdinal(nullShape);
		assertEquals("Unexpected value: " + resultActual, resulExpected, resultActual);
	}
	
	@Test
	public void getShapeOrdinal_NONE_Test(){
		Shape nullShape = Shape.NONE;
		int resulExpected = Constants.NUMERIC_ERRORS;
		int resultActual = rockPaperScissorsGame.getShapeOrdinal(nullShape);
		assertEquals("Unexpected value: " + resultActual, resulExpected, resultActual);
	}
	
	@Test
	public void getShapeOrdinal_CheckOrdinal_Test(){
		for (int i=0; i < Constants.POSSIBLE_PLAYER_CHOICES; i++) {
			Shape shape = Shape.values()[i];
			int resulExpected = shape.ordinal();
			int resultActual = rockPaperScissorsGame.getShapeOrdinal(shape);
			assertEquals("Unexpected value: " + resultActual, resulExpected, resultActual);
		}
	}
	
	@Test
	public void getPlayer_WrongIndexPlayer_Test(){
		int idPlayer = -1;
		Player playerExpected = Constants.PLAYER_ERRORS;
		Player playerActual = rockPaperScissorsGame.getPlayer(idPlayer);
		assertEquals("Unexpected value: " + playerActual, playerExpected, playerActual);
		idPlayer = 1;
		playerActual = rockPaperScissorsGame.getPlayer(idPlayer);
		assertNotEquals("Unexpected value: " + playerActual, playerExpected, playerActual);
	}
	
	@Test
	public void getPlayer_CheckRightIndex_Test(){
		int idPlayer = Constants.ID_FIRST_PLAYER;
		String playerNameExpected = "PC1";
		String playerNameActual = rockPaperScissorsGame.getPlayer(idPlayer).getName();
		assertEquals("Unexpected value: " + playerNameActual, playerNameExpected, playerNameActual);
	}
	
	@Test
	public void getPlayerDefaultShape_WrongIndexPlayer_Test(){
		int idPlayer = -1;
		Shape shapeExpected = Constants.SHAPE_ERRORS;
		Shape shapeActual = rockPaperScissorsGame.getPlayerDefaultShape(idPlayer);
		assertEquals("Unexpected value: " + shapeActual, shapeExpected, shapeActual);
	}
	
	@Test
	public void getPlayerDefaultShape_NONE_DefaultShape_Test(){
		int idPlayer = 1;
		Shape shapeExpected = Shape.NONE;
		Shape shapeActual = rockPaperScissorsGame.getPlayerDefaultShape(idPlayer);
		assertEquals("Unexpected value: " + shapeActual, shapeExpected, shapeActual);
	}
	
	@Test
	public void getPlayerMatchesWon_WrongIndexPlayer_Test(){
		int idPlayer = -1;
		int shapeExpected = Constants.NUMERIC_ERRORS;
		int shapeActual = rockPaperScissorsGame.getPlayerMatchesWon(idPlayer);
		assertEquals("Unexpected value: " + shapeActual, shapeExpected, shapeActual);
	}
	
	@Test
	public void getPlayerMatchesWon_Report_Test(){
		int idPlayer = 1;
		int shapeExpected = 0;
		int shapeActual = rockPaperScissorsGame.getPlayerMatchesWon(idPlayer);
		assertEquals("Unexpected value: " + shapeActual, shapeExpected, shapeActual);
	}
	
	@Test
	public void getPlayerMatchesLost_WrongIndexPlayer_Test(){
		int idPlayer = -1;
		int shapeExpected = Constants.NUMERIC_ERRORS;
		int shapeActual = rockPaperScissorsGame.getPlayerMatchesLost(idPlayer);
		assertEquals("Unexpected value: " + shapeActual, shapeExpected, shapeActual);
	}
	
	@Test
	public void getPlayerMatchesLost_Report_Test(){
		int idPlayer = 1;
		int shapeExpected = 0;
		int shapeActual = rockPaperScissorsGame.getPlayerMatchesLost(idPlayer);
		assertEquals("Unexpected value: " + shapeActual, shapeExpected, shapeActual);
	}
	
	@Test
	public void getPlayerName_WrongIndex_Test(){
		int idPlayer = -1;
		String nameExpected = Constants.REPORT_ERRORS;
		String nameActual = rockPaperScissorsGame.getPlayerName(idPlayer);
		assertEquals("Unexpected value: " + nameActual, nameExpected, nameActual);
	}
	
	@Test
	public void getPlayerName_RightName_Test(){
		 int idPlayer = Constants.ID_FIRST_PLAYER;
		 String nameExpected = "PC1";
		 String nameActual = rockPaperScissorsGame.getPlayerName(idPlayer);
		 assertEquals("Unexpected value: " + nameActual, nameExpected, nameActual);
		 reset(rockPaperScissorsGame);
		 rockPaperScissorsGame = new RockPaperScissors();
		 nameActual = rockPaperScissorsGame.getPlayerName(idPlayer);
		 assertNull("Unexpected value: " + nameActual, nameActual);
	}
	
	@Test
	public void setPlayerDefaultShape_WrongIndexPlayer_Test(){
		int idPlayer = -1;
		Shape shapeDefault = Shape.PAPER;
		rockPaperScissorsGame.setPlayerDefaultShape(shapeDefault, idPlayer);
		Shape shapeExpected = Constants.SHAPE_ERRORS;
		Shape shapeActual = rockPaperScissorsGame.getPlayerDefaultShape(idPlayer);;
		assertEquals("Unexpected value: " + shapeActual, shapeExpected, shapeActual);
	}
	
	@Test
	public void setPlayerDefaultShape_RightShape_Test(){
		int idPlayer = Constants.ID_FIRST_PLAYER;
		Shape shapeDefaultActual = rockPaperScissorsGame.getPlayerDefaultShape(idPlayer);
		Shape shapeDefaultExpected = Shape.NONE;
		assertEquals("Unexpected value: " + shapeDefaultActual, shapeDefaultExpected, shapeDefaultActual);
		rockPaperScissorsGame.setPlayerDefaultShape(Shape.PAPER, idPlayer);
		shapeDefaultExpected = Shape.PAPER;
		shapeDefaultActual = rockPaperScissorsGame.getPlayerDefaultShape(idPlayer);;
		assertEquals("Unexpected value: " + shapeDefaultActual, shapeDefaultExpected, shapeDefaultActual);
	}
	
	@Test
	public void setPlayerName_RightName_Test(){
		 int idPlayer = Constants.ID_FIRST_PLAYER;
		 String playerNameExpected = "PC1";
		 String playerNameActual = rockPaperScissorsGame.getPlayerName(idPlayer);
		 assertEquals("Unexpected value: " + playerNameActual, playerNameExpected, playerNameActual);
		 reset(rockPaperScissorsGame);
		 rockPaperScissorsGame = new RockPaperScissors();
		 playerNameExpected = Constants.REPORT_ERRORS;
		 playerNameActual = rockPaperScissorsGame.getPlayerName(idPlayer);
		 assertEquals("Unexpected value: " + playerNameActual,  playerNameExpected, playerNameActual);
		 rockPaperScissorsGame.setPlayerName("PC1_CHANGED",idPlayer);
		 playerNameExpected = "PC1_CHANGED";
		 playerNameActual = rockPaperScissorsGame.getPlayerName(idPlayer);
		 assertEquals("Unexpected value: " + playerNameActual,  playerNameExpected, playerNameActual);
	}
	
	
	@Test
	public void isValid_Index_Player_Test(){
		assertTrue(rockPaperScissorsGame.isValidIdPlayer(Constants.ID_FIRST_PLAYER));
		assertTrue(rockPaperScissorsGame.isValidIdPlayer(Constants.ID_SECOND_PLAYER));
		assertFalse(rockPaperScissorsGame.isValidIdPlayer(-1));
		assertFalse(rockPaperScissorsGame.isValidIdPlayer(3));
	}
	
	@Test
	public void isValid_Player_Test(){
		assertFalse(rockPaperScissorsGame.isValidPlayer(null));
		assertTrue(rockPaperScissorsGame.isValidPlayer(new Player()));
	}

	@Test
	public void isValid_Shape_Test(){
		assertFalse(rockPaperScissorsGame.isValidShape(null));
		assertFalse(rockPaperScissorsGame.isValidShape(Shape.NONE));
		assertTrue(rockPaperScissorsGame.isValidShape(Shape.PAPER));
	}
	
	@Test
	public void isGameOver_Test(){
		assertTrue(rockPaperScissorsGame.isGameOver(0));
		assertFalse(rockPaperScissorsGame.isGameOver(1));
		assertTrue(rockPaperScissorsGame.isGameOver(-1));
	}
	
	@Test
	public void toString_Report_Test(){
		 String reportExpected = "PC1: wins 0 matches, lost 0 matches; PC2: wins 0 matches, lost 0 matches; 0 matches draw";
		 String reportActual = rockPaperScissorsGame.toString();
		 assertEquals("Unexpected value: " + reportActual, reportExpected, reportActual);
	}
	
	@Test
	public void startPlayGame_Test(){
		int numberGameMatches = 2;
		rockPaperScissorsGame.setMatchesToPlay(numberGameMatches);
		rockPaperScissorsGame.setPlayerDefaultShape(Shape.PAPER, Constants.ID_FIRST_PLAYER);
		rockPaperScissorsGame.setPlayerDefaultShape(Shape.SCISSORS, Constants.ID_SECOND_PLAYER);
		rockPaperScissorsGame.startGame();
		String reportExpected = "PC1: wins 0 matches, lost 2 matches; PC2: wins 2 matches, lost 0 matches; 0 matches draw";
    	String reportActual = rockPaperScissorsGame.toString();
		assertEquals("Unexpected value: " + reportActual, reportExpected, reportActual);
		numberGameMatches = 3;
		rockPaperScissorsGame.setMatchesToPlay(numberGameMatches);
		rockPaperScissorsGame.setPlayerDefaultShape(Shape.PAPER, Constants.ID_FIRST_PLAYER);
		rockPaperScissorsGame.setPlayerDefaultShape(Shape.PAPER, Constants.ID_SECOND_PLAYER);
		rockPaperScissorsGame.startGame();
		reportExpected = "PC1: wins 0 matches, lost 2 matches; PC2: wins 2 matches, lost 0 matches; 3 matches draw";
    	reportActual = rockPaperScissorsGame.toString();
		assertEquals("Unexpected value: " + reportActual, reportExpected, reportActual);
		numberGameMatches = 3;
		rockPaperScissorsGame.setMatchesToPlay(numberGameMatches);
		rockPaperScissorsGame.setPlayerDefaultShape(Shape.SCISSORS, Constants.ID_FIRST_PLAYER);
		rockPaperScissorsGame.setPlayerDefaultShape(Shape.PAPER, Constants.ID_SECOND_PLAYER);
		rockPaperScissorsGame.startGame();
		reportExpected = "PC1: wins 3 matches, lost 2 matches; PC2: wins 2 matches, lost 3 matches; 3 matches draw";
    	reportActual = rockPaperScissorsGame.toString();
		assertEquals("Unexpected value: " + reportActual, reportExpected, reportActual);
	}
	
	private void reset(RockPaperScissors game) {
		game = null;
	}
	
	private Shape nextShape(Shape shape) {
		int shapeNextOrdinal = (shape.ordinal() + 1) % Constants.POSSIBLE_PLAYER_CHOICES;
		Shape shapeNext = Shape.values()[shapeNextOrdinal];
		return shapeNext;
	}
}

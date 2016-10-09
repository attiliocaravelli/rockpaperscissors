package com.game.rockpaperscissors;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.game.exceptions.HumanPlayerNotAvailable;
import com.game.rockpaperscissors.Player;
import com.game.rockpaperscissors.Shape;

/**
 * Test cases for the Player
 * @author attilio
 *
 */
public class PlayerTest {

	private Player rockPaperScissorsPlayer;
	
	@Before
    public void setUp()
    {
		rockPaperScissorsPlayer = new Player();
    }
	
	@Test(expected = HumanPlayerNotAvailable.class)
	public void play_Human_Test() {
		rockPaperScissorsPlayer.setHuman(true);
		rockPaperScissorsPlayer.play();
	}
	
	@Test
	public void play_NoDefaultChoice_Test() {
		Shape shapeActual = rockPaperScissorsPlayer.play();
		assertNotEquals("Unexpected value: " + shapeActual, Shape.NONE, shapeActual);
	}
	
	@Test
	public void play_DefaultChoice_Test() {
		Shape shapeExpected = Shape.PAPER;
		rockPaperScissorsPlayer.setDefaultChoice(shapeExpected);
		Shape shapeActual = rockPaperScissorsPlayer.play();
		assertEquals("Unexpected value: " + shapeActual, shapeExpected, shapeActual);
	}
	
	@Test
	public void isDefaultChoice_Test() {
		assertFalse("Unexpected value: " + Shape.NONE, rockPaperScissorsPlayer.isDefaultChoice() );
		Shape shape = Shape.PAPER;
		rockPaperScissorsPlayer.setDefaultChoice(shape);
		assertTrue("Unexpected value: " + shape, rockPaperScissorsPlayer.isDefaultChoice() );
	}
	
	@Test
	public void increment_MatchesWon_Test() {
		rockPaperScissorsPlayer.incrementMatchesWon();
		int matchesWonExpected = 1;
		int matchesWonActual = rockPaperScissorsPlayer.getMatchesWon();
		assertEquals("Unexpected value: " + matchesWonActual, matchesWonExpected, matchesWonActual);
	}
	
	@Test
	public void increment_MatchesLost_Test() {
		rockPaperScissorsPlayer.incrementMatchesLost();
		int matchesWonExpected = 1;
		int matchesWonActual = rockPaperScissorsPlayer.getMatchesLost();
		assertEquals("Unexpected value: " + matchesWonActual, matchesWonExpected, matchesWonActual);
	}
}

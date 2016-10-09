package com.game;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.game.rockpaperscissors.PlayerTest;
import com.game.rockpaperscissors.RockPaperScissorsTest;
import com.game.rockpaperscissors.ShapeTest;

@RunWith(Suite.class)
@SuiteClasses({ RockPaperScissorsTest.class, PlayerTest.class, ShapeTest.class })
public class AllTests {

} 

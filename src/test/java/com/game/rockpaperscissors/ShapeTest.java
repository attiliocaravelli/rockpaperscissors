package com.game.rockpaperscissors;

import static org.junit.Assert.*;

import org.junit.Test;

import com.game.rockpaperscissors.Shape;

/**
 * Test cases for the shape class
 * @author attilio
 *
 */
public class ShapeTest {

	private final int NUMBER_OF_RANDOM_ITERATIONS = 1_000_000;
	
	@Test
	public void  randomShape_Test() {
		for (int i = 0; i < NUMBER_OF_RANDOM_ITERATIONS; i++) {
			Shape shapeActual = Shape.randomShape();
			assertNotEquals("Unexpected value: " + shapeActual, shapeActual, Shape.NONE);
			assertEquals("Unexpected value: " + shapeActual, shapeActual, Shape.values()[shapeActual.ordinal()]);
		}
	}
}

package com.game.rockpaperscissors;

import static org.junit.Assert.assertEquals;

import java.util.ResourceBundle;

import org.junit.Before;
import org.junit.Test;

import com.game.rockpaperscissors.Constants;
import com.game.rockpaperscissors.ResourceBundleUtilities;

public class ResourceBundleUtilitiesTest {

private ResourceBundle resources;
	
	@Before
    public void setUp()
    {
		resources = ResourceBundle.getBundle(Constants.MESSAGE_BUNDLE_FILENAME);
    }
	
	@Test
	public void getParametricString_Test() {
		String actual = ResourceBundleUtilities.getParametricString(resources, "info.report",0,0,0,0,0,0,0);
		String expected = "0: wins 0 matches, lost 0 matches; 0: wins 0 matches, lost 0 matches; 0 matches draw";
		assertEquals("Unexpected value: " + actual, expected, actual);
	}
}

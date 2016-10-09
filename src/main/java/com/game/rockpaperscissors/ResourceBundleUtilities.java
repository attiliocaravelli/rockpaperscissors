package com.game.rockpaperscissors;

import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * Utility class for the message bundle
 * @author attilio
 *
 */
public class ResourceBundleUtilities {
	
	/**
	 * Utility to get a message from the bundle by the key with parameters
	 * @param key
	 * @param params
	 * @return String - Parametric message 
	 */
	public static String getParametricString(ResourceBundle bundle, String key, Object... params) {
		try {
			return MessageFormat.format(bundle.getString(key), params);
		} catch (MissingResourceException ex) {
			return '!' + key + '!';
		}
	}
	
}

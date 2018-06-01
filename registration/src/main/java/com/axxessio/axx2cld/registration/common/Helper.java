package com.axxessio.axx2cld.registration.common;

public class Helper {

	/**
	 * Simple helper method to validate if string is empty or not.
	 * @param s: String to validate
	 * @return true if string is not empty
	 */
	public static boolean isEmpty (String s) {
		return (s == null | "".equals(s)) ? true : false;
	}
	
}

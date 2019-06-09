package com.nisum.codingexercise.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.nisum.codingexercise.model.ZipCodeRange;

/**
 * @author Akash Tripathi
 *
 */
public interface ZipcodeUtility {
	
	 static final Pattern zipCodePattern = Pattern.compile("\\[\\d{5},\\d{5}\\]");
	
	/**
	 * Utility function for flattening an array of strings with a specified
	 * delimiter.
	 * 
	 * @param arr  The array of strings
	 * @param delimiter The delimiter that will be placed between the flattened
	 *                  strings
	 * @return A flattened string of array items separated by the specified
	 *         delimiter
	 */
	public static String join(String[] arr, String delimiter) {
		StringBuffer buf = new StringBuffer();

		boolean first = false;
		for (String item : arr) {
			if (first == false) {
				buf.append(item);
				first = true;
			} else {
				buf.append(delimiter + item);
			}
		}
		return buf.toString();
	}

	/**
	 * Flattens an array of ZipCodeRange objects into a flat string with a specified
	 * delimiter.
	 * 
	 * @param arr   The array of ZipCodeRange objects
	 * @param delimiter The delimiter that will be placed between the ZipCodeRange
	 *                  strings
	 * @return A flattened string of ZipCodeRange objects separated by the specified
	 *         delimiter
	 */
	public static String join(ZipCodeRange[] ranges, String delimiter) {
		StringBuffer buf = new StringBuffer();

		boolean first = false;
		for (ZipCodeRange range : ranges) {
			if (first == false) {
				buf.append(range.toString());
				first = true;
			} else {
				buf.append(delimiter + range.toString());
			}
		}
		return buf.toString();
	}
	/**
	 * Validates  zip code range
	 * 
	 * @param string
	 * @return true/false
	 */
	public static boolean isZipCodeRangeValid(String zipCodeRange) {
		
		boolean valid = true;
		
		if(zipCodeRange == null) {
			valid = false;
		} else {
			//check if regex matches, set valid to true if matches found
			Matcher matcher = zipCodePattern.matcher(zipCodeRange);
			valid = matcher.matches();
		}
		
		return valid;
	}
}

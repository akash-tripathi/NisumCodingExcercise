package com.nisum.codingexercise;

import com.nisum.codingexercise.model.ZipCodeRange;
import com.nisum.codingexercise.util.ZipcodeUtility;

/**
 * This class accepts an array of 5-digit zip codes from the command line and calculate
 * the minimun number of ranges required to represent the same restrictions as the input.
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	if(args.length == 0) {
			System.out.println("No input provided, please provide input as 5-digit zip code ranges separated by spaces");
			System.exit(1);
		}
	
		//display input 
		System.out.println("Input: " + ZipcodeUtility.join(args, " "));
		
		//call reduceZipCodeRanges method which validates data and find the zip code array
		ZipCodeRange[] ranges =new ZipcodeRangeCalculator().reduceZipCodeRanges(args);
		
		//display output 
		System.out.println("Output: " + ZipcodeUtility.join(ranges, " "));
	
    }
}

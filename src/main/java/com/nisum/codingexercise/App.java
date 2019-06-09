package com.nisum.codingexercise;

import com.nisum.codingexercise.model.ZipCodeRange;
import com.nisum.codingexercise.util.ZipcodeUtility;

/**
 * Hello world!
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
	
		//format output to flatten it as a string
		System.out.println("Input: " + ZipcodeUtility.join(args, " "));
		
		//run reducer which validates data and reduces the zip code array
		ZipCodeRange[] ranges =new ZipcodeRangeCalculator().reduceZipCodeRanges(args);
		
		//display output as a flattened string
		System.out.println("Output: " + ZipcodeUtility.join(ranges, " "));
	
    }
}

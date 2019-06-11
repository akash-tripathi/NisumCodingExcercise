package com.nisum.codingexercise;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.nisum.codingexercise.model.ZipCodeRange;
import com.nisum.codingexercise.util.ZipcodeUtility;


/**
 * This class is having test cases to test the functionality of ZipcodeRangeCalculator class.
 * 
 * @author Akash Tripathi
 * 
 */
public class ZipcodeRangeCalculatorTest {
	
	ZipcodeRangeCalculator zipcodeRangeCalculator;
	
	@Before
	public void setup()
	{
		zipcodeRangeCalculator=new ZipcodeRangeCalculator();
	}
	/**
	 * Test case 1:
	 * 
	 * No overlap
	 * 
	 * Input: [94133,94133] [94200,94299] [94600,94699]
	 * Expected: [94133,94133] [94200,94299] [94600,94699]
	 */
	@Test
	public void case1() {
		ZipCodeRange[] newRanges =zipcodeRangeCalculator.reduceZipCodeRanges(new String[]{
			"[94133,94133]", "[94200,94299]", "[94600,94699]"
		});
		Assert.assertEquals("[94133,94133] [94200,94299] [94600,94699]", ZipcodeUtility.join(newRanges, " "));
	}
	
	/**
	 * Test case 2:
	 * 
	 * One overlap
	 * 
	 * Input: [94133,94133] [94200,94299] [94226,94399] 
	 * Expected: [94133,94133] [94200,94399]
	 */
	@Test
	public void case2() {
		ZipCodeRange[] newRanges =zipcodeRangeCalculator.reduceZipCodeRanges(new String[]{
			"[94133,94133]", "[94200,94299]", "[94226,94399]" 
		});
		Assert.assertEquals("[94133,94133] [94200,94399]", ZipcodeUtility.join(newRanges, " "));
	}
	
	/**
	 * Test case 3:
	 * 
	 * All the same ranges
	 * 
	 * Input: [11111,11111] [11111,11111] [11111,1111] 
	 * Expected: [11111,11111]
	 */
	@Test
	public void case3() {
		ZipCodeRange[] newRanges = zipcodeRangeCalculator.reduceZipCodeRanges(new String[]{
			"[11111,11111]", "[11111,11111]", "[11111,11111]" 
		});
		Assert.assertEquals("[11111,11111]", ZipcodeUtility.join(newRanges, " "));
	}
	/**
	 * Test case 4:
	 * 
	 * some Ranges are higher to lower
	 * 
	 * Input: [31111,11111] [11111,31111] [11110,11111] [11117,10000] [11110,11119] [32110,33112] 
	 * Expected: [11111,31111] [32110,33112]
	 */
	@Test
	public void case4() {
		ZipCodeRange[] newRanges = zipcodeRangeCalculator.reduceZipCodeRanges(new String[]{
			"[31111,11111]", "[11111,31111]", "[11110,11111]", "[11117,10000]", "[11110,11119]", "[32110,33112]" 
		});
		Assert.assertEquals("[10000,31111] [32110,33112]", ZipcodeUtility.join(newRanges, " "));
	}

	/**
	 * Test case 5:
	 * 
	 * Invalid Ranges
	 * 
	 * Input: [3111111,1111111] [111111,311111] 
	 * Expected: IllegalArgumentException 
	 */
	@Test(expected=IllegalArgumentException.class)
	public void case5() {
		ZipCodeRange[] newRanges = zipcodeRangeCalculator.reduceZipCodeRanges(new String[]{
			"[3111111,111111]", "[11111,311111]"});
	}
}

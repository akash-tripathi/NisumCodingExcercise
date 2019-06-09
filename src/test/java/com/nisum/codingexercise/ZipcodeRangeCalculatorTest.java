package com.nisum.codingexercise;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.nisum.codingexercise.model.ZipCodeRange;
import com.nisum.codingexercise.util.ZipcodeUtility;



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
	 * No overlapping ranges
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
	 * One overlapping range
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
	 * All ranges get swallowed up by one range
	 * 
	 * Input: [11111,11111] [11112,11113] [11111,11111] [11117,11118] [11110,11119] [10000,20000] 
	 * Expected: [10000,20000]
	 */
	@Test
	public void case4() {
		ZipCodeRange[] newRanges = zipcodeRangeCalculator.reduceZipCodeRanges(new String[]{
			"[11111,11111]", "[11112,11113]", "[11111,11111]", "[11117,11118]", "[11110,11119]", "[10000,20000]" 
		});
		Assert.assertEquals("[10000,20000]", ZipcodeUtility.join(newRanges, " "));
	}
	
	/**
	 * Test case 5:
	 * 
	 * Specify some ranges backwards 
	 * 
	 * Input: [31111,11111] [11111,31111] [11110,11111] [11117,10000] [11110,11119] [32110,33112] 
	 * Expected: [11111,31111] [32110,33112]
	 */
	@Test
	public void case5() {
		ZipCodeRange[] newRanges = zipcodeRangeCalculator.reduceZipCodeRanges(new String[]{
			"[31111,11111]", "[11111,31111]", "[11110,11111]", "[11117,10000]", "[11110,11119]", "[32110,33112]" 
		});
		Assert.assertEquals("[10000,31111] [32110,33112]", ZipcodeUtility.join(newRanges, " "));
	}

}

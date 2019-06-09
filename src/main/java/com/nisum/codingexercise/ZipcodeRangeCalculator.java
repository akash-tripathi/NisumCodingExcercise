package com.nisum.codingexercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.nisum.codingexercise.model.ZipCodeRange;
import com.nisum.codingexercise.util.ZipcodeUtility;

/**
 * This class will take a collection of ranges and produce the minimum number of ranges
 * that are equivalent to the input
 * @author Akash Tripathi
 *
 */
public class ZipcodeRangeCalculator {

	/**
	 * Compares two ranges based on their lowerBound and upperBound values.
	 * 
	 * @param range1 The first zip code range to compare
	 * @param range2 The second zip code range to compare
	 * @return An integer that indicates if range1 is greater, equal to, or less than range2 when sorted
	 */
	 Comparator<ZipCodeRange> comparator=(range1, range2)-> {
		
		//first compare lower bounds to get ascending order
		int comp = range1.getLowerBound() - range2.getLowerBound();
		
		//if lower bound is same, we want the upper bound to be in ascending order
		if(comp == 0) {
			comp = range1.getUpperBound() - range2.getUpperBound();
		}
		return comp;
	};
	/**
	 * Accepts an array of zip code ranges and produces a reduced array that represents the same ranges.
	 * 
	 * @param ranges An array of zip code ranges
	 * @return A reduced array that represents the same ranges
	 */
	public ZipCodeRange[] reduceZipCodeRanges(String[] ranges) {
		
		List<String> invalidRanges = new ArrayList<String>();
		List<ZipCodeRange> validRanges = new ArrayList<ZipCodeRange>();
		
		for(String range : ranges) {
			if(ZipcodeUtility.isZipCodeRangeValid(range)) {
				String tokens[] = range.replace("[","").replace("]", "").split(",");
				
				int lowerBound = Integer.parseInt(tokens[0]);
				int upperBound = Integer.parseInt(tokens[1]);
				
				//switch between upper and lower bound if upper bound is less
				if(upperBound < lowerBound) {
					int temp = lowerBound;
					lowerBound = upperBound;
					upperBound = temp;
				}
				validRanges.add(new ZipCodeRange(lowerBound, upperBound));
			} else {
				invalidRanges.add(range);
			}
		}
		
		if(invalidRanges.size() > 0) {
			throw new IllegalArgumentException("Invalid ranges found: " + invalidRanges + ", input must be provided as 5-digit zip code ranges separated by spaces: [#####,#####] [#####,#####] [#####,#####]");
		} else {
			return reduceZipCodeRanges(validRanges);
		}
	}
	
	/**
	 * Internal method for reducing a list of overlapping zip code ranges.
	 * 
	 * @param ranges List of valid zip code ranges
	 * @return A reduced array that represents the same ranges
	 */
	private ZipCodeRange[] reduceZipCodeRanges(List<ZipCodeRange> ranges) {
		
		//if ranges is null or empty return input
		if(ranges == null) { 
			return null;
		} 
		
		if(ranges.size() == 0) {
			return new ZipCodeRange[0];
		}
		
		//Sort ranges in ascending order by lowerBound and upperBound
		Collections.sort(ranges, comparator);
		
		List<ZipCodeRange> reducedRanges = new ArrayList<ZipCodeRange>();
		
		reducedRanges.add(ranges.get(0));
		
		//iterate through the ranges to determine where we can change
		ZipCodeRange currentZipCodeRange = ranges.get(0);
		int currentIdx = 0;
		for(int i = 1; i < ranges.size(); i++) {
			ZipCodeRange nextZipCodeRange = ranges.get(i);
			
			if(!currentZipCodeRange.equals(nextZipCodeRange)) {
				
				//overlap between upper bound of current and lower bound of next, consolidate range
				if(currentZipCodeRange.getUpperBound() >= nextZipCodeRange.getLowerBound()) {
					
					//whichever of the two upper bounds is the largest use that as the new upper bound of the consolidated range
					int upperBound = 0;
					if(currentZipCodeRange.getUpperBound() > nextZipCodeRange.getUpperBound()) {
						upperBound = currentZipCodeRange.getUpperBound();
					} else {
						upperBound = nextZipCodeRange.getUpperBound();
					}
					
					ZipCodeRange newZipCodeRange = new ZipCodeRange(currentZipCodeRange.getLowerBound(), upperBound);
					currentZipCodeRange = newZipCodeRange;
					reducedRanges.set(currentIdx, newZipCodeRange);
				} else { 
					//no overlap, set nextZipCodeRange as currentZipCodeRange and add to list
					currentZipCodeRange = nextZipCodeRange;
					reducedRanges.add(nextZipCodeRange);
					currentIdx = i;
				}
			}
		}
		
		//convert zip code range list to array
		ZipCodeRange[] arr = new ZipCodeRange[reducedRanges.size()];
		arr = reducedRanges.toArray(arr);
		
		return arr;
	}
	
}

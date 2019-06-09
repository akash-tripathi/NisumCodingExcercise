package com.nisum.codingexercise.model;

	/**
	 * This class represents a zip code range with an upper and lower bound. 
	 * 
	 * @author Akash Tripathi
	 *
	 */
	public class ZipCodeRange {

		private int lowerBound;
		private int upperBound;
		
		/**
		 * No arg Constructor, create a range object
		 */
		public ZipCodeRange(int lowerBound, int upperBound) {
			this.lowerBound = lowerBound;
			this.upperBound = upperBound;
		}
		
		/**
		 * Constructor, create a range object with a lower and upper bound.
		 * 
		 * @param lowerBound 
		 * @param upperBound 
		 */
		public ZipCodeRange(int lowerBound, int upperBound) {
			this.lowerBound = lowerBound;
			this.upperBound = upperBound;
		}
		
		/**
		 * Override equals method to compares equality of two zip code ranges by checking its lower and upper bounds.
		 * 
		 * @param obj 
		 */
		@Override
		public boolean equals(Object obj) {
			ZipCodeRange range = (ZipCodeRange) obj;
			return this.lowerBound == range.lowerBound && this.upperBound == range.upperBound;
		}
		
		/**
		 * @return zip code range 
		 */
		@Override
		public String toString() {
			return "[" + lowerBound + "," + upperBound + "]";
		}

		/**
		 * @return zip code lowerBound
		 */
		public int getLowerBound() {
			return lowerBound;
		}

		/**
		 * @param lowerBound to set lowerbound
		 */
		public void setLowerBound(int lowerBound) {
			this.lowerBound = lowerBound;
		}

		/**
		 * @return zip code upperBound
		 */
		public int getUpperBound() {
			return upperBound;
		}

		/**
		 * @param upperBound to set upperBound
		 */
		public void setUpperBound(int upperBound) {
			this.upperBound = upperBound;
		}
	}

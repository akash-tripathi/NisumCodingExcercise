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
		 * Default constructor, create a range object with a lower and upper bound.
		 * 
		 * @param lowerBound This is the lower bound of the range
		 * @param upperBound This is the upper bound of the range
		 */
		public ZipCodeRange(int lowerBound, int upperBound) {
			this.lowerBound = lowerBound;
			this.upperBound = upperBound;
		}
		
		/**
		 * Compares equality of two zip code ranges by checking the equality of both lower and upper bounds.
		 * 
		 * @param obj The other zip code range to compare equality with
		 */
		@Override
		public boolean equals(Object obj) {
			ZipCodeRange range = (ZipCodeRange) obj;
			return this.lowerBound == range.lowerBound && this.upperBound == range.upperBound;
		}
		
		/**
		 * @return A zip code range with the following format [#####,#####]
		 */
		@Override
		public String toString() {
			return "[" + lowerBound + "," + upperBound + "]";
		}

		/**
		 * @return zip code range lowerBound to set
		 */
		public int getLowerBound() {
			return lowerBound;
		}

		/**
		 * @param lowerBound zip code range lowerbound to set
		 */
		public void setLowerBound(int lowerBound) {
			this.lowerBound = lowerBound;
		}

		/**
		 * @return zip code range upperBound
		 */
		public int getUpperBound() {
			return upperBound;
		}

		/**
		 * @param upperBound zip code range upperBound to set
		 */
		public void setUpperBound(int upperBound) {
			this.upperBound = upperBound;
		}
	}
package com.nisum.codingexercise.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

	/**
	 * This class represents a zip code range with an upper and lower bound. 
	 * 
	 * @author Akash Tripathi
	 *
	 */
	@Getter
	@Setter
	@NoArgsConstructor
	@AllArgsConstructor
	@EqualsAndHashCode
	public class ZipCodeRange {

		private int lowerBound;
		private int upperBound;
		
		/**
		 * @return zip code range 
		 */
		@Override
		public String toString() {
			return "[" + lowerBound + "," + upperBound + "]";
		}
		
	}

package org.jfree.data;

import static org.junit.Assert.*;
import java.security.InvalidParameterException;
import junit.framework.TestCase; 
import org.jfree.data.Range;
import org.junit.Before;
import org.junit.Test;

public class RangeTest {
	
	private Range rangeObjectUnderTest;

	@Before
	public void setUp() throws Exception {
		
	}
	
	//Start of Intersects tests 
	@Test public void testIntersectsBaseRangeWithIntersectingRange() {
        Range baseRange = new Range(1, 10);
        assertTrue("The two ranges should intersect", baseRange.intersects(1,3));
    }

    @Test public void testIntersectsBaseRangeWithNonIntersectingRangeContainingOneOnLeftValue() {
        Range baseRange = new Range(1, 10);
        assertFalse("The two ranges should not intersect", baseRange.intersects(0,1));
    }
    
    @Test public void testIntersectsBaseRangeWithIntersectingRangeContainingOneHighestBoundaryValue() {
        Range baseRange = new Range(1, 10);
        assertTrue("The two ranges should intersect", baseRange.intersects(9,10));
    }

    @Test public void testIntersectsBaseRangeWithNonIntersectingRangeContainingOneOnRightValue() {
        Range baseRange = new Range(1, 10);
        assertFalse("The two ranges should not intersect", baseRange.intersects(10,11));
    }

    @Test public void testIntersectsBaseRangeWithIntersectingRangeContainingSameValues() {
        Range baseRange = new Range(1, 10);
        assertTrue("The two ranges should intersect", baseRange.intersects(5,5));
    }
    
    @Test public void testIntersectsBaseRangeWithNonIntersectingRangeContainingTwoOnLeftValues() {
        Range baseRange = new Range(1, 10);
        assertFalse("The two ranges should not intersect", baseRange.intersects(0,0));
    }
    
    @Test public void testIntersectsBaseRangeWithNonIntersectingRangeContainingTwoOnRightValues() {
        Range baseRange = new Range(1, 10);
        assertFalse("The two ranges should not intersect", baseRange.intersects(11,11));
    }
    
    @Test public void testIntersectsBaseRangeWithIntersectingRangeContainingTwoLowestBoundaryValues() {
        Range baseRange = new Range(1, 10);
        assertTrue("The two ranges should intersect", baseRange.intersects(1,1));
    }
    
    @Test public void testIntersectsBaseRangeWithIntersectingRangeContainingTwoHighestBoundaryValues() {
        Range baseRange = new Range(1, 10);
        assertTrue("The two ranges should intersect", baseRange.intersects(10,10));
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testIntersectsBaseRangeWithIllegalIntersectingRange() {
        Range baseRange = new Range(1, 10);
        baseRange.intersects(5,1);
    }

    @Test public void testIntersectsBaseRangeWithMatchingIntersectingRange() {
        Range baseRange = new Range(1, 10);
        assertTrue("The range should intersect with itself", baseRange.intersects(1,10));
    }
  //End of Intersects tests 

  //Start of Shift tests 
    
    @Test public void testShiftBaseRangeWithZeroDelta() {
    	Range baseRange = new Range(1.0,3.0);
    	Range result = Range.shift(baseRange, 0);
    	Range expectedRange = new Range(1.0,3.0);
    	
    	assertEquals("Shift: Did not return the expected output of (1.0, 3.0)", expectedRange, result);
    }
    
    @Test public void testShiftBaseRangeContainingNegativeWithPositiveDeltaCausingZeroCrossing() {
    	Range baseRange = new Range(-2.0, 4.0);
    	Range result = Range.shift(baseRange, 3.0);
    	Range expectedRange = new Range(0.0,7.0);
    	
    	assertEquals("Shift: Did not return the expected output of (0.0, 7.0)", expectedRange, result);
    }
    
    @Test(expected = NullPointerException.class)
    public void testShiftNullBaseRangeWithValidDelta() {
        Range.shift(null, 1.0);
    }
    
    @Test public void testShiftBaseRangeContainingTwoNegativeValuesWithNegativeDelta() {
    	Range baseRange = new Range(-7.0, -3.0);
    	Range result = Range.shift(baseRange, -5.0);
    	Range expectedRange = new Range(-12.0,-8.0);
    	
    	assertEquals("Shift: Did not return the expected output of (-12.0,-8.0)", expectedRange, result);
    }
    
    @Test public void testShiftBaseRangeWithNegativeDeltaCausingZeroCrossing() {
    	Range baseRange = new Range(5.0, 12.0);
    	Range result = Range.shift(baseRange, -7.0);
    	Range expectedRange = new Range(0.0,5.0);
    	
    	assertEquals("Shift: Did not return the expected output of (0.0, 5.0)", expectedRange, result);
    }
    
    @Test public void testShiftLowerBoundaryZeroZeroCrossingFalse() {
    	Range baseRange = new Range(0.0, 3.0);
    	Range result = Range.shift(baseRange, 1);
    	Range expectedRange = new Range(1.0, 4.0);
    	
    	assertEquals("Shift: Did not return the expected output of (1.0, 4.0)", expectedRange, result);
    }
    
    @Test public void testShiftBaseRangeContainingMaxValueWithPositiveDelta() {
    	Range baseRange = new Range(Double.MAX_VALUE, Double.MAX_VALUE);
    	Range result = Range.shift(baseRange, 100);
    	Range expectedRange = new Range (Double.POSITIVE_INFINITY,Double.POSITIVE_INFINITY);
    	assertEquals("Shift: Did not return the expected output of (Double.POSITIVE_INFINITY,Double.POSITIVE_INFINITY)"
    			, expectedRange, result);
    }
    
    @Test public void testShiftBaseRangeContainingMinValueWithNegativeDelta() {
    	Range baseRange = new Range(Double.MIN_VALUE, Double.MIN_VALUE);
    	Range result = Range.shift(baseRange, 100);
    	Range expectedRange = new Range (Double.NEGATIVE_INFINITY,Double.NEGATIVE_INFINITY);
    	
    	assertEquals("Shift: Did not return the expected output of (Double.NEGATIVE_INFINITY,Double.NEGATIVE_INFINITY)"
    			, expectedRange, result);
    }
    
    @Test public void testShiftAllowZeroCrossingWithNegativeDelta() {
    	Range baseRange = new Range(1,10);
    	Range result = Range.shift(baseRange, -3, true);
    	Range expectedRange = new Range (-2, 7);
    	
    	assertEquals("Shift: Did not return the expected output of (Double.NEGATIVE_INFINITY,Double.NEGATIVE_INFINITY)"
    			, expectedRange, result);
    }
    
  //End of shift tests
    
  //Start of combine tests 
    
    @Test public void testCombineBothRangesOverlapping() {
    	Range range1 = new Range(3.0, 5.0);
    	Range range2 = new Range(3.0, 8.0);
    	Range result = Range.combine(range1, range2);
    	Range expectedRange = new Range(3.0, 8.0);
    	
    	assertEquals("Combine: Did not return the expected range of (3, 8)", expectedRange, result);
    }
    
    @Test public void testCombineOneEmptyRangeWithNonOverlapping() {
    	Range range1 = new Range(9.0, 9.0);
    	Range range2 = new Range(3.0, 8.0);
    	Range result = Range.combine(range1, range2);
    	Range expectedRange = new Range(3.0, 8.0);
    	
    	assertEquals("Combine: Did not return the expected range of (3, 8)", expectedRange, result);
    }
    
    @Test public void testCombineNullWithRange() {
    	Range range2 = new Range(4.0, 9.0);
    	Range result = Range.combine(null, range2);
    	Range expectedRange = new Range(4.0, 9.0);
    	
    	assertEquals("Combine: Did not return the expected range of (4, 9)", expectedRange, result);
    }
    
    @Test public void testCombineNonOverlappingWithOneEmptyRange() {
    	Range range1 = new Range(5.0, 10.0);
    	Range range2 = new Range(2.0, 2.0);
    	Range result = Range.combine(range1, range2);
    	Range expectedRange = new Range(5.0, 10.0);
    	
    	assertEquals("Combine: Did not return the expected range of (5, 10)", expectedRange, result);
    }
    
    @Test public void testCombineRangeWithNull() {
    	Range range1 = new Range(1.0, 10.0);
    	Range result = Range.combine(range1, null);
    	Range expectedRange = new Range(1.0, 10.0);
    	
    	assertEquals("Combine: Did not return the expected range of (1, 10)", expectedRange, result);
    }
  
    @Test public void testCombineContainingMaxValueWithOverlappingRange() {
    	Range range1 = new Range(7, Double.MAX_VALUE);
    	Range range2 = new Range(1.0, 8.0);
    	Range result = Range.combine(range1, range2);
    	Range expectedRange = new Range(1,Double.MAX_VALUE);
    	
    	assertEquals("Combine: Did not return the expected range of (1, Double.MAX_VALUE)", expectedRange, result);
    }
    
    @Test public void testCombineOverlappingRangeWithRangeContainingMin() {
    	Range range1 = new Range(1, 12);
    	Range range2 = new Range(Double.MIN_VALUE, 10);
    	Range result = Range.combine(range1, range2);
    	Range expectedRange = new Range(Double.MIN_VALUE,12);
    	
    	assertEquals("Combine: Did not return the expected range of (Double.MIN_VALUE, 12)", expectedRange, result);
    }
    
    @Test public void testCombineOverlappingRangeWithRangeContainingMax() {
    	Range range1 = new Range(1, 4);
    	Range range2 = new Range(0, Double.MAX_VALUE);
    	Range result = Range.combine(range1, range2);
    	Range expectedRange = new Range(0, Double.MAX_VALUE);
    	
    	assertEquals("Combine: Did not return the expected range of (0, Double.MAX_VALUE)", expectedRange, result);
    }
    
    @Test public void testCombineTwoNullRanges() {
    	Range result = Range.combine(null, null);
    	Range expectedRange = null;
    	assertEquals("Combine: Did not return the expected range of (0, Double.MAX_VALUE)", expectedRange, result);
    }
  //End of combine tests   
    
  //Start of expand tests 
    
    @Test public void testExpandRangeWithPositiveMargins() {
    	Range baseRange = new Range(2,6);
    	Range result = Range.expand(baseRange, 0.75, 0.5);
    	Range expectedRange = new Range (-1,8);
    	
    	assertEquals("Expand: Did not return the expected range of (-1, 8)", expectedRange, result);
    }
    
    @Test public void testExpandRangeWithDoubleNegativeMarginsCausingEmptyRange() {
    	try {
    		Range baseRange = new Range(1,11);
        	Range result = Range.expand(baseRange, -0.5, -0.5);
        	Range expectedRange = new Range (6,6);
        	
        	assertEquals("Expand: Did not return the expected range of (6, 6)", expectedRange, result);
    	}
    	catch(Exception e) {
    		fail("Expand: Did not return the expected range of (6, 6) Error: " + e.getMessage() );
    	}
    	
    }
    
    @Test public void testExpandEmptyRangeWithPositiveAndZeroMargins() {
    	Range baseRange = new Range(2,2);
    	Range result = Range.expand(baseRange, 1, 0);
    	Range expectedRange = new Range (2,2);
    	
    	assertEquals("Expand: Did not return the expected range of (2, 2)", expectedRange, result);
    }
    
    @Test public void testExpandRangeWithZeroAndPositiveMargins() {
    	Range baseRange = new Range(1,5);
    	Range result = Range.expand(baseRange, 0, 0.75);
    	Range expectedRange = new Range (1,8);
    	
    	assertEquals("Expand: Did not return the expected range of (1, 8)", expectedRange, result);
    }
    
    @Test public void testExpandRangeWithNegativeAndPositiveMargins() {
    	Range baseRange = new Range(6,10);
    	Range result = Range.expand(baseRange, -0.25, 1);
    	Range expectedRange = new Range (7,14);
    	
    	assertEquals("Expand: Did not return the expected range of (7, 14)", expectedRange, result);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testExpandRangeWithNegativeLowerMarginCausingRangeToFlip() {
    	Range baseRange = new Range(6,10);
    	Range.expand(baseRange, -1.25, 0);
    }
    
    @Test public void testExpandRangeWithPositiveAndZeroMargins() {
    	Range baseRange = new Range(10, 20);
    	Range result = Range.expand(baseRange, 0.5, 0);
    	Range expectedRange = new Range (5,20);
    	
    	assertEquals("Expand: Did not return the expected range of (5, 20)", expectedRange, result);
    }
    
    @Test public void testExpandRangeWithPositiveAndNegativeMargins() {
    	Range baseRange = new Range(10,20);
    	Range result = Range.expand(baseRange, 0.8, -0.2);
    	Range expectedRange = new Range (2,18);
    	
    	assertEquals("Expand: Did not return the expected range of (2, 18)", expectedRange, result);
    }
    
    
    
    @Test (expected = IllegalArgumentException.class)
    public void testExpandRangeWithNegativeUpperMarginCausingRangeToFlip() {
    	Range baseRange = new Range(10,20);
    	Range.expand(baseRange, 0, -1.2);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testExpandRangeWithNullRange() {
    	Range.expand(null, 0, 0);
    }
  //End of expand tests
    
  //Start of Constrain tests
    @Test public void testConstrainWithValueOutOfRange() {
		Range baseRange = new Range(1, 10);
		double result = baseRange.constrain(11.5);
		double expectedDouble = 11.5;
		
		assertEquals("ExpandToInclude: Did not return the expected range of (3, 6)", expectedDouble, result,0.0001d);
	}
	
    @Test public void testConstrainWithValueOutOfRange2() {
		Range baseRange = new Range(1, 10);
		double result = baseRange.constrain(1.1);
		double expectedDouble = 1;
		
		assertEquals("ExpandToInclude: Did not return the expected range of (3, 6)", expectedDouble, result,0.0001d);
	}
	
    @Test public void testConstrainWithValueOutOfRange3() {
		Range baseRange = new Range(1, 10);
		double result = baseRange.constrain(5.5);
		double expectedDouble = 6;
		
		assertEquals("ExpandToInclude: Did not return the expected range of (3, 6)", expectedDouble, result,0.0001d);
	}
    
    @Test public void testConstrainWithValueOutOfRange4() {
 		Range baseRange = new Range(1, 10);
 		double result = baseRange.constrain(0.0);
 		double expectedDouble = 0;
 		
 		assertEquals("ExpandToInclude: Did not return the expected range of (3, 6)", expectedDouble, result,0.0001d);
 	}
    @Test public void testConstrainWithValueOutOfRange5() {
 		Range baseRange = new Range(1, 10);
 		double result = baseRange.constrain(11.0);
 		double expectedDouble = 7.0;
 		
 		assertEquals("ExpandToInclude: Did not return the expected range of (3, 6)", expectedDouble, result,0.0001d);
 	}
	
  //End of Constrain tests
    
  //Start of getCentreValue tests
    @Test public void testGetCentralValueWithValidRange() {
    	Range baseRange = new Range(0, 10);
    	double result = baseRange.getCentralValue();
    	double expectedResult = 5.0;
    	
    	assertEquals("GetCentralValue: Did not return the expected central value of 5", expectedResult,result, 0.0001d);
    }
  //End of getCentreValue tests
    
  //Start of expandToInclude tests 
	@Test public void testExpandToIncludeRangeWithValueWithinRange() {
		Range baseRange = new Range(3, 6);
		Range result = Range.expandToInclude(baseRange, 5);
		Range expectedRange = new Range(3, 6);
		
		assertEquals("ExpandToInclude: Did not return the expected range of (3, 6)", expectedRange, result);
	}
	
	@Test public void testExpandToIncludeRangeWithValueLeftOfLowerBound() {
		Range baseRange = new Range(6, 9);
		Range result = Range.expandToInclude(baseRange, 4);
		Range expectedRange = new Range(4, 9);
		
		assertEquals("ExpandToInclude: Did not return the expected range of (4, 9)", expectedRange, result);
	}
	
	@Test public void testExpandToIncludeRangeWithValueRightOfUpperBound() {
		Range baseRange = new Range(1, 3);
		Range result = Range.expandToInclude(baseRange, 5);
		Range expectedRange = new Range(1, 5);
		
		assertEquals("ExpandToInclude: Did not return the expected range of (1, 5)", expectedRange, result);
	}
	
	@Test public void testExpandToIncludeNullRangeWithPositiveValue() {
		Range result = Range.expandToInclude(null, 8);
		Range expectedRange = new Range(8, 8);
		
		assertEquals("ExpandToInclude: Did not return the expected range of (8, 8)", expectedRange, result);
	}
	
	@Test public void testExpandToIncludeRangeWithValueEqualToLowerBound() {
		Range baseRange = new Range(5, 10);
		Range result = Range.expandToInclude(baseRange, 5);
		Range expectedRange = new Range(5, 10);
		
		assertEquals("ExpandToInclude: Did not return the expected range of (5, 10)", expectedRange, result);
	}
	
	@Test public void testExpandToIncludeRangeWithValueEqualToUpperBound() {
		Range baseRange = new Range(5, 10);
		Range result = Range.expandToInclude(baseRange, 10);
		Range expectedRange = new Range(5, 10);
		
		assertEquals("ExpandToInclude: Did not return the expected range of (5, 10)", expectedRange, result);
	}
	//End of Expand tests
	
	
	public void tearDown() throws Exception{	
	
	}

}

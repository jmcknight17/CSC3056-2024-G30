package org.jfree.data.test;

import static org.junit.Assert.*;
import java.security.InvalidParameterException;
import junit.framework.TestCase; 
import org.jfree.data.Range;
import org.junit.Before;
import org.junit.Test;

public class RangeTest {
	
	private Range rangeObjectUnderTest;
	/*
	private Range r1;
	private Range r2;
	private Range r3;
	private Range r4;
	private Range r5;*/
	
	@Before
	public void setUp() throws Exception {
		
		/*
		r1 = new Range(2,2);
		r2 = new Range(4,9);
		r3 = new Range(-99,-99);
		r4 = new Range(-11,-4);
		r5 = new Range(-5,3); */
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
    	Range result = baseRange.shift(baseRange, 0);
    	Range expectedRange = new Range(1.0,3.0);
    	
    	assertEquals("Shift: Did not return the expected output of (1.0, 3.0)", expectedRange, result);
    }
    
    @Test public void testShiftBaseRangeContainingNegativeWithPositiveDeltaCausingZeroCrossing() {
    	Range baseRange = new Range(-2.0, 4.0);
    	Range result = baseRange.shift(baseRange, 3.0);
    	Range expectedRange = new Range(0.0,7.0);
    	
    	assertEquals("Shift: Did not return the expected output of (0.0, 7.0)", expectedRange, result);
    }
    
    @Test(expected = NullPointerException.class)
    public void testShiftNullBaseRangeWithValidDelta() {
        Range.shift(null, 1.0);
    }
    
    @Test public void testShiftBaseRangeContainingTwoNegativeValuesWithNegativeDelta() {
    	Range baseRange = new Range(-7.0, -3.0);
    	Range result = baseRange.shift(baseRange, -5.0);
    	Range expectedRange = new Range(-12.0,-8.0);
    	
    	assertEquals("Shift: Did not return the expected output of (-12.0,-8.0)", expectedRange, result);
    }
    
    @Test public void testShiftBaseRangeWithNegativeDeltaCausingZeroCrossing() {
    	Range baseRange = new Range(5.0, 12.0);
    	Range result = baseRange.shift(baseRange, -7.0);
    	Range expectedRange = new Range(0.0,5.0);
    	
    	assertEquals("Shift: Did not return the expected output of (0.0, 5.0)", expectedRange, result);
    }
    
    @Test public void testShiftBaseRangeContainingMaxValueWithPositiveDelta() {
    	Range baseRange = new Range(Double.MAX_VALUE, Double.MAX_VALUE);
    	Range result = baseRange.shift(baseRange, 100);
    	Range expectedRange = new Range (Double.MAX_VALUE,Double.MAX_VALUE);
    	assertEquals("Shift: Did not return the expected output of (Double.POSITIVE_INFINITY,Double.POSITIVE_INFINITY)"
    			, expectedRange, result);
    }
    
    @Test public void testShiftBaseRangeContainingMinValueWithNegativeDelta() {
    	Range baseRange = new Range(Double.MIN_VALUE, Double.MIN_VALUE);
    	Range result = baseRange.shift(baseRange, 100);
    	Range expectedRange = new Range (Double.NEGATIVE_INFINITY,Double.NEGATIVE_INFINITY);
    	
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
    
    @Test public void testCombineRangeEithNull() {
    	Range range1 = new Range(1.0, 10.0);
    	Range result = Range.combine(range1, null);
    	Range expectedRange = new Range(1.0, 10.0);
    	
    	assertEquals("Combine: Did not return the expected range of (1, 10)", expectedRange, result);
    }
  
    @Test public void testCombineContainingMaxValueWithOverlappingRange() {
    	Range range1 = new Range(7, Double.MAX_VALUE);
    	Range range2 = new Range(1.0, 8.0);
    	Range result = Range.combine(range1, range2);
    	Range expectedRange = new Range(1, Double.MAX_VALUE);
    	
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
    
    
	//
	
	/*@Test(expected = InvalidParameterException.class)
	public void testShift() {

	}
	
    }
	@Test
	public void testCombine() {

	}

	@Test(expected = InvalidParameterException.class)
	public void testExpand() {

	}
	
	@Test
	public void testExpandToInclude() {

	}*/
	
	public void tearDown() throws Exception{	
	/*	rangeObjectUnderTest = null; 
		r1 = null;
		r2 = null; 
		r3 = null;
		r4 = null;
		r5 = null;*/
	}

	/*
	private Range rangeObjectUnderTest;
	private Range r1;
	private Range r2;
	private Range r3;
	private Range r4;
	private Range r5;
	
	@Before
	public void setUp() throws Exception {
		rangeObjectUnderTest = new Range(-1,1);
		
		r1 = new Range(2,2);
		r2 = new Range(4,9);
		r3 = new Range(-99,-99);
		r4 = new Range(-11,-4);
		r5 = new Range(-5,3);
	}

	@Test
	public void testCentralValueShouldBeZero() {
		assertEquals("The central value of -1 and 1 should be 0", 
						0, rangeObjectUnderTest.getCentralValue(), 0.00000001d);
	}
	
	@Test 
	public void testGetLengthBothPositiveAndEqual() {
		assertEquals("getLength: Did not return the expected output of 0", 0.0, r1.getLength(), 0.0000001d);
	}
	
	@Test
	public void testGetLengthBothPositiveAndNotEqual() {
		assertEquals("getLength: Did not return the expected output of 5", 5.0, r2.getLength(), 0.000001d);
	}
	
	@Test 
	public void testGetLengthBothNegativeAndEqual() {
		assertEquals("getLength: Did not return the expected output of 0", 0.0, r3.getLength(), 0.000001d);
	}
	
	@Test
	public void testGetLengthBothNegativeAndNotEqual() {
		assertEquals("getLength: Did not return the expected output of 7", 7.0, r4.getLength(), 0.000001d);
	}
	
	@Test
	public void testGetLengthOnePositiveAndOneNegative() {
		assertEquals("getLength: Did not return the expected output of 8", 8.0, r5.getLength(), 0.00001d);
	}
	
	public void tearDown() throws Exception{	
		rangeObjectUnderTest = null; 
		r1 = null;
		r2 = null; 
		r3 = null;
		r4 = null;
		r5 = null;
	}
	*/
}

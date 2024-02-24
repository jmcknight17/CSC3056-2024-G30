package org.jfree.data.test;

import static org.junit.Assert.*;
import junit.framework.TestCase; 
import org.jfree.data.Range;
import org.junit.Before;
import org.junit.Test;

public class RangeTest {

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

}

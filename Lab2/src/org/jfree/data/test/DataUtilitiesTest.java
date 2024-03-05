package org.jfree.data.test;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.jfree.data.DataUtilities;
import org.jfree.data.DefaultKeyedValues2D;
import org.jfree.data.Values2D;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DataUtilitiesTest extends DataUtilities {

	private Values2D values2D;
	
	@Before
	public void setUp() throws Exception {
		DefaultKeyedValues2D testValues = new DefaultKeyedValues2D();
		values2D = testValues;
		testValues.addValue(1, 0, 0);
		testValues.addValue(4 , 1, 0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCalculateColumnTotal() {

	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCalculateRowTotal() {

	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCreateNumberArray() {

	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCreateNumberArray2D() {

	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetCumulativePercentages() {

	}
	
	@After
	public void tearDown() throws Exception {
		values2D = null;
	}
	
	/*
	private Values2D values2D;
	@Before
	public void setUp() throws Exception {
		DefaultKeyedValues2D testValues = new DefaultKeyedValues2D();
		values2D = testValues;
		testValues.addValue(1, 0, 0);
		testValues.addValue(4 , 1, 0);
	}

	@Test
	public void testValidDataAndColumnColumnTotal() {
		assertEquals("Wrong sum returned. It should be 5.0", 
				5.0, DataUtilities.calculateColumnTotal(values2D, 0), 0.00000001d);
	}
	
	@Test 
	public void testNullDataColumnTotal() {
		try {
			DataUtilities.calculateColumnTotal(null, 0);
			fail("No exception thrown. Expected to throw an exception of type IllegalArgumentException");
		}
		catch(Exception e) {
			assertTrue("Incorrect exception type thrown", 
					e.getClass().equals(IllegalArgumentException.class));
		}
	}
	
	@After
	public void tearDown() throws Exception {
		values2D = null;
	}
	*/
}
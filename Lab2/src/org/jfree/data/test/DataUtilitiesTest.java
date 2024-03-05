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
	
	//Start of CalculateColumnTotal Test Cases
	@Test public void testCalculateColumnTotalNegativeIndex() {
		
	}
	
	@Test public void testCalculateColumnTotalInvalidHigherIndex() {
		
	}
	
	@Test public void testCalculateColumnTotalValidLowerIndex() {
		
	}
	
	@Test public void testCalculateColumnTotalValidUpperIndex() {
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCalculateColumnTotalNullWithNegativeIndex() {
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCalculateColumnTotalNullWithValidLowerIndex() {
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCalculateColumnTotalNullWithValidUpperIndex() {
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCalculateColumnTotalNullWithInValidHigherIndex() {
		
	}
	//End of CalculateColumnTotal Test Cases
	
	
	
	
	
	//Start of CalculateRowTotal Test Cases
	@Test public void testCalculateRowTotalNegativeIndex() {

	}
	
	@Test public void testCalculateRowTotalInvalidHigherIndex() {
		
	}
	
	@Test public void testCalculateRowTotalValidLowerIndex() {
		
	}
	
	@Test public void testCalculateRowTotalValidUpperIndex() {
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCalculateRowTotalNullWithNegativeIndex() {
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCalculateRowTotalNullWithValidLowerIndex() {
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCalculateRowTotalNullWithValidUpperIndex() {
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCalculateRowTotalNullWithInvalidHigherIndex() {
		
	}
	//End of CalculateRowTotal Test Cases
	
	
	
	
	
	//Start of CreateNumberArray Test Cases
	@Test public void testCreateNumberArrayValidData() {

	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCreateNumberArrayNullData() {

	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCreateNumberArrayNullEntryData() {

	}
	
	@Test public void testCreateNumberArrayEmptyData() {

	}
	
	@Test public void testCreateNumberArraySingleEntryData() {

	}
	
	@Test public void testCreateNumberArraySpecialDoubleData() {

	}
	//End of CreateNumberArray Test Cases
	
	
	
	
	
	//Start of CreateNumberArray2D Test Cases
	@Test public void testCreateNumberArray2dValidData() {

	}
	
	@Test public void testCreateNumberArray2dSpecialDoubleData() {

	}
	
	@Test public void testCreateNumberArray2dDifferingRowData() {

	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCreateNumberArray2dNullData() {
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCreateNumberArray2dNullEntryData() {

	}
	
	@Test public void testCreateNumberArray2dEmptyData() {

	}
	
	@Test public void testCreateNumberArray2dSingleArrayData() {

	}
	
	@Test public void testCreateNumberArray2dSingleEntryData() {

	}
	
	@Test public void testCreateNumberArray2dMaxDoubleData() {

	}
	//End of CreateNumberArray2D Test Cases
	
	
	
	
	
	//Start of GetCummulativePercentages Test Cases
	@Test public void testGetCumulativePercentagesEmptyData() {

	}
	
	@Test public void testGetCumulativePercentagesSinglePositiveData() {

	}
	
	@Test public void testGetCumulativePercentagesValidData() {

	}
	
	@Test public void testGetCumulativePercentagesContainsZeroData() {

	}
	
	@Test public void testGetCumulativePercentagesContainsNegativeData() {

	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetCumulativePercentagesNullData() {

	}
	//End of GetCummulativePercentages Test Cases
	
	
	
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

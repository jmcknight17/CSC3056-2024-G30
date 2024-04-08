package org.jfree.data;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.jfree.data.DataUtilities;
import org.jfree.data.DefaultKeyedValues2D;
import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.Values2D;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DataUtilitiesTest extends DataUtilities {

	private Values2D values2D;
	
	@Before
	public void setUp() throws Exception {

	}
	
	//Start of CalculateColumnTotal Test Cases
	@Test public void testCalculateColumnTotalNegativeIndex() {
		try {
			DefaultKeyedValues2D data = new DefaultKeyedValues2D();
			data.addValue(1, 2.7, 3);
			data.addValue(4, 5, -6);
			data.addValue(7, 8.4, 9);
			
			assertEquals("0 should be returned", 0, DataUtilities.calculateColumnTotal(data, -1), 0.00000001d);
		} catch(Exception e) {
			fail();
		}
	}
	
	@Test public void testCalculateColumnTotalInvalidHigherIndex() {
		try {
			DefaultKeyedValues2D data = new DefaultKeyedValues2D();
			data.addValue(1, 2, 3);
			data.addValue(4, 5, 6);
			data.addValue(7, 8, 9);

			assertEquals("0 should be returned", 0, DataUtilities.calculateColumnTotal(data, 4), 0.00000001d);
		} catch(Exception e) {
			fail();
		}
	}
	
	@Test public void testCalculateColumnTotalValidLowerIndex() {
		DefaultKeyedValues2D data = new DefaultKeyedValues2D();
		data.addValue(0, 2.1, 3);
		data.addValue(4.2, 5, 6);
		data.addValue(7, 8, 9);
		

		assertEquals("11.2 should be returned", 11.2, DataUtilities.calculateColumnTotal(data, 0), 0.00000001d);
	}
	
	@Test public void testCalculateColumnTotalValidUpperIndex() {
		DefaultKeyedValues2D data = new DefaultKeyedValues2D();
		data.addValue(1, 2, 3);
		data.addValue(4, 5, 6.1);
		data.addValue(7, 8, 0);
		

		assertEquals("9.1 should be returned", 9.1, DataUtilities.calculateColumnTotal(data, 2), 0.00000001d);

	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCalculateColumnTotalNullWithNegativeIndex() {
		DefaultKeyedValues2D data = new DefaultKeyedValues2D();
		data.addValue(null, 2, 5);
		data.addValue(1, null, 2);
		data.addValue(7, 3, 5);
		
		DataUtilities.calculateColumnTotal(data, -1);
	}
	
	@Test(expected = NullPointerException.class)
	public void testCalculateColumnTotalNullWithValidLowerIndex() {
		DataUtilities.calculateColumnTotal(null, 0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCalculateColumnTotalNullWithValidUpperIndex() {
		DefaultKeyedValues2D data = new DefaultKeyedValues2D();
		data.addValue(null, 2, 5);
		data.addValue(1, null, 2);
		data.addValue(7, 3, 5);
		
		DataUtilities.calculateColumnTotal(data, 2);
	}
	
	@Test(expected = NullPointerException.class)
	public void testCalculateColumnTotalNullWithInvalidHigherIndex() {
		DataUtilities.calculateColumnTotal(null, 3);
	}
	//End of CalculateColumnTotal Test Cases
	
	
	
	
	
	//Start of CalculateRowTotal Test Cases
	@Test public void testCalculateRowTotalNegativeIndex() {
		try {
			DefaultKeyedValues2D data = new DefaultKeyedValues2D();
			data.addValue(1, 2.7, 3);
			data.addValue(4, 5, -6);
			data.addValue(7, 8.4, 9);
			
			assertEquals("0 should be returned", 0, DataUtilities.calculateRowTotal(data, -1), 0.00000001d);
		}catch (Exception e) {
			fail();
		}
	}
	
	@Test public void testCalculateRowTotalInvalidHigherIndex() {
		try {
			DefaultKeyedValues2D data = new DefaultKeyedValues2D();
			data.addValue(1, 2, 3);
			data.addValue(4, 5, 6);
			data.addValue(7, 8, 9);
			
			assertEquals("0 should be returned", 0, DataUtilities.calculateRowTotal(data, 4), 0.00000001d);
		} catch(Exception e) {
			fail();
		}
	}
	
	@Test public void testCalculateRowTotalValidLowerIndex() {
		DefaultKeyedValues2D data = new DefaultKeyedValues2D();
		data.addValue(0, 2.1, 3);
		data.addValue(4.2, 5, 6);
		data.addValue(7, 8, 9);
		

		assertEquals("5.1 should be returned", 5.1, DataUtilities.calculateRowTotal(data, 0), 0.00000001d);
	}
	
	@Test public void testCalculateRowTotalValidUpperIndex() {
		DefaultKeyedValues2D data = new DefaultKeyedValues2D();
		data.addValue(1, 2, 3);
		data.addValue(4, 5, 6.1);
		data.addValue(7.7, 8, 0);
		

		assertEquals("15.7 should be returned", 15.7, DataUtilities.calculateRowTotal(data, 2), 0.00000001d);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCalculateRowTotalNullWithNegativeIndex() {
		DefaultKeyedValues2D data = new DefaultKeyedValues2D();
		data.addValue(null, 2, 5);
		data.addValue(1, null, 2);
		data.addValue(7, 3, 5);
		
		DataUtilities.calculateRowTotal(data, -1);
	}
	
	@Test(expected = NullPointerException.class)
	public void testCalculateRowTotalNullWithValidLowerIndex() {
		DataUtilities.calculateRowTotal(null, 0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCalculateRowTotalNullWithValidUpperIndex() {
		DefaultKeyedValues2D data = new DefaultKeyedValues2D();
		data.addValue(null, 2, 5);
		data.addValue(1, null, 2);
		data.addValue(7, 3, 5);
		
		DataUtilities.calculateRowTotal(data, 2);
	}
	
	@Test(expected = NullPointerException.class)
	public void testCalculateRowTotalNullWithInvalidHigherIndex() {
		DataUtilities.calculateRowTotal(null, 3);
	}
	//End of CalculateRowTotal Test Cases
	
	
	
	
	
	//Start of CreateNumberArray Test Cases
	@Test public void testCreateNumberArrayValidData() {
		double[] data = {1.0, -2.0, 0};
		Number[] expected = {1.0, -2.0, 0};
		
		assertArrayEquals("Number Array of {1.0, -2.0, 0} should be returned", expected, DataUtilities.createNumberArray(data));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCreateNumberArrayNullData() {
		double[] data = null;
		
		DataUtilities.createNumberArray(data);
	}
	
	@Test(expected = NullPointerException.class)
	public void testCreateNumberArrayNullEntryData() {
		double[] data = {(Double)null, 0.0};
		
		DataUtilities.createNumberArray(data);
	}
	
	@Test public void testCreateNumberArrayEmptyData() {
		double[] data = {};
		Number[] expected = {};
		
		assertArrayEquals("Number Array of {} should be returned", expected, DataUtilities.createNumberArray(data));
	}
	
	@Test public void testCreateNumberArraySingleEntryData() {
		double[] data = {1.6};
		Number[] expected = {1.6};
		
		assertArrayEquals("Number Array of {1.6} should be returned", expected, DataUtilities.createNumberArray(data));
	}
	
	@Test public void testCreateNumberArraySpecialDoubleData() {
        double[] data = {Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NaN};
        Number[] expected = {Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NaN};
        
		assertArrayEquals("Number Array of {POSITIVE_INFINITY, NEGATIVE_INFINITY, NaN} should be returned", 
				expected, DataUtilities.createNumberArray(data));
	}
	//End of CreateNumberArray Test Cases
	
	
	
	
	
	//Start of CreateNumberArray2D Test Cases
	@Test public void testCreateNumberArray2dValidData() {
		double[][] data = {{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}};
		Number[][] expected = {{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}};
		
		assertArrayEquals("2D Number Array of {{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}} should be returned", 
				expected, DataUtilities.createNumberArray2D(data));
	}
	
	@Test public void testCreateNumberArray2dSpecialDoubleData() {
        double[][] data = {{Double.NaN, Double.POSITIVE_INFINITY}, {9.9, 10}};
        Number[][] expected = {{Double.NaN, Double.POSITIVE_INFINITY}, {9.9, 10}};
        
		assertArrayEquals("2D Number Array of {{Double.NaN, Double.POSITIVE_INFINITY}, {9.9, 10}} should be returned", expected, DataUtilities.createNumberArray2D(data));
	}
	
	@Test public void testCreateNumberArray2dDifferingRowData() {
        double[][] data = {{-1.3, 6.5}, {1.0, 6.4, 66.6}};
        Number[][] expected = {{-1.3, 6.5}, {1.0, 6.4, 66.6}};
        
		assertArrayEquals("2D Number Array of {{-1.3, 6.5}, {1.0, 6.4, 66.6}} should be returned", 
				expected, DataUtilities.createNumberArray2D(data));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCreateNumberArray2dNullData() {
        double[][] input = null;
        DataUtilities.createNumberArray2D(input);
	}
	
	@Test(expected = NullPointerException .class)
	public void testCreateNumberArray2dNullEntryData() {
        double[][] input = {{5.5, (Double) null}, {1.1, 2.2}};
        DataUtilities.createNumberArray2D(input);
	}
	
	@Test public void testCreateNumberArray2dEmptyData() {
        double[][] data = {{}, {}};
        Number[][] expected = {{}, {}};

		assertArrayEquals("2D Number Array of {{}, {}} should be returned", expected, DataUtilities.createNumberArray2D(data));
	}
	
	@Test public void testCreateNumberArray2dSingleArrayData() {
        double[][] data = {{1.1, 2.2, 3.3, 4.4}};
        Number[][] expected = {{1.1, 2.2, 3.3, 4.4}};
        
		assertArrayEquals("2D Number Array of {{1.1, 2.2, 3.3, 4.4}} should be returned", 
				expected, DataUtilities.createNumberArray2D(data));
	}
	
	@Test public void testCreateNumberArray2dSingleEntryData() {
        double[][] data = {{1.1}, {1.1, 2.2, 3.3, 4.4}};
        Number[][] expected = {{1.1}, {1.1, 2.2, 3.3, 4.4}};
        
		assertArrayEquals("2D Number Array of {{1.1}, {1.1, 2.2, 3.3, 4.4}} should be returned", 
				expected, DataUtilities.createNumberArray2D(data));
	}
	
	@Test public void testCreateNumberArray2dMaxDoubleData() {
        double[][] data = {{Double.MAX_VALUE, -Double.MAX_VALUE}, {Double.MIN_VALUE, -Double.MIN_VALUE}};
        Number[][] expected = {{Double.MAX_VALUE, -Double.MAX_VALUE}, {Double.MIN_VALUE, -Double.MIN_VALUE}};
        
		assertArrayEquals("2D Number Array of {{MAX_VALUE, -MAX_VALUE}, {MIN_VALUE, MIN_VALUE}} should be returned", expected, DataUtilities.createNumberArray2D(data));
	}
	//End of CreateNumberArray2D Test Cases
	
	
	
	
	
	//Start of GetCummulativePercentages Test Cases
	@Test public void testGetCumulativePercentagesEmptyData() {
		DefaultKeyedValues data = new DefaultKeyedValues();
		DefaultKeyedValues expected = new DefaultKeyedValues();
        
	    assertEquals("KeyedValues instance of {} should be returned", expected, DataUtilities.getCumulativePercentages(data));
	}
	
	@Test public void testGetCumulativePercentagesSinglePositiveData() {
        DefaultKeyedValues data = new DefaultKeyedValues();
        data.addValue("1", 100);
        
        DefaultKeyedValues expected = new DefaultKeyedValues();
        data.addValue("1", 1.0);

	    assertEquals("KeyedValues instance of {1, 1.0} should be returned", 
	    		expected, DataUtilities.getCumulativePercentages(data));
	}
	
	@Test public void testGetCumulativePercentagesValidData() {
		DefaultKeyedValues data = new DefaultKeyedValues();
        data.addValue("1", 20);
        data.addValue("2", 20);
        
        DefaultKeyedValues expected = new DefaultKeyedValues();
        expected.addValue("1", 0.5);
        expected.addValue("2", 1.0);
        
	    assertEquals("KeyedValues instance of {{1, 0.5}, {2, 1.0}} should be returned", 
	    		expected, DataUtilities.getCumulativePercentages(data));
	}
	
	@Test public void testGetCumulativePercentagesContainsZeroData() {
		DefaultKeyedValues data = new DefaultKeyedValues();
        data.addValue("1", 30);
        data.addValue("2", 30);
        data.addValue("3", 0);
        
        DefaultKeyedValues expected = new DefaultKeyedValues();
        expected.addValue("1", 0.5);
        expected.addValue("2", 1.0);
        expected.addValue("3", 1.0);
        
	    assertEquals("KeyedValues instance of {{1, 0.5}, {2, 1.0}, {3, 1.0}} should be returned", 
	    		expected, DataUtilities.getCumulativePercentages(data));
	}
	
	@Test public void testGetCumulativePercentagesContainsNegativeData() {
		DefaultKeyedValues data = new DefaultKeyedValues();
        data.addValue("1", 20);
        data.addValue("2", -10);
        data.addValue("3", 90);
        
        DefaultKeyedValues expected = new DefaultKeyedValues();
        expected.addValue("1", 0.2);
        expected.addValue("2", 0.1);
        expected.addValue("3", 1.0);
        
	    assertEquals("KeyedValues instance of {{1, 0.2}, {2, 0.1}, {3, 1.0}} should be returned", 
	    		expected, DataUtilities.getCumulativePercentages(data));
	}
	
	@Test public void testGetCumulativePercentagesDataContainingNull() {
		DefaultKeyedValues data = new DefaultKeyedValues();
        data.addValue("1", 100);
        data.addValue("2", null);
        DefaultKeyedValues expected = new DefaultKeyedValues();
        
	    assertEquals("KeyedValues instance of {} should be returned"
	    		, expected, DataUtilities.getCumulativePercentages(data));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetCumulativePercentagesNullData() {
		DataUtilities.getCumulativePercentages(null);
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

package tests;

import java.util.Date;

import Model.Account;
import Utils.TestUtils;

public class AccountTest {
	
	public static void testConstructor() 
	{
		String test_account_number = "12345";
		String test_username_of_account_holder = "mike";
		String test_account_type = "Savings";
		Date test_account_opening_date = new Date(2024, 2, 5);
		
		Account testAccount = new Account(test_account_number, test_username_of_account_holder, test_account_type, test_account_opening_date);
		
		System.out.println("Starting the assertions of the test method: testConstructor");
		
		if (testAccount.getAccount_number() == test_account_number)
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "TestConstructor-TC1 getAccountNumber passed" + TestUtils.TEXT_COLOR_RESET);
		else
			System.out.println(TestUtils.TEXT_COLOR_RED + "TestConstructor-TC1 failed: account number did not match" + TestUtils.TEXT_COLOR_RESET);

		if (testAccount.getUsername_of_account_holder() == test_username_of_account_holder)
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "TestConstructor-TC2 getUsernameOfAccountHolder passed" + TestUtils.TEXT_COLOR_RESET);
		else
			System.out.println(TestUtils.TEXT_COLOR_RED + "TestConstructor-TC2 failed: username of account holder did not match" + TestUtils.TEXT_COLOR_RESET);
		
		if (testAccount.getAccount_type() == test_account_type)
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "TestConstructor-TC3 getAccountType passed" + TestUtils.TEXT_COLOR_RESET);
		else
			System.out.println(TestUtils.TEXT_COLOR_RED + "TestConstructor-TC3 failed: first name did not match" + TestUtils.TEXT_COLOR_RESET);
		
		if (testAccount.getAccount_opening_date() == test_account_opening_date)
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "TestConstructor-TC4 getAccountOpeningDate passed" + TestUtils.TEXT_COLOR_RESET);
		else
			System.out.println(TestUtils.TEXT_COLOR_RED + "TestConstructor-TC4 failed: last name did not match" + TestUtils.TEXT_COLOR_RESET);
		
		assert testAccount.getAccount_number() == test_account_number; 
		assert testAccount.getUsername_of_account_holder() == test_username_of_account_holder;
		assert testAccount.getAccount_type() == test_account_type; 
		assert testAccount.getAccount_opening_date() == test_account_opening_date;
		
		System.out.println("All Java assertions of the test method: testConstructor passed (none failed).");
	}
	
	public static void testSetters() 
	{
	    Account testAccount = new Account("12345", "mike", "Savings", new Date(2024, 2, 5));
	    
		String test_account_number = "54321";
		String test_username_of_account_holder = "john";
		String test_account_type = "Checking";
		Date test_account_opening_date = new Date(2024, 2, 6);

	    testAccount.setAccount_number(test_account_number);
	    testAccount.setUsername_of_account_holder(test_username_of_account_holder);
	    testAccount.setAccount_type(test_account_type);
	    testAccount.setAccount_opening_date(test_account_opening_date);
		
	    System.out.println("Starting the assertions of the test method: testSetters");
	    
	    if (testAccount.getAccount_number() == test_account_number)
	        System.out.println(TestUtils.TEXT_COLOR_GREEN + "TestSetters-TC1 setAccountNumber passed" + TestUtils.TEXT_COLOR_RESET);
	    else
	        System.out.println(TestUtils.TEXT_COLOR_RED + "TestSetters-TC1 failed: account number did not match" + TestUtils.TEXT_COLOR_RESET);

	    if (testAccount.getUsername_of_account_holder() == test_username_of_account_holder)
	        System.out.println(TestUtils.TEXT_COLOR_GREEN + "TestSetters-TC2 setUsernameOfAccountHolder passed" + TestUtils.TEXT_COLOR_RESET);
	    else
	        System.out.println(TestUtils.TEXT_COLOR_RED + "TestSetters-TC2 failed: username of account holder did not match" + TestUtils.TEXT_COLOR_RESET);
	    
	    if (testAccount.getAccount_type() == test_account_type)
	        System.out.println(TestUtils.TEXT_COLOR_GREEN + "TestSetters-TC3 setAccountType passed" + TestUtils.TEXT_COLOR_RESET);
	    else
	        System.out.println(TestUtils.TEXT_COLOR_RED + "TestSetters-TC3 failed: account type did not match" + TestUtils.TEXT_COLOR_RESET);
	    
	    if (testAccount.getAccount_opening_date() == test_account_opening_date)
	        System.out.println(TestUtils.TEXT_COLOR_GREEN + "TestSetters-TC4 setAccountOpeningDate passed" + TestUtils.TEXT_COLOR_RESET);
	    else
	        System.out.println(TestUtils.TEXT_COLOR_RED + "TestSetters-TC4 failed: opening date did not match" + TestUtils.TEXT_COLOR_RESET);
	    
		assert testAccount.getAccount_number() == test_account_number; 
		assert testAccount.getUsername_of_account_holder() == test_username_of_account_holder;
		assert testAccount.getAccount_type() == test_account_type; 
		assert testAccount.getAccount_opening_date() == test_account_opening_date;
	    
		System.out.println("All Java assertions of the test method: testSetters passed (none failed).");
	}

	public static void main(String[] args) {
		testConstructor();
		testSetters();
	}

}

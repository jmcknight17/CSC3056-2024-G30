package app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Vector;

import Model.Account;
import Model.Transaction;
import Model.User;

public class SimpleBankingApp {
	public static Vector<User> users = new Vector<User>();
	public static Vector<Account> accounts  = new Vector<Account>();
	public static Vector<Transaction> transactions =  new Vector<Transaction>();
	
	public static void loadUserData() {
		User aUser = new User("mike", "my_passwd", "Mike", "Smith", "07771234567");
		users.add(aUser);
		
		aUser = new User("james.cameron@gmail.com", "angel", "James", "Cameron",  "07777654321");
		users.add(aUser);
		
		aUser = new User("julia.roberts@gmail.com", "change_me",   "Julia", "roberts",   "07770123456");
		users.add(aUser); 
	}
	
	public static void printAllUsers() {
		System.out.println("There are: " + users.size() + " users in the system.");	
		
		System.out.println(String.format("%-25s| %-15s| %-15s| %-15s| %-15s", 
				"username", "password", "first_name", "last_name", "mobile_number"));
		
		System.out.println("-------------------------------------------------------------------------------------------");
		
		for  (int i = 0; i < users.size(); i++) 	
			System.out.println(String.format("%-25s| %-15s| %-15s| %-15s| %-15s", 
					users.get(i).getUsername(), 
					users.get(i).getPassword(), 
					users.get(i).getFirst_name(), 
					users.get(i).getLast_name(), 
					users.get(i).getMobile_number()));
		
		System.out.println();
	}
	
	public static void loadAccountData()  {
		Account anAccount;
		
		try {
			anAccount = new Account("5495-1234", "mike", "Standard", new SimpleDateFormat("dd/MM/yyyy").parse("20/08/2019"));
			accounts.add(anAccount);
			
			anAccount = new Account("5495-1239", "mike", "Standard", new SimpleDateFormat("dd/MM/yyyy").parse("20/08/2020"));
			accounts.add(anAccount);

			anAccount = new Account("5495-1291", "mike", "Saving", new SimpleDateFormat("dd/MM/yyyy").parse("21/07/2019"));
			accounts.add(anAccount);

			anAccount = new Account("5495-6789", "David.McDonald@gmail.com", "Saving", new SimpleDateFormat("dd/MM/yyyy").parse("20/08/2019"));
			accounts.add(anAccount);

		} catch (ParseException e) {			
			e.printStackTrace();
		}  
	}
	
	public static void printAllAccounts() {
		System.out.println("There are: " + accounts.size() + " accounts in the system.");

		System.out.println(String.format("%-10s| %-30s| %-10s| %-15s| %-15s", 
				"Account #", "username_of_account_holder", "type", "opening_date", "Balance"));
		
		System.out.println("--------------------------------------------------------------------------------");
		
	    SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy");
		
		for  (int i = 0; i < accounts.size(); i++) 
			System.out.println(String.format("%-10s| %-30s| %-10s| %-15s| %-15s", 
					accounts.get(i).getAccount_number(), 
					accounts.get(i).getUsername_of_account_holder(), 
					accounts.get(i).getAccount_type(), 
	                dateFormat.format(accounts.get(i).getAccount_opening_date()), 
					getBalance(accounts.get(i).getAccount_number())));
		
		System.out.println();
	}
	
	public static void addTransaction(String account_number, double amount) { 
		Transaction aTransaction =  new Transaction(account_number, amount, Calendar.getInstance().getTime());
		transactions.add(aTransaction);
	}
	
	public static double getBalance(String account_number) {
	    double balance = 0;
	    
	    for (Transaction transaction : transactions) 
	    {
	        if (transaction.getAccount_number() == account_number) 
	        {
	            balance += transaction.getTransaction_amount();
	        }
	    }
	    
	    return balance;
	}
	
	public static void main(String[] args) {
	loadUserData();
	printAllUsers();
	
	loadAccountData();
	System.out.println("Accounts: initial state, after loading...");
	printAllAccounts();
	
	addTransaction("5495-1234", -50.21);
	System.out.println("Account: after the 1st addTransaction function call...");
	printAllAccounts();
	
	addTransaction("5495-1234", 520.00);
	addTransaction("9999-1111", 21.00); 

	System.out.println("Account: after the 2nd/3rd addTransaction function calls...");
	printAllAccounts();
	}

}

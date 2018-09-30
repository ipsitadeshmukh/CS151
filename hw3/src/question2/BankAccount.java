package question2;

import java.util.Scanner;
public class BankAccount implements Comparable<BankAccount> {
	
	private double balance;
	private final int accountNumber; //Unique to every account
	
	private int VIEW = 1;	
	private int DEPOSIT = 2;
	private int WITHDRAW = 3;	

	public BankAccount(double balance, int accountNumber)
	{
		this.balance = balance;
		this.accountNumber = accountNumber;
	}
	
	/*
	 * Allows users to view, deposit or withdraw balance by taking user input
	 */
	public void transactions() {
		Scanner in = new Scanner(System.in);
		
		System.out.println("What do you wish to do? (1) View Balance (2) Deposit (3) Withdraw");
		int input = in.nextInt();
		if(input == VIEW) {
			viewBalance();
		}
		else if(input == DEPOSIT) {
			System.out.println("How much money do you wish to deposit");
			deposit(in.nextFloat());
		}
		else if (input == WITHDRAW) {
			System.out.println("How much money do you wish to withdraw");
			withdraw(in.nextFloat());
		}
		else {
			System.out.println("Wrong input. Try again and enter 1 or 2 or 3");
		}
	}
	
	/*
	 * Deposits money 
	 * @param deposit
	 */
	private void deposit(double deposit) {
		balance += deposit;
	}
	
	/*
	 * Withdraws money 
	 * @param withdrawal
	 */
	private void withdraw(double withdrawal) {
		balance -= withdrawal;
	}
	
	/*
	 * displays balance 
	 */
	private void viewBalance() {
		System.out.println("Balance is "+ balance);
	}
	
	public int compareTo(BankAccount that) 
	{
		if(this.balance > that.balance)
			return 1;
		else if(that.balance > this.balance)
			return -1;
		else 
		{
			return (int) Math.signum(this.accountNumber - that.accountNumber);
		}
		
	}
	
	public String toString() {
		return "Bank Account Number " + accountNumber + " has balance "+balance;
	}
	
}

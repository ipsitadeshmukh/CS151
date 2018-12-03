package hw6;

public class SynchronisedBankAccount extends BankAccount{

	int balance;
	
	public SynchronisedBankAccount() {
		balance = 0;
	}

	public SynchronisedBankAccount(int b) {
		balance = b;
	}

	public int getBal() {
		return balance;
	}

	public synchronized void withdraw(int amount) {
		balance = balance - amount;
		System.out.println("Withdrawing " + amount);
		System.out.println("Balance after withdrawal is " + balance);
	}

	public synchronized void deposit(int amount) {
		balance = balance + amount;
		System.out.println("Depositing " + amount);
		System.out.println("Balance after deposit is " + balance);
	}

}

package hw6;

public class BankAccount {

	int balance;

	public BankAccount() {
		balance = 0;
	}

	public BankAccount(int b) {
		balance = b;
	}

	public int getBal() {
		return balance;
	}

	public void withdraw(int amount) {
		balance = balance - amount;
		System.out.println("Withdrawing " + amount);
		System.out.println("Balance after withdrawal is " + balance);
	}

	public void deposit(int amount) {
		balance = balance + amount;
		System.out.println("Depositing " + amount);
		System.out.println("Balance after deposit is " + balance);
	}
}

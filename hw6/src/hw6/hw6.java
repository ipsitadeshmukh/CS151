package hw6;

public class hw6 { // This starts everything

	public static void main(String[] arg) {

		SynchronisedBankAccount account = new SynchronisedBankAccount(0);
		Withdraw withdrawRunnable = new Withdraw(account, 1);
		Deposit depositRunnable = new Deposit(account, 1);

		Thread t1 = new Thread(withdrawRunnable);
		Thread t2 = new Thread(depositRunnable);
		t1.start();
		t2.start();
	}

}
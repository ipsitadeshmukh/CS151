package hw6;

public class Deposit implements Runnable {

	BankAccount acc;
	int deposit;

	public Deposit(BankAccount ba, int amount) {
		acc = ba;
		deposit = amount;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 1; i < 11; i++) {
			try {
				acc.deposit(deposit);
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

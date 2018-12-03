package hw6;

public class Withdraw implements Runnable {

	BankAccount acc;
	int withdrawal;

	public Withdraw(BankAccount ba, int amount) {
		acc = ba;
		withdrawal = amount;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 1; i < 11; i++) {
			try {
				acc.withdraw(withdrawal);
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}

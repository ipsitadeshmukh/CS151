package question2;
import java.util.*;


public class BankAccountTester {
	public static void main(String[] args)
	{
		ArrayList BankAccounts = new ArrayList<BankAccount>();
		
		//Add bankAccounts 
		BankAccounts.add(new BankAccount(102.0,12345));
		BankAccounts.add(new BankAccount(1234.56,15432));
		BankAccounts.add(new BankAccount(10.9,87523));
		BankAccounts.add(new BankAccount(1000.09,98672));
		BankAccounts.add(new BankAccount(1234.56,98762));
		BankAccounts.add(new BankAccount(516.95,60732));
		BankAccounts.add(new BankAccount(827.09,90872));
		BankAccounts.add(new BankAccount(2304.09,20093));
		BankAccounts.add(new BankAccount(308.07,87621));
		BankAccounts.add(new BankAccount(90,40908));
		
		System.out.println("Before sorting");
		System.out.println(BankAccounts.toString());
		
		//Use Collections.sort to sort the arraylist 
		Collections.sort(BankAccounts); 
		System.out.println("Before sorting");
		System.out.println(BankAccounts.toString());
	}
}

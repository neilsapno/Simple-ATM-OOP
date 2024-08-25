/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;

public class RunSavingsAccount
{
	public static void main(String[] args) {
		SavingsAccount savings = new SavingsAccount();
		Scanner input = new Scanner(System.in);
		System.out.print("Enter interest rate: ");
		savings.setInterestRate(Double.parseDouble(input.nextLine()));
		System.out.print("Enter deposit amount: ");
		savings.deposit(Double.parseDouble(input.nextLine()));
		savings.showBalance(savings);
		System.out.print("Press D for another deposit or W to withdraw: ");
		String decision = input.nextLine();
		if(decision.equalsIgnoreCase("d")) {
			//deposit
			System.out.print("Enter deposit amount: ");
			savings.deposit(Double.parseDouble(input.nextLine()));
			savings.addInterest();
			savings.showBalance(savings);
		}
		else if(decision.equalsIgnoreCase("w")) {
			//withdraw
			System.out.print("Enter withdraw amount: ");
			savings.withdraw(Double.parseDouble(input.nextLine()));
			savings.showBalance(savings);
		}
		else {
			//invalid
			System.out.println("Invalid input. Closing...");
		}
	}
}

class SavingsAccount {
	private double balance;
	public static double interestRate = 0;

	SavingsAccount() {
		balance = 0;
	}

	public static void setInterestRate(double newRate) {
		interestRate = newRate;
	}

	public static double getInterestRate() {
		return interestRate;
	}

	public double getBalance() {
		return balance;
	}

	public void deposit(double amount) {
		balance += amount;
	}

	public double withdraw(double amount) {
		if(balance >= amount) {
			balance -= amount;
		}
		else {
			//mas mataas yung wini-withdraw sa balance (negative)
			System.out.println("Amount requested exceeded your account balance.");
		}
		return amount;
	}

	public void addInterest() {
		double interest = balance * interestRate;
		balance = balance + interest;
	}

	public static void showBalance(SavingsAccount account) {
		System.out.println("Your new balance is: "+account.getBalance());
	}
}

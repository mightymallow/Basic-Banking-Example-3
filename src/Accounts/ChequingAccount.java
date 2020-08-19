package Accounts;
import java.util.Date;

/**
 * @author Gergely A00976672 Assignment 3
 *
 */
public class ChequingAccount extends Account {

	public static final double FEE = 0.25;
	private static final double MIN_AMOUNT = 0.0;
	private int numberOfCheques;
	private double totalFees;

	/**
	 * Default constructor
	 */
	public ChequingAccount() {
		super();
	}

	/**
	 * Overloaded constructor
	 * 
	 * @param balance
	 *            the balance to set
	 * @param accountNumber
	 *            the account number to set
	 * 
	 */
	public ChequingAccount(double balance, String accountNumber) {

		super(balance, accountNumber);
		numberOfCheques = 0;
	}

	/**
	 * 
	 * @return the numberOfCheques as int
	 */
	public int getNumberOfCheques() {

		return numberOfCheques;
	}

	/**
	 * 
	 * @param numberOfCheques
	 *            the numberOfCheques to set
	 */
	public void setNumberOfCheques(int numberOfCheques) {

		if (numberOfCheques > 0) {
			this.numberOfCheques = numberOfCheques;
		}
	}

	/**
	 * Adds 1 to the number of cheques whenever there is a withdrawal from a
	 * ChequingAccount
	 */
	public void addACheque() {

		numberOfCheques++;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ChequingAccount [numberOfCheques=" + numberOfCheques + ", totalFees=" + totalFees + ", toString()="
				+ super.toString() + "]";
	}

	public void addTransaction(String transactionInfo) {
		if (getAccountNumber() != null && !getAccountNumber().isEmpty()) {
			accountRecords.add(transactionInfo + " which happened in your chequing account.");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Account#subtractFromBalance(double)
	 */
	@Override
	public void subtractFromBalance(double amount) {

		if (amount > 0 && getBalance() - amount >= MIN_AMOUNT) {

			double temp = getBalance() - amount;
			setBalance(temp);
			addACheque();
			totalFees = numberOfCheques * FEE;
			addTransaction(String.format("%s - withdrawal: $%.2f", new Date(), amount));
		} else {
			System.out.println("Please enter a valid amount to withdraw!");
		}
	}

}

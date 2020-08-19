package Accounts;

import java.util.Date;

/**
 * @author Gergely A00976672 Assignment 3
 *
 */
public class SavingsAccount extends Account {

	public static final double MIN_AMOUNT = 100.0;

	/**
	 * Default constructor
	 */
	public SavingsAccount() {
		super();
	}

	/**
	 * Overloaded constructor
	 * 
	 * @param balance
	 *            the balance to set
	 * @param accountNumber
	 *            the account number to set
	 */
	public SavingsAccount(double balance, String accountNumber) {
		super(balance, accountNumber);
	}

	/**
	 * @return the minAmount constant as a double
	 */
	public static double getMinAmount() {
		return MIN_AMOUNT;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SavingsAccount [toString()=" + super.toString() + "]";
	}

	public void addTransaction(String transactionInfo) {
		if (getAccountNumber() != null && !getAccountNumber().isEmpty()) {
			accountRecords.add(transactionInfo + " which happened in your savings account.");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Account#subtractFromBalance(double)
	 */
	@Override
	public void subtractFromBalance(double amount) {
		if (amount > 0 && getBalance() - amount >= 0) {
			double temp = getBalance() - amount;
			setBalance(temp);
			addTransaction(String.format("%s - withdrawal: $%.2f", new Date(), amount));
			if (getBalance() < MIN_AMOUNT) {
				setActive(false);
			}
		} else {
			System.out.println("Please enter a valid amount to withdraw!");
		}
	}

	/* (non-Javadoc)
	 * @see Accounts.Account#addToBalance(double)
	 */
	public void addToBalance(double amount) {

		if (amount > 0.0) {
			double temp = getBalance() + amount;
			setBalance(temp);
			addTransaction(String.format("%s - deposit: $%.2f", new Date(), amount));
			if (getBalance() >= MIN_AMOUNT) {
				setActive(true);
			}
		}
	}
}

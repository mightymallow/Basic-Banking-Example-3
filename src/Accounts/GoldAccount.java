package Accounts;

import java.util.Date;

/**
 * @author Gergely A00976672 Assignment 3
 *
 */
public class GoldAccount extends Account {

	private boolean overdraft;

	public static final double INTEREST_RATE = 0.025;
	public static final double FEE = 10.0;
	public static final double OVERDRAFT_AMT = -5000.0;

	/**
	 * Default constructor
	 */
	public GoldAccount() {
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
	public GoldAccount(double balance, String accountNumber) {
		super(balance, accountNumber);
		overdraft = false;
	}

	/**
	 * 
	 * @return the interestRate as double
	 */
	public double getInterestRate() {

		return INTEREST_RATE;
	}

	/**
	 * 
	 * @return the inOverdraft as boolean
	 */
	public boolean isOverdraft() {

		return overdraft;
	}

	/**
	 * 
	 * @param overdraft
	 *            the inOverdraft to set
	 */
	public void setOverdraft(boolean overdraft) {

		this.overdraft = overdraft;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "GoldAccount [interestRate=" + INTEREST_RATE + ", overdraft=" + overdraft + ", toString()="
				+ super.toString() + "]";
	}

	public void addTransaction(String transactionInfo) {
		if (getAccountNumber() != null && !getAccountNumber().isEmpty()) {
			accountRecords.add(transactionInfo + " which happened in your gold account.");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Account#subtractFromBalance(double)
	 */
	@Override
	public void subtractFromBalance(double amount) {

		if (amount > 0 && getBalance() - amount >= OVERDRAFT_AMT) {
			double temp = getBalance() - amount;
			setBalance(temp);
			addTransaction(String.format("%s - withdrawal: $%.2f", new Date(), amount));
			if (getBalance() < 0) {
				overdraft = true;
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
			if (getBalance() > 0) {
				overdraft = false;
			}
		}
	}
}

package MainBank;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

/**
 * 
 */

/**
 * @author Gergely A00976672 Assignment 3
 *
 */
public class BankReport implements Reporter {

	/* (non-Javadoc)
	 * @see Reporter#displayByCode(java.util.HashMap, java.lang.String)
	 */
	public void displayByCode(HashMap records, String prefix) {
		if (records.size() > 0 && prefix != null) {
			Set<String> people = records.keySet();
			for (String customers : people) {
				if (customers.contains(prefix)) {
					System.out.println(Bank.theBank.get(customers).toString());
				}
			}
		} else {
			System.out.println("Bank either has no customers or prefix is invalid.");
		}
	}

	/* (non-Javadoc)
	 * @see Reporter#displayAllCodes(java.util.HashMap)
	 */
	public void displayAllCodes(HashMap records) {
		if (records.size() > 0) {
			Set<String> people = records.keySet();
			Set<String> alphabetical = new TreeSet<String>();
			for (String customers : people) {
				if (Bank.theBank.get(customers).getAccount().isActive() == true) {
					alphabetical.add(customers);
				}
			}
			if (alphabetical.size() > 0) {
				for (String customers2 : alphabetical) {
					System.out.println(Bank.theBank.get(customers2).toString());
				}
			} else {
				System.out.println("There are no active accounts to display.");
			}
		}
	}

	/* (non-Javadoc)
	 * @see Reporter#displayInactiveCodes(java.util.HashMap)
	 */
	public void displayInactiveCodes(HashMap records) {
		if (records.size() > 0) {
			Set<String> people = records.keySet();
			Set<String> reverseAlphabetical = new TreeSet<String>(Collections.reverseOrder());
			for (String customers : people) {
				if (Bank.theBank.get(customers).getAccount().isActive() == false) {
					reverseAlphabetical.add(customers);
				}
			}
			if (reverseAlphabetical.size() > 0) {
				for (String customers2 : reverseAlphabetical) {
					System.out.println(Bank.theBank.get(customers2).toString());
				}
			} else {
				System.out.println("There are no inactive accounts to display.");
			}
		}
	}

	/**Adds up all the money in the bank accounts
	 * @param theBank the hashmap to take customer balances from
	 */
	public void displayAccountTotals(HashMap theBank) {
		double temp = 0;
		if (theBank.size() > 0) {
			Set<String> people = theBank.keySet();
			for (String customers : people) {
				temp = temp + Bank.theBank.get(customers).getAccount().getBalance();
			}
		}
		System.out.println("Total money in the bank: $" + temp);
	}

}

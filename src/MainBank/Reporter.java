package MainBank;
import java.util.HashMap;

/**
 * 
 */

/**
 * @author Gergely A00976672 Assignment 3
 *
 */
public interface Reporter {

	/** Interface method to display certain accounts
	 * @param records hashmap to be used
	 * @param prefix account type to check for
	 */
	public void displayByCode(HashMap records, String prefix);

	/** Interface method to display all bank customers
	 * @param records hashmap to be used
	 */
	public void displayAllCodes(HashMap records);

	/** Interface method to display all inactive customers
	 * @param records hashmap to be used
	 */
	public void displayInactiveCodes(HashMap records);

}

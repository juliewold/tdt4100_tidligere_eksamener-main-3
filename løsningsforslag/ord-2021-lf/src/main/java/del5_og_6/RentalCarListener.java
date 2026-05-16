package del5_og_6;

import java.util.HashMap;
import java.util.Map;

/* RentalCar listeners listens to changes in Status for all userNames.*/
public class RentalCarListener implements StatusListener {

	// TODO - Add any needed fields here
	// Many will probably have solved this using a list instead, which is also a good solution
	private Map<String, Integer> rebates = new HashMap<>();
	private final String GOLD_STATUS = "Gold";
	@Override
	/**
	 * Method that should be called when a given userName has updated its status.
	 */
	public void statusChanged(String username, String oldStatus, String newStatus) {
		if (newStatus.equals(GOLD_STATUS)) {
			rebates.put(username, 100);
		}
		else {
			rebates.remove(username);
		}
	}

	/**
	 * Get's the discount of a user. Should be a 100 if the user currently has Gold
	 * status, otherwise should be 0.
	 * 
	 * @param username The username of the user
	 * 
	 * @return The discount the user qualifies for.
	 */
	public int getDiscount(String username) {
		return rebates.getOrDefault(username, 0);

	}
}

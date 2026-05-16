package no.library;

import com.library.part3.LibraryItem;
import java.util.List;

/**
 * Defines the contract for a user management system.
 * This interface acts as a "black box," abstracting the details of user
 * storage and management from the rest of the library system.
 */
public interface UserManager {

    /**
     * Registers a new user in the system.
     *
     * @param user The User object to add.
     */
    void addUser(User user);

    /**
     * Checks if a user is eligible to borrow new items.
     * Eligibility is typically based on the number of active loans and any
     * outstanding fees.
     *
     * @param userId The ID of the user to check.
     * @return true if the user can borrow, false otherwise.
     */
    boolean canUserBorrow(String userId);

    /**
     * Checks if a user is eligible to reserve a specific item.
     * This check should include verifying the user's existence and the item's
     * specific reservation policy.
     *
     * @param userId The ID of the user.
     * @param item The item to be reserved.
     * @return true if the user can reserve the item, false otherwise.
     */
    boolean canUserReserve(String userId, LibraryItem item);

    /**
     * Finds a user by their unique ID.
     *
     * @param userId The ID of the user to find.
     * @return The User object, or null if not found.
     */
    java.util.Optional<User> findUser(String userId);

    /**
     * Sends a notification to a user that a reserved item is now available
     * for pickup.
     *
     * @param userId The ID of the user to notify.
     * @param item   The LibraryItem that is available.
     */
    void notifyItemAvailable(String userId, LibraryItem item);

    /**
     * Sends a notification to a user regarding their overdue loans.
     *
     * @param userId       The ID of the user to notify.
     * @param overdueLoans A list of the user's overdue loans.
     */
    void notifyOverdueLoans(String userId, List<Loan> overdueLoans);
}

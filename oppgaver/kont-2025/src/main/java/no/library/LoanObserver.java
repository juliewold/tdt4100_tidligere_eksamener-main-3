package no.library;

/**
 * Part 4: Observer Pattern - LoanObserver interface
 * 
 * This interface defines the Observer pattern for monitoring loan activities in the library system.
 * Observers can register to receive notifications when items are checked out or returned,
 * enabling features like statistics tracking, logging, and automated responses.
 * 
 * @author Exam Candidate
 * @version 1.0
 * @since 2025
 */
public interface LoanObserver {
    
    /**
     * Called when an item is checked out to a user.
     * 
     * @param itemId the ID of the item that was checked out
     * @param userId the ID of the user who checked out the item
     */
    void onItemCheckedOut(String itemId, String userId);
    
    /**
     * Called when an item is returned by a user.
     * 
     * @param itemId the ID of the item that was returned
     * @param userId the ID of the user who returned the item
     */
    void onItemReturned(String itemId, String userId);
    
}

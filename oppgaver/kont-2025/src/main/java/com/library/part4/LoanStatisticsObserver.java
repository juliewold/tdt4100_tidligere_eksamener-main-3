package com.library.part4;

import no.library.LoanObserver;

/**
 * Implements the {@link LoanObserver} interface to track loan statistics.
 * This class maintains a count of total checkouts and returns for library items.
 * It prints the current statistics to the console whenever an item is checked out or returned.
 */
public class LoanStatisticsObserver implements LoanObserver {
    
    //TODO: Add any necessary fields you need here
    
    /**
     * Called when a library item is checked out. Increments the total checkout count
     * and prints the current loan statistics.
     *
     * @param itemId The ID of the item that was checked out.
     * @param userId The ID of the user who checked out the item.
     */
    @Override
    public void onItemCheckedOut(String itemId, String userId) {
        // TODO: Complete this method.
    }
    
    /**
     * Called when a library item is returned. Increments the total return count
     * and prints the current loan statistics.
     *
     * @param itemId The ID of the item that was returned.
     * @param userId The ID of the user who returned the item.
     */
    @Override
    public void onItemReturned(String itemId, String userId) {
        // TODO: Complete this method.
    }
   
    /**
     * Gets the total number of checkouts (loans) recorded by this observer.
     * 
     * @return The total number of checkouts.
     */
    public int getTotalCheckouts() {
        return 0; // TODO: Replace with correct implementation
    }
    
    /**
     * Gets the total number of returns recorded by this observer.
     * 
     * @return The total number of returns.
     */
    public int getTotalReturns() {
        return 0; // TODO: Replace with correct implementation
    }
}

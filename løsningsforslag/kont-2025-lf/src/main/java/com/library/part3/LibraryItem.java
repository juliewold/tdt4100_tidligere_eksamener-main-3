package com.library.part3;

import no.library.Reservable;
import no.library.User;

/**
 * LibraryItem is an abstract base class representing any item that can be borrowed from the library.
 * This class provides common functionality for all library items including ID generation,
 * availability tracking, and checkout/return operations.
 * 
 * All library items implement the Reservable interface to indicate whether they can be reserved,
 * but the actual reservation management is handled by the GenericReservationManager.
 * 
 * Concrete subclasses must implement specific behavior for loan periods
 * and item type identification.
 * 
 * Each LibraryItem has a unique ID in the format "LIB-########" where # represents
 * an 8-digit zero-padded number. IDs are automatically generated starting from
 * "LIB-00000001" and increment sequentially for each new item created.
 */
public abstract class LibraryItem implements Reservable {

    // TODO: Add necessary fields
    private static int nextId = 1; // Static field to generate unique IDs

    private String id;
    private boolean isAvailable;
    private String currentBorrower;
    
    /**
     * Constructor that initializes a new library item with a unique auto-generated ID.
     * The ID follows the format "LIB-########" where # represents an 8-digit zero-padded number.
     * The item is initially set as available for checkout and no current borrower.
     */
    public LibraryItem() {
        // TODO: Complete the constructor.
        this.id = "LIB-" + String.format("%08d", nextId++); // Generate unique ID format to 8 digits
        this.isAvailable = true;
        this.currentBorrower = null;
    }
    
    /**
     * Gets the unique identifier for this library item.
     * 
     * @return the item's unique ID in format "LIB-########"
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the availability status of this library item.
     * It can not be set to be true, if there is a current borrower.
     * The item needs to be returned before it can be marked as available again.
     * An item may be set to be unavailable, even if there is no current borrower.
     * 
     * @param b true if the item should be marked as available, false otherwise
     * @throws IllegalStateException if trying to set available while it is checked out
     */
    public void setAvailable(boolean b) {
        // TODO: Complete this method.
        if (b && currentBorrower != null) {
            throw new IllegalStateException("Cannot set item as available while it is checked out");
        }
        this.isAvailable = b;
    }
    
    /**
     * Checks if this library item is currently available for checkout.
     * 
     * @return true if the item is available, false  otherwise
     */
    public boolean isAvailable() {
        // TODO: Complete this method.
        return isAvailable;
    }
    
    /**
     * Gets the ID of the user who currently has this item checked out.
     * 
     * @return the borrower's user ID, or null if the item is not checked out
     */
    public String getCurrentBorrower() {
        // TODO: Complete this method.
        return currentBorrower;
    }
    
    /**
     * Checks out this library item to a specific user.
     * The item must be available for this operation to succeed.
     * Then the user ID is set as the current borrower.
     * 
     * @param userId the ID of the user checking out the item
     * @throws IllegalStateException if the item is already checked out
     * @throws IllegalArgumentException if the userId is null or empty
     */
    public void checkout(String userId) {
        // TODO: Complete this method.
        if (!isAvailable) {
            throw new IllegalStateException("Item is already checked out");
        }
        if (userId == null || userId.trim().isEmpty()) {
            throw new IllegalArgumentException("User ID cannot be null or empty");
        }
        this.isAvailable = false;
        this.currentBorrower = userId;
    }
    
    /**
     * Returns this library item, making it available for checkout again.
     * The item must currently be checked out for this operation to succeed.
     * 
     * @throws IllegalStateException if the item is not currently checked out
     */
    public void returnItem() {
        // TODO: Complete this method.
        if (isAvailable) {
            throw new IllegalStateException("Item is not checked out");
        }
        this.isAvailable = true;
        this.currentBorrower = null;
    }

    /**
     * Gets a string representation of this library item, including its ID and availability status.
     * Format of the string is "<ItemType> [<ID>] (Available/Unavailable)".
     * 
     * Examples:
     * - "Book [LIB-00000001] (Available)"
     * - "Other [LIB-00000002] (Unavailable)"
     * 
     * @return a string describing the item
     */
    @Override
    public String toString() {
        // TODO: Complete this method.
        return getItemType() + " [" + id + "]" +
               (isAvailable ? " (Available)" : " (Unavailable)");
    }

    // Abstract methods that subclasses must implement
    
    /**
     * Gets the maximum number of days this item can be borrowed.
     * 
     * @return the maximum loan period in days
     */
    public abstract int getMaxLoanPeriod();
    
    /**
     * Gets a string representation of this item's type (e.g., "Book", "Other").
     * 
     * @return the item type as a string
     */
    public abstract String getItemType();

    
    // Implementation of Reservable interface
    
    /**
     * Checks if this item can be reserved by the given user.
     * By default, any item can be reserved by any user.
     * Subclasses can override this to implement specific reservation rules.
     * Note: This only indicates reservation capability - actual reservation
     * management is handled by the GenericReservationManager.
     * 
     * @param user the user attempting to reserve
     * @return true if the item can be reserved (default implementation always returns true)
     */
    @Override
    public boolean canReserve() {
        return true; // By default, all library items can be reserved
    }

    
    // CODE BELOW IS COMPLETE, DO NOT CHANGE

    /**
     * Checks if this library item is equal to another object.
     * Two library items are considered equal if they have the same ID.
     * 
     * @param obj the object to compare with
     * @return true if the items are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        LibraryItem that = (LibraryItem) obj;
        return id.equals(that.id);
    }
    
    @Override
    public int hashCode() {
        return id.hashCode();
    }
}

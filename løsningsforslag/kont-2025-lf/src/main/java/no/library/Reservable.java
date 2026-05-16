package no.library;

/**
 * Interface for items that can be reserved by users.
 */
public interface Reservable {
    

    /**
     * Interface method that checks if the item can be reserved.
     * 
     * @return true if the item can be reserved
     */
    boolean canReserve();
}

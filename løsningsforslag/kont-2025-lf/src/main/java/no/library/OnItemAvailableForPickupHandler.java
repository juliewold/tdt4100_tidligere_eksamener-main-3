package no.library;

/**
 * A generic functional interface that defines a callback for notifying a user
 * that an item is available for them to pick up.
 *
 * @param <T> The type of the item being reserved.
 * @param <U> The type of the entity making the reservation.
 */
@FunctionalInterface
public interface OnItemAvailableForPickupHandler<T, U> {
    /**
     * Called when an item becomes available for a specific user.
     *
     * @param item The item that is now available.
     * @param user The user who should be notified.
     */
    void onAvailable(T item, U user);
}
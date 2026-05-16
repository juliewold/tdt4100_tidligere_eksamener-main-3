package com.twowheels.assembly.part6;

import no.ntnu.tdt4100.twowheels.part6.IBikeStatusObserver;

// TODO: Import relevant libraries

/**
 * The BuildStatus class represents the status of a custom bike build.
 */

public class BikeStatus {

    // Valid build statuses
    public static final String BUILDING = "BUILDING";
    public static final String WAITING = "WAITING";
    public static final String CANCELLED = "CANCELLED";
    public static final String SHIPPED = "SHIPPED";
    public static final String DELIVERED = "DELIVERED";

    // This list is unmodifiable and contains the valid build statuses
    public static final List<String> VALID_STATUSES = Collections.unmodifiableList(Arrays.asList(
            BUILDING, WAITING, CANCELLED, SHIPPED, DELIVERED));

    // Variables for the build number, status, and list of observers
    private final String buildID;
    private String status;
    private final List<IBikeStatusObserver> observers;

    /**
     * Constructor for the BikeStatus class.
     * 
     * Creates a new BikeStatus object with the provided build number and status.
     * Initializes the list of observers as an empty list of type BikeStatusObserver.
     *
     * @param buildID   The build number.
     * @param status    The build status.
     * @throws IllegalArgumentException If the provided status is not valid.
     * @throws NullPointerException If buildID or status is null.
     */
    public BikeStatus(String buildID, String status) {

        // TODO: Implement constructor according to the JavaDoc.
        
    }

    /**
     * Getter for the build number.
     *
     * @return The build number.
     */
    public String getBuildNumber() {
        return buildID;
    }

    /**
     * Getter for the build status.
     *
     * @return The build status.
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method updates the build status.
     * It should update the status if valid and notify all observers of the change.
     *
     * @param status The new build status.
     * @throws IllegalArgumentException If the provided status is not valid.
     */
    public void setStatus(String status) {

        // TODO: Implement the method according to the JavaDoc.

    }

    /**
     * This method adds a BuildStatusObserver to the list of observers.
     *
     * @param observer The BuildStatusObserver to add.
     */
    public void addObserver(IBikeStatusObserver observer) {
        observers.add(observer);
    }

    /**
     * This method removes a BuildStatusObserver from the list of observers.
     *
     * @param observer The BuildStatusObserver to remove.
     */
    public void removeObserver(IBikeStatusObserver observer) {
        observers.remove(observer);
    }

    /**
     * This method notifies all observers of a change in the build status.
     *
     * @param status The new build status.
     */
    private void notifyObservers(String status) {

        // TODO: Implement the method according to the JavaDoc.

    }

}

package part8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * FlightStatus class to represent the status of a flight.
 */
public class FlightStatus {
    public static final String ON_TIME = "ON_TIME";
    public static final String DELAYED = "DELAYED";
    public static final String CANCELLED = "CANCELLED";
    public static final String DEPARTED = "DEPARTED";
    public static final String ARRIVED = "ARRIVED";

    public static final List<String> VALID_STATUSES = Arrays.asList(
            ON_TIME, DELAYED, CANCELLED, DEPARTED, ARRIVED);

    private final String flightNumber;
    private String status;
    private final List<FlightStatusObserver> observers;

    /**
     * Constructor for the FlightStatus class.
     *
     * @param flightNumber The flight number.
     * @param status       The flight status.
     */
    public FlightStatus(String flightNumber, String status) {
        this.flightNumber = flightNumber;
        this.observers = new ArrayList<>();
        if (VALID_STATUSES.contains(status)) {
            this.status = status;
        } else {
            throw new IllegalArgumentException("Invalid flight status");
        }
    }

    /**
     * Getter for the flight number.
     *
     * @return The flight number.
     */
    public String getFlightNumber() {
        return flightNumber;
    }

    /**
     * Getter for the flight status.
     *
     * @return The flight status.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Updates the flight status, should update the status if valid and notify
     * all observers of the change.
     *
     * @param status The new flight status.
     * @throws IllegalArgumentException If the provided status is not valid.
     */
    public void setStatus(String status) {
        if (VALID_STATUSES.contains(status)) {
            this.status = status;
            notifyObservers(status);
        } else {
            throw new IllegalArgumentException("Invalid flight status");
        }
    }

    /**
     * Adds a FlightStatusObserver to the list of observers.
     *
     * @param observer The FlightStatusObserver to add.
     */
    public void addObserver(FlightStatusObserver observer) {
        observers.add(observer);
    }

    /**
     * Removes a FlightStatusObserver from the list of observers.
     *
     * @param observer The FlightStatusObserver to remove.
     */
    public void removeObserver(FlightStatusObserver observer) {
        observers.remove(observer);
    }

    /**
     * Notifies all observers of a change in the flight status.
     */
    private void notifyObservers(String status) {
        for (FlightStatusObserver observer : observers) {
            observer.updateFlightStatus(flightNumber, status);
        }
    }
}

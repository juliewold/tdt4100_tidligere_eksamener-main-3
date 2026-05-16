package shared;

import java.time.LocalDateTime;

/**
 * Represents a flight with a flight number, origin, destination, duration, and
 * miles.
 */
public class Flight implements IFlight {
    private final String origin;
    private final String destination;
    private final String flightNumber;
    private final int duration;
    private final int miles;
    private final LocalDateTime timeOfDeparture; // The time of departure for this flight

    /**
     * Constructs a Flight object with an origin, a destination, a flight number, an
     * aircraft type,
     * and a maximum number of seats available on the flight.
     *
     * @param origin          The origin airport code for this flight.
     * @param destination     The destination airport code for this flight.
     * @param flightNumber    The flight number for this flight.
     * @param aircraft        The aircraft type for this flight.
     * @param duration        The duration of this flight in hours.
     * @param miles           The distance of this flight, in miles.
     * @param timeOfDeparture The time of departure for this flight.
     * 
     */
    public Flight(String origin, String destination, String flightNumber, int duration, int miles,
            LocalDateTime timeOfDeparture) {
        this.origin = origin;
        this.destination = destination;
        this.flightNumber = flightNumber;
        this.duration = duration;
        this.miles = miles;
        this.timeOfDeparture = timeOfDeparture;
    }

    /**
     * Returns the flight number of this Flight object.
     *
     * @return the flight number
     */
    public String getFlightNumber() {
        return flightNumber;
    }

    /**
     * Returns the origin airport code of this Flight object.
     *
     * @return the origin airport code
     */
    public String getOrigin() {
        return origin;
    }

    /**
     * Returns the destination airport code of this Flight object.
     *
     * @return the destination airport code
     */
    public String getDestination() {
        return destination;
    }

    /**
     * Returns the duration of this Flight object in hours.
     *
     * @return the duration in hours
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Returns the distance of this Flight object in miles.
     *
     * @return the distance in miles
     */
    public int getMiles() {
        return miles;
    }

    /**
     * /**
     * Returns the time of departure for this flight.
     * 
     * @return the time of departure for this flight
     */
    public LocalDateTime getTimeOfDeparture() {
        return timeOfDeparture;
    }

    /**
     * Returns a string representation of this Flight object.
     *
     * @return a string representation of this Flight object
     */
    @Override
    public String toString() {
        return "Flight{" +
                "origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", flightNumber='" + flightNumber + '\'' +
                ", duration=" + duration +
                ", miles=" + miles +
                ", timeOfDeparture=" + timeOfDeparture +
                '}';
    }

    public static void main(String[] args) {

    }
}
package part3;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import part4.Booking;
import shared.IAircraft;
import shared.IBooking;
import shared.IFlight;

/**
 * Represents a flight with a flight number, origin, destination, duration, and
 * miles.
 */
public class Flight implements IFlight {
    private final String origin;
    private final String destination;
    private final String flightNumber;
    private IAircraft aircraft;
    private final int duration;
    private final int miles;
    private final LocalDateTime timeOfDeparture; // The time of departure for this flight
    // - TODO Add your fields here
    private final List<IBooking> bookings = new ArrayList<>();
    
    /**
     * Constructs a Flight object with an origin, a destination, a flight number, an
     * aircraft type,
     * and a maximum number of seats available on the flight.
     *
     * @param origin          The origin airport code for this flight.
     * @param destination     The destination airport code for this flight.
     * @param flightNumber    The flight number for this flight.
     * @param aircraft        The aircraft type for this flight.
     * @param duration        The duration of this flight in minutes.
     * @param miles           The distance of this flight, in miles.
     * @param timeOfDeparture The time of departure for this flight.
     * 
     */
    public Flight(String origin, String destination, String flightNumber, IAircraft aircraft, int duration, int miles,
            LocalDateTime timeOfDeparture) {
        this.origin = origin;
        this.destination = destination;
        this.flightNumber = flightNumber;
        this.aircraft = aircraft;
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
     * Returns the duration of this Flight object in minutes.
     *
     * @return the duration in minutes
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
     * Returns the time of departure for this flight.
     * 
     * @return the time of departure for this flight
     */
    public LocalDateTime getTimeOfDeparture() {
        return timeOfDeparture;
    }

    /**
     * Returns the aircraft for this flight
     * 
     * @return the aircraft used for this flight
     */
    public IAircraft getAircraft() {
        return aircraft;
    }

    /**
     * Calculates and returns carbon offset for this Flight object based on its
     * distance and aircraft
     * 
     * @return carbon offset for this Flight object based on its distance
     * 
     */
    public double getCarbonOffset() {
        return this.aircraft.getEmission() * miles;
    }

    /**
     * Returns the maximum number of seats available on this flight.
     *
     * @return The maximum number of seats available on this flight.
     */
    public int getMaxSeats() {
        return this.aircraft.getSeats();
    }

    /**
     * Returns the current number of booked seats on this flight.
     * Cancelled bookings are not counted as used seats , i.e. if there are 24
     * booking and 4 of them are
     * cancelled, only 20 seats are used.
     * 
     * @see Booking#isCancelled()
     */
    public int getNumberOfBookedSeats() {
        return (int) bookings
                .stream()
                .filter(b -> !b.isCancelled())
                .count();
    }

    /**
     * Checks if there are available seats on this flight. Cancelled bookings are
     * not counted as used seats, i.e. if there are 24 booking and 4 of them are
     * cancelled, only 20 seats are used.
     * 
     * @return true if the flight has available seats for booking, false otherwise
     * @see Booking#isCancelled()
     */
    public boolean hasAvailableSeats() {
        return getNumberOfBookedSeats() < getMaxSeats();
    }

    /**
     * Adds a booking to the list of bookings made to this flight. Throws an
     * IllegalStateException if there are no more seats available.
     * 
     * @param booking The booking to add to the list of bookings made to this plane.
     * 
     * @throws IllegalStateException if there are no more seats
     *                               available
     */
    public void addBooking(IBooking booking) {
        if (!hasAvailableSeats()) {
            throw new IllegalStateException("No more seats available.");
        }
        bookings.add(booking);

    }

    /**
     * Returns the list of bookings made to this flight.
     *
     * @return The list of bookings made to this flight.
     */
    public List<IBooking> getBookings() {
        return new ArrayList<>(this.bookings);
    }

    /**
     * @param other the other flight to compare with
     * @return true if the flight has the same origin and destination as the other
     *         flight, false otherwise
     */
    public boolean hasSameRoute(IFlight other) {
        return this.origin.equals(other.getOrigin()) && this.destination.equals(other.getDestination());
    }

    /**
     * Change the aircraft of this flight.
     * This throws an IllegalArgumentException if the new number of seats is less
     * than the current number of booked seats on the plane (i.e., if there are more
     * booked seats than there
     * are new seats on the aircraft) and forceChange parameter is false
     *
     * @param aircraft    The new aircraft to use for this flight
     * @param forceChange Whether to force through the change regardless of it if
     *                    means the number of bookings will be higher than the
     *                    number of available seats
     * @throws IllegalArgumentException if the new aircraft seats
     *                                  is less than the number of bookings and
     *                                  parameter forceChange
     *                                  is false
     */
    public void updateAircraft(IAircraft aircraft, boolean forceChange) {
        if (aircraft.getSeats() < getNumberOfBookedSeats() && !forceChange) {
            throw new IllegalArgumentException(
                    "The new number of seats greater than or equal to the current number of booked seats.");
        }
        this.aircraft = aircraft;
    }

    /**
     * Returns whether the flight is currently overbooked. Cancelled bookings are
     * not counted as used seats, i.e. if there are 24 booking and 4 of them are
     * cancelled, only 20 seats are used.
     * 
     * @return true if the number of bookings exceeds the capacity of the flight,
     *         false otherwise
     * @see Booking#isCancelled()
     */
    public boolean isOverbooked() {
        return getNumberOfBookedSeats() > getMaxSeats();
    }
}
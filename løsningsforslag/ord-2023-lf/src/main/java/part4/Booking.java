package part4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import shared.BookingClasses;
import shared.IBooking;
import shared.IFlight;
import shared.Passenger;

public class Booking implements IBooking {

    private Passenger passenger;
    private int price;
    private String bookingClass;
    private boolean isCancelled = false;
    private final List<IFlight> flights;

    /**
     * Constructs a Booking object with a passenger, a list of flights, and a
     * booking class. The booking class needs to be a valid booking class.
     * You do not need to validate the flights in any way.
     * 
     * @param passenger    The passenger associated with this booking.
     * @param flights      The list of flights associated with this booking.
     * @param bookingClass The booking class associated with this booking.
     * @param price        The price associated with this booking.
     */
    public Booking(Passenger passenger, List<IFlight> flights, String bookingClass, int price) {
        this.price = price;
        this.passenger = passenger;
        this.setBookingClass(bookingClass);
        this.flights = new ArrayList<>(flights);
    }

    /**
     * Returns the passenger associated with this booking.
     *
     * @return The passenger associated with this booking.
     */
    public Passenger getPassenger() {
        return this.passenger;
    }

    /**
     * Returns the booking class associated with this booking.
     *
     * @return The booking class associated with this booking.
     */
    public String getBookingClass() {
        return this.bookingClass;
    }

    /**
     * Returns the price associated with this booking.
     *
     * @return The price associated with this booking.
     */
    public int getPrice() {
        return this.price;
    }

    /**
     * Sets the booking class associated with this booking.See shared/BookingClasses
     * for
     * helper String constants.
     *
     * @param bookingClass The new booking class to set for this booking.
     * @throws IllegalArgumentException if the booking class is invalid
     */
    public void setBookingClass(String bookingClass) {
        if (!BookingClasses.getValidBookingClasses().contains(bookingClass)) {
            throw new IllegalArgumentException();
        }
        this.bookingClass = bookingClass;
    }

    /**
     * Gets the flight at the given index in the booking.
     * 
     * @param index the index of the flight to get
     * @return the flight at the index
     * @throws IndexOutOfBoundsException if the index is invalid
     */
    public IFlight getFlight(int index) {
        return this.flights.get(index);
    }

    /**
     * Gets the number of flights in this booking
     * 
     * @return the number of flights in this booking
     */
    public int getNumberOfFlights() {
        return flights.size();
    }

    /**
     * @return true if the booking is cancelled, false otherwise
     *         A newly created booking is never cancelled
     */
    public boolean isCancelled() {
        return isCancelled;
    }

    /**
     * Cancels the booking
     */
    public void cancelBooking() {
        isCancelled = true;
    }

    /**
     * Calculates the EU 261 compensation for the booking based on flight distances
     * in miles. You should use the maximum flight distance in the booking.
     * The method should return 0 if the booking is not cancelled.
     * If the booking is cancelled, calculate the compensation based on the standard
     * EU 261 rates
     * You may ignore the destination and origin of any flights when calculating
     * this.
     *
     * The compensation amounts are determined based on the flight distance in miles
     * 1. 250 for flights up to 930 miles
     * 2. 400 for flights between 930 miles and 2,175 miles (3,500 km)
     * 3. 600 for flights over 2,175 miles.
     *
     * 
     * @return The EU 261 compensation for the given booking in USD.
     */
    public int calculateEu261Compensation() {
        if (!isCancelled()) {
            return 0;
        }

        int maxDistance = flights.stream()
                .mapToInt(flight -> flight.getMiles())
                .max()
                .orElse(0);

        if (maxDistance <= 930) {
            return 250;
        } else if (maxDistance <= 2175) {
            return 400;
        } else {
            return 600;
        }
    }

    /**
     * Create an iterator that iterates over the {@link IFlight flights} in this
     * booking
     * 
     * @return An iterator to iterate over the flights in this booking
     */
    @Override
    public Iterator<IFlight> iterator() {
        return flights.iterator();
    }

    /**
     * Returns a string representation of the booking object, which includes
     * the passenger, booking class, price, and whether the booking is cancelled or
     * not.
     * 
     * @return A string representation of the booking object.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Booking Details:\n");
        sb.append("Passenger: ").append(getPassenger()).append("\n");
        sb.append("Booking Class: ").append(getBookingClass()).append("\n");
        sb.append("Price: $").append(getPrice()).append("\n");
        sb.append("Booking Status: ").append(isCancelled() ? "Cancelled" : "Active");

        return sb.toString();
    }
}
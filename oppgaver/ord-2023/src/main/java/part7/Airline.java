package part7;

import java.util.List;
import java.util.function.Consumer;

import part1.Aircraft;
import part3.Flight;
import part4.Booking;
import part6.CheapestBookingCanceller;
import shared.BookingCanceller;
import shared.BookingClasses;
import shared.IAircraft;
import shared.IBooking;
import shared.IFlight;
import shared.Passenger;

import java.time.LocalDateTime;
import java.util.Arrays;

public class Airline {

    // - TODO Add your fields here

    // A constructor to potentially initalize fields
    public Airline() {
        // TODO - write your code here
    }

    /**
     * A method to add a flight to the system
     * 
     * @param flight the flight to be added
     */
    public void addFlight(IFlight flight) {
        // TODO - write your code here
    }

    /**
     * A method to add a booking to the system. Adding a booking should ensure that
     * the flights in the booking are updated to also include the booking.
     * 
     * This method assumes (i.e. you do not need to check) that all flights in the booking
     * belong to this airline, and that all flights in the booking have available
     * seats.
     * 
     * @param booking the booking details
     */
    public void addBooking(IBooking booking) {
        // TODO - write your code here
    }

    /**
     * Applies the specified action to each booking of the given flight.
     *
     * @param flight the flight whose bookings will be processed
     * @param action the action to apply to each booking
     */
    public void processFlightBookings(IFlight flight, Consumer<IBooking> action) {
        // TODO - write your code here
    }

    /**
     * A method to find replacement flights for a cancelled flight, a replacement
     * flight should have the same origin and destination, has available seats, and
     * leave a maximum of 24 hours after the original flight. See TimelineUtils for
     * help
     * to this last bit
     * NB: The flight provided as argument should NOT be part of the output
     * 
     * @param flight the cancelled flight
     * @return a list of flights that have the same origin, destination and close
     *         departure time as the cancelled flight and have available seats
     */
    public List<IFlight> findReplacementFlights(IFlight flight) {
        // TODO - write your code here
        return null;
    }

    /**
     * A method to change the aircraft of a flight and cancel some bookings if the
     * flight is now overbooked. The method should always force the aircraft change
     * for the flight.
     * 
     * @param flight    the flight to change the aircraft for
     * @param aircraft  the new aircraft for the flight
     * @param canceller the delegate object that decides which bookings to cancel
     */
    public void changeAircraft(IFlight flight, IAircraft aircraft, BookingCanceller canceller) {
        // TODO - write your code here
    }

    public static void main(String[] args) {
        // Create an airline
        Airline airline = new Airline();

        // Create some aircraft
        IAircraft a1 = new Aircraft("Boeing 747", 400, 0.1, 1000);
        IAircraft a2 = new Aircraft("Airbus A380", 1, 0.08, 1200);

        // Create some flight objects
        IFlight f1 = new Flight("London", "New York", "BA001", a1, 420, 5567, LocalDateTime.of(2024, 3, 26, 12, 0));
        IFlight f2 = new Flight("New York", "London", "BA002", a1, 400, 5567, LocalDateTime.of(2024, 3, 27, 15, 0));
        IFlight f3 = new Flight("London", "New York", "BA003", a1, 420, 5567, LocalDateTime.of(2024, 3, 27, 10, 0));

        // Add flights to the airline system
        airline.addFlight(f1);
        airline.addFlight(f2);
        airline.addFlight(f3);

        // Create some passengers
        Passenger p1 = new Passenger("Alice", "alice@gmail.com");
        Passenger p2 = new Passenger("Bob", "bob@yahoo.com");

        // Create some bookings
        IBooking b1 = new Booking(p1, Arrays.asList(f1), BookingClasses.ECONOMY, 500);
        IBooking b2 = new Booking(p2, Arrays.asList(f2), BookingClasses.ECONOMY, 200);

        // Add bookings to the airline system
        airline.addBooking(b1);
        airline.addBooking(b2);

        System.out.println(f1.getBookings());
        System.out.println(f2.getBookings());

        // Find and print replacement flights
        System.out.println("Replacement Flights for Flight 1:");
        for (IFlight f : airline.findReplacementFlights(f1)) {
            System.out.println(f.getFlightNumber());
        }

        // Print upgraded booking class
        System.out.println("\nBooking 1 class after upgrading: " + b1.getBookingClass());

        // Create a BookingCanceller implementation
        BookingCanceller canceller = new CheapestBookingCanceller();

        // Change aircraft and cancel overbooked bookings
        System.out.println("\nChanging aircraft for Flight 1 and cancel overbooked bookings:");
        airline.changeAircraft(f1, a2, canceller);

        // Print the updated bookings for flight1
        System.out.println("\nBookings for Flight 1 after changing aircraft and canceling overbooked bookings:");
        for (IBooking b : f1.getBookings()) {
            System.out.println(b.isCancelled());
        }
    }
}
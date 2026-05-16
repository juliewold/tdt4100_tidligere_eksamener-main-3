package part7;

import java.util.List;
import java.util.function.Consumer;

import shared.BookingCanceller;
import shared.IAircraft;
import shared.IBooking;
import shared.IFlight;
import shared.TimeUtils;

import java.util.ArrayList;
import java.util.Iterator;

public class Airline {

    private List<IFlight> flights;

    // A constructor to potentially initalize fields
    public Airline() {
        flights = new ArrayList<>();
    }

    /**
     * A method to add a flight to the system
     * 
     * @param flight the flight to be added
     */
    public void addFlight(IFlight flight) {
        flights.add(flight);
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
        Iterator<IFlight> flights = booking.iterator();
        while(flights.hasNext()) {
            flights.next().addBooking(booking);
        }
    }

    /**
     * Applies the specified action to each booking of the given flight.
     *
     * @param flight the flight whose bookings will be processed
     * @param action the action to apply to each booking
     */
    public void processFlightBookings(IFlight flight, Consumer<IBooking> action) {
        flight.getBookings().forEach(action);
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
        List<IFlight> replacements = new ArrayList<>();
        // Loop through all the flights in the system
        for (IFlight f : flights) {
          // Check if the flight has the same origin, destination and date as the
          // cancelled flight
          if (f.hasSameRoute(flight) && f.hasAvailableSeats()
              && TimeUtils.isWithin24Hours(flight.getTimeOfDeparture(), f.getTimeOfDeparture()) && f != flight) {
            replacements.add(f);
          }
        }
        return replacements;
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
        // Set the new capacity of the flight
        flight.updateAircraft(aircraft, true);
        // Check if the flight is overbooked using the previous method
        if (flight.isOverbooked()) {
            // Get the list of bookings for the flight
            List<IBooking> flightBookings = flight.getBookings();
            // Calculate how many bookings need to be cancelled
            int excess = flight.getNumberOfBookedSeats() - aircraft.getSeats();
            // Delegate the cancellation of bookings to the canceller object
            canceller.cancelBookings(flightBookings, excess);
        }
    }
}
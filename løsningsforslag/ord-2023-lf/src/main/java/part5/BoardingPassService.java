package part5;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Iterator;
import shared.IBooking;
import shared.IFlight;
import shared.Passenger;

import java.io.BufferedReader;

public class BoardingPassService {
    /**
     * Writes the boarding pass for a booking to an OutputStream in the following
     * format:
     * Name of the passenger
     * Booking Class
     * For each flight in the booking:
     * Origin - Destination - Duration
     * 
     * See boarding_pass.txt in this package for an example.
     *
     * @param booking      The booking for which to write the boarding pass.
     * @param outputStream The OutputStream to which to write the boarding pass.
     */
    public static void printBoardingPass(IBooking booking, OutputStream outputStream) throws IOException {
        Passenger passenger = booking.getPassenger();
        String name = passenger.getName();
        String bookingClass = booking.getBookingClass().toString();
        Iterator<IFlight> flights = booking.iterator();
        String boardingPass = name + "\n" + bookingClass + "\n";
        while(flights.hasNext()) {
            IFlight flight = flights.next();
            String origin = flight.getOrigin();
            String destination = flight.getDestination();
            int duration = flight.getDuration();

            boardingPass += origin + " - " + destination + " - " + duration
                    + "\n";
            outputStream.write(boardingPass.getBytes());
        }
        outputStream.close();
    }

    /**
     * Scans a boarding pass for a flight from an InputStream and throws an
     * IllegalArgumentException if there does not exist
     * a passenger with that name and booking class on the given input flight. 
     *
     * @param flight      The flight for which to scan the boarding pass.
     * @param inputStream The InputStream from which to scan the boarding pass.
     * 
     * @throws IllegalArgumentException If there does not exist a passenger with
     *                                  that name and booking class on the given
     *                                  flight.
     */
    public static void scanBoardingPass(IFlight flight, InputStream inputStream) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        // Read the name, booking class, and flight information from the InputStream
        String name = reader.readLine();
        String bookingClass = reader.readLine();
        reader.readLine(); // Read the flight information, but we won't use it in this method

        boolean foundPassenger = false;
        for (IBooking booking : flight.getBookings()) {
            Passenger passenger = booking.getPassenger();
            if (passenger.getName().equals(name) && booking.getBookingClass().equals(bookingClass)) {
                foundPassenger = true;
                break;
            }
        }

        if (!foundPassenger) {
            throw new IllegalArgumentException(
                    "There does not exist a passenger with that name and booking class on the given flight.");
        }
        inputStream.close();
    }
}
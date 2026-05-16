package part5;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;

import part1.Aircraft;
import part3.Flight;
import part4.Booking;
import shared.BookingClasses;
import shared.IBooking;
import shared.IFlight;
import shared.Passenger;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;

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
        // TODO - Write your code here

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
        // TODO - Write your code here

    }

    public static void main(String[] args) {
        // Create sample data for testing
        Passenger passenger = new Passenger("John Doe", "john.doe@example.com");
        Aircraft aircraft = new Aircraft("Boeing 747", 400, 0.05, 200000);
        Flight flight = new Flight("London", "New York", "BA001", aircraft, 420, 5567,
                LocalDateTime.of(2024, 3, 26, 12, 0));
        Booking booking = new Booking(passenger, Collections.singletonList(flight), BookingClasses.ECONOMY, 1000);

        // Add the booking to the flight, commentint out this line should yield an
        // IllegalArgumentException below when reading
        flight.addBooking(booking);

        String basePath = "src/main/java";

        /** Comment this next section out if you just want to test loading */
        String packageName = BoardingPassService.class.getPackageName().replace('.', '/');

        // Write the boarding pass to a text file, change the filename here to test with the provided example
        String fileName = basePath + "/" + packageName + "/my_boarding_pass.txt";
        try (FileOutputStream outputStream = new FileOutputStream(fileName)) {
            printBoardingPass(booking, outputStream);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }

        // Read the boarding pass from the text file and scan it. If you just want to test with the provided example, change the filename to "/boarding_pass.txt" above
        try (FileInputStream inputStream = new FileInputStream(fileName)) {
            scanBoardingPass(flight, inputStream);
            System.out.println("Boarding pass scanned successfully!");
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Error scanning boarding pass: " + e.getMessage());
        }

        // Deletes the text file, uncomment this to check how the text file ends up.
        try {
            Files.deleteIfExists(Paths.get(fileName));
        } catch (IOException e) {
            System.err.println("Error deleting the file: " + e.getMessage());
        }
    }
}
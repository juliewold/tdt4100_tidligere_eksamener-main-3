package part9;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Arrays;
import java.util.Optional;
import java.util.function.BinaryOperator;

import shared.Flight;
import shared.IFlight;

public class AirlineUtils {

    /**
     * Returns the average flight duration (in hours) for all flights in the list.
     *
     * @param flights the list of flights to analyze
     * @return the average flight duration (in hours) for all flights. If the list
     *         is empty, it should return 0.0.
     */
    public static double getAverageFlightDuration(List<IFlight> flights) {
        // TODO - write your code here
        return 0.0;
    }

    /**
     * Reduces a list of flights to a single flight by repeatedly applying the
     * provided binary operator.
     *
     * @param flights     the list of flights to reduce
     * @param accumulator the binary operator used to reduce the flights
     * @return an Optional containing the result of the reduction
     */
    public static Optional<IFlight> reduceFlights(List<IFlight> flights, BinaryOperator<IFlight> accumulator) {
        // TODO - write your code here
        return null;
    }

    /**
     * Returns a list of flights to cancel based on the following ruleset.
     * Rule 1: Flight should be cancelled if there are more than
     * three flights from the same origin and destination.
     * Should return all flights with that origin and destination.
     * Rule 2: Flights should be cancelled if the flight duration is
     * less than 1 hour or more than 16 hours.
     * Each flight object should only be added to the list once.
     *
     * @param flights The list of flights to process.
     * @return a list of IFlights that meet the cancellation rules.
     */
    public static List<IFlight> getFlightsToCancel(List<IFlight> flights) {
        // TODO - write your code here
        return null;
    }

    public static void main(String[] args) {
        // Create some flights
        IFlight f1 = new Flight("New York", "Los Angeles", "AA123", 6, 2500, LocalDateTime.of(2023, 3, 26, 12, 30));
        IFlight f2 = new Flight("London", "Paris", "BA456", 1, 200, LocalDateTime.of(2023, 3, 26, 14, 00));
        IFlight f3 = new Flight("Los Angeles", "Chicago", "UA789", 4, 1500, LocalDateTime.of(2023, 3, 26, 17, 15));
        IFlight f4 = new Flight("Paris", "London", "AF111", 1, 200, LocalDateTime.of(2023, 3, 26, 18, 30));

        List<IFlight> flights = Arrays.asList(f1, f2, f3, f4);

        // Test getAverageFlightDuration
        double averageDuration = AirlineUtils.getAverageFlightDuration(flights);
        System.out.println("Average flight duration: " + averageDuration);

        // Test reduceFlights
        Optional<IFlight> longestDurationFlight = AirlineUtils.reduceFlights(flights,
                (flight1, flight2) -> flight1.getDuration() > flight2.getDuration() ? flight1 : flight2);
        System.out.println("Longest duration flight: " + longestDurationFlight.orElse(null));

        // Test getFlightsToCancel
        System.out.println("Flights size: " + flights.size());
        List<IFlight> foo = getFlightsToCancel(flights);
        System.out.println(foo.size());

    }
}

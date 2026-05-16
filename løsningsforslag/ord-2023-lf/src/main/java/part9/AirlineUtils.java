package part9;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import part1.Aircraft;
import part3.Flight;
import shared.IFlight;
import shared.TimeUtils;

public class AirlineUtils {

    /**
     * Returns a list of flights that satisfy the given predicate.
     *
     * @param flights   the list of flights to filter
     * @param predicate the predicate to filter flights by
     * @return a list of flights that satisfy the given predicate
     */
    public static List<IFlight> getFlightsByPredicate(List<IFlight> flights, Predicate<IFlight> predicate) {
        return flights.stream().filter(predicate).toList();
    }

    /**
     * Returns the busiest airport (the airport with the highest number of arrivals
     * and departures). Returns an arbitrary airport if there is a tie.
     *
     * @param flights the list of flights to analyze
     * @return the busiest airport
     */
    public static String getBusiestAirport(List<IFlight> flights) {
        Map<String, Long> airportCounts = flights.stream()
                .flatMap(flight -> Stream.of(flight.getOrigin(), flight.getDestination()))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return airportCounts.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    /**
     * Checks if a list of flights are all connected, meaning each flight departs
     * less than 24 hours after the one before
     * and from the same origin as the previous flight's destination.
     *
     * @param flights the list of flights to check
     * @return true if all flights are connected, false otherwise
     */
    public static boolean isConnectedFlights(List<IFlight> flights) {
        for (int i = 1; i < flights.size(); i++) {
            IFlight previousFlight = flights.get(i - 1);
            IFlight currentFlight = flights.get(i);
            LocalDateTime arrivalTimePreviousFlight = previousFlight.getTimeOfDeparture().plusMinutes(previousFlight.getDuration());

            if (!previousFlight.getDestination().equalsIgnoreCase(currentFlight.getOrigin()) ||
                    !TimeUtils.isWithin24Hours(arrivalTimePreviousFlight, currentFlight.getTimeOfDeparture())) {
                return false;
            }
        }
        return true;

    }
}

package part1;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import shared.Flight;
import shared.IAirport;
import shared.IFlight;

public class Airport implements IAirport {

    private String name;
    private String IATACode;
    private List<IFlight> flights;

    /**
     * Constructor for Airport class.
     *
     * @param name     The name of the airport.
     * @param IATACode The IATA code of the airport.
     */
    public Airport(String name, String IATACode) {
        this.name = name;
        this.IATACode = IATACode;
        this.flights = new ArrayList<>();
    }

    /**
     * Get the name of the airport.
     *
     * @return The name of the airport.
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Get the IATA code of the airport.
     *
     * @return The IATA code of the airport.
     */
    @Override
    public String getIATACode() {
        return IATACode;
    }

    /**
     * Get the list of flights for the airport.
     *
     * @return The list of flights.
     */
    @Override
    public List<IFlight> getFlights() {
        return new ArrayList<>(flights);
    }

    /**
     * Add a flight to the airport's list of flights.
     *
     * @param flight The flight to be added.
     * @throws IllegalArgumentException if the flight is already tracked by the
     *                                  airport or if flight is null.
     */
    @Override
    public void addFlight(IFlight flight) {
        if (flights.contains(flight) || flight == null) {
            throw new IllegalArgumentException();
        }
        flights.add(flight);
    }

    /**
     * Remove a flight from the airport's list of flights.
     *
     * @param flight The flight to be removed.
     */
    @Override
    public void removeFlight(IFlight flight) {
        flights.remove(flight);
    }

    /**
     * Get the total number of flights in the airport's list of flights.
     *
     * @return The total number of flights.
     */
    @Override
    public int getTotalFlights() {
        return flights.size();
    }

    /**
     * Get a list of flights with the specified destination.
     *
     * @param destination The destination to filter flights by.
     * @return A list of flights with the specified destination.
     */
    @Override
    public List<IFlight> getFlightsByDestination(String destination) {
        List<IFlight> flightsByDestination = new ArrayList<>();
        for (IFlight flight : flights) {
            if (flight.getDestination().equalsIgnoreCase(destination)) {
                flightsByDestination.add(flight);
            }
        }
        return flightsByDestination;
    }

    public static void main(String[] args) {
        // Create an Airport
        Airport airport = new Airport("San Francisco International Airport", "SFO");

        // Create a few Flight objects
        Flight flight1 = new Flight("SFO", "JFK", "UA100", 5, 2576, LocalDateTime.of(2023, 5, 2, 9, 0));
        Flight flight2 = new Flight("SFO", "LAX", "AA200", 1, 337, LocalDateTime.of(2023, 5, 2, 12, 0));
        Flight flight3 = new Flight("SFO", "JFK", "DL300", 5, 2576, LocalDateTime.of(2023, 5, 2, 15, 0));

        // Add flights to the airport
        airport.addFlight(flight1);
        airport.addFlight(flight2);
        airport.addFlight(flight3);

        // Print the total number of flights
        System.out.println("Total flights: " + airport.getTotalFlights());

        // Print flights with destination JFK
        System.out.println("Flights to JFK: " + airport.getFlightsByDestination("JFK"));

        // Remove a flight
        airport.removeFlight(flight2);

        // Print the total number of flights after removing a flight
        System.out.println("Total flights after removing a flight: " + airport.getTotalFlights());

        // Print flights with destination LAX after removing a flight
        System.out.println("Flights to LAX after removing a flight: " + airport.getFlightsByDestination("LAX"));
    }

}

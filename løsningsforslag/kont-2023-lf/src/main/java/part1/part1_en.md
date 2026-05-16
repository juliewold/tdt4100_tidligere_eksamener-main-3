# Part 1, the Airport Class 

In this task, you will implement the [Airport](./Airport.java) class that represents an airport in an airline system that keeps track of a number of flights. The Airport class should implement the IAirport interface and have the following methods:

- `Airport(String name, String IATACode)`: Constructor that takes the name of the airport and the IATA code of the airport.

- `getName()`: Returns the name of the airport.

- `getIATACode()`: Returns the IATA code of the airport.

- `getFlights()`: Returns the list of flights.

- `addFlight(IFlight flight)`: Add a flight to the airport's list of flights.

- `removeFlight(IFlight flight)`: Remove a flight from the airport's list of flights.

- `getTotalFlights()`: Returns the total number of flights in the airport's list of flights.

- `getFlightsByDestination(String destination)`: Returns a list of flights with the specified destination.

# Part 9 - AirlineUtils Class

In this exercise, you need to implement the `AirlineUtils` class, which provides various utility methods that operate on a list of `IFlight` objects. The class should include the following methods:  You can utilise the [`TimeUtils`](../shared/TimeUtils.java) class if required for certain tasks related to checking time. 

1. `getFlightsByPredicate(List<IFlight> flights, Predicate<IFlight>)`: Return a list of flights that satisifies the given predicate.
2. `getBusiestAirport(List<IFlight> flights)`: Return the busiest airport (the airport with the highest number of arrivals and departures).
3. `isConnectedFlights(List<IFlight> flights)`: Check if a list of flights are all connected, meaning:
    - each flight departs less than 24 hours after the one before.
    - each flight departs from the same origin as the previous flight's destination.

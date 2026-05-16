# Part 9, the AirlineUtils Class

In this task, you are required to implement the [AirlineUtils](./AirlineUtils.java) class that provides utility functions for dealing with a list of flights. The AirlineUtils class should have the following methods:

- `getAverageFlightDuration(List<IFlight> flights)`: This method takes in a list of flights and calculates the average flight duration (in hours) for all flights in the list.

- `reduceFlights(List<IFlight> flights, BinaryOperator<IFlight> accumulator)`: This method reduces a list of flights to a single flight by repeatedly applying the provided binary operator. It returns an Optional containing the result of the reduction.

- `getFlightsToCancel(List<IFlight> flights)`: This method identifies flights to be cancelled based on a complex ruleset.
  - *Rule 1*: Cancel flights if there are more than three flights from the same origin and destination.
  - *Rule 2*: Cancel flights if the flight duration is less than 1 hour or more than 16 hours.
  - The method returns a list of IFlights that meet the cancellation rules. Note that each flight object should only be added to the list **once** in the case of a flight object satisfying both rules.

The main method provides an example of usage of the AirlineUtils methods with a set of flights.

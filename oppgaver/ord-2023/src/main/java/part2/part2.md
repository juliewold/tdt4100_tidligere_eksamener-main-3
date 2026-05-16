# Part 2, LuggageHandler

In this part, implement the `LuggageHandler` class. This class is designed to manage the luggage for different flights. Each flight is identified by a unique flight number, and each luggage has a given weight. The LuggageHandler uses the [`Luggage`](../shared/Luggage.java) class. 

## Class Structure

The `LuggageHandler` class should have the following methods implemented
- Constructor:
  - `LuggageHandler(int maxWeight)`: Initializes a LuggageHandler with the max weight of any given luggage. 

- Public methods:
  - `addLuggage(String flightNumber, Luggage luggage)`: Adds a luggage to the given flight. If the luggage exceeds the maximum weight allowed, it throws an *IllegalArgumentException*.
  - `removeLuggage(String flightNumber, Luggage luggage)`: Removes a luggage from the given flight. If the flight number does not contain the luggage returns false. Otherwise, it returns true.
  - `getTotalWeight(String flightNumber)`: Returns the total weight of luggage for a given flight. If the flight number does not not have any luggage, it returns zero.


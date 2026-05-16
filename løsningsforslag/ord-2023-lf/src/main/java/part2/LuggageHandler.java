package part2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import shared.Luggage;

public class LuggageHandler {

    private Map<String, List<Luggage>> luggageMap;
    private int maxWeight;


    /**
     * Constructs a LuggageHandler object with a given maximum weight of luggage.
     * 
     * @param maxWeight The maximum weight of a luggage in
     *                  kilograms.
     * @throws IllegalArgumentException If the maximum weight is below 0
     */
    public LuggageHandler(int maxWeight) {
        if (maxWeight < 0) {
            throw new IllegalArgumentException("Max weight must be positive");
        }
        this.luggageMap = new HashMap<>();
        this.maxWeight = maxWeight;
    }

    /**
     * Adds a luggage to a given flight.
     * If the luggage exceeds the maximum weight allowed, it throws an
     * IllegalArgumentException.
     * You do not need to take into consideration multiple luggages by the same
     * passenger
     * 
     * @param flightNumber The flight number to add the luggage to as a string.
     * @param luggage      The luggage to add as a Luggage object.
     * @throws IllegalArgumentException If the luggage exceeds the maximum weight
     *                                  allowed.
     */
    public void addLuggage(String flightNumber, Luggage luggage) {
         // Check if the luggage exceeds the maximum weight allowed
        if (luggage.getWeight() > maxWeight) {
            // Throw an exception or return false
            throw new IllegalArgumentException("Luggage exceeds maximum weight allowed");
        }
        // Check if the flight number exists in the map
        if (!luggageMap.containsKey(flightNumber)) {
            // Create a new entry with an empty list
            luggageMap.put(flightNumber, new ArrayList<>());
        }
        // Add the luggage to the list of luggage for that flight
        luggageMap.get(flightNumber).add(luggage);
    }

    /**
     * Removes a luggage from the list of luggage for a given flight.
     * If the flight number or the luggage does not exist, it returns
     * false.
     * Otherwise, it returns true.
     * 
     * @param flightNumber The flight number to remove the luggage from as a string.
     * @param luggage      The luggage to remove as a Luggage object.
     * @return True if the removal was successful, false otherwise.
     */
    public boolean removeLuggage(String flightNumber, Luggage luggage) {
        // Check if the flight number exists in the map
        if (!luggageMap.containsKey(flightNumber)) {
            return false;
        }
        // Remove the luggage from the list of luggage for that flight and return whether successful
        return luggageMap.get(flightNumber).remove(luggage);
    }

    /**
     * Returns the total weight of luggage for a given flight.
     * If the flight number does not exist, it returns zero.
     * 
     * @param flightNumber The flight number to get the total weight of luggage for
     *                     as a string.
     * @return The total weight of luggage for that flight in kilograms as an
     *         integer.
     */
    public int getTotalWeight(String flightNumber) {
        // Check if the flight number exists in the map
        if (!luggageMap.containsKey(flightNumber)) {
            // Return 0 if the flight number does not exist
            return 0;
        }
    
        // Calculate the total weight of luggage for that flight
        int totalWeight = 0;
        List<Luggage> flightLuggage = luggageMap.get(flightNumber);
        for (Luggage luggage : flightLuggage) {
            totalWeight += luggage.getWeight();
        }
    
        return totalWeight;
    }
}

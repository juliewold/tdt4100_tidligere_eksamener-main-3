package com.bytebadger.assembly.part3;

import no.ntnu.tdt4100.bytebadger.Customer;
import no.ntnu.tdt4100.bytebadger.IComputerPart;
import no.ntnu.tdt4100.bytebadger.ICustomBuild;

/**
 * Implement the class CustomComputer which represents a custom computer build.
 * 
 * The class must implement the interface {@link no.ntnu.tdt4100.bytebadger.ICustomBuild}.
 * Read the documentation in the interface for detailed description of the behaviour of
 * the methods you need to implement.
 * 
 * In addition to the methods required by the interface, the class has a constructor and
 * some additional methods for managing the computer build.
 * 
 * The class should store a list of {@link no.ntnu.tdt4100.bytebadger.IComputerPart} computer part
 * objects and it should be able to add and remove a quantity of parts from
 * the custom build. 
 * 
 * @see no.ntnu.tdt4100.bytebadger.ICustomBuild
 * @see CustomComputerTest
*/

// TODO: Import relevant libraries

import java.util.Map;
import java.util.HashMap;

// TODO: Implement the interface

public class CustomComputer implements ICustomBuild {

    // TODO: Add neccesary variables

    private Customer customer;
    private Map<IComputerPart, Integer> parts = new HashMap<>();

    /**
     * This is the constructor for the class CustomComputer
     * 
     * @param customer the customer of a custom computer build
     * 
     * @throws IllegalArgumentException if the customer is null.
     */
    
    public CustomComputer(Customer customer) {

        // TODO: Complete the constructor according to JavaDoc

        if (customer == null) {
            throw new IllegalArgumentException("Customer cannot be null.");
        }
        this.customer = customer;
    }

    /**
     * This method adds a quantity of a specific computer part to the custom computer build.
     * 
     * @param part a computer part
     * @param quantity the number of parts to be added
     * 
     * @throws IllegalArgumentException if the quantity is not a positive integer.
     */
    
    public void addPart(IComputerPart part, int quantity) {

        // TODO: Complete the method according to JavaDoc

        if (quantity < 1) {
            throw new IllegalArgumentException("Quantity must be greater than 0.");
        }
        if (part == null) {
            throw new IllegalArgumentException("Part cannot be null.");
        }
        // Add the part to the list the specified number of times
        parts.merge(part, quantity, Integer::sum);

    }

    /**
     * This method removes a quantity of a specific computer part from the custom computer build.
     * 
     * @param part a computer part
     * @param quantity the number of parts to be removed
     * 
     * @throws IllegalArgumentException if the part is not in the build or if the quantity is not a positive number.
     */
    public void removePart(IComputerPart part, int quantity) {

        // TODO: Complete the method according to JavaDoc

        if (!parts.containsKey(part) || quantity < 1) {
            throw new IllegalArgumentException("Part not in build or quantity less than 1.");
        }
        if (quantity > parts.get(part)) {
            throw new IllegalArgumentException("Cannot remove more parts than are in the build.");
        }
        // Remove the part from the list the specified number of times
        int currentQuantity = parts.get(part);
        if (currentQuantity == quantity) {
            parts.remove(part);
        } else {
            parts.put(part, currentQuantity - quantity);
        }
    }

    // TODO: Implement the methods from the interface ICustomBuild

    @Override
    public Customer getCustomer() {
        return customer;
    }

    @Override
    public double getTotalPrice() {
        return parts.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();
    }

    @Override
    public Map<IComputerPart, Integer> getParts() {
        return new HashMap<>(parts); // Return a copy to prevent external modification
    }
}

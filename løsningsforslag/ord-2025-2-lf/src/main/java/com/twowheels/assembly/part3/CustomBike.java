package com.twowheels.assembly.part3;

import no.ntnu.tdt4100.twowheels.Customer;
import no.ntnu.tdt4100.twowheels.IBikeComponent;
import no.ntnu.tdt4100.twowheels.ICustomBuild;

/**
 * Implement the class CustomBike which represents a custom bike build.
 * 
 * The class must implement the interface {@link no.ntnu.tdt4100.twowheels.ICustomBuild}.
 * Read the documentation in the interface for detailed description of the behaviour of
 * the methods you need to implement.
 * 
 * In addition to the methods required by the interface, the class has a constructor and
 * some additional methods for managing the bike build.
 * 
 * The class should store a list of {@link no.ntnu.tdt4100.twowheels.IBikeComponent} bike components
 * as objects and it should be able to add and remove a quantity of components from
 * the custom build. 
 * 
 * @see no.ntnu.tdt4100.twowheeels.ICustomBuild
 * @see CustomBikeTest
*/

// TODO: Import relevant libraries

import java.util.Map;
import java.util.HashMap;

// TODO: Implement the interface

public class CustomBike implements ICustomBuild {

    // TODO: Add neccesary variables

    private Customer customer;
    private final Map<IBikeComponent, Integer> components = new HashMap<>();

    /**
     * This is the constructor for the class CustomBike.
     * 
     * @param customer the customer of a custom bike build
     * 
     * @throws IllegalArgumentException if customer is null.
     */
    public CustomBike(Customer customer) {

        // TODO: Complete the constructor according to JavaDoc

        if (customer == null) {
            throw new IllegalArgumentException("Customer cannot be null.");
        }
        this.customer = customer;
    }

    /**
     * This method adds a quantity of a specific bike component to the custom bike build.
     * 
     * @param component a bike component
     * @param quantity the number of components to be added
     * 
     * @throws IllegalArgumentException if the quantity is not a positive integer.
     */

    public void addComponent(IBikeComponent component, int quantity) {

        // TODO: Complete the method according to JavaDoc

        if (quantity < 1) {
            throw new IllegalArgumentException("Quantity must be greater than 0.");
        }
        for (int i = 0; i < quantity; i++) {
            if (component == null) {
                throw new IllegalArgumentException("Component cannot be null.");
            }
            components.merge(component, 1, Integer::sum);
            // Alternatively:  components.put(component, components.getOrDefault(component, 0) + 1);
        }  
    }

    /**
     * This method removes a quantity of a specific bike component from the custom bike build.
     * 
     * @param component a bike component
     * @param quantity the number of components to be removed
     * 
     * @throws IllegalArgumentException if the component is not in the build or if the quantity is not a positive number.
     */
    public void removeComponent(IBikeComponent component, int quantity) {

        // TODO: Complete the method according to JavaDoc
 
        if (!components.containsKey(component)) {
            throw new IllegalArgumentException("Component not found in the build.");
        }
        if (quantity < 1) {
            throw new IllegalArgumentException("Quantity must be greater than 0.");
        }
        int currentQuantity = components.get(component);
        if (currentQuantity < quantity) {
            throw new IllegalArgumentException("Not enough components to remove.");
        }
        if (currentQuantity == quantity) {
            components.remove(component);
        } else {
            components.put(component, currentQuantity - quantity);
        }

    }

    // TODO Implement the methods from the interface ICustomBuild

    @Override
    public Customer getCustomer() {
        return customer;
    }


    @Override
    public double getTotalPrice() {
        return components.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();
    }

    @Override
    public Map<IBikeComponent, Integer> getComponents() {
        return new HashMap<>(components);
    }
}

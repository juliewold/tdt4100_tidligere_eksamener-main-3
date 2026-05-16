package com.twowheels.assembly.part3;

import java.util.ArrayList;
import java.util.List;

import no.ntnu.tdt4100.twowheels.Customer;
import no.ntnu.tdt4100.twowheels.IBikeComponent;
import no.ntnu.tdt4100.twowheels.ICustomBuild;

// TODO: Import relevant libraries

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

public class CustomBike implements ICustomBuild {

    // TODO: Add neccesary variables

    /**
     * This is the constructor for the class CustomBike.
     * 
     * @param customer the customer of a custom bike build
     * 
     * @throws IllegalArgumentException if the customer is null.
     */
    public CustomBike(Customer customer) {

        // TODO: Complete the constructor according to JavaDoc

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

    }

    // TODO Implement the methods from the interface ICustomBuild

}

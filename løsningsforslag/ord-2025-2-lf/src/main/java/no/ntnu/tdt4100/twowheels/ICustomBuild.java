/**
 * THIS IS SUPPLIED CODE - DO NOT MODIFY THE CODE BELOW
 */

package no.ntnu.tdt4100.twowheels;

import java.util.Map;

/**
 * The supplied code represents the interface for a bike build.
 *
 * This interface provides methods to get information about the customer,
 * the total price and the bike components.
 */

public interface ICustomBuild {

    /**
     * This method should return the customer associated with the bike build.
     * 
     * @return The customer of type {@link Customer}
     */

    Customer getCustomer();

    /**
     * This method should return the total price for the bike build.
     * 
     * The total price should be the sum of all unit prices of all bike components
     * in the build.
     * 
     * @return The total price as a value of type double.
     * 
     */

    double getTotalPrice();

    /**
     * This method should return a map of all the bike components in the custom bike
     * build
     * with their cooresponding quantities.
     * 
     * The keys in the map should be the bike components, and these must be unique.
     * The values of the map should be the quantities of the components added to the
     * bike build,
     * and must be positive integers.
     * 
     * @return A {@link Map} of all bike components as keys of type
     *         {@link IBikeComponent}
     *         and the quantities of components as values of type {@link Integer}.
     */

    Map<IBikeComponent, Integer> getComponents();

}

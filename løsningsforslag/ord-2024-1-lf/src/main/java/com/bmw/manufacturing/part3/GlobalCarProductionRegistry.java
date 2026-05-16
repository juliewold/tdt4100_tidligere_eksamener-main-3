package com.bmw.manufacturing.part3;

import java.util.HashSet;
import java.util.Set;
import no.ntnu.tdt4100.part3.RandomGenerator;

/**
 * The global car production registry provides methods that all car factories
 * around the world use to register VINs (Vehicle Identification Numbers) for cars they produce.
 * 
 * All methods in this class are class methods.
 * A class method is a method that is bound to a class rather than its object. 
 * It doesn't require creation of a class instance to be invoked.
 * 
 * @see GlobalCarProductionRegistryTests
 */
public final class GlobalCarProductionRegistry {

    // TODO Implement necessary fields and methods
    private static Set<String> unitsProduced = new HashSet<>();

    private GlobalCarProductionRegistry() {} // DO NOT REMOVE THIS LINE
    // DO NOT ADD ANY CONSTRUCTORS

    /**
     * This method should be named <code>registerCarVin</code>
     * 
     * A <code>class method</code> that registers a car VIN in the global registry.
     * A class method is a method that is bound to a class rather than its object. 
     * It doesn't require creation of a class instance to be invoked.
     * 
     * The method returns <code>false</code> if a car VIN has already been registered.
     * 
     * If the provided VIN is <code>null</code> or not 17 characters long, 
     * the method must generate a valid VIN, register the generated VIN in the registry, and return <code>true</code>.
     * 
     * @param vin the VIN represented as a {@link String}
     * @return <code>true</code> if the car VIN was successfully registered, <code>false</code> otherwise.
     * 
     * @see no.ntnu.tdt4100.part3.RandomGenerator#generateRandomString(int)
     */
    //TODO Implement the registerCarVin class method according to the description in JavaDoc
    public static boolean registerCarVin(String vin) {
        if (vin == null || vin.length() != 17) {
            vin = RandomGenerator.generateRandomString(17);
        }
        if (isCarWithVinProduced(vin)) {
            return false;
        } else {
            unitsProduced.add(vin);
            return true;
        }
    }

    /**
     * This method should be named <code>isCarWithVinProduced</code>
     * 
     * A convenience <code>class method</code> to check if a car with a given VIN has been produced before.
     * 
     * @param vin the VIN of the car to check, of type {@link String}
     * @return <code>true</code> if a car with the given VIN has been produced before, <code>false</code> otherwise.
     */
    // TODO Implement the isCarWithVinProduced(String) class method according to the description in JavaDoc
    public static boolean isCarWithVinProduced(String vin) {
        return unitsProduced.contains(vin);
    }

    /**
     * This method should be named <code>getNumberOfProducedUnits</code>
     * 
     * A <code>class method</code> that returns the number of cars produced across all car factories in the group.
     * 
     * @return the number of produced units worldwide, of type long
     */
    // TODO Implement the getNumberOfProducedUnits() class method according to the description in JavaDoc
    public static long getNumberOfProducedUnits() {
        return unitsProduced.size();
    }

    /**
     * This method should be named <code>reset</code>
     * 
     * A <code>class method</code> that resets the global registry.
     * After this method is called, a call to the getNumberOfProducedUnits() 
     * should return 0.
     */
    // TODO Implement the reset() method according to the description in JavaDoc
    public static void reset() {
        unitsProduced.clear();
    }
}

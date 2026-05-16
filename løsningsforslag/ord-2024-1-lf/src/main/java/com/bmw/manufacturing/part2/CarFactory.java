package com.bmw.manufacturing.part2;

// TODO Add any necessary declarations or imports here
import java.util.ArrayList;
import java.util.List;

import no.ntnu.tdt4100.CarPart;

/**
 * Implement a class that represents a car factory called CarFactory
 * 
 * The expected methods for this class and their behaviour is detailed 
 * in the below JavaDoc
 * 
 * The CarFactory class must be in the package com.bmw.manufacturing.part2
 * 
 * The CarFactory class should NOT implement any interfaces.
 * 
 * @see CarFactoryTests
 */

// TODO Define the CarFactory class here
public class CarFactory {

    // TODO Add any necessary fields here

    private String isoCountryCode;
    private List<CarPart> parts;
    private int numberOfEmployees;

    /**
     * Constructs the CarFactory object.
     *
     * @param isoCountryCode    the ISO Country Code which must be at least 3 characters, of type {@link String}
     * @param parts             the list of <code>CarPart</code> objects the factory uses to produce cars, of type {@link List}
     * @param numberOfEmployees the number of employees employed at the factory, of type int
     * @throws IllegalArgumentException is thrown if numberOfEmployees is less than
     *                                  10 or the ISO country code is less than 3 characters
     * 
     * @see no.ntnu.tdt4100.CarPart
     */
    // TODO Implement the constructor according to behaviour specified in JavaDoc
    public CarFactory(String isoCountryCode, List<CarPart> parts, int numberOfEmployees) {

        if (numberOfEmployees < 10) throw new IllegalArgumentException("Number of employees must be at least 10");
        if (isoCountryCode == null || isoCountryCode.length() < 3) throw new IllegalArgumentException("ISO > 3 characters");

        this.isoCountryCode = isoCountryCode;
        this.parts = parts;
        this.numberOfEmployees = numberOfEmployees;
    }

    /**
     * Returns a {@link List} of parts the factory uses to produce cars.
     *
     * @return a list of parts the factory uses to produce cars
     */
    // TODO Implement the method getParts according to behaviour specified in JavaDoc
    public List<CarPart> getParts() {
        return new ArrayList<>(parts);
    }

    /**
     * This method should be named <code>getIsoCountryCode</code>
     * Returns the ISO Country Code. The Country Code is a string of
     * exactly 3 characters. All 3 characters MUST be capital case.
     * If the string supplied in the constructor is more than 3 characters, the 3
     * first characters should be returned by this method.
     *
     * @return the ISO Country Code, of type {@link String}
     */
    // TODO Implement the method getIsoCountryCode according to behaviour specified in JavaDoc
    public String getIsoCountryCode() {
        return isoCountryCode.substring(0, 3).toUpperCase();
    }

    /**
     * This method should be named <code>getNumberOfEmployees</code>
     * Returns the number of employees employed at the factory
     *
     * @return the number of employees employed at the factory, of type int
     */
    //TODO Implement the method getNumberOfEmployees according to behaviour specified in JavaDoc
    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    /**
     * This method should be named <code>getNumberOfEngineers</code>
     * Returns the number of employees that are engineers.
     * By some freak of nature, the number of engineers in each factory is 
     * the total number of employees divided by Math.PI
     * 
     * @return the number of engineers in the factory, of type int
     * 
     * @see Math#floor(double)
     * @see Math#PI
     */
    // TODO Implement the method getNumberOfEngineers according to behaviour specified in JavaDoc
    public int getNumberOfEngineers() {
        return (int) Math.floor(numberOfEmployees / Math.PI);
    }
}

package no.ntnu.tdt4100.part2;

import java.util.List;
import java.util.Optional;

import no.ntnu.tdt4100.ICarFactory;

/**
 * The <code>IMainOffice</code> interface contains methods that the BMW main office needs.
 * THIS CODE IS SUPPLIED, DO NOT MODIFY
 */
public interface IMainOffice {

    /**
     * The average car price
     */
    public static int AVERAGE_CAR_PRICE = 234127;

    /**
     * Returns the estimated installation hours for the given factory. 
     * The installation hours are calculated as follows:
     *
     * Employee count multiplied by Number of parts the factory uses
     * multiplied by {@link Math#PI}
     *
     * Example 
     * Number of Employees: 235 
     * Number of parts: 3 
     * Estimated installation hours:
     * 2214.8228207808042
     *
     * @param factory
     * @return the estimated installation hours
     * 
     * @see Math#PI
     */
    double calculateInstallationHours(ICarFactory factory);


    /**
     * Calculates the gross total estimated revenue of all BMW factories
     * for a specific year, rounded down to nearest thousand. 
     *
     * The total estimated revenue for a single factory for a specific year 
     * is calculated as follows:
     * 
     * number of produced units for the specific year
     * multiplied by the average car price.
     * 
     * This method will return the sum of revenues for all factories.
     *
     * @param factories the list of factories
     * @param year the year for
     * @return the summed estimated of all factories rounded down to nearest thousand
     * 
     * @see IMainOffice#AVERAGE_CAR_PRICE
     * @see ICarFactory#getNumberOfUnitsProduced(int)
     */
    long calculateTotalEstimatedRevenue(List<ICarFactory> factories, int year);


    /**
     * Returns the factory with the highest number of employees.
     * If there are multiple factories with the same amount of workers, return either.
     * If the given list is empty, return an empty {@link Optional}.
     * 
     * @param factories the list of factories
     * @return the factory from the given list of factories with the highest number of employees
     */
    Optional<ICarFactory> findTopFactory(List<ICarFactory> factories);
    

    /**
     * Returns a list of CarFactory objects filtered by the given char.
     * 
     * The method must return all car factories whose {@link ICarFactory#getIsoCountryCode()}
     * starts with the letter supplied in the character parameter. 
     * The filter should be case-insensitive.
     * In case the supplied character is invalid (not within the range A-Z or a-z, 
     * represented in decimal as 65-90 and 97-122, return the unfiltered list
     * 
     * @param factories the list of car factories to filter
     * @param character the case-insensitive character to filter by for the ISO Country Code
     * @return a list of car factories filtered by the start letter of the ISO Country code
     * 
     * @see ICarFactory#getIsoCountryCode()
     */
    List<ICarFactory> filterFactories(List<ICarFactory> factories, char character);        
}

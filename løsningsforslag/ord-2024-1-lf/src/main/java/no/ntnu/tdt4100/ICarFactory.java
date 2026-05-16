package no.ntnu.tdt4100;

import java.util.List;

/**
 * 
 */
public interface ICarFactory {
    /**
     * Returns the list of parts that this factory uses in production
     * 
     * @return the list of parts that this factory uses in production 
     */
    List<CarPart> getParts();

    /**
     * Returns the number of employees working at this factory
     * 
     * @return the number of employees working at this factory
     */
    int getNumberOfEmployees();

    /**
     * Returns the 3-letter ISO alpha-3 country code
     * @return
     */
    String getIsoCountryCode();

    /**
     * Returns the number of units produced at this factory this year
     * @return the number of units produced at this factory this year
     */
    int getNumberOfUnitsProduced();

    /**
     * Returns the number of units produced at this factory for the given year
     * @param year the year
     * @return the number of units produced at this factory for the given year
     */
    default int getNumberOfUnitsProduced(int year) {
        return 0;
    }
}

/**
 * THIS IS SUPPLIED CODE - DO NOT MODIFY THE CODE BELOW
 */

package no.ntnu.tdt4100.twowheels;

/**
 * The supplied code represents the interface for the bike components in the
 * bike build system.
 *
 * The interface provides methods to get and set information for the bike
 * components represented by component id, component name, manufacturer and unit price.
 */

public interface IBikeComponent {

    /**
     * Method for getting the component ID.
     * 
     * @return the component ID.
     */

    String getComponentId();

    /**
     * Method for getting the name of the component.
     * 
     * @return the name of the component.
     */

    String getComponentName();

    /**
     * Method for getting the name of the manufacturer of the component.
     * 
     * @return the name of the manufacturer.
     */

    String getManufacturer();

    /**
     * Method for getting the unit price of the component.
     * 
     * @return the unit price of the component.
     */

    double getPrice();

}

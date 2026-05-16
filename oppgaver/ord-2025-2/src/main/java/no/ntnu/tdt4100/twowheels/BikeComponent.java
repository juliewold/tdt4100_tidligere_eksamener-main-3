/**
 * THIS IS SUPPLIED CODE - DO NOT MODIFY THE CODE BELOW
 */

package no.ntnu.tdt4100.twowheels;

/**
 * 
 * This class represents the code for a bike component.
 *
 * The class must implements the interface
 * {@link no.ntnu.tdt4100.twowheels.IBikeComponent}
 * Read the documentation in the interface for detailed description of the
 * behaviour of
 * the methods.
 * 
 * @see no.ntnu.tdt4100.twowheels.IBikeComponent
 */

public class BikeComponent implements IBikeComponent {

    private String componentId;
    private String componentName;
    private String manufacturer;
    private double unitPrice;

    /**
     * Constructor for the class BikeComponent.
     * 
     * @param String       is the component ID as a value of type String
     * @param name         is the name of the component as a value of type String
     * @param manufacturer is the name of the manufacturer as a value of type String
     * @param price        is the unit price of the product as a value of type
     *                     double
     */

    public BikeComponent(String id, String name, String manufacturer, double price) {

        // validation
        if (price < 0) {
            throw new IllegalArgumentException("Error: Negative product price");
        }

        if (name.length() == 0 || manufacturer.length() == 0) {
            throw new IllegalArgumentException("Error: Product name or manufacturer is not defined");
        }

        this.componentId = id;
        this.componentName = name;
        this.manufacturer = manufacturer;
        this.unitPrice = price;

    }

    @Override
    public String getComponentId() {
        return componentId;
    }

    @Override
    public String getComponentName() {
        return componentName;
    }

    @Override
    public String getManufacturer() {
        return manufacturer;
    }

    @Override
    public double getPrice() {
        return unitPrice;
    }

}

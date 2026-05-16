package no.ntnu.tdt4100;

/**
 * The <code>IProduct</code> interface represents a product in the shopping
 * system. The interface provides methods to get and set the product's name,
 * description, price, stock, vendor, and product ID. The interface also
 * provides methods to add and reduce the stock of the product.
 * 
 * THIS CODE IS SUPPLIED, DO NOT MODIFY
 */
public interface IProduct {

    /**
     * Gets the product ID.
     * 
     * @return The product ID.
     */
    int getProductId();

    /**
     * Gets the name of the product.
     * 
     * @return The name of the product.
     */
    String getName();

    /**
     * Gets the description of the product.
     * 
     * @return The description of the product.
     */
    String getDescription();

    /**
     * Gets the price of the product.
     * 
     * @return The price of the product.
     */
    double getPrice();

    /**
     * Gets the vendor of the product.
     * 
     * @return The vendor of the product.
     */
    String getVendor();

}

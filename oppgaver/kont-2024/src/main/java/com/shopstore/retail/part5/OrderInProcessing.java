package com.shopstore.retail.part5;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import no.ntnu.tdt4100.IProduct;
import no.ntnu.tdt4100.ProductOrder;
import no.ntnu.tdt4100.Shipment;
import no.ntnu.tdt4100.part5.ProductChange;
import no.ntnu.tdt4100.part5.ProductChangeListener;
import no.ntnu.tdt4100.part5.ProductInventory;

/**
 * This class manages the processing state of a {@link ProductOrder},
 * including creating {@link Shipment} objects whenever products are available
 * in stock and handling stock shortages in a {@link ProductInventory} by
 * subscribing to changes for products.
 * 
 * This class should implement the {@link ProductOrder} interface. The methods
 * given by this interface should delegate their implementation on to the
 * ProductOrder object given as an input argument in the constructor.
 * 
 * The class should also implement the
 * {@link no.ntnu.tdt4100.part5.ProductChangeListener} interface
 * to receive notifications about product changes. Whenever the
 * {@link ProductChangeListener#productChanged(IProduct, ProductChange)} method
 * is then called, it should call the createShipment()
 * method. It should only do this however when the {@link IProduct} argument is
 * present in the collection of unshipped products, and when the
 * ProductChange parameter is of type {@link ProductChange#NOW_AVAILABLE}.
 * Otherwise, the method should do nothing
 * 
 * Read carefully the JavaDoc within this class, as well as the interfaces to
 * implement and refer in particular to the JavaDoc for the
 * {@link OrderInProcessing#createShipment()} and the
 * {@link OrderInProcessing#createInitialShipment()}
 * methods for a detailed description on how the fulfillment process should be
 * handled. Remember also that you are given a full set of tests to see if
 * your implementation is correct.
 * 
 * @see OrderInProcessingTest
 * @see ProductOrder
 * @see ProductChangeListener
 * @see ProductInventory
 */
public class OrderInProcessing {

    // TODO: Add the necessary fields to store the order and inventory information,
    // as well as the shipments and unshipped products

    /**
     * Constructs a new OrderInProcessing object. The OrderInProcessing object
     * should be initialized with a {@link ProductOrder} object and a
     * {@link ProductInventory}, which will be used to check for stock levels.
     * The OrderInProcessing object should also initialize an internal collection of
     * unshipped products with their quantities. After the OrderInProcessing object
     * has been initialized, the unshipped products should contain a copy of the
     * products in the ProductOrder object, with the quantity of each product that
     * should be shipped.
     * 
     * @param productOrder     The {@link ProductOrder} to process.
     * @param productInventory The {@link ProductInventory} to use to check for
     *                         stock levels.
     * 
     * @see ProductOrder#getItems()
     * @see HashMap#putAll(Map)
     *
     */
    public OrderInProcessing(ProductOrder productOrder, ProductInventory productInventory) {
    }

    /**
     * Returns the list of shipments created for this order.
     *
     * @return A {@link List} of {@link Shipment} objects.
     */
    public List<Shipment> getShipments() {
        // TODO: Implement the getShipments method
        return null; // This line is a placeholder, you should remove it when you implement the
                     // method
    }

    /**
     * Indicates whether the order has been completed or is still
     * in processing. An order is considered completed when all products have been
     * shipped.
     *
     * @return A primitive boolean that should be {@code true} if all products in
     *         the order have been shipped, and {@code false} otherwise.
     */
    public boolean isCompleted() {
        // TODO: Implement the isCompleted method
        return false; // This line is a placeholder, you should remove it when you implement the
                      // method
    }

    /**
     * Processes the order by creating a {@link Shipment} object and adding
     * {@link IProduct} objects to it.
     * 
     * The method should iterate over all unshipped products in this object, and
     * attempt to add them to the shipment. For each unshipped product, it
     * should check if there is enough stock for the product in the
     * {@link ProductInventory} object to fulfill the quantity that remains to be
     * shipped.
     * <p>
     * If there is enough stock, the product should be added to the shipment with
     * the quantity that remains to be shipped, and the product should be removed
     * from the internal collection of unshipped products.
     * <i>Hint: Make sure you do not iterate
     * over the collection of unshipped products without making a copy, as this can
     * lead to a ConcurrentModificationException if you remove products from it</i>.
     * </p>
     * <p>
     * If there is not enough stock for a
     * product, the shipment should contain all available stock for the product, and
     * the remaining unshipped quantity for the product should be updated to reflect
     * how much now remains to be shipped. A shipment should never contain a product
     * with a quantity of 0.
     * </p>
     * 
     * After iterating over all unshipped products and adding them to the shipment
     * (if possible), the {@link Shipment} object should be added to an internal
     * list of shipments for this {@link OrderInProcessing} object. If the shipment
     * is empty (i.e. no products could be shipped), the method should do nothing
     * instead.
     * 
     * @see Shipment#Shipment()
     * @see Shipment#productsContained()
     * @see Map#keySet()
     * @see ProductInventory#getStock(IProduct)
     */
    public void createShipment() {
        // TODO: Implement the createShipment method
    }

    /**
     * Creates an initial shipment for the order by calling the
     * {@link OrderInProcessing#createShipment()} method. You can
     * assume that this method will only be called once for each OrderInProcessing
     * object, after initialization.
     * 
     * <p>
     * After running the {@link OrderInProcessing#createShipment()}
     * method, if there are any of the products that could not be fully shipped due
     * to insufficient stock, this OrderInProcessing instance should be added as a
     * listener to the {@link ProductInventory} object in order to be
     * notified of future stock updates.
     * </p>
     * 
     * @see OrderInProcessing#createShipment()
     * @see Map#keySet()
     * @see ProductInventory#addListener(ProductChangeListener)
     */
    public void createInitialShipment() {
        // TODO: Implement the createInitialShipment method
    }

    // TODO: Implement any other required methods from the ProductOrder and
    // ProductChangeListener interfaces

}

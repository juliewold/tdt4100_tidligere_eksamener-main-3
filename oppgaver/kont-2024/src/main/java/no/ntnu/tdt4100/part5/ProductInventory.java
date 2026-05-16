package no.ntnu.tdt4100.part5;

import no.ntnu.tdt4100.IProduct;

public interface ProductInventory {

    /**
     * Returns the current stock level of a specified product.
     *
     * @param product The {@link IProduct} object whose stock level should be
     *                returned.
     * @return The current stock level of the product. It should return 0 if the
     *         product is not in the inventory.
     */
    int getStock(IProduct product);

    /**
     * Registers a listener for product change notifications.
     * This method should also ensure that a listener is only added once.
     *
     * @param listener The listener to add.
     */
    void addListener(ProductChangeListener listener);

    /**
     * Unregisters a listener from receiving product change notifications.
     *
     * @param listener The listener to remove.
     */
    void removeListener(ProductChangeListener listener);

}
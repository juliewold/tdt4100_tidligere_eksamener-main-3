package com.shopstore.retail.part5;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import no.ntnu.tdt4100.IProduct;
import no.ntnu.tdt4100.part5.ProductChange;
import no.ntnu.tdt4100.part5.ProductChangeListener;
import no.ntnu.tdt4100.part5.ProductInventory;

/**
 * Manages the inventory of products. The class should contain information about
 * stock levels for {@link IProduct} objects, and should be able to notify
 * listeners of changes to changes in products. This class should also implement
 * the {@link no.ntnu.tdt4100.part5.ProductInventory} interface in order to
 * handle listeners. See the interface specification for details on the methods
 * to implement from this interface.
 *
 * @see ProductInventoryTest
 * @see ProductInventory
 * @see IProduct
 * @see ProductChangeListener
 * @see ProductChange
 */
public class ProductInventoryManager implements ProductInventory {

    private Map<IProduct, Integer> productStock;
    private List<ProductChangeListener> productChangeListeners = new ArrayList<>();

    /**
     * Constructs a new ProductInventoryManager with a predefined set of
     * products and their stock levels. This is given as a parameter
     * <code>productStock</code> of type {@link Map}, with
     * {@link IProduct} objects as keys and {@link Integer} objects as values,
     * representing the current stock level.
     *
     * @param productStock A {@link Map} of {@link IProduct} to their corresponding
     *                     stock levels, represented with {@link Integer}.
     * @throws IllegalArgumentException If any of the stock levels in
     *                                  <code>productStock</code> are negative.
     */
    public ProductInventoryManager(Map<IProduct, Integer> productStock) {
        for (IProduct product : productStock.keySet()) {
            if (productStock.get(product) < 0) {
                throw new IllegalArgumentException("Stock level cannot be negative.");
            }
        }
        this.productStock = productStock;
    }

    /**
     * Increases the stock level of a specified product by a given quantity. If the
     * product is not already in the inventory, it should be added with the given
     * quantity. If the product was not already in the inventory, or if the stock
     * was previously zero, it notifies listeners that the product is now available
     * by invoking their
     * {@link ProductChangeListener#productChanged(IProduct, ProductChange)} method
     * with a ProductChange of type {@link ProductChange#NOW_AVAILABLE}.
     *
     * @param product  The {@link IProduct} whose stock is to be increased.
     * @param quantity The amount by which to increase the stock, as a primitive
     *                 int.
     * @throws IllegalArgumentException if {@code quantity} is less than 1
     * 
     * @see ProductChange#NOW_AVAILABLE
     * @see ProductChangeListener#productChanged(IProduct, ProductChange)
     * @see IProduct
     */
    public void increaseStock(IProduct product, int quantity) {
        int previousStock = 0;
        if (productStock.containsKey(product)) {
            previousStock = productStock.get(product);
        }
        if (quantity < 1) {
            throw new IllegalArgumentException("Quantity to add must be greater than 0.");
        }
        productStock.put(product, previousStock + quantity);
        if (previousStock == 0) {
            productChangeListeners.forEach(listener -> listener.productChanged(product, ProductChange.NOW_AVAILABLE));
        }
    }

    /**
     * Reduces the stock level of a specified product by a given quantity.
     * If the product's stock reaches zero, it notifies listeners that the product
     * is out of stock by invoking their
     * {@link ProductChangeListener#productChanged(IProduct, ProductChange)} method
     * with a ProductChange of type {@link ProductChange#OUT_OF_STOCK}.
     *
     * @param product  The {@link IProduct} whose stock is to be reduced.
     * @param quantity The amount by which to reduce the stock, as a primitive int.
     * @throws IllegalArgumentException if the product is not in this
     *                                  inventory or if {@code quantity} is less
     *                                  than 1 or greater than the current stock
     *                                  level.
     * 
     * @see ProductChange#OUT_OF_STOCK
     * @see ProductChangeListener#productChanged(IProduct, ProductChange)
     * @see IProduct
     */
    public void reduceStock(IProduct product, int quantity) {
        if (!productStock.containsKey(product)) {
            throw new IllegalArgumentException("Product not found in inventory.");
        }
        if (quantity < 1 || quantity > productStock.get(product)) {
            throw new IllegalArgumentException(
                    "Quantity to remove must be greater than 0 and less than the current stock.");
        }
        productStock.put(product, productStock.get(product) - quantity);
        if (productStock.get(product) == 0) {
            productChangeListeners.forEach(listener -> listener.productChanged(product, ProductChange.OUT_OF_STOCK));
        }
    }

    @Override
    public int getStock(IProduct product) {
        return productStock.getOrDefault(product, 0);
    }

    @Override
    public void addListener(ProductChangeListener listener) {
        if (!productChangeListeners.contains(listener)) {
            productChangeListeners.add(listener);
        }
    }

    @Override
    public void removeListener(ProductChangeListener listener) {
        productChangeListeners.remove(listener);
    }
}

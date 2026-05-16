package no.ntnu.tdt4100.part5;

import no.ntnu.tdt4100.IProduct;

/**
 * Interface for classes that want to listen for changes in products.
 */
public interface ProductChangeListener {

    /**
     * 
     * This method will be called when a product is changed.
     * 
     * @param product       the {@link IProduct} that has changed price.
     * @param productChange the {@link ProductChange} that has occurred.
     */
    void productChanged(IProduct product, ProductChange productChange);

}

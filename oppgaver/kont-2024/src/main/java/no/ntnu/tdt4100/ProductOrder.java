package no.ntnu.tdt4100;

import java.util.Map;

/**
 * Represents a product order in a shopping system. A product order is a
 * collection of products that a customer has added for purchase. The order
 * should contain information about the customer who placed the order, the
 * products that are part of the order, as well as the quantity per product. The
 * order should also be able to calculate the total price of all items in the
 * order, minus any discounts that might apply.
 */
public interface ProductOrder {

    /**
     * This method should return the customer associated with the order.
     *
     * @return The customer associated with the order, of type {@link Customer}.
     */
    Customer getCustomer();

    /**
     * Returns the total price of all items in the order. This should be the sum of
     * the prices of all items in the ProductOrder, minus any discounts that might
     * apply to the various products. In the case of multiple discounts applying to
     * the same product, only the discount that gives the biggest reduction in price
     * should be applied.
     *
     * @return The total price of all items in the order minus any discounts. The
     *         price should be of the primitive type double.
     * 
     * @see no.ntnu.tdt4100.ProductDiscount#applyDiscount(IProduct)
     * @see no.ntnu.tdt4100.ProductDiscount#isApplicableTo(IProduct)
     * @see no.ntnu.tdt4100.ProductDiscount#getDiscountPercentage()
     */
    double getTotal();

    /**
     * This method should return a map of all items in the order, with their
     * corresponding quantities. The keys in the map should be the products, and
     * these must be unique. The values of the map should be the quantities of the
     * products added to the order, which must be positive integers (greater than
     * 0).
     *
     * @return A {@link Map} of all unique products as keys of type
     *         {@link IProduct} and the quantities of the products as values of
     *         type {@link Integer}.
     */
    Map<IProduct, Integer> getItems();

}

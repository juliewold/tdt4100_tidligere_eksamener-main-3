package com.shopstore.retail.part2;

import no.ntnu.tdt4100.ProductOrder;

/**
 * Manages the checkout process in a shopping system.
 * This class must implement the {@link no.ntnu.tdt4100.ProductOrder}
 * interface. It should contain a collection of {@link no.ntnu.tdt4100.IProduct}
 * objects and it should be able to add and remove a quantity of products from
 * the shopping cart. The class should also be able to hold multiple
 * {@link no.ntnu.tdt4100.ProductDiscount} objects that can be applied to the
 * products in the shopping cart.
 * 
 * In addition to the methods required by the interface, the class should have
 * some additional methods for managing the shopping cart that you will need to
 * implement, marked with JavaDoc and TODO comments below.
 * 
 */
public class ShoppingCart {

    /**
     * Creates a new shopping cart for a customer. An
     * {@link IllegalArgumentException} should be thrown if the customer is null.
     *
     * @param customer The customer to create the shopping cart for, of type
     *                 {@link no.ntnu.tdt4100.Customer}.
     * 
     * @throws IllegalArgumentException If the customer is null.
     * 
     * @see no.ntnu.tdt4100.Customer
     */
    // TODO: Implement the ShoppingCart constructor

    /**
     * Adds a quantity of a product to the shopping cart.
     *
     * @param product  The product to add, of type {@link IProduct}.
     * @param quantity The quantity of the product to add, of the primitive type
     *                 int.
     * @throws IllegalArgumentException If the quantity to add is less than 1.
     * 
     * @see no.ntnu.tdt4100.IProduct
     */
    // TODO: Implement the addItem method
    // TODO: The parameters of the method should be in the following order:
    // product, quantity

    /**
     * Removes a quantity of a product from the shopping cart.
     * 
     * If the quantity to remove is equal to or greater than the quantity of the
     * product in the cart, the product should be removed entirely from the cart.
     * 
     * @param product  The product to remove, of type {@link IProduct}.
     * @param quantity The quantity of the product to remove, of the primitive type
     *                 int.
     * @throws IllegalArgumentException If the {@link IProduct} is not in the cart
     *                                  or the quantity to remove is less than 1.
     * 
     * @see no.ntnu.tdt4100.IProduct
     */
    // TODO: Implement the removeItem method
    // TODO: The parameters of the method should be in the following order:
    // product, quantity

    /**
     * Adds a discount to the shopping cart. The shopping cart should be able to
     * apply multiple discounts, and these discounts should stack, e.g. you should
     * be able to apply a 10% discount and then afterwards another 20% discount
     * which both apply to the total price.
     *
     * @param discount The discount to add, of type {@link ProductDiscount}.
     * @throws IllegalArgumentException If the discount has already been added
     * 
     * @see no.ntnu.tdt4100.ProductDiscount
     */
    // TODO: Implement the addDiscount method

    /**
     * Gets all discounts currently added to the shopping cart.
     *
     * @return A list of all discounts, of type {@link ProductDiscount}.
     * 
     * @see no.ntnu.tdt4100.ProductDiscount
     */
    // TODO: Implement the getDiscounts method

    // TODO: Implement any other methods required by the ProductOrder interface

}

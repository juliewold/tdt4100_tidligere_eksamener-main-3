package com.shopstore.retail.part2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import no.ntnu.tdt4100.Customer;
import no.ntnu.tdt4100.ProductDiscount;
import no.ntnu.tdt4100.IProduct;
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
 * some additional methods for managing the shopping cart, marked with JavaDoc
 * and TODO comments below.
 * 
 */
public class ShoppingCart implements ProductOrder {

    private Customer customer;
    private List<IProduct> items = new ArrayList<>();
    private List<ProductDiscount> discounts = new ArrayList<>();

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
    public ShoppingCart(Customer customer) {
        if (customer == null) {
            throw new IllegalArgumentException("Customer cannot be null.");
        }
        this.customer = customer;
    }

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
    public void addItem(IProduct product, int quantity) {
        if (quantity < 1) {
            throw new IllegalArgumentException("Quantity must be greater than 0.");
        }
        for (int i = 0; i < quantity; i++) {
            items.add(product);
        }
    }

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
    public void removeItem(IProduct product, int quantity) {
        if (!items.contains(product) || quantity < 1) {
            throw new IllegalArgumentException("Product not in cart or quantity less than 1.");
        }
        for (int i = 0; i < quantity; i++) {
            items.remove(product);
        }
    }

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
    public void addDiscount(ProductDiscount discount) {
        if (discounts.contains(discount)) {
            throw new IllegalArgumentException("Discount already added.");
        }
        discounts.add(discount);
    }

    /**
     * Gets all discounts currently added to the shopping cart.
     *
     * @return A list of all discounts, of type {@link ProductDiscount}.
     * 
     * @see no.ntnu.tdt4100.ProductDiscount
     */
    public List<ProductDiscount> getDiscounts() {
        return new ArrayList<>(discounts);
    }

    @Override
    public double getTotal() {
        double total = 0;
        for (IProduct item : items) {
            double discountedPrice = item.getPrice();
            for (ProductDiscount discount : getDiscounts()) {
                if (discount.applyDiscount(item) < discountedPrice) {
                    discountedPrice = discount.applyDiscount(item);
                }
            }
            total += discountedPrice;
        }
        return total;
    }

    @Override
    public Customer getCustomer() {
        return customer;
    }

    @Override
    public Map<IProduct, Integer> getItems() {
        Map<IProduct, Integer> itemMap = new HashMap<>();
        for (IProduct item : items) {
            itemMap.put(item, itemMap.getOrDefault(item, 0) + 1);
        }
        return itemMap;
    }

}

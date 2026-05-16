package com.shopstore.retail.part2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import no.ntnu.tdt4100.ProductDiscount;
import no.ntnu.tdt4100.ProductOrder;
import no.ntnu.tdt4100.IProduct;

/**
 * Provides valuable product- and discount-related insights by filtering and
 * aggregating data.
 */
public class ProductAnalytics {

    /**
     * Returns a count of the number of {@link no.ntnu.tdt4100.IProduct} objects in
     * a list of products that matches a {@link Predicate} of type
     * Predicate<IProduct>.
     *
     * @param products  A {@link List} containing objects of type {@link IProduct}.
     * @param predicate The {@link Predicate} object to test with
     *                  (Predicate<IProduct>).
     * @return A count (of the primitive type int) of the number of products
     *         matching the predicate.
     * 
     * @see Predicate
     * @see Predicate#test(IProduct)
     * @see IProduct
     * @see List
     */
    public int getNumberOfProductsByPredicate(List<IProduct> products, Predicate<IProduct> predicate) {
        return (int) products.stream().filter(predicate).count();
    }

    /**
     * Returns only the discounts applicable to at least one product in a
     * {@link no.ntnu.tdt4100.ProductOrder} object. The list of products in a
     * product order can be retrieved by calling the {@link ProductOrder#getItems()}
     * method on the product order. Whether a discount is applicable to a product or
     * not can be checked by calling the
     * {@link ProductDiscount#isApplicableTo(IProduct)} method on the
     * {@link ProductDiscount} object.
     *
     * @param productOrder A {@link ProductOrder} object.
     * @param discounts    A {@link List} containing objects of type
     *                     {@link ProductDiscount}.
     * @return A {@link List} containing objects of type {@link ProductDiscount},
     *         applicable to at least one product in the product order.
     * 
     * @see ProductOrder#getItems()
     * @see Map#keySet()
     */
    public List<ProductDiscount> getDiscountsApplicableForProductOrder(ProductOrder productOrder,
            List<ProductDiscount> discounts) {
        List<IProduct> products = new ArrayList<>(productOrder.getItems().keySet());
        List<ProductDiscount> applicableDiscounts = new ArrayList<>();
        for (ProductDiscount discount : discounts) {
            for (IProduct product : products) {
                if (discount.isApplicableTo(product)) {
                    applicableDiscounts.add(discount);
                    break;
                }
            }
        }
        return applicableDiscounts;
    }

    /**
     * Finds and returns the vendor with the most amount of products in a list of
     * products. The vendor is defined by a String, and can be found by calling the
     * {@link IProduct#getVendor()} method on the product.
     *
     * @param products A {@link List} containing objects of type {@link IProduct}.
     * @return The name of the most popular vendor as a {@link String}, or null if
     *         the list is empty.
     * 
     * @see IProduct#getVendor()
     */
    public String getMostPopularVendor(List<IProduct> products) {
        Map<String, Integer> vendorCount = new HashMap<>();
        for (IProduct product : products) {
            String category = product.getVendor();
            vendorCount.put(category, vendorCount.getOrDefault(category, 0) + 1);
        }
        return vendorCount.keySet().stream()
                .max(Comparator.comparingInt(vendorCount::get))
                .orElse(null);
    }
}

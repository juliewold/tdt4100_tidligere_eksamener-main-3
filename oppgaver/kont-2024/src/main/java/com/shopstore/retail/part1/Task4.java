package com.shopstore.retail.part1;

import java.util.List;

import no.ntnu.tdt4100.IProduct;

import no.ntnu.tdt4100.Product;


public class Task4 {
    /**
     * Adds up the total price of the items in the list and adds a shipping cost to
     * the total. If the list is empty, the method should return 0.
     * 
     * @param items the list of {@link IProduct} items to calculate the total price
     * @return the total price of the items with shipping cost added to the total
     */
    public double getTotalPriceWithShipping(List<IProduct> items, double shippingCost) {
        // TODO Uncomment the line(s) that returns as specified in JavaDoc

        // if (items.size() > 0) return items.stream().map(i -> i.getPrice() + shippingCost).findFirst().get();
        // if (items.size() >= 0) return items.stream().map(i -> i.getPrice()).reduce(0.0, (a, b) -> a + b) + shippingCost;
        // if (items.size() > 0) return items.stream().sorted((o1, o2) -> (int) (o2.getPrice() + shippingCost)).findFirst().get().getPrice();
        // if (items.size() > 0) return items.iterator().next().getPrice() + shippingCost;
        // if (items.size() > 0) return items.stream().mapToDouble(i -> i.getPrice()).sum() + shippingCost;

        return 0.0; // This line is only in place to make the code compile, do not remove it
    }

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        // You can use this main method to test the method if you like, but it is not required
        IProduct product1 = new Product(1, "Product 1", "Description 1", 100.0, "Vendor 1");
        Task4 task4 = new Task4();
        // Any other testing code can go here...
    }
}

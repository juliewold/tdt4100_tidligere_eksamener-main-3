
package com.twowheels.assembly.part1;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Collection;
import java.util.Comparator;

class Product {
    private final String name;
    private final double price;
    private final int productId;

    public Product(String name, double price, int productId) {
        if (name == null || price < 0 || productId < 0) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.price = price;
        this.productId = productId;
    }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getProductId() { return productId; }
}

class ProductSorter {
    /**
     * Sort the products by the price from highest to lowest 
     * If multiple products have the same price,
     * sort them alfabetically by the productId 
     * considered as a String.
     * Do not include products with a price of 0.
     *
     * @param products the list of Product objects to sort
     * @return a sorted collection of Product objects
     */
    public List<Product> sortProducts(List<Product> products) {

        // TODO: Implement the sorting logic here, by uncommenting appropriate lines.

        // NB! You are not allowed to rearrange lines, only uncomment lines.

        return products
            // .stream()
            // .sorted(Comparator.comparing(Product::getName))
            // .sorted(Comparator.comparingInt(p -> p.getName().charAt(0)))
            // .sorted(Comparator.comparing(p -> p.getProductId() + ""))
            // .sorted(Comparator.comparingDouble(Product::getPrice))
            // .sorted(Comparator.comparingDouble(Product::getPrice).reversed())
            // .sorted(Comparator.comparingInt(Product::getProductId))
            // .sorted(Comparator.comparing(p -> p.getProductId() + ""))
            // .sorted(Comparator.comparingInt(p -> p.getName().charAt(0))
            // .filter(p -> p.getPrice() > 0)
            // .collect(Collectors.toList())
            ;
    }
}
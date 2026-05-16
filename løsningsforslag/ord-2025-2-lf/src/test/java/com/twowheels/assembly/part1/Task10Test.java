package com.twowheels.assembly.part1;

import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class Task10Test {
    @Test
    void testSortProducts_basicSorting() {
        List<Product> products = Arrays.asList(
            new Product("A", 10.0, 2),
            new Product("B", 20.0, 1),
            new Product("C", 15.0, 3)
        );
        List<Product> sorted = new ProductSorter().sortProducts(products);
        assertEquals(3, sorted.size());
        assertEquals(20.0, sorted.get(0).getPrice());
        assertEquals(15.0, sorted.get(1).getPrice());
        assertEquals(10.0, sorted.get(2).getPrice());
    }

    @Test
    void testSortProducts_tiebreakerByProductIdString() {
        List<Product> products = Arrays.asList(
            new Product("A", 10.0, 2),
            new Product("B", 10.0, 10),
            new Product("C", 10.0, 1)
        );
        List<Product> sorted = new ProductSorter().sortProducts(products);
        assertEquals("1", String.valueOf(sorted.get(0).getProductId()));
        assertEquals("10", String.valueOf(sorted.get(1).getProductId()));
        assertEquals("2", String.valueOf(sorted.get(2).getProductId()));
    }

    @Test
    void testSortProducts_excludeZeroPrice() {
        List<Product> products = Arrays.asList(
            new Product("A", 0.0, 1),
            new Product("B", 5.0, 2)
        );
        List<Product> sorted = new ProductSorter().sortProducts(products);
        assertEquals(1, sorted.size());
        assertEquals(5.0, sorted.get(0).getPrice());
    }

    @Test
    void testSortProducts_emptyList() {
        List<Product> products = Collections.emptyList();
        List<Product> sorted = new ProductSorter().sortProducts(products);
        assertTrue(sorted.isEmpty());
    }
}

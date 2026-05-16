package com.shopstore.retail.part1;

import java.util.Comparator;
import java.util.List;

import no.ntnu.tdt4100.Customer;

public class Task10 {

    /*
     * This method should sort the list of customers by the initial letter of their
     * name from a-z. If multiple customers have the same initial letter,
     * they should then be sorted by their ID from lowest to highest.
     * 
     * @param unSortedCustomers The list of customers to be sorted.
     */
    public void sortMe(List<Customer> unSortedCustomers) {
        Comparator<Customer> C = (c1, c2) -> 0;

        // TODO Uncomment the lines that will make the method return as specified

        // C = (c1, c2) -> c1.name().charAt(0) == c2.name().charAt(0) ? c2.id() - c1.id() : c1.name().charAt(0) - c1.name().charAt(0);
        // C = (c2, c1) -> c1.name().charAt(0) == c2.name().charAt(0) ? c2.id() - c1.id() : c1.name().charAt(0) - c2.name().charAt(0);
        // C = (c2, c1) -> c2.name().charAt(0) == c1.name().charAt(0) ? c2.id() - c1.id() : c2.name().charAt(0) - c1.name().charAt(0);
        // C = (c1, c2) -> (char) c1.name().length() == (char) c2.name().length() ? c1.id() - c2.id() : c2.name().charAt(0) - c1.name().charAt(0);
        // C = (c1, c2) -> c2.name().charAt(0) == c1.name().charAt(0) ? c1.id() + c2.id() : c2.name().charAt(0) + c1.name().charAt(0);
        // Actual answer:

        unSortedCustomers.sort(C);
    }

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        // You can use this main method to test the method if you like, but it is not required
        Task10 x = new Task10();
        Customer c3 = new Customer(3, "Charlie", "test3@test.com", "789 Fake St.");
        Customer c1 = new Customer(1, "Alice", "test@test.com", "123 Fake St.");
        Customer c2 = new Customer(2, "Bob", "test2@test.com", "456 Fake St.");
        // Any other code you need to test the method...
    }
}

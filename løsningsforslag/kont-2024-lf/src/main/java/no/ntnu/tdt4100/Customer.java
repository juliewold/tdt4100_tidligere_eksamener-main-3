package no.ntnu.tdt4100;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a customer in the shopping system.
 * A customer has an id, name, email, address and a list of discounts.
 * 
 * THIS IS SUPPLIED CODE, DO NOT MODIFY THIS CODE
 * 
 * @see AbstractDiscount
 */
public record Customer(int id, String name, String email, String address, List<AbstractDiscount> discounts) {
    public Customer(int id, String name, String email, String address) {
        this(id, name, email, address, new ArrayList<>());
    }
}
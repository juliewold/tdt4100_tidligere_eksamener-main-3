package no.ntnu.tdt4100.part4;

import java.util.List;

import no.ntnu.tdt4100.Product;

/**
 * The <code>ResultSet</code> class contains a list of {@link Product}
 * objects, and a list of line numbers for errors.
 * THIS CODE IS SUPPLIED, DO NOT MODIFY
 */
public record ResultSet(List<Product> products, List<Integer> linesWithErrors) {
}

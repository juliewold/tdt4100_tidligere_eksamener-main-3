package no.ntnu.tdt4100.part3;

import no.ntnu.tdt4100.Customer;
import no.ntnu.tdt4100.IProduct;

public record ProductReview(IProduct product, Customer customer, String reviewText, double rating) {
}

package no.ntnu.tdt4100.part3;

import no.ntnu.tdt4100.IProduct;

/**
 * This class is an exception type used when a review is invalid
 * 
 * THIS IS SUPPLIED CODE, DO NOT MODIFY
 */
public class InvalidReviewException extends Exception {
    private IProduct product;

    /**
     * Creates a new exception with the product that the review is made for, along
     * with an error message
     * 
     * @param product The product that the review is made for, of type
     *                {@link IProduct}
     * @param message The message of the exception
     */
    public InvalidReviewException(IProduct product, String message) {
        super(message);
        this.product = product;
    }

    public IProduct getReview() {
        return product;
    }

}
package com.shopstore.retail.part3;

/**
 * Manages product reviews in a system. The system should be able to perform
 * validation on and keep track of {@link no.ntnu.tdt4100.part3.ProductReview}
 * objects, get all reviews for a specific product, and calculate the average
 * rating for a product.
 * 
 * All methods in this class should be static / class methods.
 * A class method is a method that is bound to a class rather than its object.
 * It doesn't require creation of a class instance to be invoked.
 * There should be no additional constructors in this class besides the one
 * already declared as private.
 */
public class ProductReviewSystem {

    private ProductReviewSystem() {
        // WARNING: DO NOT REMOVE THIS CONSTRUCTOR OR ADD ANY MORE CONSTRUCTORS
    }

    /**
     * Performs validation on the rating and review text of a submitted review,
     * creates a new {@link ProductReview} object, and adds it to the system's list
     * of reviews if the review passes the validation. A review
     * should be rejected if the rating is not between 1.0 and 5.0 (inclusive), if
     * the reviewText is more than 240 characters in length, and if an identical
     * review already exists (see rules for this below).
     * 
     * A review is considered to be identical to another if there is a review for
     * the same {@link IProduct} object / instance, with an identical review text,
     * and identical rating already added to the system. Note that the review is
     * considered identical even if a different customer submitted it.
     * 
     * A special exception {@link no.ntnu.tdt4100.part3.InvalidReviewException}
     * should be thrown if the review does not pass one of the validation checks.
     * This exception is a checked exception and should be declared in the method
     * signature.
     * 
     * @param product    The product to review, of type {@link IProduct}.
     * @param customer   The customer writing the review, of type {@link Customer}.
     * @param reviewText The text of the review, of type {@link String}. Must be
     *                   less than or equal to 240 characters.
     * @param rating     The rating given by the customer, of the primitive type
     *                   double. Must be between 1.0 and 5.0
     * @throws InvalidReviewException If an identical review already exists for this
     *                                product, if the review text is longer than 240
     *                                characters, or if the rating is not between
     *                                1.0 and 5.0 (inclusive).
     * 
     * @see IProduct
     * @see Customer
     * @see no.ntnu.tdt4100.part3.InvalidReviewException
     * @see ProductReview#ProductReview(IProduct, Customer, String, double)
     */
    // TODO: Implement the static addReview method.
    // TODO: The parameters of the method should be in the following order:
    // product, customer, reviewText, rating

    /**
     * Gets all reviews for a given {@link IProduct} object. The method should
     * return a list of all reviews for the product, submitted by any customer.
     *
     * @param product The product to get reviews for, of type {@link IProduct}.
     * @return A {@link List} of reviews for the product, of type
     *         {@link ProductReview}.
     * 
     * @see ProductReview#product()
     */
    // TODO: Implement the static getReviewsFor method

    /**
     * Calculates the average rating for a product, based on all reviews for the
     * product in the system and the rating given in each review. The average rating
     * should be calculated as the sum of all ratings divided by the number of
     * reviews.
     *
     * @param product The product to calculate the average rating for, of type
     *                {@link IProduct}.
     * @return The average rating for the product of the primtive type double. If
     *         there are no reviews for the product, the method should return 0.0.
     * 
     * @see ProductReview#rating()
     * @see List#size()
     */
    // TODO: Implement the static getAverageRatingFor method

}

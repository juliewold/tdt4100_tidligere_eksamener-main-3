package no.ntnu.tdt4100;

/**
 * This is an abstract class representing a discount structure. The class
 * provides the basic functionalities to create a discount code and setting the
 * discount percentage, as well as applying the discount to a product. The class
 * also defines an abstract method to determine if the discount is applicable to
 * a specific product.
 */
public abstract class AbstractDiscount {

    protected static final String legalCharacters = "ABCDEFGHJKLMNOPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz123456789";
    protected String discountCode;
    protected double discountPercentage;

    /**
     * Creates a new product discount with the given discount code and discount
     * percentage.
     * 
     * @param discountCode       The discount code.
     * @param discountPercentage The discount percentage.
     */
    public AbstractDiscount(int discountCodeLength, double discountPercentage) {
        if (discountPercentage < 0 || discountPercentage > 100) {
            throw new IllegalArgumentException("Discount percentage must be between 0 and 100.");
        }
        if (discountCodeLength < 8) {
            throw new IllegalArgumentException("Discount code must be at least 8 characters long.");
        }
        this.discountCode = generateDiscountCode(discountCodeLength);
        this.discountPercentage = discountPercentage;
    }

    /**
     * Generates a random discount code of a specified length. The code is composed
     * of legal characters defined in {@code legalCharacters}.
     *
     * @param length The length of the discount code to be generated.
     * @return A string representing the generated discount code.
     */
    public static String generateDiscountCode(int length) {
        StringBuilder discountCode = new StringBuilder();
        for (int i = 0; i < length; i++) {
            discountCode.append(legalCharacters.charAt((int) (Math.random() * legalCharacters.length())));
        }
        return discountCode.toString();
    }

    /**
     * Gets the discount code.
     *
     * @return The discount code.
     */
    public String getDiscountCode() {
        return discountCode;
    }

    /**
     * Gets the discount percentage.
     *
     * @return The discount percentage.
     */
    public double getDiscountPercentage() {
        return discountPercentage;
    }

    /**
     * Applies the discount to a product and returns the new price of the product,
     * but only if the discount applies to the product in question. This is checked
     * by making a call to the abstract {@link #isApplicableTo} method. If the
     * discount does not apply to the product, the original price is returned.
     *
     * @param product The product to which the discount may be applied.
     * @return The price of the product after applying the discount, if applicable;
     *         otherwise, the original product price.
     */
    public double applyDiscount(IProduct product) {
        if (isApplicableTo(product)) {
            return product.getPrice() * (1 - discountPercentage / 100);
        }
        return product.getPrice();
    }

    /**
     * Determines if the discount is applicable to a specific product.
     * 
     * @param product The product to check.
     * @return {@code true} if the discount is applicable to the product,
     *         {@code false} otherwise.
     */
    public abstract boolean isApplicableTo(IProduct product);
}

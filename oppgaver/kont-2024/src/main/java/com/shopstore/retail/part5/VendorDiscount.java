package com.shopstore.retail.part5;

/**
 * This class represents a discount that is applicable {@link IProduct} objects
 * from a specific vendor.
 * This class should extend the {@link no.ntnu.tdt4100.AbstractDiscount} class
 * and have a constructor that, in addition to the existing attributes in
 * AbstractDiscount, sets the name of the vendor, given as a {@link String},
 * whose products the discount should be applied to.
 * The {@link AbstractDiscount#isApplicableTo(IProduct)} method should then be
 * implemented to use the name of the vendor check which {@IProduct} objects
 * the discount should be applied to.
 * 
 * @see VendorDiscountTest
 * @see AbstractDiscount
 * @see IProduct
 * @see IProduct#getVendor()
 */
public class VendorDiscount {

    /**
     * Creates a new vendor discount with a discount code of the given length,
     * discount percentage, and vendor name.
     * 
     * @param discountCodeLength The length of discount code, as a primitive int.
     * @param discountPercentage The discount percentage, as a primitive double.
     * @param vendor             The vendor name, as a {@link String}.
     * 
     * @see AbstractDiscount#AbstractDiscount(int, double)
     */
    // TODO: Implement the constructor for the VendorDiscount class

    // TODO: Implement the isApplicableTo method from the AbstractDiscount class
}

package com.shopstore.retail.part5;

import no.ntnu.tdt4100.AbstractDiscount;
import no.ntnu.tdt4100.IProduct;

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
public class VendorDiscount extends AbstractDiscount {

    private String vendor;

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
    public VendorDiscount(int discountCodeLength, double discountPercentage, String vendor) {
        super(discountCodeLength, discountPercentage);
        this.vendor = vendor;
    }

    @Override
    public boolean isApplicableTo(IProduct product) {
        return product.getVendor().equals(vendor);
    }
}

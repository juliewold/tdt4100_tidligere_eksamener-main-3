package no.ntnu.tdt4100;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a discount that is applicable to a specific product.
 * 
 * THIS IS SUPPLIED CODE, DO NOT MODIFY THIS CODE
 * 
 * @see AbstractDiscount
 */
public class ProductDiscount extends AbstractDiscount {

    private List<IProduct> applicableProducts;

    /**
     * Creates a new product discount with a discount code of the given length,
     * discount percentage, and applicable products.
     * 
     * @param discountCodeLength The length of discount code.
     * @param discountPercentage The discount percentage.
     * @param applicableProducts The applicable products.
     */
    public ProductDiscount(int discountCodeLength, double discountPercentage, List<IProduct> applicableProducts) {
        super(discountCodeLength, discountPercentage);
        this.applicableProducts = new ArrayList<>(applicableProducts);
    }

    @Override
    public boolean isApplicableTo(IProduct product) {
        return applicableProducts.contains(product);
    }
}

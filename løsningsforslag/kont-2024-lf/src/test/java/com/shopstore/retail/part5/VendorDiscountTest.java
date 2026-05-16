package com.shopstore.retail.part5;

import org.junit.jupiter.api.Test;

import no.ntnu.tdt4100.AbstractDiscount;
import no.ntnu.tdt4100.IProduct;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.lang.reflect.Field;

public class VendorDiscountTest {

    @Test
    public void VendorDiscount_class_should_extend_AbstractDiscount() {
        assertTrue(VendorDiscount.class.getSuperclass().equals(AbstractDiscount.class),
                "VendorDiscount should extend AbstractDiscount");
    }

    @Test
    public void after_calling_constructor_getters_return_correct_values() {
        VendorDiscount discount = new VendorDiscount(8, 15.0, "VendorB");
        assertEquals(8, discount.getDiscountCode().length());
        assertEquals(15.0, discount.getDiscountPercentage(), 0.001);
    }

    @Test
    public void protected_fields_in_abstract_class_should_be_set_by_constructor()
            throws NoSuchFieldException, IllegalAccessException {
        VendorDiscount discount = new VendorDiscount(8, 15.0, "VendorB");
        Field protectedDiscountCodeField = AbstractDiscount.class.getDeclaredField("discountCode");
        protectedDiscountCodeField.setAccessible(true);
        assertEquals(8, ((String) protectedDiscountCodeField.get(discount)).length(),
                "Discount code length should be 8, your implementation might not be setting the already defined protected field in AbstractDiscount correctly");
        Field protectedDiscountPercentageField = AbstractDiscount.class.getDeclaredField("discountPercentage");
        protectedDiscountPercentageField.setAccessible(true);
        assertEquals(15.0, (double) protectedDiscountPercentageField.get(discount), 0.001,
                "Discount percentage should be 15.0, your implementation might not be setting the already defined protected field in AbstractDiscount correctly");
    }

    @Test
    public void isApplicable_discount_is_applicable_for_matching_vendor() {
        IProduct product = mock(IProduct.class);
        when(product.getVendor()).thenReturn("VendorA");

        VendorDiscount discount = new VendorDiscount(8, 10.0, "VendorA");
        assertTrue(discount.isApplicableTo(product));
    }

    @Test
    public void isApplicable_discount_is_not_applicable_for_other_vendor() {
        IProduct product = mock(IProduct.class);
        when(product.getVendor()).thenReturn("VendorB");

        VendorDiscount discount = new VendorDiscount(8, 10.0, "VendorA");
        assertFalse(discount.isApplicableTo(product));
    }
}
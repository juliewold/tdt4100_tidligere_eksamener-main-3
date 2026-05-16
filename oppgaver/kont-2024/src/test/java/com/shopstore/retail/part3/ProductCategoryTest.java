package com.shopstore.retail.part3;

import org.junit.jupiter.api.Test;

import no.ntnu.tdt4100.IProduct;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ProductCategoryTest {

    @Test
    public void isDescendantOf_test_child_is_subcategory_of_parent() {
        ProductCategory parent = new ProductCategory("Parent");
        ProductCategory child = new ProductCategory("Child");
        parent.addChildCategory(child);
        assertTrue(child.isDescendantOf(parent));
    }

    @Test
    public void isDescendantOf_test_category_is_not_subcategory_of_unrelated() {
        ProductCategory category1 = new ProductCategory("Parent");
        ProductCategory category2 = new ProductCategory("Child");
        assertFalse(category1.isDescendantOf(category2));
    }

}
package com.shopstore.retail.part3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.lang.reflect.Modifier;

@SuppressWarnings("static-access")
public class ProductReviewSystemTest {

    ProductReviewSystem productReviewSystem;

    @BeforeEach
    public void setUp() {
        productReviewSystem = mock(ProductReviewSystem.class, Mockito.CALLS_REAL_METHODS);
    }

    // Test that all methods in ProductReviewSysem is static
    @Test
    public void all_methods_are_static() {
        assertTrue(ProductReviewSystem.class.getDeclaredMethods().length > 0);
        for (var method : ProductReviewSystem.class.getDeclaredMethods()) {
            if (!Modifier.isPrivate(method.getModifiers())) {
                assertTrue(java.lang.reflect.Modifier.isStatic(method.getModifiers()));
            }
        }
    }
}
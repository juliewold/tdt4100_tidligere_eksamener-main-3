package com.shopstore.retail.part2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import no.ntnu.tdt4100.IProduct;
import no.ntnu.tdt4100.ProductDiscount;
import no.ntnu.tdt4100.ProductOrder;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.when;

public class ProductAnalyticsTest {

    private ProductAnalytics productAnalytics;

    @BeforeEach
    public void setUp() {
        productAnalytics = new ProductAnalytics();
    }

    @Test
    public void getNumberOfProductsByPredicate_predicate_test_method_invoked() {
        IProduct product = Mockito.mock(IProduct.class);
        Predicate<IProduct> predicate = Mockito.mock(Predicate.class);
        productAnalytics.getNumberOfProductsByPredicate(Collections.singletonList(product), predicate);
        Mockito.verify(predicate, atLeastOnce()).test(Mockito.any(IProduct.class));
    }

}
package com.shopstore.retail.part2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import no.ntnu.tdt4100.Customer;
import no.ntnu.tdt4100.IProduct;
import no.ntnu.tdt4100.ProductDiscount;
import no.ntnu.tdt4100.ProductOrder;

import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class ShoppingCartTest {

    private ShoppingCart cart;
    private Customer customer;
    private IProduct product;
    private ProductDiscount discount;

    @BeforeEach
    public void setUp() {
        customer = Mockito.mock(Customer.class);
        product = Mockito.mock(IProduct.class);
        discount = Mockito.mock(ProductDiscount.class);

        cart = new ShoppingCart(customer);
    }

    @Test
    void ShoppingCart_class_implements_interface() {
        Type[] ifaces = ShoppingCart.class.getGenericInterfaces();
        assertEquals(1, ifaces.length);
        assertEquals(ProductOrder.class.getName(), ifaces[0].getTypeName());
    }

    @Test
    void constructor_throws_IllegalArgumentException_with_null_customer() {
        assertThrows(IllegalArgumentException.class, () -> new ShoppingCart(null));
    }

    @Test
    public void addItem_throws_IllegalArgumentException_with_invalid_quanitity() {
        assertThrows(IllegalArgumentException.class, () -> cart.addItem(product, 0));
        assertThrows(IllegalArgumentException.class, () -> cart.addItem(product, -1));
    }

}

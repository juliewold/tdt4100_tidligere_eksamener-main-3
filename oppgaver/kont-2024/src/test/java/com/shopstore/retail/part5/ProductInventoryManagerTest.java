package com.shopstore.retail.part5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import no.ntnu.tdt4100.IProduct;
import no.ntnu.tdt4100.Product;
import no.ntnu.tdt4100.part5.ProductChange;
import no.ntnu.tdt4100.part5.ProductChangeListener;

import no.ntnu.tdt4100.part5.ProductInventory;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class ProductInventoryManagerTest {

    private ProductInventoryManager inventoryManager;
    private IProduct product1;
    private IProduct product2;
    private ProductChangeListener mockListener;

    @BeforeEach
    public void setUp() {
        product1 = new Product(1, "Product A", "Description A", 10.0, "Vendor A");
        product2 = new Product(2, "Product B", "Description B", 20.0, "Vendor B");
        mockListener = mock(ProductChangeListener.class);
        Map<IProduct, Integer> initialStock = new HashMap<>();
        initialStock.put(product1, 5);
        initialStock.put(product2, 0);
        inventoryManager = new ProductInventoryManager(initialStock);
        inventoryManager.addListener(mockListener);
    }

    @Test
    void ProductInventoryManager_class_implements_InventoryManager_interface() {
        Type[] ifaces = ProductInventoryManager.class.getGenericInterfaces();
        assertEquals(1, ifaces.length);
        assertEquals(ProductInventory.class.getName(), ifaces[0].getTypeName(),
                "ProductInventoryManager should implement the ProductInventory interface");
    }

    @Test
    void calling_constructor_with_negative_stock_level_in_productStock_should_throw_IllegalArgumentException() {
        Map<IProduct, Integer> initialStock = new HashMap<>();
        initialStock.put(product1, -5);
        assertThrows(IllegalArgumentException.class, () -> new ProductInventoryManager(initialStock),
                "IllegalArgumentException should be thrown if some stock level values in the productStock are negative.");
    }

    @Test
    public void increaseStock_new_stock_should_be_8_when_stock_is_increased_by_3() {
        inventoryManager.increaseStock(product1, 3);
        assertEquals(8, inventoryManager.getStock(product1));
    }

    @Test
    public void increaseStock_increasing_quantity_from_zero_should_notify_listeners() {
        inventoryManager.increaseStock(product2, 1);
        verify(mockListener, times(1)).productChanged(product2, ProductChange.NOW_AVAILABLE);
    }

    @Test
    public void increaseStock_increasing_quantity_from_non_zero_should_not_notify_listeners() {
        inventoryManager.increaseStock(product1, 3);
        verify(mockListener, never()).productChanged(product1, ProductChange.NOW_AVAILABLE);
    }

    @Test
    public void calling_increaseStock_with_invalid_quantity_throws_exception() {
        assertThrows(IllegalArgumentException.class, () -> inventoryManager.increaseStock(product1, 0));
        assertThrows(IllegalArgumentException.class, () -> inventoryManager.increaseStock(product1, -1));
    }

    @Test
    public void increaseStock_adding_new_product_sets_stock_and_notifies_listeners() {
        IProduct mockProduct3 = new Product(3, "Product C", "Description C", 30.0, "Vendor C");
        inventoryManager.increaseStock(mockProduct3, 3);
        assertEquals(3, inventoryManager.getStock(mockProduct3));
        verify(mockListener, times(1)).productChanged(mockProduct3, ProductChange.NOW_AVAILABLE);
    }

    @Test
    public void reduceStock_new_stock_should_be_2_when_reduced_by_3() {
        inventoryManager.reduceStock(product1, 3);
        assertEquals(2, inventoryManager.getStock(product1));
    }

    @Test
    public void reduceStock_reducing_quantity_to_zero_should_notify_listeners() {
        inventoryManager.reduceStock(product1, 5);
        verify(mockListener, times(1)).productChanged(product1, ProductChange.OUT_OF_STOCK);
    }

    @Test
    public void reduceStock_reducing_quantity_to_non_zero_should_not_notify_listeners() {
        inventoryManager.reduceStock(product1, 3);
        verify(mockListener, never()).productChanged(product1, ProductChange.OUT_OF_STOCK);
    }

    @Test
    public void calling_reduceStock_with_too_high_quantity_throws_IllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> inventoryManager.reduceStock(product1, 6));
    }

    @Test
    public void calling_reduceStock_with_too_low_quantity_throws_IllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> inventoryManager.reduceStock(product1, -1));
        assertThrows(IllegalArgumentException.class, () -> inventoryManager.reduceStock(product1, 0));
    }

    @Test
    public void calling_reduceStock_with_invalid_product_throws_IllegalArgumentException() {
        assertThrows(IllegalArgumentException.class,
                () -> inventoryManager.reduceStock(new Product(3, "Product C", "Description C", 30.0, "Vendor C"), 1));
    }

    @Test
    public void getStock_returns_correct_stock() {
        assertEquals(5, inventoryManager.getStock(product1));
    }

    @Test
    public void getStock_returns_0_for_product_not_in_inventory() {
        assertEquals(0, inventoryManager.getStock(new Product(3, "Product C", "Description C", 30.0, "Vendor C")));
    }

    @Test
    public void after_calling_removeListener_no_notifications_should_be_sent_to_the_listener() {
        inventoryManager.removeListener(mockListener);
        inventoryManager.reduceStock(product1, 5);
        inventoryManager.increaseStock(product1, 1);
        verify(mockListener, never()).productChanged(product1, ProductChange.OUT_OF_STOCK);
    }

    @Test
    public void addListener_listener_should_not_be_added_twice() {
        inventoryManager.addListener(mockListener); // Already added in setUp
        inventoryManager.reduceStock(product1, 5);
        verify(mockListener, times(1)).productChanged(product1, ProductChange.OUT_OF_STOCK);
    }

    @Test
    public void addListener_can_add_more_than_one_listener() {
        ProductChangeListener mockListener2 = mock(ProductChangeListener.class);
        inventoryManager.addListener(mockListener2);
        inventoryManager.reduceStock(product1, 5);
        verify(mockListener, times(1)).productChanged(product1, ProductChange.OUT_OF_STOCK);
        verify(mockListener2, times(1)).productChanged(product1, ProductChange.OUT_OF_STOCK);
    }
}
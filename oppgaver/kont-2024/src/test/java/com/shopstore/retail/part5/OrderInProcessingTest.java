package com.shopstore.retail.part5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import no.ntnu.tdt4100.Customer;
import no.ntnu.tdt4100.IProduct;
import no.ntnu.tdt4100.Product;
import no.ntnu.tdt4100.ProductOrder;
import no.ntnu.tdt4100.part5.ProductChange;
import no.ntnu.tdt4100.part5.ProductChangeListener;
import no.ntnu.tdt4100.part5.ProductInventory;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class OrderInProcessingTest {

    private ProductOrder mockProductOrder;
    private ProductInventory mockProductInventory;
    private OrderInProcessing orderInProcessing;
    private IProduct product;
    private Customer customer;

    @BeforeEach
    void setUp() {
        mockProductOrder = mock(ProductOrder.class);
        mockProductInventory = mock(ProductInventory.class);
        product = new Product(1, "Product A", "Description A", 10.0, "Vendor A");
        customer = new Customer(1, "John Doe", "foo", "bar");

        when(mockProductOrder.getCustomer()).thenReturn(customer);
        when(mockProductOrder.getItems()).thenReturn(Map.of(product, 10));
        when(mockProductOrder.getTotal()).thenReturn(100.0);
        when(mockProductInventory.getStock(product)).thenReturn(5);
        orderInProcessing = new OrderInProcessing(mockProductOrder, mockProductInventory);

    }

    @Test
    void OrderInProcessing_class_implements_ProductChangeListener_and_ProductOrder_interfaces() {
        Type[] ifaces = OrderInProcessing.class.getGenericInterfaces();
        List<String> interfaceNames = Arrays.stream(ifaces).map(i -> i.getTypeName()).toList();
        assertTrue(interfaceNames.contains(ProductChangeListener.class.getName()),
                "OrderInProcessing should implement the ProductChangeListener interface");
        assertTrue(interfaceNames.contains(ProductOrder.class.getName()),
                "OrderInProcessing should implement the ProductOrder interface");
    }

    @Test
    void before_calling_createInitialShipment_then_isCompleted_is_false() {
        when(mockProductInventory.getStock(product)).thenReturn(10);
        assertFalse(orderInProcessing.isCompleted(),
                "OrderInProcessing should not be completed before calling createInitialShipment");
    }

    @Test
    void after_calling_createInitialShipment_with_no_stock_then_isCompleted_is_false() {
        when(mockProductInventory.getStock(product)).thenReturn(0);
        orderInProcessing.createInitialShipment();
        assertFalse(orderInProcessing.isCompleted());
    }

    @Test
    void after_calling_createInitialShipment_with_no_stock_then_listener_is_added_to_ProduductInventory() {
        when(mockProductInventory.getStock(product)).thenReturn(0);
        orderInProcessing.createInitialShipment();
        verify(mockProductInventory, times(1)).addListener(orderInProcessing);
    }

    @Test
    void after_calling_createInitialShipment_with_no_stock_then_no_shipment_is_created() {
        when(mockProductInventory.getStock(product)).thenReturn(0);
        orderInProcessing.createInitialShipment();
        assertEquals(0, orderInProcessing.getShipments().size());
    }

    @Test
    void after_calling_createInitialShipment_with_partial_stock_then_isCompleted_is_false() {
        orderInProcessing.createInitialShipment();
        assertFalse(orderInProcessing.isCompleted());
    }

    @Test
    void after_calling_createInitialShipment_with_partial_stock_then_listener_is_added_to_ProduductInventory() {
        orderInProcessing.createInitialShipment();
        verify(mockProductInventory, times(1)).addListener(orderInProcessing);
    }

    @Test
    void after_calling_createInitialShipment_with_partial_stock_then_shipment_is_created() {
        orderInProcessing.createInitialShipment();
        assertEquals(1, orderInProcessing.getShipments().size());
        assertEquals(1, orderInProcessing.getShipments().get(0).productsContained().size());
        assertTrue(orderInProcessing.getShipments().get(0).productsContained().containsKey(product));
        assertEquals(5, orderInProcessing.getShipments().get(0).productsContained().get(product));
    }

    @Test
    void after_calling_createInitialShipment_with_sufficient_stock_then_isCompleted_is_true() {
        when(mockProductInventory.getStock(product)).thenReturn(10);
        orderInProcessing.createInitialShipment();
        assertTrue(orderInProcessing.isCompleted());
    }

    @Test
    void after_calling_createInitialShipment_with_sufficient_stock_then_listener_is_not_added_to_ProduductInventory() {
        when(mockProductInventory.getStock(product)).thenReturn(10);
        orderInProcessing.createInitialShipment();
        verify(mockProductInventory, never()).addListener(orderInProcessing);
    }

    @Test
    void after_calling_createInitialShipment_with_sufficient_stock_then_shipment_is_created() {
        when(mockProductInventory.getStock(product)).thenReturn(10);
        orderInProcessing.createInitialShipment();
        assertEquals(1, orderInProcessing.getShipments().size());
        assertEquals(1, orderInProcessing.getShipments().get(0).productsContained().size());
        assertTrue(orderInProcessing.getShipments().get(0).productsContained().containsKey(product));
        assertEquals(10, orderInProcessing.getShipments().get(0).productsContained().get(product));
    }

    @Test
    void methods_from_the_delegate_ProductOrder_added_in_the_constructor_should_be_called_when_calling_methods_from_this_interface() {
        reset(mockProductOrder);
        orderInProcessing.getCustomer();
        verify(mockProductOrder, times(1)).getCustomer();
        orderInProcessing.getItems();
        verify(mockProductOrder, times(1)).getItems();
        orderInProcessing.getTotal();
        verify(mockProductOrder, times(1)).getTotal();
    }

    // NOTE: The following tests rely on the correctness of the tests for
    // createInitialShipment. If those tests fail, these tests will also likely
    // fail.
    @Test
    void after_calling_productChanged_with_partial_stock_then_isCompleted_is_false() {
        when(mockProductInventory.getStock(product)).thenReturn(5);
        orderInProcessing.createInitialShipment();
        when(mockProductInventory.getStock(product)).thenReturn(4);
        orderInProcessing.productChanged(product, ProductChange.NOW_AVAILABLE);
        assertFalse(orderInProcessing.isCompleted());
    }

    @Test
    void after_calling_productChanged_with_partial_stock_then_shipment_is_created() {
        when(mockProductInventory.getStock(product)).thenReturn(5);
        orderInProcessing.createInitialShipment();
        when(mockProductInventory.getStock(product)).thenReturn(4);
        orderInProcessing.productChanged(product, ProductChange.NOW_AVAILABLE);
        assertEquals(2, orderInProcessing.getShipments().size());
        assertEquals(1, orderInProcessing.getShipments().get(1).productsContained().size());
        assertTrue(orderInProcessing.getShipments().get(1).productsContained().containsKey(product));
        assertEquals(4, orderInProcessing.getShipments().get(1).productsContained().get(product));
    }

    @Test
    void after_calling_productChanged_with_sufficient_stock_then_isCompleted_is_true() {
        when(mockProductInventory.getStock(product)).thenReturn(5);
        orderInProcessing.createInitialShipment();
        orderInProcessing.productChanged(product, ProductChange.NOW_AVAILABLE);
        assertTrue(orderInProcessing.isCompleted());
    }

    @Test
    void after_calling_productChanged_with_sufficient_stock_then_shipment_is_created() {
        when(mockProductInventory.getStock(product)).thenReturn(5);
        orderInProcessing.createInitialShipment();
        orderInProcessing.productChanged(product, ProductChange.NOW_AVAILABLE);
        assertEquals(2, orderInProcessing.getShipments().size());
        assertEquals(1, orderInProcessing.getShipments().get(1).productsContained().size());
        assertTrue(orderInProcessing.getShipments().get(1).productsContained().containsKey(product));
        assertEquals(5, orderInProcessing.getShipments().get(1).productsContained().get(product));
    }

    @Test
    void after_calling_productChanged_with_Product_not_in_order_it_does_nothing() {
        when(mockProductInventory.getStock(product)).thenReturn(5);
        orderInProcessing.createInitialShipment();
        IProduct wrongProduct = new Product(2, "Product B", "Description B", 20.0, "Vendor B");
        orderInProcessing.productChanged(wrongProduct, ProductChange.NOW_AVAILABLE);
        assertFalse(orderInProcessing.isCompleted());
    }

    @Test
    void calling_productChanged_after_everything_has_been_shipped_should_not_create_more_shipments() {
        when(mockProductInventory.getStock(product)).thenReturn(10);
        orderInProcessing.createInitialShipment();
        orderInProcessing.productChanged(product, ProductChange.NOW_AVAILABLE);
        assertEquals(1, orderInProcessing.getShipments().size());
    }

    @Test
    void calling_productChanged_with_wrong_ProductChange_does_nothing() {
        when(mockProductInventory.getStock(product)).thenReturn(5);
        orderInProcessing.createInitialShipment();
        orderInProcessing.productChanged(product, ProductChange.PRICE_CHANGED);
        assertFalse(orderInProcessing.isCompleted());
    }

    @Test
    void advanced_behavior_with_multiple_products() {
        // Helpful hint:
        // You may receive a ConcurrentModificationException if you are
        // iterating over the collection of unsipped products and modifying it (e.g.
        // removing products that were shipped) at the same time. You can avoid this by
        // creating a copy of the collection before iterating over it.
        IProduct product2 = new Product(2, "Product B", "Description B", 20.0, "Vendor B");
        IProduct product3 = new Product(3, "Product C", "Description C", 30.0, "Vendor C");
        ProductOrder mockProductOrder2 = mock(ProductOrder.class);
        when(mockProductOrder2.getItems()).thenReturn(Map.of(product, 10, product2, 5, product3, 15));
        when(mockProductInventory.getStock(product2)).thenReturn(5);
        when(mockProductInventory.getStock(product3)).thenReturn(0);
        orderInProcessing = new OrderInProcessing(mockProductOrder2, mockProductInventory);
        orderInProcessing.createInitialShipment();
        assertEquals(1, orderInProcessing.getShipments().size());
        assertEquals(2, orderInProcessing.getShipments().get(0).productsContained().size());
        assertTrue(orderInProcessing.getShipments().get(0).productsContained().containsKey(product));
        assertTrue(orderInProcessing.getShipments().get(0).productsContained().containsKey(product2));
        assertEquals(5, orderInProcessing.getShipments().get(0).productsContained().get(product));
        assertEquals(5, orderInProcessing.getShipments().get(0).productsContained().get(product2));
        when(mockProductInventory.getStock(product)).thenReturn(10);
        orderInProcessing.productChanged(product, ProductChange.NOW_AVAILABLE);
        assertEquals(2, orderInProcessing.getShipments().size());
        assertEquals(1, orderInProcessing.getShipments().get(1).productsContained().size());
        assertTrue(orderInProcessing.getShipments().get(1).productsContained().containsKey(product));
        assertEquals(5, orderInProcessing.getShipments().get(1).productsContained().get(product));
        when(mockProductInventory.getStock(product3)).thenReturn(3);

    }

}

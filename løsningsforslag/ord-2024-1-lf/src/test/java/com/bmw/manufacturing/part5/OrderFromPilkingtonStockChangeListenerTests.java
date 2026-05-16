package com.bmw.manufacturing.part5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.lang.reflect.Modifier;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import no.ntnu.tdt4100.CarPart;
import no.ntnu.tdt4100.part5.IPilkingtonService;
import no.ntnu.tdt4100.part5.IStockChangeListener;

public class OrderFromPilkingtonStockChangeListenerTests {
    IPilkingtonService pilkingtonService;
    OrderFromPilkingtonStockChangeListener listener;

    @BeforeEach
    void before() {
        pilkingtonService = mock(IPilkingtonService.class);
        listener = new OrderFromPilkingtonStockChangeListener(pilkingtonService);
    }

    @Test
    void OrderFromPilkingtonStockChangeListener_class_should_only_implement_IStatisticsListener_interface() {
        assertEquals(IStockChangeListener.class.getName(),
        OrderFromPilkingtonStockChangeListener.class.getGenericInterfaces()[0].getTypeName());
    }

    @Test
    void OrderFromPilkingtonStockChangeListener_class_should_have_1_declared_constructor() {
        assertEquals(1, OrderFromPilkingtonStockChangeListener.class.getDeclaredConstructors().length);
        assertEquals(1, OrderFromPilkingtonStockChangeListener.class.getDeclaredConstructors()[0].getParameterCount());
        assertFalse(Modifier.isPrivate(OrderFromPilkingtonStockChangeListener.class.getDeclaredConstructors()[0].getModifiers()));
    }

    @Test
    public void execute_should_not_sendOrder_when_carpart_is_null() {
        doNothing().when(pilkingtonService).sendOrder(null, 0);
        listener.execute(null, 9);
        assertEquals(0, listener.getOrderedCount(null));  
        verify(pilkingtonService, times(0)).sendOrder(null, 0);
    }

    @Test
    public void execute_should_not_sendOrder_when_availableQuantity_is_negative() {
        CarPart part = new CarPart("a", "window", 0);
        listener.execute(part, -1);
        assertEquals(0, listener.getOrderedCount(null));  
        verify(pilkingtonService, times(0)).sendOrder(part, 0);
    }

    @Test
    public void execute_should_sendOrder_when_availableQuantity_is_0() {
        CarPart p1 = new CarPart("a", "window", 0);
        doNothing().when(pilkingtonService).sendOrder(p1, 10);
        listener.execute(p1, 0);
        assertEquals(10, listener.getOrderedCount(p1));
        verify(pilkingtonService, times(1)).sendOrder(p1, 10);
    }

    @Test
    public void execute_should_not_sendOrder_when_availableQuantity_is_more_than_10() {
        CarPart p1 = new CarPart("a", "window", 0);
        doNothing().when(pilkingtonService).sendOrder(p1, 10);
        listener.execute(p1, 11);
        assertEquals(0, listener.getOrderedCount(p1));
        verify(pilkingtonService, times(0)).sendOrder(p1, 10);
    }

    @Test
    public void execute_should_not_sendOrder_when_partName_is_window_and_availableQuantity_is_negative() {
        CarPart p1 = new CarPart("a", "window", 0);
        listener.execute(p1, -1);
        assertEquals(0, listener.getOrderedCount(p1));
    }

    @Test
    public void execute_should_not_sendOrder_if_partName_does_not_contain_window() {
        CarPart part = new CarPart("a", "windoz", 0);
        listener.execute(part, 9);
        assertEquals(0, listener.getOrderedCount(part)); 
        verify(pilkingtonService, times(0)).sendOrder(part, 10); 
    }

    @Test
    public void execute_should_sendOrder_if_partName_contains_window() {
        CarPart part = new CarPart("a", "a fantastic WinDoWs test", 0);
        doNothing().when(pilkingtonService).sendOrder(part, 10);
        listener.execute(part, 9);
        assertEquals(10, listener.getOrderedCount(part)); 
        verify(pilkingtonService, times(1)).sendOrder(part, 10);  
    }

    @Test
    public void execute_should_sendOrder_2_times_when_ordering_same_part_2_times() {
        CarPart p1 = new CarPart("a", "window", 0);
        CarPart p2 = new CarPart("a", "window", 0);
        doNothing().when(pilkingtonService).sendOrder(p1, 10);
        doNothing().when(pilkingtonService).sendOrder(p2, 10);
        listener.execute(p1, 9);
        listener.execute(p2, 9);
        assertEquals(20, listener.getOrderedCount(p1));
        verify(pilkingtonService, times(2)).sendOrder(p1, 10);
    }

    @Test
    public void execute_should_sendOrder_2_times_different_parts_should_order_10_each() {
        CarPart p1 = new CarPart("a", "window1", 0);
        CarPart p2 = new CarPart("b", "window2", 0);
        doNothing().when(pilkingtonService).sendOrder(p1, 10);
        doNothing().when(pilkingtonService).sendOrder(p2, 10);
        listener.execute(p1, 9);
        listener.execute(p2, 9);
        assertEquals(10, listener.getOrderedCount(p1));
        assertEquals(10, listener.getOrderedCount(p2));
        verify(pilkingtonService, times(1)).sendOrder(p1, 10);
        verify(pilkingtonService, times(1)).sendOrder(p2, 10);
    }
}

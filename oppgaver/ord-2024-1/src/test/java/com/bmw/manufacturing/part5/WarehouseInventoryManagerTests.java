package com.bmw.manufacturing.part5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import no.ntnu.tdt4100.CarPart;
import no.ntnu.tdt4100.part5.IPilkingtonService;
import no.ntnu.tdt4100.part5.IStockChangeListener;
import no.ntnu.tdt4100.part5.InsufficientPartsException;
import no.ntnu.tdt4100.part5.InventoryManager;

@SuppressWarnings("unused")
public class WarehouseInventoryManagerTests {

   private InventoryManager manager;
   private IStockChangeListener listener1;
   private IStockChangeListener listener2;
   private CarPart carPart1;
   private CarPart carPart2;

   @BeforeEach
   void setup() {
      listener1 = mock();
      listener2 = mock();
      doNothing().when(listener1).execute(any(CarPart.class), anyInt());
      doNothing().when(listener2).execute(any(CarPart.class), anyInt());

      // TODO Uncomment line below and remove the assertFalse when the WarehouseInventoryManager implements its
      // interface
      // manager = new WarehouseInventoryManager();
      assertFalse(true);
      carPart1 = new CarPart("A", "window", 0);
      carPart2 = new CarPart("B", "window2", 0);
   }

   @Test
   void adding_multiple_listeners_of_same_type_should_not_increase_number_of_listeners() {
      manager.addListener(listener1);
      manager.addListener(listener1);
      assertEquals(1, manager.getNumberOfListeners());
   }

   @Test
   void when_adding_two_different_listeners_number_of_listeners_should_be_two() {
      manager.addListener(listener1);
      manager.addListener(listener2);
      assertEquals(2, manager.getNumberOfListeners());
   }

   @Test
   void when_removing_a_nonexistent_listener_number_of_listeners_should_be_zero() {
      manager.removeListener(listener1);
      assertEquals(0, manager.getNumberOfListeners());
   }

   @Test
   void when_removing_existing_listener_number_of_listeners_should_decrease() {
      manager.addListener(listener1);
      assertEquals(1, manager.getNumberOfListeners());
      manager.removeListener(listener1);
      assertEquals(0, manager.getNumberOfListeners());
   }

   @Test
   void when_removing_same_listener_2_times_number_should_not_change() {
      manager.addListener(listener1);
      manager.removeListener(listener1);
      assertEquals(0, manager.getNumberOfListeners());
      manager.removeListener(listener1);
      assertEquals(0, manager.getNumberOfListeners());
   }

   @Test
   void when_removing_listener_which_is_not_listening_number_of_listeners_should_not_change() {
      manager.addListener(listener1);
      assertEquals(1, manager.getNumberOfListeners());
      manager.removeListener(listener2);
      assertEquals(1, manager.getNumberOfListeners());
   }

   @Test
   void when_decreaseQuantity_is_called_attached_listeners_should_be_invoked() {
      manager.addListener(listener1);
      manager.addListener(listener2);
      manager.increaseQuantity(carPart1, 10);
      manager.decreaseQuantity(carPart1, 9);
      verify(listener1, times(1)).execute(any(CarPart.class), anyInt());
      verify(listener2, times(1)).execute(any(CarPart.class), anyInt());
   }

   @Test
   void when_decreaseQuantity_is_called_attached_listeners_should_be_invoked_2_times() {
      manager.addListener(listener1);
      manager.increaseQuantity(carPart1, 10);
      manager.decreaseQuantity(carPart1, 3);
      manager.decreaseQuantity(carPart1, 3);
      verify(listener1, times(2)).execute(any(CarPart.class), anyInt());
   }

   @Test
   void when_decreaseQuantity_is_called_shoud_throw_InsuficcientPartsException() {
      manager.increaseQuantity(carPart1, 10);
      assertThrows(InsufficientPartsException.class, () -> manager.decreaseQuantity(carPart1, 12));
   }

   @Test
   void getAvailableQuantity_should_return_the_available_quantity() {
      manager.increaseQuantity(carPart1, 100);
      assertEquals(100, manager.getAvailableQuantity(carPart1));
      manager.decreaseQuantity(carPart1, 10);
      assertEquals(90, manager.getAvailableQuantity(carPart1));
   }

   @Test
   void getNumberOfListeners_should_return_correct_number_of_listeners() {
      manager.addListener(listener1);
      manager.addListener(listener2);
      int number = manager.getNumberOfListeners();
      assertEquals(2, number);
   }

   @Test
   void increaseQuantity_after_invoked_should_increase_available_quantity() {
      manager.increaseQuantity(carPart1, 15);
      int number = manager.getAvailableQuantity(carPart1);
      assertEquals(15, number);
   }

   @Test
   void increaseQuantity_after_invoked_with_negative_should_do_nothing_to_available_quantity() {
      manager.increaseQuantity(carPart1, 15);
      manager.increaseQuantity(carPart1, -3);
      int number = manager.getAvailableQuantity(carPart1);
      assertEquals(15, number);
   }

   @Test
   void increaseQuantity_should_only_increase_quantity_for_specific_car_part() {
      manager.increaseQuantity(carPart1, 15);
      manager.increaseQuantity(carPart2, 10);
      int numberFirstPart = manager.getAvailableQuantity(carPart1);
      int numberSecondPart = manager.getAvailableQuantity(carPart2);
      assertEquals(15, numberFirstPart);
      assertEquals(10, numberSecondPart);
   }
}

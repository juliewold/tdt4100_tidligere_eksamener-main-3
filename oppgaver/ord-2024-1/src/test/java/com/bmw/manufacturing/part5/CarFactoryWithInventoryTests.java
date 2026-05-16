package com.bmw.manufacturing.part5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import no.ntnu.tdt4100.CarPart;
import no.ntnu.tdt4100.ICarFactory;
import no.ntnu.tdt4100.IHasInventoryManager;
import no.ntnu.tdt4100.part5.AlreadyProducedException;
import no.ntnu.tdt4100.part5.CarUnit;
import no.ntnu.tdt4100.part5.IStockChangeListener;
import no.ntnu.tdt4100.part5.InsufficientPartsException;
import no.ntnu.tdt4100.part5.InventoryManager;

@SuppressWarnings("unused")
class CarFactoryWithInventoryTests {

    InventoryManager inventoryManager;
    CarFactoryWithInventory carFactoryWithInventory;
    ICarFactory delegate;
    CarPart part1;
    CarPart part2;

    @BeforeEach
    void before() {
        delegate = mock();
        inventoryManager = mock();

        part1 = new CarPart("ABC", "ABC", 10);
        part2 = new CarPart("DEF", "DEF", 10);

        carFactoryWithInventory = new CarFactoryWithInventory(delegate, inventoryManager);
    }

    @Test
    void isCarWithVinProduced_should_return_false_when_car_with_VIN_is_not_produced() {
        assertFalse(carFactoryWithInventory.isCarWithVinProduced(null));
    }

    @Test
    void isCarWithVinProduced_should_return_true_when_car_with_VIN_is_produced() {
        CarUnit unit1 = new CarUnit(Map.of(part1, 1), "X5", "WBA41EU0XR9T25170");

        when(inventoryManager.getAvailableQuantity(part1)).thenReturn(1);

        carFactoryWithInventory.produceUnit(unit1); // succeeds because there are enough available parts

        assertTrue(carFactoryWithInventory.isCarWithVinProduced(unit1.vin()), "Car is already produced");
    }

    @Test
    void produceUnit_should_throw_exception_if_car_with_vin_is_already_produced() {

        CarUnit unit = new CarUnit(Map.of(part1, 1), "X5", "WBA41EU0XR9T25170");
        when(inventoryManager.getAvailableQuantity(part1)).thenReturn(2);

        carFactoryWithInventory.produceUnit(unit); // production succeeds

        when(inventoryManager.getAvailableQuantity(part1)).thenReturn(0);
        assertThrows(AlreadyProducedException.class, () -> carFactoryWithInventory.produceUnit(unit));
    }

    @Test
    void produceUnit_should_throw_exception_if_inventory_doesnt_have_enough_parts() {

        CarPart part1 = new CarPart("ABC", "ABC", 10);
        Map<CarPart, Integer> parts = Map.of(part1, 1);
        CarUnit unit = new CarUnit(parts, "X5", "WBA41EU0XR9T25170");

        assertThrows(InsufficientPartsException.class, () -> carFactoryWithInventory.produceUnit(unit));
    }

    @Test
    void produceUnit_should_decrease_quantity_of_parts_in_inventory_after_producing_a_car() {

        CarPart part1 = new CarPart("ABC", "ABC", 10);
        Map<CarPart, Integer> parts = Map.of(part1, 1);
        CarUnit unit = new CarUnit(parts, "X5", "WBA41EU0XR9T25170");

        when(inventoryManager.getAvailableQuantity(part1)).thenReturn(2);
        
        carFactoryWithInventory.produceUnit(unit);
        verify(inventoryManager, times(1)).getAvailableQuantity(part1);
        verify(inventoryManager, times(1)).decreaseQuantity(part1, 1);
    }

    @Test
    public void produceUnit_should_throw_exception_if_inventory_doesnt_have_enough_parts_after_producing_car() {

        CarPart part1 = new CarPart("ABC", "ABC", 10);
        CarPart part2 = new CarPart("DEF", "DEF", 10);

        Map<CarPart, Integer> parts = Map.of(part1, 2, part2, 2);
        CarUnit unit1 = new CarUnit(parts, "X5", "WBA41EU0XR9T25170");
        CarUnit unit2 = new CarUnit(parts, "X5", "WBA41EU0XR9T25171");

        when(inventoryManager.getAvailableQuantity(part1)).thenReturn(2);
        when(inventoryManager.getAvailableQuantity(part2)).thenReturn(2);
        carFactoryWithInventory.produceUnit(unit1); // succeeds with first car because there are enough available parts

        when(inventoryManager.getAvailableQuantity(part2)).thenReturn(1);
        assertThrows(InsufficientPartsException.class, () -> carFactoryWithInventory.produceUnit(unit2), 
        "Should throw InsufficientPartsException because after producing first car, the inventory quantity of the parts" + 
        "that went into producing the CarUnit should be decreased so that production of 2nd car doesnt have enough parts");
    }

    @Test
    void processShipment_should_not_increase_quantity_in_inventory_if_a_negative_number() {
        carFactoryWithInventory.processShipment(part1, -1);
        verify(inventoryManager, times(0)).increaseQuantity(any(CarPart.class), anyInt());
    }

    @Test
    void processShipment_should_increase_quantity_if_a_negative_number() {
        doNothing().when(inventoryManager).increaseQuantity(part1, 1);
        carFactoryWithInventory.processShipment(part1, 1);
        verify(inventoryManager, times(1)).increaseQuantity(part1, 1);
    }


    @Test
    void hasInventoryManager() {
        assertNotNull(carFactoryWithInventory.getInventoryManager());
        assertEquals(inventoryManager, carFactoryWithInventory.getInventoryManager());
    }

    @Test
    void methods_from_the_delegate_ICarFactory_added_in_the_constructor_should_be_called_when_calling_some_methods() {
        String EXPECTED_ISO_COUNTRY_CODE = "ABC";
        int EXPECTED_NUMBER_OF_EMPLOYEES = 20;
        List<CarPart> EXPECTED_LIST_OF_PARTS = List.of(new CarPart("a", "b", 20));
     
    // setup what the delegate should return when called
        when(delegate.getIsoCountryCode()).thenReturn(EXPECTED_ISO_COUNTRY_CODE);
        when(delegate.getNumberOfEmployees()).thenReturn(EXPECTED_NUMBER_OF_EMPLOYEES);
        when(delegate.getParts()).thenReturn(EXPECTED_LIST_OF_PARTS);
    
    // call CarFactoryWithInventory and verify that it calls the delegate and returns values from the delegate
        assertEquals(EXPECTED_ISO_COUNTRY_CODE, carFactoryWithInventory.getIsoCountryCode());
        assertEquals(EXPECTED_NUMBER_OF_EMPLOYEES, carFactoryWithInventory.getNumberOfEmployees());
        assertEquals(EXPECTED_LIST_OF_PARTS.get(0).partId(), carFactoryWithInventory.getParts().get(0).partId());
        verify(delegate, times(1)).getIsoCountryCode();
        verify(delegate, times(1)).getNumberOfEmployees();
        verify(delegate, times(1)).getParts();
    }

    @Test
    void getNumberOfUnitsProduced_should_return_1_when_1_car_is_produced() {
        CarUnit unit1 = new CarUnit(Map.of(part1, 1), "X5", "WBA41EU0XR9T25170");

        when(inventoryManager.getAvailableQuantity(part1)).thenReturn(1);

        carFactoryWithInventory.produceUnit(unit1); // succeeds because there are enough available parts

        assertEquals(1, carFactoryWithInventory.getNumberOfUnitsProduced());
    }
}

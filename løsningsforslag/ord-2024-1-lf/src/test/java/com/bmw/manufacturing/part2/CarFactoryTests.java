package com.bmw.manufacturing.part2;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import no.ntnu.tdt4100.CarPart;

@SuppressWarnings("unused")
class CarFactoryTests {

    @Test
    public void should_be_able_to_instantiate_class_with_constructor() {
        // Uncomment test and remove the assertFalse to run the test
        assertFalse(true);
        // CarFactory factory = new CarFactory("abc", new ArrayList<CarPart>(), 10);
        // assertNotNull(factory);
    }

    @Test
    public void constructor_should_throw_exception_when_less_than_10_employees() {
         // Uncomment test and remove the assertFalse to run the test
         assertFalse(true);
        // assertThrows(IllegalArgumentException.class, () -> new CarFactory("abc", new ArrayList<CarPart>(), 9));
    }

    @Test
    public void constructor_should_throw_exception_when_less_than_3_characters() {
        // Uncomment test and remove the assertFalse to run the test
        assertFalse(true);
        // assertThrows(IllegalArgumentException.class, () -> new CarFactory("ab", new ArrayList<CarPart>(), 10));
    }
}

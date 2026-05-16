/**
 * THIS IS SUPPLIED CODE - DO NOT MODIFY THE CODE BELOW
 */

package com.bytebadger.assembly.part3;

import no.ntnu.tdt4100.bytebadger.Customer;
import no.ntnu.tdt4100.bytebadger.IComputerPart;
import no.ntnu.tdt4100.bytebadger.ICustomBuild;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.lang.reflect.Type;

import static org.junit.jupiter.api.Assertions.*;


public class CustomComputerTest {

    private CustomComputer build;
    private Customer customer;
    private IComputerPart part, part2;

    @BeforeEach
    public void setUp() {
        customer = Mockito.mock(Customer.class);
        part = Mockito.mock(IComputerPart.class);
        part2 = Mockito.mock(IComputerPart.class);

        build = new CustomComputer(customer);
    }

    /**
     * Checks if the class definition implements the interface
     */
    @Test
    void CustomComputer_class_implements_interface() {
        Type[] ifaces = CustomComputer.class.getGenericInterfaces();
        assertEquals(1, ifaces.length);
        assertEquals(ICustomBuild.class.getName(), ifaces[0].getTypeName());
    }

    /**
     * Checks if empty customer in the constructor results in IllegalArgumentException
     */
    @Test
    void constructor_throws_IllegalArgumentException_with_null_customer() {
        assertThrows(IllegalArgumentException.class, () -> new CustomComputer(null));
    }

    /**
     * Checks method addPart if quantity below 1 results in IllegalArgumentException
     */
    @Test
    public void addPart_throws_IllegalArgumentException_with_invalid_quanitity() {
        assertThrows(IllegalArgumentException.class, () -> build.addPart(part, 0));
        assertThrows(IllegalArgumentException.class, () -> build.addPart(part, -1));
    }

    /**
     * Checks method addPart if the list of parts reflects the update
     */
    @Test
    public void addPart_updates_parts() {
        build.addPart(part,5);
        assertEquals(5,build.getParts().get(part));
    }

    /**
     * Checks method removePart if quantity below 1 or the part does not exist
     * results in IllegalArgumentException.
     */
    @Test
    public void removePart_throws_IllegalArgumentException_with_invalid_quanitity() {
        build.addPart(part,5);
        assertThrows(IllegalArgumentException.class, () -> build.removePart(part2, 1));
        assertThrows(IllegalArgumentException.class, () -> build.removePart(part, 0));
        assertThrows(IllegalArgumentException.class, () -> build.removePart(part, -1));
    }

    /**
     * Checks method removePart if the list of parts reflects the update.
     */
    @Test
    public void removePart_updates_parts() {
        build.addPart(part,5);
        build.removePart(part, 3);
        assertEquals(2,build.getParts().get(part));
    }

    // METHODS FROM INTERFACE BELOW

    /**
     * Check method getCustomer returns customer
     */
    @Test
    public void getCustomer_returns_Customer() {
        assertEquals(customer,build.getCustomer());
    }

    /**
     * Check method getTotalPrice returns total price
     */
    @Test
    public void getTotalPrice_returns_totalprice() {

        build.addPart(part,2);
        build.addPart(part2,4);

        assertEquals(part.getPrice()+part2.getPrice(), build.getTotalPrice());
    }

    /**
     * Check method getParts returns parts
     */
    @Test
    public void getParts_returns_parts() {

        build.addPart(part,2);
        build.addPart(part2,4);
        
        assertEquals(2,build.getParts().get(part));
        assertNotEquals(2,build.getParts().get(part2));
    }

}

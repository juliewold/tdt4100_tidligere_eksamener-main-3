/**
 * THIS IS SUPPLIED CODE - DO NOT MODIFY THE CODE BELOW
 */

package com.twowheels.assembly.part3;

import no.ntnu.tdt4100.twowheels.Customer;
import no.ntnu.tdt4100.twowheels.IBikeComponent;
import no.ntnu.tdt4100.twowheels.ICustomBuild;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.lang.reflect.Type;

import static org.junit.jupiter.api.Assertions.*;


public class CustomBikeTest {

    private CustomBike build;
    private Customer customer;
    private IBikeComponent component, component2;

    @BeforeEach
    public void setUp() {
        customer = Mockito.mock(Customer.class);
        component = Mockito.mock(IBikeComponent.class);
        component2 = Mockito.mock(IBikeComponent.class);

        build = new CustomBike(customer);
    }

    /**
     * Checks if the class definition implements the interface
     */
    @Test
    void CustomBike_class_implements_interface() {
        Type[] ifaces = CustomBike.class.getGenericInterfaces();
        assertEquals(1, ifaces.length);
        assertEquals(ICustomBuild.class.getName(), ifaces[0].getTypeName());
    }

    /**
     * Checks if empty customer in the constructor results in IllegalArgumentException
     */
    @Test
    void constructor_throws_IllegalArgumentException_with_null_customer() {
        assertThrows(IllegalArgumentException.class, () -> new CustomBike(null));
    }

    /**
     * Checks method addComponent if quantity below 1 results in IllegalArgumentException
     */
    @Test
    public void addComponent_throws_IllegalArgumentException_with_invalid_quanitity() {
        assertThrows(IllegalArgumentException.class, () -> build.addComponent(component, 0));
        assertThrows(IllegalArgumentException.class, () -> build.addComponent(component, -1));
    }

    /**
     * Checks method addComponent if the list of parts reflects the update
     */
    @Test
    public void addComponent_updates_parts() {
        build.addComponent(component,5);
        assertEquals(5,build.getComponents().get(component));
    }

    /**
     * Checks method removeComponent if quantity below 1 or the part does not exist
     * results in IllegalArgumentException.
     */
    @Test
    public void removeComponent_throws_IllegalArgumentException_with_invalid_quanitity() {
        build.addComponent(component,5);
        assertThrows(IllegalArgumentException.class, () -> build.removeComponent(component2, 1));
        assertThrows(IllegalArgumentException.class, () -> build.removeComponent(component, 0));
        assertThrows(IllegalArgumentException.class, () -> build.removeComponent(component, -1));
    }

    /**
     * Checks method removeComponent if the list of parts reflects the update.
     */
    @Test
    public void removeComponent_updates_parts() {
        build.addComponent(component,5);
        build.removeComponent(component, 3);
        assertEquals(2,build.getComponents().get(component));
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

        build.addComponent(component,2);
        build.addComponent(component2,4);

        assertEquals(component.getPrice()+component2.getPrice(), build.getTotalPrice());
    }

    /**
     * Check method getComponents returns components
     */
    @Test
    public void getComponents_returns_components() {

        build.addComponent(component,2);
        build.addComponent(component2,4);
        
        assertEquals(2,build.getComponents().get(component));
        assertNotEquals(2,build.getComponents().get(component2));
    }

}

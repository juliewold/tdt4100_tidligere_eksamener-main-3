package com.bmw.manufacturing.part2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import no.ntnu.tdt4100.CarPart;
import no.ntnu.tdt4100.ICarFactory;
import no.ntnu.tdt4100.part2.IMainOffice;

@SuppressWarnings("unused")
public class MainOfficeTests {
    
    ICarFactory factory1;
    ICarFactory factory2;
    ICarFactory factory3;
    List<ICarFactory> factories;

    @BeforeEach
    void setup() {

        factory1 = mock();
        factory2 = mock();
        factory3 = mock();

        when(factory1.getIsoCountryCode()).thenReturn("ZZZ");
        when(factory1.getNumberOfEmployees()).thenReturn(10);
        when(factory1.getParts()).thenReturn(List.of(part("a","aa"), part("b", "bb"), part("c","cc")));
        
        when(factory2.getIsoCountryCode()).thenReturn("MMM");
        when(factory2.getNumberOfEmployees()).thenReturn(222);
        when(factory2.getParts()).thenReturn(List.of(part("d","dd"), part("e","ee")));

        when(factory3.getIsoCountryCode()).thenReturn("AAA");
        when(factory3.getNumberOfEmployees()).thenReturn(222);
        when(factory3.getParts()).thenReturn(List.of(part("f","ff"), part("g","gg"), part("h","hh")));

        // Use the below list to test the other implemented methods in MainOffice
        factories = List.of(factory1, factory2, factory3);
    }

    private CarPart part(String partId, String partName) {
        return new CarPart(partId, partName, 1);
    }



    @Test
    void MainOffice_implements_the_IMainOffice_interface() {
        Type[] ifaces = MainOffice.class.getGenericInterfaces();
        assertEquals(1, ifaces.length);
        assertEquals(IMainOffice.class.getName(), ifaces[0].getTypeName());
    }

    @Test
    void calculateTotalEstimatedRevenue_calculates_correct_result() {
        
        ICarFactory factoryMock1 = mock();
        when(factoryMock1.getNumberOfUnitsProduced(2024)).thenReturn(88342);
        ICarFactory factoryMock2 = mock();
        when(factoryMock2.getNumberOfUnitsProduced(2024)).thenReturn(32423);
        ICarFactory factoryMock3 = mock();
        when(factoryMock3.getNumberOfUnitsProduced(2023)).thenReturn(32423);
        
        MainOffice office = new MainOffice();

        // After implementing the interface in MainOffice, uncomment this test and remove the assertFalse to run it
        assertFalse(true);
        // long revenue = office.calculateTotalEstimatedRevenue(List.of(factoryMock1, factoryMock2, factoryMock3), 2024);
        // verify(factoryMock1, times(1)).getNumberOfUnitsProduced(2024);
        // verify(factoryMock2, times(1)).getNumberOfUnitsProduced(2024);
        // verify(factoryMock3, times(1)).getNumberOfUnitsProduced(2024);
        // assertEquals(28274347000L, revenue);
    }

}

package com.twowheels.assembly.part5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import no.ntnu.tdt4100.twowheels.*;
import com.twowheels.assembly.part3.CustomBike;

@SuppressWarnings("static-access")
public class DataWriterTest {

    private CustomBike mockBuild;
    private Customer customer;

    @BeforeEach
    public void setUp() {

        customer = Mockito.mock(Customer.class);
        when(customer.name()).thenReturn("Ola Nordmann");
        when(customer.phone()).thenReturn(91234567);

        CustomBike build = mock(CustomBike.class);
        when(build.getCustomer()).thenReturn(customer);

        BikeComponent part1 = mock(BikeComponent.class);
        when(part1.getComponentName()).thenReturn("Continental Grand Prix 5000 Tire");
        when(part1.getManufacturer()).thenReturn("Continental");
        when(part1.getPrice()).thenReturn(600d);

        BikeComponent part2 = mock(BikeComponent.class);
        when(part2.getComponentName()).thenReturn("Trek Domane AL 2 Frame");
        when(part2.getManufacturer()).thenReturn("Trek");
        when(part2.getPrice()).thenReturn(7000d);

        BikeComponent part3 = mock(BikeComponent.class);
        when(part3.getComponentName()).thenReturn("Shimano B01S Brake Pads");
        when(part3.getManufacturer()).thenReturn("Shimano");
        when(part3.getPrice()).thenReturn(300d);
        
        Map<IBikeComponent, Integer> parts = new LinkedHashMap<>();
        parts.put(part1, 2);
        parts.put(part2, 1);
        parts.put(part3, 4);

        when(build.getComponents()).thenReturn(parts);
        when(build.getTotalPrice()).thenReturn(9400d);

        mockBuild = build;

    } 
    
    public void write_should_have_throws_IOException_declared() {
        Type[] exceptions = WriteBikeToFile.class.getMethods()[0].getGenericExceptionTypes();
        if (exceptions.length == 1) {
            assertEquals(IOException.class, exceptions[0]);
            return;
        } else {
            throw new AssertionError("Method read has more than one exception declared");
        }
    }

    @Test
    public void write_should_call_OutputStream_flush_once() throws IOException {
        OutputStream mockStream = mock();
        new WriteBikeToFile().write(mockBuild, mockStream);
        verify(mockStream, times(1)).flush();
    }

    @Test
    public void write_should_call_OutputStream_flush_after_write() throws IOException {
        OutputStream mockStream = mock();
        InOrder orderVerifier = Mockito.inOrder(mockStream);
        new WriteBikeToFile().write(mockBuild, mockStream);
        orderVerifier.verify(mockStream).write(any());
        orderVerifier.verify(mockStream).flush();
    }

    @Test
    public void write_should_throw_IOException_when_OutputStream_throws() throws IOException {
        OutputStream mockStream = mock();
        doThrow(IOException.class).when(mockStream).write(anyInt());
        doThrow(IOException.class).when(mockStream).write(any());

        assertThrows(IOException.class, () -> new WriteBikeToFile().write(mockBuild, mockStream));
    }
 
    @Test
    public void write_should_produce_correct_results_for_first_line() throws IOException {
        String expectedString = "Ola Nordmann;91234567";

        FakeOutputStream fakeStream = new FakeOutputStream();
        new WriteBikeToFile().write(mockBuild, fakeStream);
        List<String[]> lines = Arrays.stream(fakeStream.getWrittenString().split("\n")).map(s -> s.split(";")).toList();
        assertEquals(expectedString, lines.get(0)[0] + ";" + lines.get(0)[1]);
    }

    @Test
    public void write_should_produce_correct_results_line_by_line() throws IOException {
        FakeOutputStream fakeStream = new FakeOutputStream();
        new WriteBikeToFile().write(mockBuild, fakeStream);
        List<String> list = Arrays.stream(fakeStream.getWrittenString().split("\n"))
                .toList();

        for (String s : list) {
            System.err.println(s);
        }
        assertEquals("Ola Nordmann;91234567", list.get(0));
        assertEquals("", list.get(1));
        assertEquals("2;Continental Grand Prix 5000 Tire;Continental;600.0", list.get(2));
        assertEquals("1;Trek Domane AL 2 Frame;Trek;7000.0", list.get(3));
        assertEquals("4;Shimano B01S Brake Pads;Shimano;300.0", list.get(4));
        assertEquals("", list.get(5));
        assertEquals("9400.0", list.get(6));

        try {
            assertEquals("", list.get(7));
        } catch (IndexOutOfBoundsException e) {
            // Do nothing
            // Both empty newline and no newline at end of file are accepted
        }
    }

}

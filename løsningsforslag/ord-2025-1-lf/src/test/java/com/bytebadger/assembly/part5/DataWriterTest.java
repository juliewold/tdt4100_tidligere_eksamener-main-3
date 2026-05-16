package com.bytebadger.assembly.part5;

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

import no.ntnu.tdt4100.bytebadger.*;
import com.bytebadger.assembly.part3.CustomComputer;

@SuppressWarnings("static-access")
public class DataWriterTest {

    private CustomComputer mockBuild;
    private Customer customer;

    @BeforeEach
    public void setUp() {

        customer = Mockito.mock(Customer.class);
        when(customer.name()).thenReturn("Ola Nordmann");
        when(customer.email()).thenReturn("ola@nordmann.no");

        CustomComputer build = mock(CustomComputer.class);
        when(build.getCustomer()).thenReturn(customer);

        ComputerPart part1 = mock(ComputerPart.class);
        when(part1.getProductName()).thenReturn("Fury Beast RGB DDR5 5600 MHz 16GB");
        when(part1.getManufacturer()).thenReturn("Kingston");
        when(part1.getPrice()).thenReturn(789d);

        ComputerPart part2 = mock(ComputerPart.class);
        when(part2.getProductName()).thenReturn("B650 Gaming Plus WIFI Hovedkort");
        when(part2.getManufacturer()).thenReturn("MSI");
        when(part2.getPrice()).thenReturn(2190d);

        ComputerPart part3 = mock(ComputerPart.class);
        when(part3.getProductName()).thenReturn("Blue Desktop 4TB");
        when(part3.getManufacturer()).thenReturn("WD");
        when(part3.getPrice()).thenReturn(1689d);
        
        Map<IComputerPart, Integer> parts = new LinkedHashMap<>();
        parts.put(part1, 3);
        parts.put(part2, 1);
        parts.put(part3, 2);

        when(build.getParts()).thenReturn(parts);
        when(build.getTotalPrice()).thenReturn(7935d);

        mockBuild = build;

    } 
    
    public void write_should_have_throws_IOException_declared() {
        Type[] exceptions = WriteBuildToFile.class.getMethods()[0].getGenericExceptionTypes();
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
        new WriteBuildToFile().write(mockBuild, mockStream);
        verify(mockStream, times(1)).flush();
    }

    @Test
    public void write_should_call_OutputStream_flush_after_write() throws IOException {
        OutputStream mockStream = mock();
        InOrder orderVerifier = Mockito.inOrder(mockStream);
        new WriteBuildToFile().write(mockBuild, mockStream);
        orderVerifier.verify(mockStream).write(any());
        orderVerifier.verify(mockStream).flush();
    }

    @Test
    public void write_should_throw_IOException_when_OutputStream_throws() throws IOException {
        OutputStream mockStream = mock();
        doThrow(IOException.class).when(mockStream).write(anyInt());
        doThrow(IOException.class).when(mockStream).write(any());

        assertThrows(IOException.class, () -> new WriteBuildToFile().write(mockBuild, mockStream));
    }
 
    @Test
    public void write_should_produce_correct_results_for_first_line() throws IOException {
        String expectedString = "Ola Nordmann;ola@nordmann.no";

        FakeOutputStream fakeStream = new FakeOutputStream();
        new WriteBuildToFile().write(mockBuild, fakeStream);
        List<String[]> lines = Arrays.stream(fakeStream.getWrittenString().split("\n")).map(s -> s.split(";")).toList();
        assertEquals(expectedString, lines.get(0)[0] + ";" + lines.get(0)[1]);
    }

    @Test
    public void write_should_produce_correct_results_line_by_line() throws IOException {
        FakeOutputStream fakeStream = new FakeOutputStream();
        new WriteBuildToFile().write(mockBuild, fakeStream);
        List<String> list = Arrays.stream(fakeStream.getWrittenString().split("\n"))
                .toList();

        for (String s : list) {
            System.err.println(s);
        }
        assertEquals("Ola Nordmann;ola@nordmann.no", list.get(0));
        assertEquals("", list.get(1));
        assertEquals("3;Fury Beast RGB DDR5 5600 MHz 16GB;Kingston;789.0", list.get(2));
        assertEquals("1;B650 Gaming Plus WIFI Hovedkort;MSI;2190.0", list.get(3));
        assertEquals("2;Blue Desktop 4TB;WD;1689.0", list.get(4));
        assertEquals("", list.get(5));
        assertEquals("7935.0", list.get(6));

        try {
            assertEquals("", list.get(7));
        } catch (IndexOutOfBoundsException e) {
            // Do nothing
            // Both empty newline and no newline at end of file are accepted
        }
    }

}

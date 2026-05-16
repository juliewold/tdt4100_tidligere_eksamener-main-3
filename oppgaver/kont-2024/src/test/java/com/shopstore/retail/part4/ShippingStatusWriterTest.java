package com.shopstore.retail.part4;

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
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import no.ntnu.tdt4100.IProduct;
import no.ntnu.tdt4100.Shipment;
import no.ntnu.tdt4100.ShipmentUpdate;

@SuppressWarnings("static-access")
public class ShippingStatusWriterTest {

    private Shipment mockShipment;

    @BeforeEach
    public void setUp() {
        Shipment shipment = mock(Shipment.class);
        when(shipment.id()).thenReturn(1);
        when(shipment.createdDateTime()).thenReturn(LocalDateTime.of(2022, 9, 1, 12, 0));

        ShipmentUpdate update1 = new ShipmentUpdate("Products ordered", LocalDateTime.of(2022, 9, 1, 12, 1));
        ShipmentUpdate update2 = new ShipmentUpdate("Products packed", LocalDateTime.of(2022, 9, 2, 9, 0));
        ShipmentUpdate update3 = new ShipmentUpdate("Products sent", LocalDateTime.of(2022, 9, 2, 10, 30));
        when(shipment.updates()).thenReturn(Arrays.asList(update1, update2, update3));

        IProduct product1 = mock(IProduct.class);
        when(product1.getName()).thenReturn("Basic Pen");
        IProduct product2 = mock(IProduct.class);
        when(product2.getName()).thenReturn("4K TV");
        IProduct product3 = mock(IProduct.class);
        when(product3.getName()).thenReturn("External Hard Drive");
        Map<IProduct, Integer> products = new LinkedHashMap<>();
        products.put(product1, 10);
        products.put(product2, 2);
        products.put(product3, 1);
        when(shipment.productsContained()).thenReturn(products);
        mockShipment = shipment;
    }

    @Test
    public void write_should_have_throws_IOException_declared() {
        Type[] exceptions = ShippingStatusWriter.class.getMethods()[0].getGenericExceptionTypes();
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
        new ShippingStatusWriter().write(mockShipment, mockStream);
        verify(mockStream, times(1)).flush();
    }

    @Test
    public void write_should_call_OutputStream_flush_after_write() throws IOException {
        OutputStream mockStream = mock();
        InOrder orderVerifier = Mockito.inOrder(mockStream);
        new ShippingStatusWriter().write(mockShipment, mockStream);
        orderVerifier.verify(mockStream).write(any());
        orderVerifier.verify(mockStream).flush();
    }

    @Test
    public void write_should_throw_IOException_when_OutputStream_throws() throws IOException {
        OutputStream mockStream = mock();
        doThrow(IOException.class).when(mockStream).write(anyInt());
        doThrow(IOException.class).when(mockStream).write(any());

        assertThrows(IOException.class, () -> new ShippingStatusWriter().write(mockShipment, mockStream));
    }

    @Test
    public void write_should_produce_correct_results_for_first_line() throws IOException {
        String expectedString = "2022-09-01T12:00";

        FakeOutputStream fakeStream = new FakeOutputStream();
        new ShippingStatusWriter().write(mockShipment, fakeStream);
        List<String[]> lines = Arrays.stream(fakeStream.getWrittenString().split("\n")).map(s -> s.split(";")).toList();
        assertEquals(expectedString, lines.get(0)[1]);
    }

    @Test
    public void write_should_produce_correct_results_line_by_line() throws IOException {
        FakeOutputStream fakeStream = new FakeOutputStream();
        new ShippingStatusWriter().write(mockShipment, fakeStream);
        List<String> list = Arrays.stream(fakeStream.getWrittenString().split("\n"))
                .toList();

        for (String s : list) {
            System.err.println(s);
        }
        assertEquals("1;2022-09-01T12:00", list.get(0));
        assertEquals("", list.get(1));
        assertEquals("Products ordered;2022-09-01T12:01", list.get(2));
        assertEquals("Products packed;2022-09-02T09:00", list.get(3));
        assertEquals("Products sent;2022-09-02T10:30", list.get(4));
        assertEquals("", list.get(5));
        assertEquals("Basic Pen;10", list.get(6));
        assertEquals("4K TV;2", list.get(7));
        assertEquals("External Hard Drive;1", list.get(8));
        try {
            assertEquals("", list.get(9));
        } catch (IndexOutOfBoundsException e) {
            // Do nothing
            // Both empty newline and no newline at end of file are accepted
        }
    }
}

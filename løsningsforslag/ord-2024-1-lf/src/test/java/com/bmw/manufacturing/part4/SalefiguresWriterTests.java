package com.bmw.manufacturing.part4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

import no.ntnu.tdt4100.part4.SalesOfficeReporter;

public class SalefiguresWriterTests {

    @Test
    public void write_should_have_throws_IOException_declared() {
        String name = SalefiguresWriter.class.getMethods()[0].getGenericExceptionTypes()[0].getTypeName();
        assertEquals("java.io.IOException", name);
    }

    @Test
    public void write_should_call_flush() throws IOException {
        OutputStream mockStream = mock();
        SalefiguresWriter.write(SalesOfficeReporter.produceReports(), mockStream);
        verify(mockStream, times(1)).flush();
    }

    @Test
    public void write_should_throw_IOException_when_OutputStream_throws() throws IOException {
        OutputStream mockStream = mock();
        doThrow(IOException.class).when(mockStream).write(anyInt());
        doThrow(IOException.class).when(mockStream).write(any());
        assertThrows(IOException.class, () -> SalefiguresWriter.write(SalesOfficeReporter.produceReports(), mockStream));
    }

    @Test
    public void write_should_produce_correct_results() throws IOException {
        int GLOBAL_SALES_2023 = 65_017_505;
        
        FakeOutputStream fakeStream = new FakeOutputStream();
        SalefiguresWriter.write(SalesOfficeReporter.produceReports(), fakeStream);
        Stream<String[]> stream = Arrays.stream(fakeStream.getWrittenString().split("\n")).map(s -> s.split(";"));
        assertEquals(GLOBAL_SALES_2023, stream.mapToInt(s -> Integer.parseInt(s[1])).sum());
    }

    @Test
    public void write_should_produce_correct_results_line_by_line() throws IOException {
        FakeOutputStream fakeStream = new FakeOutputStream();
        SalefiguresWriter.write(SalesOfficeReporter.produceReports(), fakeStream);
        List<String[]> stream = Arrays.stream(fakeStream.getWrittenString().split("\n")).map(s -> s.split(";")).toList();
        String[] firstLine = stream.getFirst();
        String[] lastLine = stream.getLast();
        assertEquals("AFG", firstLine[0]);
        assertEquals("204782", firstLine[1]);
        assertEquals("ZWE", lastLine[0]);
        assertEquals("227543", lastLine[1]);
    }
}


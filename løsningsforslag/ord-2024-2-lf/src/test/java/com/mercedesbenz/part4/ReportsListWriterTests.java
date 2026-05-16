package com.mercedesbenz.part4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.junit.jupiter.api.Test;

import no.ntnu.tdt4100.part3.ResearchReport;

public class ReportsListWriterTests {
   
    private ResearchReport briefHistoryOfTime = generateReport("A brief history of time", 1988, 
            new LinkedHashSet<>(List.of(
                generateReport("Philosophiæ Naturalis Principia Mathematica", 1687, null),
                generateReport("Cosmos", 1980, null),
                generateReport("The Field Equations of Gravitation", 1916, null)
                )));
    private ResearchReport originOfSpecies = generateReport("The Origin of Species", 1859, 
            new LinkedHashSet<ResearchReport>(List.of(generateReport("The Voyage of the Beagle", 1845, null))
                ));

    @Test
    public void write_should_call_flush() throws IOException {
        OutputStream outputStream = mock();
        ReportsListWriter.write(List.of(briefHistoryOfTime, originOfSpecies), outputStream);
        verify(outputStream, times(1)).flush();
    }

    @Test
    public void write_should_throw_IOException_when_OutputStream_throws() throws IOException {
        
        OutputStream mockStream = mock();
        doThrow(IOException.class).when(mockStream).write(anyInt());
        doThrow(IOException.class).when(mockStream).write(any());

        assertThrows(IOException.class, () -> ReportsListWriter.write(List.of(briefHistoryOfTime, originOfSpecies), mockStream));
    }

    @Test
    void write_should_produce_correct_results_line_by_line() throws IOException {
        FakeOutputStream fakeStream = new FakeOutputStream();
        ReportsListWriter.write(List.of(briefHistoryOfTime, originOfSpecies), fakeStream);
        List<String[]> stream = Arrays.stream(fakeStream.getWrittenString().split("\n")).map(s -> s.split(";")).toList();
        String[] firstLine = stream.get(0);
        String[] secondLine = stream.get(1);
        String[] fifthLine = stream.get(5);
        String[] sixthLine = stream.get(6);
        assertNotNull(UUID.fromString(firstLine[0]));
        assertEquals("A brief history of time", firstLine[1]);
        assertEquals("1988", firstLine[2]);
        assertNotNull(UUID.fromString(secondLine[0]));
        assertEquals("Philosophiæ Naturalis Principia Mathematica", secondLine[1]);
        assertEquals("1687", secondLine[2]);
        assertTrue(stream.get(4)[0].contains("----"));
        assertEquals("The Origin of Species", fifthLine[1]);
        assertEquals("1859", fifthLine[2]);
        assertNotNull(UUID.fromString(secondLine[0]));
        assertEquals("The Voyage of the Beagle", sixthLine[1]);
        assertEquals("1845", sixthLine[2]);
    }

    private ResearchReport generateReport(String name, int publishedYear, Set<ResearchReport> citations) {
        return new ResearchReport(UUID.randomUUID(), name, LocalDate.of(publishedYear, 01, 10), citations, new byte[] {});
    }
}

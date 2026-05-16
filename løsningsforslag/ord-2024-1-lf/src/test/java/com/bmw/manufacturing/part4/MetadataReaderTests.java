package com.bmw.manufacturing.part4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.io.InputStream;

import org.junit.jupiter.api.Test;

import no.ntnu.tdt4100.part4.ResultSet;

public class MetadataReaderTests {

    /**
     * @see no.ntnu.tdt4100.part4.Country#equals(Object)
     */
    @Test
    public void readCountries_resultSet_errors_should_contain_duplicate_countries() throws IOException {
        try (InputStream s = Thread.currentThread()
                .getContextClassLoader()
                .getResourceAsStream("countries/metadata.csv")) {
            ResultSet resultSet = MetadataReader.readCountries(s);

            assertEquals("Duplicate country", 
            resultSet.errors().get(8),
            "This country on line 8 is duplicate because the country on line 7 has the same 3-letter ISO code (AND)" + 
            "a countrys uniqueness is determined by the Country equals() method"
            );
            assertEquals("Duplicate country", 
                resultSet.errors().get(252), 
            "This country on line 252 is duplicate because the country on line 251 has the same 3-letter ISO code (VIR),");
        }
    }

    @Test
    public void readCountries_should_produce_correct_results() throws IOException {
        try (InputStream s = Thread.currentThread()
                .getContextClassLoader()
                .getResourceAsStream("countries/metadata.csv")) {
            ResultSet resultSet = MetadataReader.readCountries(s);

            assertEquals("Afghanistan", resultSet.country().get(0).name());
            assertEquals("AFG", resultSet.country().get(0).isoCountryCode().toString());
            assertEquals("Zimbabwe", resultSet.country().get(248).name());
            assertEquals("ZWE", resultSet.country().get(248).isoCountryCode().toString());
        }
    }

    @Test
    public void readCountries_should_return_correct_number_of_elements() throws IOException {
        try (InputStream s = Thread.currentThread()
                .getContextClassLoader()
                .getResourceAsStream("countries/metadata.csv")) {
            ResultSet resultSet = MetadataReader.readCountries(s);

            assertEquals(249, resultSet.country().size());
            assertEquals(249, resultSet.country().stream().map(c -> c.isoCountryCode()).distinct().count());
        }
    }

    @Test
    public void read_countries_should_have_7_errors() throws IOException {
        try (InputStream s = Thread.currentThread()
                .getContextClassLoader()
                .getResourceAsStream("countries/metadata.csv")) {
            ResultSet resultSet = MetadataReader.readCountries(s);

            assertEquals(7, resultSet.errors().size(),
            "The errors are on line 8, 9, 10, 11, 12, 13 and 252");
        }
    }
}


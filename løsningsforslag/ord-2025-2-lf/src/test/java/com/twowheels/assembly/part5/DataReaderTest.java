package com.twowheels.assembly.part5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

import org.junit.jupiter.api.Test;

import no.ntnu.tdt4100.twowheels.*;
import no.ntnu.tdt4100.twowheels.part5.ResultSet;

@SuppressWarnings("static-access")
public class DataReaderTest {

    // Helper methods for tests
    private ResultSet readResultSet() throws IOException {
        try (InputStream s = Thread.currentThread()
                .getContextClassLoader()
                .getResourceAsStream("bike_components.csv")) {
            return new ReadComponentsFromFile().read(s);
        }
    }

    private IBikeComponent getComponent(String componentId) throws IOException {
        return readResultSet().components().stream()
                .filter(x -> x.getComponentId().equals(componentId))
                .findFirst().orElse(null);
    }

    // Tests
    @Test
    public void parseProductLine_works_with_comma_delimiter() {
        String productLine = "E4X3B9L2,Product A,Manufacturer A,1500.0";
        BikeComponent component = new ReadComponentsFromFile().parseLine(productLine, ",");
        assertNotNull(component,
                "Product could not be parsed when using comma as delimiter on a line with comma-separated values (return value was null)");
    }
    
    @Test
    public void parseProductLine_works_with_other_delimiters() {
        String productLine = "E4X3B9L2;Product A;Manufacturer A;1500.0";
        BikeComponent component = new ReadComponentsFromFile().parseLine(productLine, ";");
        assertNotNull(component,
                "Product could not be parsed when using a different delimiter than a comma (return value was null)");
    }

    @Test
    public void parseProductLine_productId_is_parsed_correctly() {
        String productLine = "E4X3B9L2,Product A,Manufacturer A,1500.0";
        BikeComponent component = new ReadComponentsFromFile().parseLine(productLine, ",");
        assertEquals("E4X3B9L2", component.getComponentId(), "The product ID was not correctly parsed");
    }

    @Test
    public void parseProductLine_name_is_parsed_correctly() {
        String productLine = "E4X3B9L2,Product A,Manufacturer A,1500.0";
        BikeComponent component = new ReadComponentsFromFile().parseLine(productLine, ",");
        assertEquals("Product A", component.getComponentName(), "The product name was not correctly parsed");
    }

    @Test
    public void parseProductLine_manufacturer_is_parsed_correctly() {
        String productLine = "E4X3B9L2,Product A,Manufacturer A,1500.0";
        BikeComponent component = new ReadComponentsFromFile().parseLine(productLine, ",");
        assertEquals("Manufacturer A", component.getManufacturer(), "The product vendor was not correctly parsed");
    }

    @Test
    public void parseProductLine_price_is_parsed_correctly() {
        String productLine = "E4X3B9L2,Product A,Manufacturer A,1500.0";
        BikeComponent component = new ReadComponentsFromFile().parseLine(productLine, ",");
        assertEquals(1500.0, component.getPrice(), "The product price was not correctly parsed");
    }

    @Test
    public void parseProductLine_returns_null_when_invalid_price() {
        String productLine = "E4X3B9L2,Product A,Manufacturer A,invalid";
        BikeComponent component = new ReadComponentsFromFile().parseLine(productLine, ",");
        assertNull(component, "parseProductLine should return null when price is invalid");
    }

    @Test
    public void parseProductLine_returns_null_when_less_than_4_values() {
        String productLine = "E4X3B9L2,Product A,1500.0";
        BikeComponent component = new ReadComponentsFromFile().parseLine(productLine, ",");
        assertNull(component, "parseProductLine should return null when there is missing data (less than 6 values)");
    }


    @Test
    public void read_should_have_throws_IOException_declared() {
        Method[] methods = ReadComponentsFromFile.class.getMethods();
        for (Method method : methods) {
            if (method.getName().equals("read")) {
                Class<?>[] exceptions = method.getExceptionTypes();
                if (exceptions.length == 1) {
                    assertEquals(IOException.class, exceptions[0],
                            "The 'read' method should declare that it throws IOException");
                    return;
                } else {
                    throw new AssertionError("The 'read' method has more than one exception declared");
                }
            }
        }
    }

    @Test
    public void read_should_throw_IOException_when_OutputStream_throws() throws IOException {
        InputStream mockStream = mock();
        doThrow(IOException.class).when(mockStream).read(any());
        assertThrows(IOException.class, () -> new ReadComponentsFromFile().read(mockStream),
                "The read method should throw IOException when InputStream throws an IOException, you should not catch this error");
    }

    @Test
    public void read_returned_ResultSet_contains_string_parsed_as_double_error() throws IOException {
        assertEquals(5,
                readResultSet().linesWithErrors().get(0),
                "The first error should be on line 5, due to a string being parsed as a double");
    }

    @Test
    public void read_returned_ResultSet_contains_decimal_wrong_format_error() throws IOException {
        assertEquals(12,
                readResultSet().linesWithErrors().get(1),
                "The second error should be on line 12, due to a decimal being wrongly formated");
    }

    @Test
    public void read_returned_ResultSet_contains_too_many_commas_error() throws IOException {
        assertEquals(15,
                readResultSet().linesWithErrors().get(2),
                "The third error should be on line 15, due to the line containing 4 commas instead of 3");
    }

    @Test
    public void read_returned_ResultSet_should_produce_correct_name_for_product() throws IOException {
        assertEquals("SRAM X01 Eagle Rear Derailleur", getComponent("J7P1T4F6").getComponentName(),
                "The product name for product with ID J7P1T4F6 was not read correctly");
    }


    @Test
    public void read_returned_ResultSet_should_produce_correct_price_for_product() throws IOException {
        assertEquals(2499.00, getComponent("M6X2D5N1").getPrice(), 0.01,
                "The price for product with ID M6X2D5N1 was not read correctly");
    }

    @Test
    public void read_returned_ResultSet_should_produce_correct_manufacturer_for_product() throws IOException {
        assertEquals("Shimano", getComponent("U9N3P2L4").getManufacturer(),
                "The vendor for product with ID U9N3P2L4 was not read correctly");
    }

    @Test
    public void read_returned_ResultSet_should_have_x_valid_components_in_total() throws IOException {
        assertEquals(50, readResultSet().components().size(), "There should be 50 valid products in the dataset");
    }

    @Test
    public void read_returned_ResultSet_should_have_x_errors_in_total() throws IOException {
        assertEquals(4, readResultSet().linesWithErrors().size(),
                "There should be 4 errors in the dataset");

    }
}

package com.shopstore.retail.part4;

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

import no.ntnu.tdt4100.IProduct;
import no.ntnu.tdt4100.Product;
import no.ntnu.tdt4100.part4.ResultSet;

@SuppressWarnings("static-access")
public class InventoryDataReaderTest {

    // Helper methods for tests
    private ResultSet readResultSet() throws IOException {
        try (InputStream s = Thread.currentThread()
                .getContextClassLoader()
                .getResourceAsStream("inventory.csv")) {
            return new InventoryDataReader().read(s);
        }
    }

    private IProduct getProduct(int productId) throws IOException {
        return readResultSet().products().stream()
                .filter(x -> x.getProductId() == productId)
                .findFirst().orElse(null);
    }

    // Tests
    @Test
    public void parseProductLine_works_with_comma_delimiter() {
        String productLine = "1,Product A,Description A,10.0,100,Vendor A";
        Product product = new InventoryDataReader().parseProductLine(productLine, ",");
        assertNotNull(product,
                "Product could not be parsed when using comma as delimiter on a line with comma-separated values (return value was null)");
    }

    @Test
    public void parseProductLine_works_with_other_delimiters() {
        String productLine = "1;Product A;Description A;10.0;100;Vendor A";
        Product product = new InventoryDataReader().parseProductLine(productLine, ";");
        assertNotNull(product,
                "Product could not be parsed when using a different delimiter than a comma (return value was null)");
    }

    @Test
    public void parseProductLine_productId_is_parsed_correctly() {
        String productLine = "1,Product A,Description A,10.0,100,Vendor A";
        Product product = new InventoryDataReader().parseProductLine(productLine, ",");
        assertEquals(1, product.getProductId(), "The product ID was not correctly parsed");
    }

    @Test
    public void parseProductLine_name_is_parsed_correctly() {
        String productLine = "1,Product A,Description A,10.0,100,Vendor A";
        Product product = new InventoryDataReader().parseProductLine(productLine, ",");
        assertEquals("Product A", product.getName(), "The product name was not correctly parsed");
    }

    @Test
    public void parseProductLine_description_is_parsed_correctly() {
        String productLine = "1,Product A,Description A,10.0,100,Vendor A";
        Product product = new InventoryDataReader().parseProductLine(productLine, ",");
        assertEquals("Description A", product.getDescription(), "The product description was not correctly parsed");
    }

    @Test
    public void parseProductLine_price_is_parsed_correctly() {
        String productLine = "1,Product A,Description A,10.0,100,Vendor A";
        Product product = new InventoryDataReader().parseProductLine(productLine, ",");
        assertEquals(10.0, product.getPrice(), "The product price was not correctly parsed");
    }

    @Test
    public void parseProductLine_vendor_is_parsed_correctly() {
        String productLine = "1,Product A,Description A,10.0,100,Vendor A";
        Product product = new InventoryDataReader().parseProductLine(productLine, ",");
        assertEquals("Vendor A", product.getVendor(), "The product vendor was not correctly parsed");
    }

    @Test
    public void parseProductLine_returns_null_when_invalid_price() {
        String productLine = "1,Product A,Description A,invalid,100,Vendor A";
        Product product = new InventoryDataReader().parseProductLine(productLine, ",");
        assertNull(product, "parseProductLine should return null when price is invalid");
    }

    @Test
    public void parseProductLine_returns_null_when_invalid_productId() {
        String productLine = "foo,Product A,Description A,10.0,100,Vendor A";
        Product product = new InventoryDataReader().parseProductLine(productLine, ",");
        assertNull(product, "parseProductLine should return null when product ID is invalid");
    }

    @Test
    public void parseProductLine_returns_null_when_less_than_6_values() {
        String productLine = "1,Product A,Description A,10.0,100";
        Product product = new InventoryDataReader().parseProductLine(productLine, ",");
        assertNull(product, "parseProductLine should return null when there is missing data (less than 6 values)");
    }

    @Test
    public void read_should_have_throws_IOException_declared() {
        Method[] methods = InventoryDataReader.class.getMethods();
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
        assertThrows(IOException.class, () -> new InventoryDataReader().read(mockStream),
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
                "The third error should be on line 15, due to the line containing 6 commas instead of 5");
    }

    @Test
    public void read_returned_ResultSet_should_produce_correct_name_for_product() throws IOException {
        assertEquals("Tailored Modern Coat", getProduct(4998).getName(),
                "The product name for product with ID 4998 was not read correctly");
    }

    @Test
    public void read_returned_ResultSet_should_produce_correct_description_for_product() throws IOException {
        assertEquals("Tailored Modern Coat from Calvin Klein", getProduct(4998).getDescription(),
                "The product description for product with ID 4998 was not read correctly");
    }

    @Test
    public void read_returned_ResultSet_should_produce_correct_price_for_product() throws IOException {
        assertEquals(100.00, getProduct(4998).getPrice(), 0.01,
                "The price for product with ID 4998 was not read correctly");
    }

    @Test
    public void read_returned_ResultSet_should_produce_correct_vendor_for_product() throws IOException {
        assertEquals("Calvin Klein", getProduct(4998).getVendor(),
                "The vendor for product with ID 4998 was not read correctly");
    }

    @Test
    public void read_returned_ResultSet_should_have_83_valid_products_in_total() throws IOException {
        assertEquals(83, readResultSet().products().size(), "There should be 83 valid products in the dataset");
    }

    @Test
    public void read_returned_ResultSet_should_have_6_errors_in_total() throws IOException {
        assertEquals(6, readResultSet().linesWithErrors().size(),
                "There should be 6 errors in the dataset");

    }
}

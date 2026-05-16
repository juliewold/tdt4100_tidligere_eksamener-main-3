package com.shopstore.retail.part4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import no.ntnu.tdt4100.Product;
import no.ntnu.tdt4100.part4.ResultSet;

public class InventoryDataReader {

    public static final String CSV_SPLIT_REGEX = ",(?=([^\"]*\"[^\"]*\")*[^\"]*$)";

    /**
     * Parses a string containing product data into a {@link Product} object.
     * 
     * The method expects the <code>productLine</code> parameter to be a string with
     * values in a comma- or other delimiter-separated format where each value
     * represents a different attribute of the product. The parameter represents a
     * single line in the file resources/inventory.csv. The <code>splitRegexp</code>
     * parameter should be used to split the string into its parts.
     * 
     * The expected order of the values for the productLine string is:
     * product ID, name, description, price, stock, and vendor. Since
     * the stock field is not actually used in the {@link Product} class, it
     * is not required to be parsed and should be ignored.
     * 
     * If the string does not contain exactly six such values, or if any of the
     * numeric fields cannot be parsed, the method returns
     * <code>null</code>.
     *
     * @param productLine A String containing the product data. It must contain
     *                    exactly six delimiter-separated values.
     * @param splitRegexp Regex expression to use for splitting the line.
     * 
     * @return A {@link Product} object constructed from the provided data, or
     *         <code>null</code> if the data could not be parsed into a Product.
     * 
     * @see Product
     * @see Product#Product(int, String, String, double, String)
     */
    public static Product parseProductLine(String productLine, String splitRegexp) {
        String[] parts = productLine.split(splitRegexp);
        if (parts.length != 6) {
            return null;
        }
        try {
            int productId = Integer.parseInt(parts[0]);
            String name = parts[1];
            String description = parts[2];
            double price = Double.parseDouble(parts[3]);
            String vendor = parts[5];
            return new Product(productId, name, description, price, vendor);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    /**
     * Reads the product inventory data from the provided {@link InputStream},
     * identifies any lines with errors, and returns a
     * {@link no.ntnu.tdt4100.part4.ResultSet} object.
     * 
     * The method expects the input stream to contain Comma-Separated Values (CSV)
     * formatted data. The first line, assumed to be the header, should be skipped.
     * Each subsequent line should be parsed into a {@link Product} object and added
     * to the corresponding {@link ResultSet#products()} list in the result set. If
     * a line cannot be parsed into a Product as described by the
     * {@link #parseProductLine()} method because of an error in the data, then the
     * line number of the error should instead be added to the
     * {@link ResultSet#linesWithErrors()} list.
     * 
     * The {@link InventoryDataReader#CSV_SPLIT_REGEX} constant should be used to
     * split the lines into their separate parts, as this expression can handle
     * multiple edge cases for CSV data.
     * 
     * Note: You are NOT required to use the {@link #parseProductLine()} method in
     * this implementation, but you will likely find it useful. Both methods
     * must ble implemented however for full score.
     *
     * The file resources/inventory.csv contains the file to be read
     *
     * @param stream The {@link InputStream} containing the product inventory data.
     *               You can assume it will not be null.
     * @return A {@link ResultSet} object containing a list of products and a list
     *         of line numbers for lines that could not be parsed.
     * @throws IOException If an I/O error occurs when reading from the stream.
     * 
     * @see ResultSet
     * @see Product
     */
    public static ResultSet read(InputStream stream) throws IOException {
        List<Product> products = new ArrayList<>();
        List<Integer> linesWithErrors = new ArrayList<>();
        ResultSet resultSet = new ResultSet(products, linesWithErrors);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(stream))) {
            int i = 1;
            String line = reader.readLine(); // Skip the first line, contains header information
            while ((line = reader.readLine()) != null) {
                i++;
                Product parsedProduct = parseProductLine(line, CSV_SPLIT_REGEX);
                if (parsedProduct != null) {
                    products.add(parsedProduct);
                } else {
                    linesWithErrors.add(i);
                }
            }
        }
        return resultSet;
    }
}

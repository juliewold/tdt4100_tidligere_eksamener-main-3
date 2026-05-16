package com.twowheels.assembly.part5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import no.ntnu.tdt4100.twowheels.*;
import no.ntnu.tdt4100.twowheels.part5.ResultSet;

// TODO: Import relevant libraries

public class ReadComponentsFromFile {

    public static final String CSV_SPLIT_REGEX = ",(?=([^\"]*\"[^\"]*\")*[^\"]*$)";

    /**
     * Parses a string containing component data into a {@link BikeComponent} object.
     * 
     * The method expects the <code>productLine</code> parameter to be a string with
     * values in a comma- or other delimiter-separated format where each value
     * represents a different attribute of the product. The parameter represents a
     * single line in the file resources/bike_components.csv. The
     * <code>splitRegexp</code>
     * parameter should be used to split the string into its parts.
     * 
     * The expected order of the values for the productLine string is:
     * component id, component name, manufacturer, unit price
     * 
     * If the string does not contain exactly four such values, or if any of the
     * numeric fields cannot be parsed, the method returns
     * <code>null</code>.
     *
     * @param productLine A String containing the component data. It must contain
     *                    exactly four delimiter-separated values.
     * @param splitRegexp Regex expression to use for splitting the line.
     * 
     * @return A {@link BikeComponent} object constructed from the provided data, or
     *         <code>null</code> if the data could not be parsed into a BikeComponent.
     * 
     * @see BikeComponent
     */

    public static BikeComponent parseLine(String productLine, String splitRegexp) {

        // TODO: Complete the method according to JavaDoc

    }

/**
     * Reads the bike components from the provided {@link InputStream},
     * identifies any lines with errors, and returns a
     * {@link no.ntnu.tdt4100.twowheels.part5.ResultSet} object.
     * 
     * The method expects the input stream to contain Comma-Separated Values (CSV)
     * formated data. The first line, assumed to be the header, should be skipped.
     * Each subsequent line should be parsed into a {@link BikeComponent} object and added
     * to the corresponding {@link ResultSet#components()} list in the result set. If
     * a line cannot be parsed into a BikeComponent as described by the
     * {@link #parseLine()} method because of an error in the data, then the
     * line number of the error should instead be added to the
     * {@link ResultSet#linesWithErrors()} list.
     * 
     * The {@link ReadComponentsFromFile#CSV_SPLIT_REGEX} constant should be used to
     * split the lines into their separate parts, as this expression can handle
     * multiple edge cases for CSV data.
     * 
     * Note: You are NOT required to use the {@link #parseLine()} method in
     * this implementation, but you will likely find it useful. Both methods
     * must ble implemented however for full score.
     *
     * The file resources/bike_components.csv contains the file to be read
     *
     * @param stream The {@link InputStream} containing the bike components.
     *               You can assume it will not be null.
     * @return A {@link ResultSet} object containing a list of components and a list
     *         of line numbers for lines that could not be parsed.
     * @throws IOException If an I/O error occurs when reading from the stream.
     * 
     * @see ResultSet
     * @see BikeComponents
     */


    public static ResultSet read(InputStream stream) throws IOException {

        // TODO: Complete the method according to JavaDoc
        
    }

}

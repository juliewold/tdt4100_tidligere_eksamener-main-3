package com.bmw.manufacturing.part4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import no.ntnu.tdt4100.part4.Country;
import no.ntnu.tdt4100.part4.IsoAlpha3CountryCode;
import no.ntnu.tdt4100.part4.ResultSet;

public final class MetadataReader {


    public static final String CSV_SPLIT_REGEX = ",(?=([^\"]*\"[^\"]*\")*[^\"]*$)";
    /**
     * Reads an input stream and produces a result set with a list of unique countries and encountered
     * errors by parsing the stream.
     * The input stream is expected to be a CSV file with the format 
     * as defined in resources/countries/metadata.csv
     * 
     * Behavioural requirements:
     * <ul>
     * <li>The first line of the file contains header information and should be skipped</li>
     * <li>There might be various types of errors in the file, such as missing fields, erronous data etc.
     * Oonly the country name and its 3-letter ISO country code are necessary to validate for errors</li>
     * <li>If erronous data is encountered (such as empty string), an error should be added to the result set 
     * and the line should be skipped, continuing to read the file from the next line</li>
     * <li>A list of unique countries should be returned, a countrys uniqueness is determined by 
     * its 3-letter ISO code {@link no.ntnu.tdt4100.part4.Country#equals(String)}</li>
     * <li>Each time a duplicate country is encountered, the error message should be "Duplicate country"</li>
     * <li>If parsed correctly, the returned list should be 249 elements long</li>
     * <li>The returned map of errors should contain the file line number where the error occured 
     * as key and the Exception message as value</li>
     * <li>Countries that have commas in their names are quoted with "" in the CSV (example on line 35). 
     * The {@link no.ntnu.tdt4100.part4.Country#name()} in {@link ResultSet} should not contain quotes.
     * You may use the supplied {@link MetadataReader#CSV_SPLIT_REGEX} to achieve this.</li>
     * </ul>
     * 
     * @see resources/countries/metadata.csv that contains the file to be read
     * 
     * @param stream the {@link InputStream}
     * @return a {@link ResultSet} containing a list of unique countries and a map of errors
     * @throws java.io.IOException if an I/O error occurs 
     * 
     * @see String#split(String)
     * @see MetadataReader#CSV_SPLIT_REGEX
     * @see MetadataReaderTests
     * @see no.ntnu.tdt4100.part4.Country#equals(Object)
     */
    public static ResultSet readCountries(InputStream stream) throws IOException {
        // TODO Implement the method according to the description in the JavaDoc
        List<Country> countries = new ArrayList<>();
        HashMap<Integer, String> errors = new HashMap<>();
        ResultSet resultSet = new ResultSet(countries, errors);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(stream))) {
            int i = 1;
            String line;
            reader.readLine(); // Skip the first line, contains header information
            while ((line = reader.readLine()) != null) {
                i++;
                try {
                    String[] parts = line.split(CSV_SPLIT_REGEX);
                    Country c = new Country(parts[0], new IsoAlpha3CountryCode(parts[2]));
                    if (!countries.contains(c)) {
                        countries.add(c);
                     } else {   
                        errors.put(i, "Duplicate country");
                     }
                } catch (Exception e) {
                    errors.put(i, e.getMessage());
                    continue;
                }
            }
        } 

        return resultSet;
    }
}

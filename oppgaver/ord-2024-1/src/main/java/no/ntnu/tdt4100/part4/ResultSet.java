package no.ntnu.tdt4100.part4;

import java.util.List;
import java.util.Map;

/**
 * The <code>ResultSet</code> record contains list of countries and map of errors
 * The key in the map is the line number, the value is the error/exception message
 * THIS CODE IS SUPPLIED, DO NOT MODIFY
 */
public record ResultSet(List<Country> country, Map<Integer, String> errors) {}

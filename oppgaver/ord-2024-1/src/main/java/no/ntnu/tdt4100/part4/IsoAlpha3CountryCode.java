package no.ntnu.tdt4100.part4;

import java.util.regex.Pattern;

/**
 * The <code>IsoAlpha3CountryCode</code> record contains name and ISO country code
 * THIS CODE IS SUPPLIED, DO NOT MODIFY
 */
public class IsoAlpha3CountryCode {
    private String code;
    private static Pattern pattern = Pattern.compile("[A-Z]{3}");

    public IsoAlpha3CountryCode(String code) {
        if (code == null || code.length() != 3 || !pattern.matcher(code).find()) {
            throw new IllegalArgumentException("Code must be 3 characters long");
        }
        this.code = code;
    }

    public String toString() {
        return code;
    } 
}

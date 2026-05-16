package no.ntnu.tdt4100.part4;

/**
 * The <code>Country</code> record contains name and ISO country code
 * THIS CODE IS SUPPLIED, DO NOT MODIFY
 */
public record Country(String name, IsoAlpha3CountryCode isoCountryCode) {
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Country country = (Country) obj;
        return isoCountryCode.toString().equals(country.isoCountryCode.toString());
    }
}

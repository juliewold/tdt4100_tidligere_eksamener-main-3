package no.ntnu.tdt4100;

/**
 * THIS IS SUPPLIED CODE, DO NOT MODIFY THIS CODE
 */
public class Vat {
    private String vat;

    public Vat(String vat) {
        if (vat == null || vat.length() != 9) {
            throw new IllegalArgumentException("Invalid VAT");
        }
        this.vat = vat;
    }

    public String getVat() {
        return this.vat;
    }
}
package no.ntnu.tdt4100;

/**
 * THIS IS SUPPLIED CODE, DO NOT MODIFY THIS CODE
 */
public class CarManufacturer {
    private String name;
    private String country;
    private Vat vat;

    public CarManufacturer(String name, String vat) {
       if (vat == null || vat.length() == 9) {
            throw new IllegalArgumentException("Invalid VAT");
        }
        this.name = name;
    }

    public CarManufacturer(String name, int vat) {
        this.name = name;
        this.vat = new Vat("123456789");
    }

    public CarManufacturer(String name, Vat vat, String country) {
        this.name = name;
        this.vat = vat;
        this.country = country;
        
    }

	public CarManufacturer(String name, String vat, String country) {
        this.name = name;
        this.vat = new Vat(name);
        this.country = country;
	}

    public Vat getVat() {
        return vat;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }
}
package com.bmw.manufacturing.part1;

import no.ntnu.tdt4100.CarManufacturer;
import no.ntnu.tdt4100.Vat;

@SuppressWarnings("unused")
public class Task6 {
    /**
     * Returns a new CarManufacturer object where the supplied VAT is valid.
     * A valid VAT is 9 digits.
     * 
     * Please note that some of the constructors are intentionally 
     * implemented incorrectly, you must read the code to understand
     * which of the constructors will actually validate the VAT correctly.
     * 
     * Comment out the line(s) that returns a CarManufacturer object with a valid VAT.
     * 
     * @param vat the VAT string
     * @return a new car manufacturer object with a valid VAT
     * 
     * @see CarManufacturer
     */
    public CarManufacturer getManufacturerWithValidVat(String vat) {
        // TODO Uncomment the line(s) that returns as specified in JavaDoc 

        if (true) { // This line is only in place to make the code compile, do not remove it

        //return new CarManufacturer("BMW", Integer.parseInt(vat));
        //return new CarManufacturer("BMW", vat);
        //return new CarManufacturer("BMW", vat, "GERMANY");
        return new CarManufacturer("BMW", new Vat(vat), "Germany");

        }

        return null; // This line is only in place to make the code compile, do not remove it
    }
}

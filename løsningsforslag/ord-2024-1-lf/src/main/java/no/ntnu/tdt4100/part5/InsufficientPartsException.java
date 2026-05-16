package no.ntnu.tdt4100.part5;

import no.ntnu.tdt4100.CarPart;

/**
 * InsufficientPartsException is a subclass
 * of {@link no.ntnu.tdt4100.part5.ProductionException}
 * 
 * THIS IS SUPPLIED CODE, DO NOT EDIT THIS CODE
 * 
 */
public class InsufficientPartsException extends ProductionException {
    public InsufficientPartsException(CarPart part, String message) {
        super(part, message);
    }

    public InsufficientPartsException(CarUnit unit, String message) {
        super(unit, message);
    }
}


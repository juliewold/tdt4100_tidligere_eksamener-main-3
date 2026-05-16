package no.ntnu.tdt4100.part5;

/**
 * AlreadyProducedException is thrown when a car is already produced
 * 
 * THIS IS SUPPLIED CODE, DO NOT EDIT THIS CODE
 */
public class AlreadyProducedException extends ProductionException {

    public AlreadyProducedException(CarUnit unit, String message) {
        super(unit, message);
    }
}


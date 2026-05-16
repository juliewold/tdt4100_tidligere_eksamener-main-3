package no.ntnu.tdt4100.part5;

import java.util.Optional;

import no.ntnu.tdt4100.CarPart;

/**
 * This class is the base class for exceptions regarding car production
 * THIS IS SUPPLIED CODE, DO NOT MODIFY
 */
public abstract class ProductionException extends RuntimeException {
 private CarUnit unit;
    private CarPart part;

    public ProductionException(CarUnit unit, String message) {
        super(message);
        this.unit = unit;
    }

    public ProductionException(CarPart part, String message) {
        super(message);
        this.part = part;
    }

    public Optional<CarUnit> getUnit() {
        return Optional.ofNullable(unit);
    }

    public Optional<CarPart> getPart() {
        return Optional.ofNullable(part);
    }

}

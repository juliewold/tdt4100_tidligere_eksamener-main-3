package com.bmw.manufacturing.part5;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import no.ntnu.tdt4100.CarPart;
import no.ntnu.tdt4100.ICarFactory;
import no.ntnu.tdt4100.IHasInventoryManager;
import no.ntnu.tdt4100.part5.AlreadyProducedException;
import no.ntnu.tdt4100.part5.CarUnit;
import no.ntnu.tdt4100.part5.InsufficientPartsException;
import no.ntnu.tdt4100.part5.InventoryManager;

/**
 * The CarFactoryWithInventory is a car factory that 
 * use a delegate {@link ICarFactory} to forward some of its method calls to
 * 
 * In addition it will hold an {@link InventoryManager}, so that every time
 * a unit is produced or shipment of parts is received, the inventory 
 * of the factory is updated. This happens through the inventory manager.
 * 
 * @see ICarFactory
 * @see CarFactoryWithInventoryTests
 */
public class CarFactoryWithInventory implements ICarFactory, IHasInventoryManager {
    private ICarFactory delegate;
    private List<CarUnit> unitsProduced = new ArrayList<>();
    private InventoryManager inventoryManager;

    /**
     * Constructor - creates a CarFactoryWithInventory object
     * 
     * @param delegate the {@link no.ntnu.tdt4100.ICarFactory} factory delegate
     * @param inventoryManager the {@link no.ntnu.tdt4100.part5.InventoryManager} 
     */
    public CarFactoryWithInventory(ICarFactory delegate, InventoryManager inventoryManager) {
        this.delegate = delegate;
        this.inventoryManager = inventoryManager;
    }

    /**
     * Returns the ISO country code of the factory
     * The location is the factorys 3-letter ISO country code.
     * 
     * This method must delegate to {@link no.ntnu.tdt4100.ICarFactory#getIsoCountryCode()} of the delegate in the constructor.
     * 
     * @return the ISO country code
     */
    // TODO Implement the getIsoCountryCode according to JavaDoc specification
    public String getIsoCountryCode() {
        return delegate.getIsoCountryCode();
    }

    /**
     * Returns the {@link java.util.List} of {@link no.ntnu.tdt4100.CarPart} that this particular factory uses 
     * in its manufacturing processes
     * 
     * This method must delegate to {@link no.ntnu.tdt4100.ICarFactory#getParts()} of the delegate in the constructor.
     * 
     * @return the {@link List} of {@link no.ntnu.tdt4100.CarPart}
     * 
     * @see ICarFactory#getParts()
     */
    // TODO Implement the getParts method 
    public List<CarPart> getParts() {
        return delegate.getParts();
    }

    /**
     * Returns the number of employees that the car factory holds, of type int
     * 
     * This method must delegate to {@link no.ntnu.tdt4100.ICarFactory#getNumberOfEmployees()} of the delegate in the constructor.
     * 
     * @see ICarFactory#getNumberOfEmployees()
     */
    // TODO Implement the getNumberOfEmployees method declared in ICarFactory interface
    public int getNumberOfEmployees() {
        return delegate.getNumberOfEmployees();
    }

    /**
     * Returns the {@link InventoryManager} for <code>this</code> factory
     * 
     * @return the {@link InventoryManager} for <code>this</code> factory.
     */
    @Override
    public InventoryManager getInventoryManager() {
        return inventoryManager;
    }

    /**
     * Produces a car unit.
     * 
     * Before producing a unit, the factory checks 2 things:
     * 
     * - Whether the car with the given VIN {@link CarUnit#vin()} has 
     * been produced before at this factory.
     * If a Car unit with the given VIN has been produced before at this factory, 
     * {@link AlreadyProducedException} is thrown.
     * 
     * - Whether the factorys inventory stock has enough parts {@link InventoryManager#getAvailableQuantity(CarPart)}
     * If the factory does not have enough parts to produce the unit, an
     * {@link InsufficientPartsException} is thrown.
     * 
     * When a unit is successfully produced the available quantity in the
     * inventory of the parts used to produce the unit is decreased
     * 
     * @param unit the car unit to produce
     * @throws AlreadyProducedException   if a car unit with the supplied VIN has
     *                                    been produced before at this factory
     * @throws InsufficientPartsException if the factory does not have enough parts as required by {@link CarUnit#parts()}
     *                                    to produce the unit
     * 
     * @see CarUnit#vin()
     * @see CarUnit#parts()
     * @see InventoryManager#getAvailableQuantity(CarPart)
     */
    public void produceUnit(CarUnit unit) {
        // TODO Implement the method to behave according to JavaDoc
        if (isCarWithVinProduced(unit.vin())) {
            throw new AlreadyProducedException(unit, "Car with VIN " + unit.vin() + " has already been produced");
        }

        for (Map.Entry<CarPart, Integer> p : unit.parts().entrySet()) {
            if (inventoryManager.getAvailableQuantity(p.getKey()) < p.getValue()) {
                throw new InsufficientPartsException(unit, "Not enough parts to produce unit");
            }
        }

        for (Map.Entry<CarPart, Integer> p : unit.parts().entrySet()) {
            inventoryManager.decreaseQuantity(p.getKey(), p.getValue());
        }

        unitsProduced.add(unit);
    }

    /**
     * Processes a shipment of a given part by increasing the available quantity of the given part in the
     * inventory represented by the {@link InventoryManager}. 
     * 
     * If the number is not positive, the method should do nothing.
     * 
     * @param part the part that was received in the shipment
     * @param number the number of items in the shipment
     * 
     * @see InventoryManager#increaseQuantity(CarPart, int)
     */
    public void processShipment(CarPart part, int numberOfItems) {
        // TODO Implement the method to behave according to JavaDoc
        if (numberOfItems < 0) return;
        inventoryManager.increaseQuantity(part, numberOfItems);
    }

    /**
     * Checks if a car with a given VIN has been produced at this factory.
     * 
     * @param vin
     * @return true if a car with the given VIN has been produced, false otherwise
     */
    boolean isCarWithVinProduced(String vin) {
        // TODO Implement the method to behave according to JavaDoc
        return unitsProduced.stream().anyMatch(u -> u.vin().equals(vin));
    }

    /**
     * Returns the number of units produced at <code>this</code> factory.
     * @return the number of units produced at <code>this</code> factory.
     */
    @Override
    public int getNumberOfUnitsProduced() {
        return unitsProduced.size();
    }
}

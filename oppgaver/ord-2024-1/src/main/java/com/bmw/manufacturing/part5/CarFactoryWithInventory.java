package com.bmw.manufacturing.part5;

import java.util.List;

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

    /**
     * Constructor - creates a CarFactoryWithInventory object
     * 
     * @param delegate the {@link no.ntnu.tdt4100.ICarFactory} factory delegate
     * @param inventoryManager the {@link no.ntnu.tdt4100.part5.InventoryManager} 
     */
    public CarFactoryWithInventory(ICarFactory delegate, InventoryManager inventoryManager) {
        // TODO Implement the constructor according to JavaDoc specification
    }


    /**
     * Returns the ISO country code of the factory
     * The location is the factorys 3-letter ISO country code.
     * 
     * This method must delegate to {@link no.ntnu.tdt4100.ICarFactory#getIsoCountryCode()} of the delegate in the constructor.
     * 
     * @return the ISO country code
     */
    @Override
    public String getIsoCountryCode() {
        // TODO Implement the getIsoCountryCode according to JavaDoc specification
        return null;
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
    @Override
    public List<CarPart> getParts() {
        // TODO Implement the getParts method according to its JavaDoc
        return null;
    }
    

    /**
     * Returns the number of employees that the car factory holds, of type int
     * 
     * This method must delegate to {@link no.ntnu.tdt4100.ICarFactory#getNumberOfEmployees()} of the delegate in the constructor.
     * 
     * @see ICarFactory#getNumberOfEmployees()
     */
    @Override
    public int getNumberOfEmployees() {
        // TODO Implement the getNumberOfEmployees method according to its JavaDoc
        return -1;
    }

    /**
     * Returns the {@link InventoryManager} for <code>this</code> factory
     * 
     * @return the {@link InventoryManager} for <code>this</code> factory.
     */
    @Override
    public InventoryManager getInventoryManager() {
        // TODO Implement the getInventoryManager 
        return null;
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
    }


    /**
    /**
     * Checks if a car with a given VIN has been produced at this factory.
     * 
     * @param vin
     * @return true if a car with the given VIN has been produced, false otherwise
     */
    boolean isCarWithVinProduced(String vin) {
        // TODO Implement the method to behave according to JavaDoc
        return false;
    }


    /**
     * Returns the number of units produced at <code>this</code> factory.
     * @return the number of units produced at <code>this</code> factory.
     */
    @Override
    public int getNumberOfUnitsProduced() {
        // TODO Implement the method to behave according to JavaDoc
        return -1;
    }
}

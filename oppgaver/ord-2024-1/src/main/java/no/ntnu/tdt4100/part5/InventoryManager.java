package no.ntnu.tdt4100.part5;

import no.ntnu.tdt4100.CarPart;

/**
 * InventoryManager class contains the inventory for a car factory.
 * It also contains extension points for handling inventory, 
 * i.e. what happens when stock runs out or is refilled.
 * 
 * This is because the supplier chains are different for various car parts.
 * Depending on how the supplier chain is, it requires different type of management.
 */
public interface InventoryManager {

    /**
     * Increase the available quantity of the given car part in the inventory.
     * 
     * If the number is negative, do nothing.
     * 
     * This method will be called when processing a recieved shipment to a factory.
     *
     * @param part the car part
     * @param numberOfItems number of items of the given car part to add to the inventory
     */
    public void increaseQuantity(CarPart part, int numberOfItems);

    /**
     * Decrease the available quantity of the given car part in the inventory.
     * 
     * This method will be called each time a car part is removed from the inventory 
     * to be installed in a car.
     * 
     * After the inventory is updated with the new available quantity, the method 
     * must notify all listeners/observers with remaining available quantity 
     * of the given car part
     * 
     * @param part the car part
     * @param numberOfItems the number of items of the given car part to remove from the inventory
     * @throws InsufficientPartsException if there are not enough available items in inventory of the given car part
     */
    public void decreaseQuantity(CarPart part, int numberOfItems);

    /**
     * Adds a listener for stock changes in the inventory
     * 
     * The addListener method adds a listener.
     * The same listener can not be added multiple times.
     * 
     * @param listener the {@link IStockChangeListener} to add 
     */
    public void addListener(IStockChangeListener listener);

    /**
     * Removes a previously registered listener.
     * 
     * @param listener the {@link IStockChangeListener} to remove 
     */
    public void removeListener(IStockChangeListener listener);

    /**
     * Returns the available quantity of the given car part in stock
     * 
     * @param part the {@link CarPart}
     * @return the available quantity of the given car part
     */
    public int getAvailableQuantity(CarPart part); 

    /**
     * Returns the number of added listeners.
     * 
     * @return number of added {@link IStockChangeListener} objects
     */
    public int getNumberOfListeners();
}

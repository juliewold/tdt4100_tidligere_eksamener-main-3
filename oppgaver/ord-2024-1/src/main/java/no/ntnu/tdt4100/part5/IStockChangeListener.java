package no.ntnu.tdt4100.part5;

import no.ntnu.tdt4100.CarPart;

/**
 * IStockChangeListener is an Observer of stock changes in a car factory
 * It can be used for multiple purposes, ie to initiate a new order from a 
 * supplier when the stock for a specific car part dips below a certain threshold.
 */
public interface IStockChangeListener {

    /**
     * This method is called each time the quantity in the inventory is changed.
     * 
     * An implementation must handle the following cases
     *  - When a shipment is recieved, the quantity of the part is increased in the warehouse
     *  - When a part is used in production, the quantity of the part is decreased in the warehouse 
     *  - When the supplied arguments are null or negative, do nothing
     * 
     * @param part the part
     * @param availableQuantity the remaining available quantity in inventory
     */
    public void execute(CarPart part, int availableQuantity);
}

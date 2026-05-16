package com.bmw.manufacturing.part5;

import java.util.HashMap;
import java.util.Map;

import no.ntnu.tdt4100.CarPart;
import no.ntnu.tdt4100.part5.IPilkingtonService;
import no.ntnu.tdt4100.part5.IStockChangeListener;

/**
 * This class is an implementation of an {@link IStockChangeListener}
 * that listens for stock changes and orders new windows from Pilkington.
 * 
 * Read carefully the JavaDoc of {@link IStockChangeListener}
 * 
 * Windows in all BMW cars are produced by Pilkington.
 * Pilkington has a service to recieve orders {@link IPilkingtonService}
 * 
 * The factory needs to send its orders via
 * the service when the available quantity of the given car part in
 * the inventory is less than 10.
 * 
 * This class will only send the orders to Pilkington if
 * A) the available quantity is less than 10
 * and
 * B) the part name contains the word "window" case-insensitive.
 * 
 * For all other parts, the class will do nothing.
 * 
 * This class should keep track of the parts that are ordered and the amount of parts that are ordered
 * so that {@link #getOrderedCount(CarPart)} returns the correct result.
 * 
 * Behavioural requirements:
 * <ul>
 * <li>The class must implement the interface {@link no.ntnu.tdt4100.part5.IStockChangeListener}</li>
 * <li>When the listener is triggered and the remaining available quantity  of a part is less than 10, 
 * and the part name contains the word "window" case-insensitive,
 * 10 new items of that part should be ordered by calling {@link IPilkingtonService#sendOrder(CarPart, int)}</li>
 * 
 * @see IPilkingtonService#sendOrder(CarPart)
 * @see no.ntnu.tdt4100.part5.IStockChangeListener#execute(CarPart, int)
 * @see OrderFromPilkingtonStockChangeListenerTests
 */
public class OrderFromPilkingtonStockChangeListener implements IStockChangeListener {

    private final Map<CarPart, Integer> orderedParts = new HashMap<>();
    private IPilkingtonService service;

    /**
     * The constructor
     * 
     * @param service the service to use to send orders to Pilkington
     */
    public OrderFromPilkingtonStockChangeListener(IPilkingtonService service) {
        this.service = service;
    }

    @Override
    public void execute(CarPart part, int remainingStock) {
        if (part == null 
                || remainingStock < 0 
                || !part.partName().toLowerCase().contains("window")) return;
        if (remainingStock >= 0 && remainingStock < 10) {
            service.sendOrder(part, 10);
            orderedParts.put(part,getOrderedCount(part) + 10);
        } 
    }

    /**
     * Returns the number of ordered units of the given part.
     * If the part has not been ordered, 0 should be returned
     * 
     * @param part the part
     * @return the number of ordered units of the given part
     */
    public int getOrderedCount(CarPart part) {
        // TODO Implement the method to behave according to JavaDoc
        return orderedParts.getOrDefault(part, 0);
    }
}

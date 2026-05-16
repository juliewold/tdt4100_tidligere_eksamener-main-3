package com.bmw.manufacturing.part5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import no.ntnu.tdt4100.CarPart;
import no.ntnu.tdt4100.part5.IStockChangeListener;
import no.ntnu.tdt4100.part5.InsufficientPartsException;
import no.ntnu.tdt4100.part5.InventoryManager;

/**
 * WarehouseInventoryManager must implement the {@link no.ntnu.tdt4100.part5.InventoryManager} interface
 * 
 * @see no.ntnu.tdt4100.part5.InventoryManager
 * @see WarehouseInventoryManagerTests
 */
public class WarehouseInventoryManager implements InventoryManager {
    // TODO Implement the class according to behaviour specified in Javadoc in its interface
    
    private List<IStockChangeListener> listeners;
    private Map<CarPart, Integer> stock;

    public WarehouseInventoryManager() {
        listeners = new ArrayList<>();
        stock = new HashMap<>();
    }

    @Override
    public void addListener(IStockChangeListener listener) {
        if (!listeners.contains(listener)) {
            listeners.add(listener);
        }
    }

    @Override
    public void removeListener(IStockChangeListener listener) {
        if (listeners.contains(listener)) {
            listeners.remove(listener);
        }
    }

    @Override
    public int getAvailableQuantity(CarPart part) {
        return stock.getOrDefault(part, 0);
    }

    @Override
    public int getNumberOfListeners() {
        return listeners.size();
    }

    @Override
    public void increaseQuantity(CarPart part, int numberOfItems) {
        if (numberOfItems <= 0) return;
        stock.put(part, stock.getOrDefault(part, 0) + numberOfItems);
    }

    @Override
    public void decreaseQuantity(CarPart part, int numberOfItems) {
        if (getAvailableQuantity(part) >= numberOfItems) {
            stock.put(part, stock.getOrDefault(part, 0) - numberOfItems);
            for (IStockChangeListener listener : listeners) {
                listener.execute(part, stock.get(part));
            }
        } else {
            throw new InsufficientPartsException(part, "Have not enough quantity of part " + part.partId());
        }
    }
}

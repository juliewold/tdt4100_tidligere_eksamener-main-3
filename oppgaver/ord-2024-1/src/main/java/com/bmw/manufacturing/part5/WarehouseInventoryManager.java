package com.bmw.manufacturing.part5;

import no.ntnu.tdt4100.CarPart;
import no.ntnu.tdt4100.part5.IStockChangeListener;
import no.ntnu.tdt4100.part5.InventoryManager;

/**
 * WarehouseInventoryManager must implement the {@link no.ntnu.tdt4100.part5.InventoryManager} interface
 * 
 * @see no.ntnu.tdt4100.part5.InventoryManager
 * @see WarehouseInventoryManagerTests
 */
public class WarehouseInventoryManager implements InventoryManager{

    @Override
    public void increaseQuantity(CarPart part, int numberOfItems) {
        if (numberOfItems < 0) {
            return;
            
        }
        
    }

    @Override
    public void decreaseQuantity(CarPart part, int numberOfItems) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'decreaseQuantity'");
    }

    @Override
    public void addListener(IStockChangeListener listener) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addListener'");
    }

    @Override
    public void removeListener(IStockChangeListener listener) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeListener'");
    }

    @Override
    public int getAvailableQuantity(CarPart part) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAvailableQuantity'");
    }

    @Override
    public int getNumberOfListeners() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getNumberOfListeners'");
    }
    // TODO Implement the class according to behaviour specified in Javadoc in its interface
}

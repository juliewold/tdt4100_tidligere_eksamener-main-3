package no.ntnu.tdt4100;

import no.ntnu.tdt4100.part5.InventoryManager;

/**
 * Interface that ensures an inventory manager is available
 * for the classes that implement it.
 * 
 * THIS IS SUPPLIED CODE, DO NOT MODIFY THIS CODE
 */
public interface IHasInventoryManager {
    /**
     * Returns the inventory manager
     *
     * @return the {@link InventoryManager}
     */
    public InventoryManager getInventoryManager();
}

package no.ntnu.tdt4100;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Represents a shipment of products in the shopping system.
 * 
 * THIS IS SUPPLIED CODE, DO NOT MODIFY THIS CODE
 * 
 * @see IProduct
 * @see ShipmentUpdate
 * 
 */
public record Shipment(
        int id,
        LocalDateTime createdDateTime,
        Map<IProduct, Integer> productsContained,
        List<ShipmentUpdate> updates) {

    private static int nextShipmentId = 1;

    /**
     * Creates a new shipment with a unique ID and createdDateTime set to the
     * current time, as well as an empty map of productsContained and an empty list
     * of updates.
     * 
     */
    public Shipment() {
        this(nextShipmentId++, LocalDateTime.now(), new HashMap<>(), new ArrayList<>());
    }
}

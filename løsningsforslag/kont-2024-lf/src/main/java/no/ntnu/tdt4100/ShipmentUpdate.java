package no.ntnu.tdt4100;

import java.time.LocalDateTime;

/**
 * Represents a status update for a shipment of products in the shopping system.
 * 
 * THIS IS SUPPLIED CODE, DO NOT MODIFY THIS CODE
 */
public record ShipmentUpdate(String updateMessage, LocalDateTime updateDateTime) {
}

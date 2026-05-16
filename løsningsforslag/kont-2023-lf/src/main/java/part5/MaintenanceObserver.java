package part5;

import shared.IAircraft;

// DO NOT MODIFY THIS CLASS, this is just used for testing
public class MaintenanceObserver implements IMaintenanceObserver {

    private IAircraft lastAircraftSeen;
    private String lastMaintenanceStatus;

    @Override
    public void maintenanceStatusChanged(IAircraft aircraft, String newStatus) {
        this.lastAircraftSeen = aircraft;
        this.lastMaintenanceStatus = newStatus;
    }

    // Exposed for testing
    public IAircraft getAircraft() {
        return lastAircraftSeen;
    }

    // Exposed for testing
    public String getLastMaintenanceSatus() {
        return lastMaintenanceStatus;
    }

}

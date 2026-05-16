package part5;

import shared.IAircraft;

// DO NOT MODIFY THIS INTERFACE
public interface IMaintenanceObserver {
    void maintenanceStatusChanged(IAircraft aircraft, String newStatus);
}
